package Receiver;

import Client.Kontroler;
import DomainClasses.DKLet;
import java.util.concurrent.atomic.AtomicInteger;

public class KreirajDomenskiObjekat { // Receiver

    Kontroler kon;

    public KreirajDomenskiObjekat(Kontroler kon1) {
        kon = kon1;
    }

    public boolean kreirajDomenskiObjekat() {
        boolean signal;
        DKLet let = new DKLet(); // Promenljivo!!!
        AtomicInteger counter = new AtomicInteger(0);

        kon.getBrokerBazePodataka().makeConnection();
        if (!kon.getBrokerBazePodataka().getCounter(let, counter)) {
            return false;
        }
        if (!kon.getBrokerBazePodataka().increaseCounter(let, counter)) {
            return false;
        }

        let.setSifraLeta(counter.get()); // Promenljivo!!!
        signal = kon.getBrokerBazePodataka().insertRecord(let);
        if (signal == true) {
            kon.getBrokerBazePodataka().commitTransation();
            kon.napuniGrafickiObjekatIzDomenskogObjekta(let);
            kon.setPoruka("Sistem je kreirao let."); // Promenljivo!!!
        } else {
            kon.getBrokerBazePodataka().rollbackTransation();
            kon.isprazniGrafickiObjekat();
            kon.setPoruka("Sistem nije kreirao let."); // Promenljivo!!!
        }
        kon.prikaziPoruku();
        kon.getBrokerBazePodataka().closeConnection();
        return signal;
    }

}
