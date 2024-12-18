import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        List<Turisti> gruppi = List.of( //Creazione dei gruppi di turisti
                new Turisti("Francesi"),
                new Turisti("Tedeschi"),
                new Turisti("Spagnoli")
        );


        Traghetto traghetto = new Traghetto(); //Traghetto che trasporta i turisti


        ExecutorService esecutore = Executors.newFixedThreadPool(3); //Pool di thread per simulare le operazioni

        for (Turisti gruppo : gruppi) {
            esecutore.execute(() -> {
                gruppo.partenza();
                gruppo.arrivo();
                gruppo.pagamento();
                synchronized (traghetto) {
                    gruppo.imbarco();
                    traghetto.partenzaCon(gruppo);
                    traghetto.ritorno();
                }
            });
        }

        esecutore.shutdown();
        while (!esecutore.isTerminated()) { //Attesa che tutti i thread si completino
        }


        salvaRisultatiSuFile(traghetto.getRegistroViaggi()); //Salvataggio dei risultati su file
    }

    private static void salvaRisultatiSuFile(List<String> registroViaggi) {
        String nomeFile = "registro_viaggi.txt";
        try (FileWriter writer = new FileWriter(nomeFile)) {
            writer.write("Data: " + LocalDate.now() + "\n");
            writer.write("Viaggi effettuati:\n");
            for (String log : registroViaggi) {
                writer.write(log + "\n");
            }
            System.out.println("Risultati scritti su " + nomeFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
