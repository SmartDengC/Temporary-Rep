package cn.dc.dao;
import cn.dc.bean.books;
import cn.dc.dao.impl.bookDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.dc.utils.db_con;

public class bookDao implements bookDaoImpl{


    @Override
    public List<books> findAllBook(int page) {
        List<books> bookList = new ArrayList<>();
        String sql = "select *from table_book order by id limit ?,?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = db_con.to_con();
            preparedStatement = db_con.to_pre(connection, sql);
            preparedStatement.setInt(1, (page-1)* books.page_size);
            preparedStatement.setInt(2, books.page_size);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                books book = new books();
                book.setAuthor(resultSet.getString("author"));
                book.setName(resultSet.getString("name"));
                book.setPrice(Integer.parseInt(resultSet.getString("price")));
                book.setPublicer(resultSet.getString("publicer"));
                book.setBookId(resultSet.getString("bookId"));

            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            db_con.to_close(connection, preparedStatement, resultSet);
        }
        return bookList;
    }

    @Override
    public int findAllBookCount() {
        int count = 0;
        Connection connection = db_con.to_con();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select count(*) from table_book";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            db_con.to_close(connection, preparedStatement, resultSet);
        }
        return count;
    }
}
