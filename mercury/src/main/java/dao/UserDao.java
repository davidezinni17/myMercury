package dao;
import model.User;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;
public class UserDao {
    Connection conn = MyConne.myConn();
    User u = new User();
    private boolean checkLogin = false;

    public boolean isCheckLogin() {
        return checkLogin;
    }

    public void setCheckLogin(boolean checkLogin) {
        this.checkLogin = checkLogin;
    }

    public void insertUser(User u){

        String query = "INSERT INTO mercury.user VALUES(0,?,?,?,?,?)";
        try{

            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1,u.getNome());
            pre.setString(2,u.getSuranme());
            pre.setString(3,u.getEmail());
            pre.setString(4,u.getAge());
            pre.setString(5,u.getPass());
            pre.executeUpdate();

            pre.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
//        catch(ClassNotFoundException ce){
//            ce.printStackTrace();
//        }

    }

    public void loginUser(User u){

        String query = "SELECT * FROM mercury.user WHERE email = ? AND pass = ?";

        try{

            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1,u.getEmail());
            pre.setString(2,u.getPass());
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                checkLogin = true;
            }

            rs.close();
            pre.close();
            conn.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
