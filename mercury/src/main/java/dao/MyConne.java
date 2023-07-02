package dao;

import java.sql.*;

public class MyConne {

    private static final String url = "jdbc:mysql://localhost:3306/mercury";
    private static final String username = "root";
    private static final String password = "root";

    public static Connection myConn(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException ce){
            ce.printStackTrace();
        }
        return null;
    }

}
