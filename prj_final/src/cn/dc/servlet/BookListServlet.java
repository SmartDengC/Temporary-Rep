package cn.dc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.dc.dao.bookDao;
import cn.dc.bean.books;
@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int currPage = 1;
        if (request.getRequestDispatcher("page")!=null){
            currPage = Integer.parseInt(request.getParameter("page"));
        }
        bookDao dao = new bookDao();
        List<books> booksList = dao.findAllBook(currPage);
        request.setAttribute("bookList", booksList);
        int Pages;
        int count = dao.findAllBookCount();
        StringBuilder sb = new StringBuilder();
        if(count%books.page_size != 0){
            Pages = count / books.page_size+1;
        }
        else{
            Pages = count / books.page_size;
        }
        for (int i =0 ;i<=Pages;i++){
            if(i == currPage){
                sb.append("<").append(i).append(">");
            }
            else{
                sb.append("<a href='bookList?page=").append(i).append("'>").append(i).append("</a>");
            }
        }
        sb.append(" ");
        request.setAttribute("bar", sb.toString());
        HttpSession session = request.getSession();
        session.setAttribute("usersList", booksList);
        request.getRequestDispatcher("cart.jsp").forward(request,response);

    }
}
