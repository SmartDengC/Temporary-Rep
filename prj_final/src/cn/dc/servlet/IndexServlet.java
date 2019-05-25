package cn.dc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    //登陆之后跳转的页面，显示用户名和登陆时间，提供一个注销超连接属性为logout
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String pword = request.getParameter("password");
        Cookie cookie = new Cookie(name, pword);
        String piccod = (String)request.getSession().getAttribute("piccode");//获得到原来的验证码信息
        String checkcode = request.getParameter("checkin");//获取前台用户输入的数
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        if (name.equals("java") && pword.equals("web") && piccod.equals(checkcode)){
            // 说明登陆成功
            // save session
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30);
            session.setAttribute("Name", name);
            session.setAttribute("Password", pword);
            // out put something info
            out.println("The user name is:"+name+"....."+"<br>");
            Calendar calendar = Calendar.getInstance();
            Date time = calendar.getTime();
            out.println("The login time is:"+time+"....."+"<br>");
            out.println("<a href='logout'>Logout</a>"+"<br>");
        }
        else{
            response.sendRedirect("login.jsp");
        }
    }
}
