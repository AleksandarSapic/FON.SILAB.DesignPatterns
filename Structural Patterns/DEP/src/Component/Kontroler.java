package Component;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKLet;

public abstract class Kontroler { // Component

    protected EkranskaForma ef;
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

    public EkranskaForma getEkranskaForma() {
        return ef;
    }

    public void setIkonu(String nazivIkone) {
    }

    public void startAudioKlip(String nazivKlipa) {
    }
}
