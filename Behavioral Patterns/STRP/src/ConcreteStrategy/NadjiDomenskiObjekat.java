package ConcreteStrategy;

import AbstractProductB.BrokerBazePodataka;
import AbstractProductC.Kontroler;
import DomainClasses.DKLet;
import Strategy.SistemskaOperacija;

public class NadjiDomenskiObjekat implements SistemskaOperacija { // Receiver

    BrokerBazePodataka bbp;
    Kontroler kon;

    public NadjiDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        bbp = bbp1;
        kon = kon1;
    }

    @Override
    public boolean izvrsiSO() {
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
