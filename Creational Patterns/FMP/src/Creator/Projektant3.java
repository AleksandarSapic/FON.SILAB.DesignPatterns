package Creator;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

public class Projektant3 extends Projektant { //ConcreteCreator

    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel pan = new Panel1(); // Promenljivo!!!
        EkranskaForma ef = new EkranskaForma2(); // Promenljivo!!!
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
