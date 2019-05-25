package cn.dc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.dc.dao.userDao;
import cn.dc.utils.db_con;

@WebServlet("/admin/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        userDao dao = new userDao();
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        String result = "";
        Boolean is_del = dao.deleteUser(id);
        if (is_del){
            System.out.println("delete user succeed");
            result = URLEncoder.encode("用户删除成功", "utf-8");
            request.setAttribute("result", result);
            request.getRequestDispatcher("userlist?page=1").forward(request, response);
        }
        else{
            System.out.println("delete user error");
            result = URLEncoder.encode("用户删除失败", "utf-8");
            request.setAttribute("result", result);
            request.getRequestDispatcher("userlist?page=1").forward(request, response);
        }

    }
}
