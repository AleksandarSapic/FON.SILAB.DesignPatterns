package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import DomainClasses.DKLet;

public class NadjiDomenskiObjekat { // Receiver

    BrokerBazePodataka bbp;
    Kontroler kon;

    public NadjiDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    public boolean nadjiDomenskiObjekat() {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        boolean signal;
        bbp.makeConnection();
        DKLet let = (DKLet) bbp.findRecord(kon.getDomenskiObjekat()); // Promenljivo!!!
        if (let != null) {
            kon.napuniGrafickiObjekatIzDomenskogObjekta(let);
            kon.setPoruka("Sistem je pronasao let."); // Promenljivo!!!
            signal = true;
        } else {
            kon.isprazniGrafickiObjekat();
            kon.setPoruka("Sistem nije pronasao let."); // Promenljivo!!!
            signal = false;
        }
        kon.prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}
