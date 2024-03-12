package AbstractClass;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;

abstract public class OpstaDBSO { // AbstractClass

    protected BrokerBazePodataka bbp;
    protected Kontroler kon;

    public OpstaDBSO(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    public boolean opstaDBSO() {
        boolean signal;
        makeConnection();
        signal = konkretnaDBSO();
        if (signal == true) {
            uspesnaDBOperacija();
        } else {
            neuspesnaDBOperacija();
        }
        closeConnection();
        return signal;
    }

    protected void makeConnection() {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        bbp.makeConnection();
    }

    protected void closeConnection() {
        kon.prikaziPoruku();
        bbp.closeConnection();
    }

    protected abstract boolean konkretnaDBSO();

    protected abstract void uspesnaDBOperacija();

    protected abstract void neuspesnaDBOperacija();

}
