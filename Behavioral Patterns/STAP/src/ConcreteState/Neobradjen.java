package ConcreteState;

import AbstractProductC.Kontroler;
import DomainClasses.DKLet;
import State.Stanje;

public class Neobradjen extends Stanje {

    public Neobradjen(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void obradiDomenskiObjekat() {
        DKLet dk = (DKLet) kon.getDKObject();
        dk.setStanje("obradjen");
        kon.promeniDomenskiObjekat();
        kon.napuniGrafickiObjekatIzDomenskogObjekta(dk);
    }

    @Override
    public void stornirajDomenskiObjekat() {
        DKLet dk = (DKLet) kon.getDKObject();
        dk.setStanje("storniran");
        kon.promeniDomenskiObjekat();
        kon.napuniGrafickiObjekatIzDomenskogObjekta(dk);
    }

    @Override
    public void promeniDomenskiObjekat() {
        kon.promeniDomenskiObjekat();
    }

}
