package AbstractProductC;

import AbstractProductA.Forma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKLet;

public abstract class Kontroler {

    Forma ef;
    BrokerBazePodataka bbp;
    DKLet let;   // Promenljivo!!!
    String poruka;

    public void Povezi(Kontroler kon) {
    }

    public abstract boolean zapamtiDomenskiObjekat();

    public abstract boolean kreirajDomenskiObjekat();

    public abstract boolean obrisiDomenskiObjekat();

    public abstract boolean promeniDomenskiObjekat();

    public abstract boolean nadjiDomenskiObjekat();

    public void napuniDomenskiObjekatIzGrafickogObjekta() {
    }

    public Forma getEkranskaForma() {
        return ef;
    }
}
