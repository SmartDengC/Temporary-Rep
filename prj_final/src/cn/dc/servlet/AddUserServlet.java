package cn.dc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import cn.dc.bean.users;
import cn.dc.dao.userDao;

@WebServlet("/admin/addUser")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 用来添加用户的一个servlet
        users user = new users();
        String name = null;
        String password = null;
        String age = null;
        String sex = null;
        String hobby = null;
        if (request.getParameter("username")!=null && request.getParameter("password")!=null){
            name = request.getParameter("username");
            password = request.getParameter("password");
        }
        age = request.getParameter("age");
        hobby = request.getParameter("hobby");
        sex = request.getParameter("sex");
        user.setHobby(hobby);
        user.setName(name);
        user.setPassword(password);
        user.setAge(Integer.parseInt(age));
        user.setSex(sex);
        userDao dao = new userDao();
        Boolean is_add = dao.addUser(user);
        if(is_add){
            System.out.println("add user succeed");
            request.getRequestDispatcher("userlist?page=1").forward(request, response);
        }
        else{
            System.out.println("add user error");
            response.sendRedirect("addUser.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
