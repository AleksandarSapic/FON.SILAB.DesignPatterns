package Client;

import AbstractProductA.*;
import AbstractProductB.*;
import ConcreteCommand.SOKreiraj;
import ConcreteCommand.SONadji;
import ConcreteCommand.SOObrisi;
import ConcreteCommand.SOPromeni;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKLet;  // Promenljivo
import DomainClasses.GeneralDObject;
import Invoker.Dugme;
import Invoker.TekstPolje;
import Iterator.DugmeKretanja;
import Receiver.KreirajDomenskiObjekat;
import Receiver.NadjiDomenskiObjekat;
import Receiver.ObrisiDomenskiObjekat;
import Receiver.PromeniDomenskiObjekat;

public final class Kontroler1 extends Kontroler {

    public Kontroler1(EkranskaForma ef1, BrokerBazePodataka bbp1) {
        ef = ef1;
        bbp = bbp1;
        Povezi();
    }

    void Povezi() {

        KreirajDomenskiObjekat kdo = new KreirajDomenskiObjekat(bbp, this);
        SOKreiraj sok = new SOKreiraj(kdo); // povezivanje ConcreteCommand and Receiver
        Dugme dk1 = new Dugme(sok, ef.getPanel().getKreiraj());

        PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(bbp, this);
        SOPromeni sop = new SOPromeni(pdo); // povezivanje ConcreteCommand and Receiver
        Dugme dk2 = new Dugme(sop, ef.getPanel().getPromeni());

        ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(bbp, this);
        SOObrisi soo = new SOObrisi(odo); // povezivanje ConcreteCommand and Receiver
        Dugme dk3 = new Dugme(soo, ef.getPanel().getObrisi());

        NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(bbp, this);
        SONadji son = new SONadji(ndo); // povezivanje ConcreteCommand and Receiver
        Dugme dk4 = new Dugme(son, ef.getPanel().getNadji());

        TekstPolje tp = new TekstPolje(son, ef.getPanel().getSifraLeta1()); //Promenljivo

        it = bbp.getIterator(new DKLet()); //Promenljivo
        DugmeKretanja dprv = new DugmeKretanja(it, ef.getPanel().getPrvi(), this);
        DugmeKretanja dsl = new DugmeKretanja(it, ef.getPanel().getSledeci(), this);
        DugmeKretanja dpre = new DugmeKretanja(it, ef.getPanel().getPredhodni(), this);
        DugmeKretanja dza = new DugmeKretanja(it, ef.getPanel().getZadnji(), this);
    }

// Promenljivo!!!  
    @Override
    public void napuniDomenskiObjekatIzGrafickogObjekta() {
        let = new DKLet();
        let.setSifraLeta(getInteger(ef.getPanel().getSifraLeta()));
        let.setAvioKompanija(ef.getPanel().getAvioKompanija());
        let.setSifraAviona(getInteger(ef.getPanel().getSifraAviona()));
        let.setPilot(ef.getPanel().getPilot());
        let.setMestoUzletanja(ef.getPanel().MestoUzletanja());
        let.setMestoSletanja(ef.getPanel().MestoSletanja());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatumLeta()));
        let.setDatumLeta(Datum);

    }

// Promenljivo!!!
    @Override
    public void napuniGrafickiObjekatIzDomenskogObjekta(GeneralDObject gdo) {
        DKLet let = (DKLet) gdo;
        ef.getPanel().setSifraLeta(Integer.toString(let.getSifraLeta()));
        ef.getPanel().setAvioKompanija(let.getAvioKompanija());
        ef.getPanel().setSifraAviona(Integer.toString(let.getSifraAviona()));
        ef.getPanel().setPilot(let.getPilot());
        ef.getPanel().setMestoUzletanja(let.getMestoUzletanja());
        ef.getPanel().setMestoSletanja(let.getMestoSletanja());
        ef.getPanel().setDatumLeta(let.getDatumLeta());

    }

// Promenljivo!!!
    @Override
    public void isprazniGrafickiObjekat() {
        ef.getPanel().setSifraLeta("");
        ef.getPanel().setAvioKompanija("");
        ef.getPanel().setSifraAviona("000000");
        ef.getPanel().setPilot("");
        ef.getPanel().setMestoUzletanja("");
        ef.getPanel().setMestoSletanja("");
        ef.getPanel().setDatumLeta(new java.util.Date());
    }

    @Override
    public void prikaziPoruku() {
        ef.getPanel().setPoruka(poruka);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ef.getPanel().setPoruka("");
            }
        }, 3000);

    }

    public int getInteger(String s) {
        int broj = 0;
        try {
            if (s != null) {
                broj = Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            broj = 0;
        }

        return broj;
    }
}
