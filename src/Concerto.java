import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Concerto extends Evento {

    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int capienza, LocalTime ora, BigDecimal prezzo) throws NegativeReseatException, PastDateException {
        super(titolo, data, capienza);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getDataOraFormattata() {


        return getData().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))+ora.toString();

    }

    public BigDecimal getPrezzoFormattato() {

        return prezzo;

    }

    @Override
    public String toString() {
        return getData() +
                ora.toString() +
                "-"+
                getTitolo()+
                "-"+
                prezzo.toString();

    }
}
