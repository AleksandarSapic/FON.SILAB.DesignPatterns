package AbstractProductC;

import AbstractProductA.EkranskaForma;
import Abstraction.BrokerBazePodataka;
import ConcreteImplementor.DKLet;

public abstract class Kontroler {

    EkranskaForma ef;
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

    public EkranskaForma getEkranskaForma() {
        return ef;
    }
}
