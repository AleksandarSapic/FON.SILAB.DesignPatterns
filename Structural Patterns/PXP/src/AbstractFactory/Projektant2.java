package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import RealSubject.Kontroler1;
import Subject.Kontroler;

// Promenljivo!!!
public class Projektant2 implements Projektant {

    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        IPanel pan = new Panel2(); // Promenljivo!!!
        EkranskaForma1 ip = new EkranskaForma1(); // Promenljivo!!!
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
        Kontroler kon = new Kontroler1(ef, dbbr); // Promenljivo!!!
        return kon;
    }

}
