package dao;

import model.Azienda;

import java.sql.*;

public class AziendaDao {

    Azienda a = new Azienda();
    Connection conn = MyConne.myConn();
    private boolean checkLogin = false;

    public boolean isCheckLogin() {
        return checkLogin;
    }

    public void setCheckLogin(boolean checkLogin) {
        this.checkLogin = checkLogin;
    }

    public void registerAzienda(Azienda a) {
        try {

            String query = "INSERT INTO mercury.azienda VALUES(0,?,?,?,?)";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, a.getNomeAzienda());
            pre.setString(2, a.getLuogoAzienda());
            pre.setString(3, a.getNumeroAzienda());
            pre.setString(4, a.getP_iva());
            pre.executeUpdate();
            System.out.println("sono nella query" + pre.executeUpdate());

            pre.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void loginAzienda(Azienda a) {
        try {
            String query = "SELECT * FROM mercury.azienda WHERE nome = ? AND p_iva = ?;";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1,a.getNomeAzienda());
            pre.setString(2,a.getP_iva());
            ResultSet rs = pre.executeQuery();

            if(rs.next()){
                checkLogin = true;
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
