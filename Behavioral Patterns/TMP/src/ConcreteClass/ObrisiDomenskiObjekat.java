package ConcreteClass;

import AbstractClass.OpstaDBSO;
import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;

public class ObrisiDomenskiObjekat extends OpstaDBSO { // ConcreteClass

    public ObrisiDomenskiObjekat(BrokerBazePodataka bbp1, Kontroler kon1) {
        super(bbp1, kon1);
    }

    @Override
    public boolean konkretnaDBSO() // delete record
    {
        return bbp.deleteRecord(kon.getDomenskiObjekat());
    }

    @Override
    public void uspesnaDBOperacija() {
        bbp.commitTransation();
        kon.setPoruka("Sistem je obrisao let.");
        kon.isprazniGrafickiObjekat();
    }

    @Override
    public void neuspesnaDBOperacija() {
        bbp.rollbackTransation();
        kon.setPoruka("Sistem nije obrisao let.");
    }
}
