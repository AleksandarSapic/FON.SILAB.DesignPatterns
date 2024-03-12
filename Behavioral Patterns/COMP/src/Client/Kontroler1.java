package Client;

import AbstractProductA.*;
import AbstractProductB.*;
import ConcreteCommand.SO;
import ConcreteCommand.SOKreiraj;
import ConcreteCommand.SONadji;
import ConcreteCommand.SOObrisi;
import ConcreteCommand.SOPromeni;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKLet;  // Promenljivo
import DomainClasses.GeneralDObject;
import Receiver.KreirajDomenskiObjekat;
import Receiver.NadjiDomenskiObjekat;
import Receiver.ObrisiDomenskiObjekat;
import Receiver.PromeniDomenskiObjekat;

public final class Kontroler1 extends Kontroler {

    public Kontroler1(EkranskaForma ef1, BrokerBazePodataka bbp1, SO so) {
        ef = ef1;
        bbp = bbp1;
        Povezi(so);
    }

    void Povezi(SO so) {
        KreirajDomenskiObjekat kdo = new KreirajDomenskiObjekat(this);
        so.sok = new SOKreiraj(kdo); // povezivanje ConcreteCommand i Receiver

        PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(this);
        so.sop = new SOPromeni(pdo);

        ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(this);
        so.soo = new SOObrisi(odo);

        NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(this);
        so.son = new SONadji(ndo);
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

    boolean zapamtiDomenskiObjekat() {

        bbp.makeConnection();
        boolean signal = bbp.insertRecord(let);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Sistem je zapamtio let."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            poruka = "Sistem nije zapamtio let."; // Promenljivo!!!  
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;

    }

    boolean kreirajDomenskiObjekat() {
        boolean signal;
        let = new DKLet(); // Promenljivo!!!
        AtomicInteger counter = new AtomicInteger(0);

        bbp.makeConnection();
        if (!bbp.getCounter(let, counter)) {
            return false;
        }
        if (!bbp.increaseCounter(let, counter)) {
            return false;
        }

        let.setSifraLeta(counter.get()); // Promenljivo!!!
        signal = bbp.insertRecord(let);
        if (signal == true) {
            bbp.commitTransation();
            napuniGrafickiObjekatIzDomenskogObjekta(let);
            poruka = "Sistem je kreirao let."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Sistem nije kreirao let."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean obrisiDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.deleteRecord(let);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Sistem je obrisao let."; // Promenljivo!!!
            isprazniGrafickiObjekat();
        } else {
            bbp.rollbackTransation();
            poruka = "Sistem nije obrisao let."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean promeniDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.updateRecord(let);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Sistem je azurirao let."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Sistem nije azurirao let."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean nadjiDomenskiObjekat() {
        boolean signal;
        bbp.makeConnection();
        let = (DKLet) bbp.findRecord(let); // Promenljivo!!!
        if (let != null) {
            napuniGrafickiObjekatIzDomenskogObjekta(let);
            poruka = "Sistem je pronasao let."; // Promenljivo!!!
            signal = true;
        } else {
            isprazniGrafickiObjekat();
            poruka = "Sistem nije pronasao let."; // Promenljivo!!!
            signal = false;
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}

class OsluskivacZapamti implements ActionListener {

    Kontroler1 kon;

    OsluskivacZapamti(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.zapamtiDomenskiObjekat();

    }
}

class OsluskivacKreiraj implements ActionListener {

    Kontroler1 kon;

    OsluskivacKreiraj(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.kreirajDomenskiObjekat();

    }
}

class OsluskivacObrisi implements ActionListener {

    Kontroler1 kon;

    OsluskivacObrisi(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.obrisiDomenskiObjekat();

    }
}

class OsluskivacPromeni implements ActionListener {

    Kontroler1 kon;

    OsluskivacPromeni(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.promeniDomenskiObjekat();

    }
}

class OsluskivacNadji implements ActionListener {

    Kontroler1 kon;

    OsluskivacNadji(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }
}

class OsluskivacNadji1 implements FocusListener {

    Kontroler1 kon;

    OsluskivacNadji1(Kontroler1 kon1) {
        kon = kon1;
    }

    public void focusLost(java.awt.event.FocusEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }

    @Override
    public void focusGained(FocusEvent e) {

    }
}
