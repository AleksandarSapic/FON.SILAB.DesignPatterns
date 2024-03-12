package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;

public class ObrisiDomenskiObjekat {

    BrokerBazePodataka bbp;
    Kontroler kon;

    public ObrisiDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    public boolean obrisiDomenskiObjekat() {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        bbp.makeConnection();
        boolean signal = bbp.deleteRecord(kon.getDomenskiObjekat());
        if (signal == true) {
            bbp.commitTransation();
            kon.setPoruka("Sistem je obrisao let."); // Promenljivo!!!
            kon.isprazniGrafickiObjekat();
        } else {
            bbp.rollbackTransation();
            kon.setPoruka("Sistem nije obrisao let."); // Promenljivo!!!
        }
        kon.prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }
}
