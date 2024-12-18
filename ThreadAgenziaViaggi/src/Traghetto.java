import java.util.ArrayList;
import java.util.List;

public class Traghetto {
    private final List<String> registroViaggi = new ArrayList<>();

    public void partenzaCon(Turisti gruppo) { //Registra il viaggio
        System.out.println("Il traghetto è partito con i " + gruppo.getNome());
        registroViaggi.add("Viaggio con i " + gruppo.getNome());
        pausa();
    }

    public void ritorno() {
        System.out.println("Il traghetto è tornato al porto.");
        pausa();
    }

    public List<String> getRegistroViaggi() {
        return registroViaggi;
    }

    private void pausa() {
        try {
            Thread.sleep((500)); //Pausa di millisecondi
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
