package ConcreteClass;

import AbstractClass.OpstaDBSO;
import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import DomainClasses.DKLet;
import DomainClasses.GeneralDObject;
import java.util.concurrent.atomic.AtomicInteger;

public class KreirajDomenskiObjekat extends OpstaDBSO { // ConcreteClass

    public KreirajDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        super(bbp1, kon1);
    }

    @Override
    public void makeConnection() {
        bbp.makeConnection();
    }

    @Override
    public boolean konkretnaDBSO() // insert record
    {
        kon.isprazniGrafickiObjekat();
        GeneralDObject let = kon.getDomenskiObjekat();
        AtomicInteger counter = new AtomicInteger(0);

        if (!bbp.getCounter(let, counter)) {
            return false;
        }
        if (!bbp.increaseCounter(let, counter)) {
            return false;
        }

        ((DKLet) let).setSifraLeta(counter.get()); // Promenljivo!!!

        return bbp.insertRecord(let);

    }

    @Override
    public void uspesnaDBOperacija() {
        bbp.commitTransation();
        kon.setPoruka("Sistem je kreirao let.");
        kon.napuniGrafickiObjekatIzDomenskogObjekta(kon.getDomenskiObjekat());
    }

    @Override
    public void neuspesnaDBOperacija() {
        bbp.rollbackTransation();
        kon.isprazniGrafickiObjekat();
        kon.setPoruka("Sistem nije kreirao let.");
    }

}
