package ConcreteState;

import AbstractProductC.Kontroler;
import DomainClasses.DKLet;
import State.Stanje;

public class Obradjen extends Stanje {

    public Obradjen(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void obradiDomenskiObjekat() {
        kon.setPoruka("Ne moze da se obradi obradjen let!");
        kon.prikaziPoruku();
        kon.nadjiDomenskiObjekat1();
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
        kon.setPoruka("Ne moze da se promeni obradjen let!");
        kon.prikaziPoruku();
        kon.nadjiDomenskiObjekat1();

    }

}
