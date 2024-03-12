package Component;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKLet;
import Visitor.Visitor;

public abstract class Kontroler {

    protected EkranskaForma ef;
    protected BrokerBazePodataka bbp;
    protected DKLet let;   // Promenljivo!!!
    protected String poruka;

    public void Povezi(Kontroler kon) {
    }

    public boolean promeniDomenskiObjekat(Visitor vis) {
        return false;
    }

    public boolean zapamtiDomenskiObjekat(Visitor vis) {
        return false;
    }

    public boolean kreirajDomenskiObjekat(Visitor vis) {
        return false;
    }

    public boolean obrisiDomenskiObjekat(Visitor vis) {
        return false;
    }

    public boolean nadjiDomenskiObjekat(Visitor vis) {
        return false;
    }

    public void napuniDomenskiObjekatIzGrafickogObjekta() {
    }

    public EkranskaForma getEkranskaForma() {
        return ef;
    }

    public void setIkonu(String nazivIkone) {
    }

    public void startAudioKlip(String nazivKlipa) {
    }

    public void prikaziOsnovnuIkonu() {
    }

    public void prikaziPoruku(String poruka) {
    }

}
