package dao;

import model.Admin;
import model.Azienda;
import model.Evento;
import model.User;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.locks.StampedLock;

public class AdminDao {

    Admin admin = new Admin();

    Connection conn = MyConne.myConn();
    private boolean checkLoginAdmin = false;

    public boolean isCheckLoginAdmin() {
        return checkLoginAdmin;
    }

    public void setCheckLoginAdmin(boolean checkLoginAdmin) {
        this.checkLoginAdmin = checkLoginAdmin;
    }

    public void insertAdmin(Admin a){
        try{
            String query = "INSERT INTO mercury.admin VALUES(0,?,?,?,?,?)";
            PreparedStatement pre = conn.prepareStatement(query);

            pre.setString(1,a.getName());
            pre.setString(2,a.getSurname());
            pre.setString(3,a.getUsername());
            pre.setString(4,a.getEmail());
            pre.setString(5,a.getPassword());

            pre.executeUpdate();
            pre.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void loginAdmin(Admin a){
        try{
            String query = "SELECT * FROM mercury.admin WHERE email = ? AND pass = ?";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1,a.getEmail());
            pre.setString(2,a.getPassword());
            ResultSet rs = pre.executeQuery();

            if(rs.next()){
                checkLoginAdmin = true;
            }

            pre.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Evento> recoveryEvent(){

        ArrayList<Evento> eventList = new ArrayList<>();

        try{
            String query = "SELECT * FROM mercury.evento";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(query);

            while(rs.next()){
                Evento ev = new Evento();
                ev.setName(rs.getString("nome_evento"));
                ev.setNomeAzienda(rs.getString("nome_azienda"));
                ev.setGenere(rs.getString("genere"));
                ev.setLuogo(rs.getString("luogo"));
                ev.setPrezzo(rs.getString("Prezzo"));

                eventList.add(ev);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return eventList;
    }

    public ArrayList<User> recoveryAllUser(){
        ArrayList<User> userList = new ArrayList<>();

        try{
            String query = "SELECT * FROM mercury.user";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(query);
            while(rs.next()){
                User u = new User();
                u.setNome(rs.getString("nome"));
                u.setSuranme(rs.getString("surname"));
                u.setEmail(rs.getString("email"));
                u.setAge(rs.getString("age"));
                u.setPass(rs.getString("pass"));

                userList.add(u);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    public ArrayList<Azienda> recoveryAllAziende(){
        ArrayList<Azienda> aziendaList = new ArrayList<>();
        try{
            String query = "SELECT * FROM mercury.azienda";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(query);

            while(rs.next()){
                Azienda a = new Azienda();
                a.setNomeAzienda(rs.getString("nome"));
                a.setLuogoAzienda(rs.getString("luogo"));
                a.setNumeroAzienda(rs.getString("numero"));
                a.setP_iva(rs.getString("p_iva"));

                aziendaList.add(a);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return aziendaList;
    }

    public ArrayList<Admin> recoveryAllAdmin(){
        ArrayList<Admin> adminList = new ArrayList<>();
        try{
            String query = "SELECT * FROM mercury.admin";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()){
                Admin a = new Admin();
                a.setName(rs.getString("nome"));
                a.setSurname(rs.getString("surname"));
                a.setUsername(rs.getString("username"));
                a.setEmail(rs.getString("email"));
                a.setPassword(rs.getString("pass"));

                adminList.add(a);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return adminList;
    }

//    public void deleteEvento(){
//
//    }

}
