package ConcreteStrategy;

import AbstractProductB.BrokerBazePodataka;
import AbstractProductC.Kontroler;
import Strategy.SistemskaOperacija;

public class ZapamtiDomenskiObjekat implements SistemskaOperacija { // Receiver

    BrokerBazePodataka bbp;
    Kontroler kon;

    public ZapamtiDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    @Override
    public boolean izvrsiSO() {
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
