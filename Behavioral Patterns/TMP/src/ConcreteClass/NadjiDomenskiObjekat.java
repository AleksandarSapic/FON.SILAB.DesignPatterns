package ConcreteClass;

import AbstractClass.OpstaDBSO;
import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import DomainClasses.GeneralDObject;

public class NadjiDomenskiObjekat extends OpstaDBSO { // ConcreteClass

    public NadjiDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        super(bbp1, kon1);
    }

    @Override
    public boolean konkretnaDBSO() // find record
    {
        GeneralDObject gdo = bbp.findRecord(kon.getDomenskiObjekat());
        if (gdo != null) {
            kon.setDomenskiObjekat(gdo);
        } else {
            kon.isprazniGrafickiObjekat();
        }
        return (gdo != null);
    }

    @Override
    public void uspesnaDBOperacija() {
        kon.napuniGrafickiObjekatIzDomenskogObjekta(kon.getDomenskiObjekat());
        kon.setPoruka("Sistem je pronasao let.");
    }

    @Override
    public void neuspesnaDBOperacija() {
        kon.isprazniGrafickiObjekat();
        kon.setPoruka("Sistem nije pronasao let.");
    }

}
