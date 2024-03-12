package Creator;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

public class Projektant4 extends Projektant { //ConcreteCreator

    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel pan = new Panel2(); // Promenljivo!!!
        EkranskaForma ef = new EkranskaForma1(); // Promenljivo!!!
        ef.setPanel(pan);
        return ef;
    }

    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka() {
        return new BrokerBazePodataka2(); // Promenljivo!!!
    }

    @Override
    public Kontroler kreirajKontroler(EkranskaForma ef, BrokerBazePodataka bbp) {
        return new Kontroler2(ef, bbp); // Promenljivo!!!
    }
}
