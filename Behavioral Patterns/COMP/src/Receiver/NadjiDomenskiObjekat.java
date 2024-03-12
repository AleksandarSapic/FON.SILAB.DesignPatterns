package Receiver;

import Client.Kontroler;
import DomainClasses.DKLet;

public class NadjiDomenskiObjekat { // Receiver

    Kontroler kon;

    public NadjiDomenskiObjekat(Kontroler kon1) {
        kon = kon1;
    }

    public boolean nadjiDomenskiObjekat() {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        boolean signal;
        kon.getBrokerBazePodataka().makeConnection();
        DKLet let = (DKLet) kon.getBrokerBazePodataka().findRecord(kon.getDomenskiObjekat()); // Promenljivo!!!
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
        kon.getBrokerBazePodataka().closeConnection();
        return signal;
    }

}
