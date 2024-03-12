package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

// Promenljivo!!!
public class Projektant3 implements Projektant {

    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        IPanel pan = new Panel2(); // Promenljivo!!!
        EkranskaForma2 ip = new EkranskaForma2(); // Promenljivo!!!
        ip.setPanel(pan);
        return ip;
    }

    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka() {
        BrokerBazePodataka dbbr = new BrokerBazePodataka1(); // Promenljivo!!!
        return dbbr;
    }

    @Override
    public Kontroler kreirajKontroler(EkranskaForma ef, BrokerBazePodataka dbbr) {
        Kontroler kon = new Kontroler2(ef, dbbr); // Promenljivo!!!
        return kon;
    }

}
