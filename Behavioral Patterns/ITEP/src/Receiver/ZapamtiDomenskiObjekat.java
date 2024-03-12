package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;

public class ZapamtiDomenskiObjekat { // Receiver

    BrokerBazePodataka bbp;
    Kontroler kon;

    public ZapamtiDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    public boolean zapamtiDomenskiObjekat() {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        bbp.makeConnection();
        boolean signal = bbp.insertRecord(kon.getDomenskiObjekat());
        if (signal == true) {
            bbp.commitTransation();
            kon.setPoruka("Sistem je zapamtio let."); // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            kon.isprazniGrafickiObjekat();
            kon.setPoruka("Sistem nije zapamtio let."); // Promenljivo!!!
        }
        kon.prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}
