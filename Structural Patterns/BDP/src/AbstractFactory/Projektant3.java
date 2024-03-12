package AbstractFactory;

import AbstractProductA.*;
import AbstractProductC.*;
import Abstraction.BrokerBazePodataka;
import Abstraction.BrokerBazePodataka2;

// Promenljivo!!!
public class Projektant3 implements Projektant {

    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        IPanel pan = new Panel1(); // Promenljivo!!!
        EkranskaForma2 ip = new EkranskaForma2(); // Promenljivo!!!
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
        Kontroler kon = new Kontroler2(ef, dbbr); // Promenljivo!!!
        return kon;
    }

}
