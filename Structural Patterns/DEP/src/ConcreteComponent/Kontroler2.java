package ConcreteComponent;

import Component.Kontroler;
import AbstractProductA.*;
import AbstractProductB.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKLet;

public final class Kontroler2 extends Kontroler {

    public Kontroler2(EkranskaForma ef1, BrokerBazePodataka bbp1) {
        ef = ef1;
        bbp = bbp1;
        Povezi();
        osveziFormu();
    }

    void Povezi() {
        javax.swing.JButton Kreiraj = (javax.swing.JButton) ef.getPanel().getKreiraj();
        javax.swing.JButton Promeni = (javax.swing.JButton) ef.getPanel().getPromeni();
        javax.swing.JButton Obrisi = (javax.swing.JButton) ef.getPanel().getObrisi();
        javax.swing.JButton Nadji = (javax.swing.JButton) ef.getPanel().getNadji();
        Kreiraj.addActionListener(new OsluskivacKreiraj1(this));
        Promeni.addActionListener(new OsluskivacPromeni1(this));
        Obrisi.addActionListener(new OsluskivacObrisi1(this));
        //Nadji.addActionListener( new OsluskivacNadji11(this));

        Nadji.addActionListener((e) -> {
            napuniDomenskiObjekatIzGrafickogObjekta();
            nadjiDomenskiObjekat();
        });

        javax.swing.JTextField SifraPrijave = (javax.swing.JTextField) ef.getPanel().getSifraLeta1(); // Promenljivo!!!
        SifraPrijave.addFocusListener(new OsluskivacNadji12(this));
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
    void napuniGrafickiObjekatIzDomenskogObjekta(DKLet let) {
        ef.getPanel().setSifraLeta(Integer.toString(let.getSifraLeta()));
        ef.getPanel().setAvioKompanija(let.getAvioKompanija());
        ef.getPanel().setSifraAviona(Integer.toString(let.getSifraAviona()));
        ef.getPanel().setPilot(let.getPilot());
        ef.getPanel().setMestoUzletanja(let.getMestoUzletanja());
        ef.getPanel().setMestoSletanja(let.getMestoSletanja());
        ef.getPanel().setDatumLeta(let.getDatumLeta());

    }

// Promenljivo!!!
    void isprazniGrafickiObjekat() {
        ef.getPanel().setSifraLeta("");
        ef.getPanel().setAvioKompanija("");
        ef.getPanel().setSifraAviona("000000");
        ef.getPanel().setPilot("");
        ef.getPanel().setMestoUzletanja("");
        ef.getPanel().setMestoSletanja("");
        ef.getPanel().setDatumLeta(new java.util.Date());
    }

    void prikaziPoruku() {
        ef.getPanel().setPoruka(poruka);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ef.getPanel().setPoruka("");
            }
        }, 10000);

    }

    void prikaziPoruku(String poruka) {
        ef.getPanel().setPoruka(poruka);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ef.getPanel().setPoruka("");
            }
        }, 1000);

    }

    void osveziFormu() {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                napuniDomenskiObjekatIzGrafickogObjekta();
                nadjiDomenskiObjekat();
                prikaziPoruku("Osvezavanje forme!!!");
            }
        }, 0, 60000);

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

    @Override
    public boolean zapamtiDomenskiObjekat() {

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

    @Override
    public boolean kreirajDomenskiObjekat() {
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

    @Override
    public boolean obrisiDomenskiObjekat() {
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

    @Override
    public boolean promeniDomenskiObjekat() {
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

    @Override
    public boolean nadjiDomenskiObjekat() {
        boolean signal;
        bbp.makeConnection();
        let = (DKLet) bbp.findRecord(let); // Promenljivo!!!
        if (let != null) {
            napuniGrafickiObjekatIzDomenskogObjekta(let);
            poruka = "Sistem je pronasao let.";  // Promenljivo!!!
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

class OsluskivacZapamti1 implements ActionListener {

    Kontroler2 kon;

    OsluskivacZapamti1(Kontroler2 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.zapamtiDomenskiObjekat();

    }
}

class OsluskivacKreiraj1 implements ActionListener {

    Kontroler2 kon;

    OsluskivacKreiraj1(Kontroler2 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.kreirajDomenskiObjekat();

    }
}

class OsluskivacObrisi1 implements ActionListener {

    Kontroler2 kon;

    OsluskivacObrisi1(Kontroler2 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.obrisiDomenskiObjekat();

    }
}

class OsluskivacPromeni1 implements ActionListener {

    Kontroler2 kon;

    OsluskivacPromeni1(Kontroler2 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.promeniDomenskiObjekat();

    }
}

class OsluskivacNadji11 implements ActionListener {

    Kontroler2 kon;

    OsluskivacNadji11(Kontroler2 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }
}

class OsluskivacNadji12 implements FocusListener {

    Kontroler2 kon;

    OsluskivacNadji12(Kontroler2 kon1) {
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
