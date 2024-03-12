package AbstractProductC;

import AbstractProductA.*;
import AbstractProductB.*;
import ConcreteStrategy.KreirajDomenskiObjekat;
import ConcreteStrategy.NadjiDomenskiObjekat;
import ConcreteStrategy.ObrisiDomenskiObjekat;
import ConcreteStrategy.PromeniDomenskiObjekat;
import Context.Dugme;
import Context.TekstPolje;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKLet;  // Promenljivo
import DomainClasses.GeneralDObject;
import javax.swing.JButton;
import javax.swing.JTextField;

public final class Kontroler1 extends Kontroler {

    public Kontroler1(EkranskaForma ef1, BrokerBazePodataka bbp1) {
        ef = ef1;
        bbp = bbp1;
        Povezi();
    }

    void Povezi() {
        KreirajDomenskiObjekat kdo = new KreirajDomenskiObjekat(bbp, this);
        Dugme dk1 = new Dugme(kdo, (JButton) ef.getPanel().getKreiraj());

        PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(bbp, this);
        Dugme dk2 = new Dugme(pdo, (JButton) ef.getPanel().getPromeni());

        ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(bbp, this);
        Dugme dk3 = new Dugme(odo, (JButton) ef.getPanel().getObrisi());

        NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(bbp, this);
        Dugme dk4 = new Dugme(ndo, (JButton) ef.getPanel().getNadji());

        TekstPolje tp = new TekstPolje(ndo, (JTextField) ef.getPanel().getSifraLeta1());
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
