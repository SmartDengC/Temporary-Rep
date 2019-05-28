package cn.dc.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 判断时候能够登陆
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String name = request.getParameter("username");
        String pword = request.getParameter("password");
        PrintWriter out = response.getWriter();
        Boolean is_true = true;
        if (name.equals("java") && pword.equals("web")){
            if (is_true){
                Cookie nameCookie = new Cookie("username", name);
                Cookie pwordCookie = new Cookie("username", name);
                nameCookie.setMaxAge(7*24*60*60);
                pwordCookie.setMaxAge(7*24*60*60);
                response.addCookie(nameCookie);
                response.addCookie(pwordCookie);
            }
            out.println("<h>Login succeed!</h>");
            out.println("<p>Hello ,"+name+"<p>");
        }
        else{
            response.sendRedirect("login.jsp");
        }

    }
}
