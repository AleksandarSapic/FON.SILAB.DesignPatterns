package Client;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKLet;
import DomainClasses.GeneralDObject;

public abstract class Kontroler {

    protected EkranskaForma ef;
    protected BrokerBazePodataka bbp;
    DKLet let;   // Promenljivo!!!
    String poruka;

    public void napuniGrafickiObjekatIzDomenskogObjekta(GeneralDObject gdo) {
    }

    public void napuniDomenskiObjekatIzGrafickogObjekta() {
    }

    public void isprazniGrafickiObjekat() {
    }

    public void setPoruka(String poruka1) {
        poruka = poruka1;
    }

    public void prikaziPoruku() {
    }

    public void prikaziPoruku(String s) {
    }

    public EkranskaForma getEkranskaForma() {
        return ef;
    }

    public BrokerBazePodataka getBrokerBazePodataka() {
        return bbp;
    }

    public GeneralDObject getDomenskiObjekat() {
        return let;
    }
}
