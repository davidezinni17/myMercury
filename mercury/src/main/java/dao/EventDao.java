package dao;

import model.Evento;

import java.sql.*;
import java.util.ArrayList;

public class EventDao {
    Evento ev = new Evento();
    Connection conn = MyConne.myConn();
    ArrayList<Evento> eventList = new ArrayList<>();
    boolean searchEvent = false;


    public ArrayList<Evento> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Evento> eventList) {
        this.eventList = eventList;
    }

    public void insertEvent(Evento ev) {

        try {
            String query = "INSERT INTO mercury.evento VALUES(0,?,?,?,?,?)";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, ev.getName());
            pre.setString(2, ev.getNomeAzienda());
            pre.setString(3, ev.getGenere());
            pre.setString(4, ev.getLuogo());
            pre.setString(5, ev.getPrezzo());
            pre.executeUpdate();

            pre.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Evento> recoveryEvento() {
        try {
            String query = "SELECT * FROM evento";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(query);

            while (rs.next()) {
                Evento ev = new Evento();
                ev.setName(rs.getString("nome_evento"));
                ev.setNomeAzienda(rs.getString("nome_azienda"));
                ev.setGenere(rs.getString("genere"));
                ev.setLuogo(rs.getString("luogo"));
                ev.setPrezzo(rs.getString("Prezzo"));

                eventList.add(ev);
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

//    public ArrayList<Evento> searchEvent(String luogo, String genere) {
//        try {
//            String query = "SELECT * FROM mercury.evento WHERE genere = ? OR luogo = ?";
//
//            PreparedStatement pre = conn.prepareStatement(query);
//            pre.setString(1, luogo);
//            pre.setString(2, genere);
//            ResultSet rs = pre.executeQuery();
//
//            while (rs.next()) {
//                Evento ev = new Evento();
//                ev.setName(rs.getString("nome_evento"));
//                ev.setNomeAzienda(rs.getString("nome_azienda"));
//                ev.setGenere(rs.getString("genere").toLowerCase());
//                ev.setLuogo(rs.getString("luogo").toLowerCase());
//                ev.setPrezzo(rs.getString("Prezzo"));
//
//                searchEventList.add(ev);
//            }
//
//            conn.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return searchEventList;
//    }
}
