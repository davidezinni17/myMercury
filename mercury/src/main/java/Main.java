import dao.EventDao;
import model.Evento;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    EventDao ed = new EventDao();


    ArrayList<Evento> listEvent = ed.recoveryEvento();
    ArrayList<Evento> searchEvent = new ArrayList<>();

//        for (Evento evento : listEvent) {
//            System.out.println(evento.getName() + "\n");
//        }

        System.out.println("\n\n\nfilterd event");

        for (Evento evento : listEvent) {
            if(evento.getGenere().toLowerCase().equals("horror")){
                searchEvent.add(evento);
            }
        }

        for (Evento evento : searchEvent) {
            System.out.println(evento.getName() + "\n");
        }
    }

}
