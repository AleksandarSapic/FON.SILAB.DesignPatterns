package Proxy;

import RealSubject.Kontroler1;
import Subject.Kontroler;

public class ProxyKontroler extends Kontroler { // Proxy

    protected Kontroler1 kon;

    public ProxyKontroler(Kontroler1 kon1) {
        kon = kon1;
        kon.Povezi(this);
    }

    @Override
    public boolean zapamtiDomenskiObjekat() {
        return kon.zapamtiDomenskiObjekat();
    }

    @Override
    public boolean kreirajDomenskiObjekat() {
        return kon.kreirajDomenskiObjekat();
    }

    @Override
    public boolean obrisiDomenskiObjekat() {
        kon.prikaziPoruku("Zabranjeno je brisanje leta!!!");
        return false;
    }

    @Override
    public boolean promeniDomenskiObjekat() {
        return kon.promeniDomenskiObjekat();
    }

    @Override
    public boolean nadjiDomenskiObjekat() {
        return kon.nadjiDomenskiObjekat();
    }

    @Override
    public void napuniDomenskiObjekatIzGrafickogObjekta() {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
    }

}
