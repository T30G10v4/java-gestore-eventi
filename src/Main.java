import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        LocalDate data = LocalDate.now();

        String titolo = "";
        int giorno = 0;
        int mese = 0;
        int anno = 0;
        int capienza = 0;

        int numeroPrenotazioni;
        int numeroDisdette;

        boolean dataError;
        boolean disdici;

        System.out.print("Inserisci il titolo dell'evento: ");
        titolo = scan.nextLine();

        do {

            dataError = false;

            try {
                System.out.print("Inserisci il giorno dell'evento in numero: ");
                giorno = Integer.parseInt(scan.nextLine());

                System.out.print("Inserisci il mese dell'evento in numero: ");
                mese = Integer.parseInt(scan.nextLine());

                System.out.print("Inserisci l' anno dell'evento in numero: ");
                anno = Integer.parseInt(scan.nextLine());

                System.out.print("Inserisci la capienza dell'evento: ");
                capienza = Integer.parseInt(scan.nextLine());

                data = LocalDate.of(anno, mese, giorno);

            } catch (NumberFormatException e) {
                System.out.println("Errore di inserimento dati");
                dataError = true;
            } catch (DateTimeException e) {
                System.out.println("Errore di inserimento data");
                dataError = true;
            }
        } while (dataError);

        try {
            Evento evento1 = new Evento(titolo, data, capienza);

            System.out.print("Vuoi effettuare delle prenotazioni? 0-NO, 1-SI: ");

            if(scan.nextLine().equals("1")) {
                System.out.print("Quante prenotazioni vuoi fare?: ");
                numeroPrenotazioni = Integer.parseInt(scan.nextLine());
                for (int i = 0; i < numeroPrenotazioni; i++) {
                    evento1.prenota();

                }
                System.out.println("  "+numeroPrenotazioni + " prenotazioni effettuate con successo. I posti disponibili sono "+(evento1.getCapienza() - evento1.getPrenotazioni()));
            }

            System.out.print("Vuoi effettuare delle disdette? 0-NO, 1-SI: ");

            if(scan.nextLine().equals("1")) {
                System.out.print("Quante disdette vuoi fare?: ");
                numeroDisdette = Integer.parseInt(scan.nextLine());
                for (int i = 0; i < numeroDisdette; i++) {
                    evento1.disdici();

                }
                System.out.println("  "+numeroDisdette + " disdette effettuate con successo. I posti disponibili sono "+(evento1.getCapienza() - evento1.getPrenotazioni()));
            }

        } catch (NegativeReseatException e) {
            System.out.println(e.getMessage());
        } catch (PastDateException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Errore di inserimento dati");
        } catch (SoldOutException e) {
            System.out.println(e.getMessage());
        } catch (NoPrenotationsException e) {
            System.out.println(e.getMessage());
        }

    }
}
