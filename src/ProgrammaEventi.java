import jdk.jfr.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

    private String titolo;
    private List<Evento> eventi;

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        eventi = new ArrayList<>();
    }

    public void addEvento(Evento e)
    {

        eventi.add(e);

    }
    public List<Evento> eventOnDate(LocalDate data)
    {

        List<Evento> eventoInData = new ArrayList<>();
        LocalDate now = LocalDate.now();

        for (Evento e : eventi) {


            if(e.getData().equals(now)) eventoInData.add(e);


        }

        return eventoInData;

    }

    public int howManyEvents()
    {
        return eventi.size();

    }

    public void freeEvents()
    {

        eventi.clear();

    }

    public String events()
    {

        String result = "";

        for(Evento e: eventi)
        {

            result+=e.getData()+" - "+e.getTitolo();

        }

        return result;

    }

}
