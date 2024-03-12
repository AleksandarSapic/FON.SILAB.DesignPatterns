package ConcreteDecorators;

import Component.Kontroler;
import Decorator.DekoratorKontroler;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public final class KonkretniDekoratorKontroleraB extends DekoratorKontroler {  // ConcretreDecoratorB

    public KonkretniDekoratorKontroleraB(Kontroler pred, Kontroler osnovni) {
        super(pred);
        ef = osnovni.getEkranskaForma();
        Povezi(osnovni);
    }

    // Dadaje se novo ponasanje postojecem ponasanju.
    @Override
    public void Povezi(Kontroler kon) { // Kada se aktivira JFrame fokus se prebacuje na polje BrojIndeksa.

        ef.addWindowListener(new WindowAdapter() {
            @Override
            //public void windowOpened( WindowEvent e ){
            public void windowActivated(WindowEvent e) {
                ef.getPanel().getAvioKompanija1().requestFocus();
                ef.getPanel().getNadji().setVisible(false);
            }
        });

        kon.Povezi(this); // Povezivanje konkretnog dekoratora sa osluskivacem.
    }

    // Dodaje se novo ponasanje postojecem ponasanju.
    @Override
    public boolean kreirajDomenskiObjekat() {
        ef.getPanel().getAvioKompanija1().requestFocusInWindow();
        kon.startAudioKlip("create.wav");
        kon.setIkonu("create.png");
        prikaziOsnovnuIkonu();
        return super.kreirajDomenskiObjekat();
    }

    @Override
    public boolean obrisiDomenskiObjekat() {
        kon.startAudioKlip("delete.wav");
        kon.setIkonu("delete.jpg");
        prikaziOsnovnuIkonu();
        return super.obrisiDomenskiObjekat();
    }

    @Override
    public boolean promeniDomenskiObjekat() {
        kon.startAudioKlip("update.wav");
        kon.setIkonu("update.jpg");
        prikaziOsnovnuIkonu();
        return super.promeniDomenskiObjekat();
    }

    @Override
    public boolean nadjiDomenskiObjekat() {
        kon.startAudioKlip("find.wav");
        kon.setIkonu("find.jpg");
        prikaziOsnovnuIkonu();
        return super.nadjiDomenskiObjekat();
    }

    public void prikaziOsnovnuIkonu() {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                kon.setIkonu("plane.jpg");
            }
        }, 5000);
    }
}
