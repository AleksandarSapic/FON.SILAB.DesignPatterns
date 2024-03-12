package Decorator;

import Component.Kontroler;
import Visitor.Visitor;

public class DekoratorKontroler extends Kontroler { // Decorator

    protected Kontroler kon;
    boolean promeni = true;

    public DekoratorKontroler(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public boolean kreirajDomenskiObjekat(Visitor vis) {
        visitorKreiraj(vis);
        return kon.kreirajDomenskiObjekat(vis);
    }

    @Override
    public boolean obrisiDomenskiObjekat(Visitor vis) {
        visitorObrisi(vis);
        return kon.obrisiDomenskiObjekat(vis);
    }

    @Override
    public boolean promeniDomenskiObjekat(Visitor vis) {
        visitorPromeni(vis);
        if (promeni) {
            return kon.promeniDomenskiObjekat(vis);
        }
        return false;
    }

    @Override
    public boolean nadjiDomenskiObjekat(Visitor vis) {
        visitorNadji(vis);
        return kon.nadjiDomenskiObjekat(vis);
    }

    @Override
    public void napuniDomenskiObjekatIzGrafickogObjekta() {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
    }

    public Kontroler getSledeci() {
        return kon;
    }

    public void visitorKreiraj(Visitor vis) {
    }

    public void visitorNadji(Visitor vis) {
    }

    public void visitorObrisi(Visitor vis) {
    }

    public void visitorPromeni(Visitor vis) {
    }

    public void postaviPromeni(boolean promeni1) {
        promeni = promeni1;
    }
}
