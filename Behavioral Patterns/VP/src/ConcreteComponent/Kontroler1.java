package ConcreteComponent;

import Component.Kontroler;
import AbstractProductA.*;
import AbstractProductB.*;
import ConcreteVisitor.VisitorKreiraj;
import ConcreteVisitor.VisitorNadji;
import ConcreteVisitor.VisitorObrisi;
import ConcreteVisitor.VisitorPromeni;
import ConcreteVisitor.VisitorZapamti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKLet;  // Promenljivo
import Visitor.Visitor;

public final class Kontroler1 extends Kontroler {

    boolean promeni = true;
    boolean zapamti = true;
    boolean nadji = true;
    boolean obrisi = true;
    boolean kreiraj = true;

    public Kontroler1(EkranskaForma ef1, BrokerBazePodataka bbp1) {
        ef = ef1;
        bbp = bbp1;
        Povezi(null);
    }

    @Override
    public void Povezi(Kontroler kon) {

        if (kon != null) {
            javax.swing.JButton Kreiraj = (javax.swing.JButton) ef.getPanel().getKreiraj();
            javax.swing.JButton Promeni = (javax.swing.JButton) ef.getPanel().getPromeni();
            javax.swing.JButton Obrisi = (javax.swing.JButton) ef.getPanel().getObrisi();
            javax.swing.JButton Nadji = (javax.swing.JButton) ef.getPanel().getNadji();
            Kreiraj.addActionListener(new OsluskivacKreiraj(kon));
            Promeni.addActionListener(new OsluskivacPromeni(kon));
            Obrisi.addActionListener(new OsluskivacObrisi(kon));
            Nadji.addActionListener(new OsluskivacNadji(kon));

            javax.swing.JTextField SifraPrijave = (javax.swing.JTextField) ef.getPanel().getSifraLeta1(); // Promenljivo!!!
            SifraPrijave.addFocusListener(new OsluskivacNadji1(this));
        }
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
    void napuniGrafickiObjekatIzDomenskogObjekta(DKLet let
    ) {
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

    public void prikaziPoruku(String poruka) {
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

    public void Promeni(boolean promeni1) {
        promeni = promeni1;
    }

    public void Zapamti(boolean zapamti1) {
        zapamti = zapamti1;
    }

    public void Nadji(boolean nadji1) {
        nadji = nadji1;
    }

    public void Obrisi(boolean obrisi1) {
        obrisi = obrisi1;
    }

    public void Kreiraj(boolean kreiraj1) {
        kreiraj = kreiraj1;
    }

    @Override
    public boolean zapamtiDomenskiObjekat(Visitor vis) {
        vis.visitKontroler(this);
        if (!zapamti) {
            poruka = "Visitor ne dozvoljava pamcenje nove prijave.";
            prikaziPoruku();
            return false;
        }
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
    public boolean kreirajDomenskiObjekat(Visitor vis) {
        vis.visitKontroler(this);
        if (!zapamti) {
            poruka = "Visitor ne dozvoljava kreiranje prijave.";
            prikaziPoruku();
            return false;
        }
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
    public boolean obrisiDomenskiObjekat(Visitor vis) {
        vis.visitKontroler(this);
        if (!zapamti) {
            poruka = "Visitor ne dozvoljava brisanje prijave.";
            prikaziPoruku();
            return false;
        }
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
    public boolean promeniDomenskiObjekat(Visitor vis) {
        vis.visitKontroler(this);
        if (!zapamti) {
            poruka = "Visitor ne dozvoljava promenu prijave.";
            prikaziPoruku();
            return false;
        }
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
    public boolean nadjiDomenskiObjekat(Visitor vis) {
        vis.visitKontroler(this);
        if (!zapamti) {
            poruka = "Visitor ne dozvoljava pretrazivanje prijave.";
            prikaziPoruku();
            return false;
        }
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

    Kontroler kon;

    OsluskivacZapamti(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.zapamtiDomenskiObjekat(new VisitorZapamti());

    }
}

class OsluskivacKreiraj implements ActionListener {

    Kontroler kon;

    OsluskivacKreiraj(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.kreirajDomenskiObjekat(new VisitorKreiraj());

    }
}

class OsluskivacObrisi implements ActionListener {

    Kontroler kon;

    OsluskivacObrisi(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.obrisiDomenskiObjekat(new VisitorObrisi());

    }
}

class OsluskivacPromeni implements ActionListener {

    Kontroler kon;

    OsluskivacPromeni(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.promeniDomenskiObjekat(new VisitorPromeni());

    }
}

class OsluskivacNadji implements ActionListener {

    Kontroler kon;

    OsluskivacNadji(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat(new VisitorNadji());

    }
}

class OsluskivacNadji1 implements FocusListener {

    Kontroler kon;

    OsluskivacNadji1(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void focusLost(java.awt.event.FocusEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat(new VisitorNadji());
    }

    @Override
    public void focusGained(FocusEvent e) {

    }
}
