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

    public abstract void napuniDomenskiObjekatIzGrafickogObjekta();

    public abstract boolean nadjiDomenskiObjekat();
}
