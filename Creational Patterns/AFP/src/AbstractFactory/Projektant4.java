package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

// Promenljivo!!!
public class Projektant4 implements Projektant {

    @Override
    public Forma kreirajEkranskuFormu() {
        IPanel pan = new Panel2(); // Promenljivo!!!
        EkranskaForma ip = new EkranskaForma1(); // Promenljivo!!!
        ip.setPanel(pan);
        return ip;
    }

    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka() {
        BrokerBazePodataka dbbr = new BrokerBazePodataka2(); // Promenljivo!!!
        return dbbr;
    }

    @Override
    public Kontroler kreirajKontroler(Forma ef, BrokerBazePodataka dbbr) {
        Kontroler kon = new Kontroler2(ef, dbbr); // Promenljivo!!!
        return kon;
    }

}
