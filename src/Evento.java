import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int capienza;
    private int prenotazioni;

    private final String ERRORE_DATA = "La data è già passata";
    private final String ERRORE_CAPIENZA = "La capienza deve essere maggiore di 0";
    private final String ERRORE_SOLD_OUT = "Non ci sono più posti disponibili";
    private final String ERRORE_NO_PRENOTAZIONI = "Non ci sono prenotazioni";


    public Evento(String titolo, LocalDate data, int capienza) throws NegativeReseatException, PastDateException{

        if(capienza <=0) throw new NegativeReseatException(ERRORE_CAPIENZA);

        LocalDate now = LocalDate.now();
        if (data.isBefore(now)) throw new PastDateException(ERRORE_DATA);

        this.titolo = titolo;
        this.data = data;
        this.capienza = capienza;
        this.prenotazioni = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getCapienza() {
        return capienza;
    }

    public int getPrenotazioni() {
        return prenotazioni;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void prenota() throws PastDateException, SoldOutException {

        LocalDate now = LocalDate.now();
        if (data.isBefore(now)) throw new PastDateException(ERRORE_DATA);
        if(prenotazioni>=capienza) throw new SoldOutException(ERRORE_SOLD_OUT);
        prenotazioni++;

    }

    public void disdici() throws PastDateException, NoPrenotationsException {

        LocalDate now = LocalDate.now();
        if (data.isBefore(now)) throw new PastDateException(ERRORE_DATA);
        if(prenotazioni<=0) throw new NoPrenotationsException(ERRORE_NO_PRENOTAZIONI);
        prenotazioni--;

    }

    @Override
    public String toString() {
        return data + " - " + titolo;
    }
}
