package cn.dc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/beforeLogin")
public class BeforeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 判断用户是否选择了复选框，如果选择了 跳转index，没有跳转login.jsp
        String name = "";
        String pword = "";
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for (int i=0; i<cookies.length; i++){
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("java")){
                    name = cookie.getValue();
                }
                if (cookie.getName().equals("web")){
                    pword = cookie.getValue();
                }
            }
        }
        if (name.equals("java") && pword.equals("web")){
            request.getRequestDispatcher("index").forward(request, response);
        }
        else{
            response.sendRedirect("login.jsp");
        }
    }
}
