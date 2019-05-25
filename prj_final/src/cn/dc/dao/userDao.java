package cn.dc.dao;
import cn.dc.bean.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import cn.dc.utils.db_con;
import cn.dc.dao.impl.userDaoImpl;
public class userDao implements userDaoImpl{

    public List<users> findAllUser(int page){
        List<users> usersList = new ArrayList<>(); //实例化list
        String sql = "select * from table_user order by id limit ?,?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        try {
            connection = db_con.to_con();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (page-1)*users.page_size);
            preparedStatement.setInt(2, users.page_size);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                users user = new users();
                user.setId(resultSet.getInt("id"));
                user.setAge(resultSet.getInt("age"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setHobby(resultSet.getString("hobby"));
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            db_con.to_close(connection, preparedStatement, resultSet);
        }
        return usersList;
    }

    public int findAllUsersCount(){
        int count = 0;
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select count(*) from table_user";

        try {
            connection =db_con.to_con();
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

    @Override
    public Boolean addUser(users user){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        String sql2 = "insert into table_user(name,password,age,sex,hobby) " +
                "values ('"+user.getName()+"','"
                +user.getPassword()+"',"+user.getAge()+",'"+user.getSex()+"','"+user.getHobby()+"');";
        connection = db_con.to_con();
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql2);
            db_con.to_cls(connection, statement);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public Boolean deleteUser(int id) {
        String sql = "delete from table_user where id="+id+";";
        Connection connection = null;
        Statement statement = null;
        try {
            connection = db_con.to_con();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int insert(users user) {
        return 0;
    }

    @Override
    public int update(users user) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<users> findByPage(int page, int pageSize) {
        return null;
    }

    @Override
    public users find(int id) {
        return null;
    }

    @Override
    public users find(String name, String password) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
