package ConcreteStrategy;

import AbstractProductB.BrokerBazePodataka;
import AbstractProductC.Kontroler;
import DomainClasses.DKLet;
import Strategy.SistemskaOperacija;
import java.util.concurrent.atomic.AtomicInteger;

public class KreirajDomenskiObjekat implements SistemskaOperacija { // Receiver

    BrokerBazePodataka bbp;
    Kontroler kon;

    public KreirajDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    @Override
    public boolean izvrsiSO() {
        boolean signal;
        DKLet let = new DKLet(); // Promenljivo!!!
        AtomicInteger counter = new AtomicInteger(0);

        bbp.makeConnection();
        if (!bbp.getCounter(let, counter)) {
            return false;
        }
        if (!bbp.increaseCounter(let, counter)) {
            return false;
        }

        let.setSifraLeta(counter.get()); // Promenljivo!!!
        signal = bbp.insertRecord(let);
        if (signal == true) {
            bbp.commitTransation();
            kon.napuniGrafickiObjekatIzDomenskogObjekta(let);
            kon.setPoruka("Sistem je kreirao let."); // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            kon.isprazniGrafickiObjekat();
            kon.setPoruka("Sistem nije kreirao let."); // Promenljivo!!!
        }
        kon.prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}
