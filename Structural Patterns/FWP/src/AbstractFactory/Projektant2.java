package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

// Promenljivo!!!
public class Projektant2 implements Projektant {

    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        IPanel pan = new Panel1(); // Promenljivo!!!
        EkranskaForma1 ip = new EkranskaForma1(); // Promenljivo!!!
        ip.setPanel(pan);
        return ip;
    }

    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka() {
        BrokerBazePodataka dbbr = new BrokerBazePodataka2(); // Promenljivo!!!
        return dbbr;
    }

    @Override
    public Kontroler kreirajKontroler(EkranskaForma ef, BrokerBazePodataka dbbr) {
        Kontroler kon = new Kontroler1(ef, dbbr); // Promenljivo!!!
        return kon;
    }

}
