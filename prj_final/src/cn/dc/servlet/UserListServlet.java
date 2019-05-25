package cn.dc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import cn.dc.dao.userDao;
import cn.dc.bean.users;

@WebServlet("/admin/userlist")
public class UserListServlet extends HttpServlet {
    // 返回用户分页信息，在该页中中和编辑和删除用户记录，并提供一个addUser.html的超连接
    // 在web.xml 中设置userlist 为首页
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int currPage = 1;
        // 判断传递的页面是否有效
        if (request.getRequestDispatcher("page")!=null){
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            System.out.println("time:"+date);
            System.out.println("some info:"+request.getRequestDispatcher("page"));
            System.out.println("currPage:"+Integer.parseInt(request.getParameter("page")));
            currPage = Integer.parseInt(request.getParameter("page"));
//            currPage = (int) Integer.parseInt(String.valueOf(request.getRequestDispatcher("page")));
            System.out.println("currPage"+currPage);
        }
        userDao dao = new userDao();
        List<users> usersList = dao.findAllUser(currPage);
        request.setAttribute("usersList", usersList);
        int pages;
        int count = dao.findAllUsersCount();
        if(count%users.page_size == 0){
            pages = count / users.page_size;
        }
        else{
            pages = count / users.page_size+1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i =0 ;i<=pages;i++){
            if(i == currPage){
                sb.append("[").append(i).append("]");
            }
            else{
                sb.append("<a href='userlist?page=").append(i).append("'>").append(i).append("</a>");
            }
        }
        sb.append(" ");
        request.setAttribute("bar", sb.toString());
        System.out.println("bat:"+sb.toString());
//        request.setAttribute("usersList", usersList);
        HttpSession session = request.getSession();
        session.setAttribute("usersList", usersList);
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }
}
