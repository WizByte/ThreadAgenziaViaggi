public class Turisti {
    private final String nome;

    public Turisti(String nome) {
        this.nome = nome;
    }
    //Simula la partenza del gruppo dagli alloggi
    public void partenza() {
        System.out.println("I " + nome + " sono partiti dagli alloggi");
        pausa();
    }

    public void arrivo() {
        System.out.println("I " + nome + " sono arrivati al porto");
        pausa();
    }

    public void pagamento() {
        System.out.println("I " + nome + " hanno pagato i biglietti");
        pausa();
    }

    public void imbarco() {
        System.out.println("I " + nome + " si stanno imbarcando sul traghetto");
    }

    private void pausa() {
        try {
            Thread.sleep((500));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getNome() {
        return nome;
    }
}
