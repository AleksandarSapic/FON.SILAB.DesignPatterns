package Subject;

import AbstractProductA.Forma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKLet;

public abstract class Kontroler {

    protected Forma ef;
    protected BrokerBazePodataka bbp;
    protected DKLet let;   // Promenljivo!!!
    protected String poruka;

    public void Povezi(Kontroler kon) {
    }

    public abstract boolean zapamtiDomenskiObjekat();

    public abstract boolean kreirajDomenskiObjekat();

    public abstract boolean obrisiDomenskiObjekat();

    public abstract boolean promeniDomenskiObjekat();

    public abstract boolean nadjiDomenskiObjekat();

    public void napuniDomenskiObjekatIzGrafickogObjekta() {
    }
}
