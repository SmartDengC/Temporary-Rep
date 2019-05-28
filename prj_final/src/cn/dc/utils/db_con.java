package cn.dc.utils;
import java.sql.*;

public class db_con {
    /**
     * To come true mysql connection
     * @return a mysql connect object
     */
    public static Connection to_con(){
        // 链接数据库前期做的准备
        String url = "jdbc:mysql://localhost:3306/mydb";
        String name = "root";
        String password  = "root";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * preparedStatement
     * @param connection connection object
     * @param sql the mysql search command
     * @return a preparedStatement object
     */
    public static PreparedStatement to_pre(Connection connection, String sql){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
     *
     * @param connection connection object
     * @param sql sql command
     * @return statement  object
     */
    public static Statement to_sta(Connection connection, String sql){
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    /**
     * foreach mysql return info
     * @param connection connection object
     * @param preparedStatement preparedStatement object
     */
    public static void to_res(Connection connection, PreparedStatement preparedStatement){
        ResultSet resultSet = null;
        while(true){
            try {
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    // out print something
                    System.out.println(resultSet.getInt("id")
                                    +resultSet.getString("name")
                                    +resultSet.getString("password"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * close the all connection
     * @param connection connection
     * @param preparedStatement prepareStatement
     * @param resultSet resultSet
     */
    public static void to_close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void to_cls(Connection connection, Statement statement){
        if (statement!=null && connection!=null){
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
