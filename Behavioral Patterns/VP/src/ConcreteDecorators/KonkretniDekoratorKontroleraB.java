package ConcreteDecorators;

import Component.Kontroler;
import Decorator.DekoratorKontroler;
import Visitor.Visitor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class KonkretniDekoratorKontroleraB extends DekoratorKontroler {  // ConcretreDecoratorB

    Kontroler konOsnovni;

    public KonkretniDekoratorKontroleraB(Kontroler pred, Kontroler osnovni) {
        super(pred);
        ef = osnovni.getEkranskaForma();
        Povezi(osnovni);
        konOsnovni = osnovni;
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

    public Kontroler vratiKonOsnovni() {
        return konOsnovni;
    }

    @Override
    public void prikaziPoruku(String poruka) {
        konOsnovni.prikaziPoruku(poruka);
    }

    @Override
    public void visitorPromeni(Visitor vis) {
        vis.visitKontrolerB(this);
    }

    @Override
    public void visitorKreiraj(Visitor vis) {
        vis.visitKontrolerB(this);
    }

    @Override
    public void visitorNadji(Visitor vis) {
        vis.visitKontrolerB(this);
    }

    @Override
    public void visitorObrisi(Visitor vis) {
        vis.visitKontrolerB(this);
    }

}
