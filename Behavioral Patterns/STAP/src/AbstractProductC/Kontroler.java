package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKLet;
import DomainClasses.GeneralDObject;

public abstract class Kontroler {

    EkranskaForma ef;
    BrokerBazePodataka bbp;
    DKLet let;   // Promenljivo!!!
    String poruka;

    public GeneralDObject getDKObject() {
        return let;
    }

    public abstract boolean promeniDomenskiObjekat();

    public void setPoruka(String poruka1) {
        poruka = poruka1;
    }

    public abstract void prikaziPoruku();

    abstract public void napuniGrafickiObjekatIzDomenskogObjekta(DKLet let);

    abstract public boolean nadjiDomenskiObjekat1();
}
