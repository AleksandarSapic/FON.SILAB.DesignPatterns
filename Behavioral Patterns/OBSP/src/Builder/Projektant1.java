package Builder;

import AbstractProductB.BrokerBazePodataka1;
import AbstractProductA.*;
import AbstractProductC.*;
import Subject.Subject;

// Promenljivo!!!
public class Projektant1 extends Projektant {

    @Override
    public void kreirajSoftverskiSistem() {
        ss = new SoftverskiSistem();
    }

    @Override
    public void kreirajEkranskuFormu() {
        Panel pan = new Panel1(); // promenljivo!!!
        ss.ef = new EkranskaForma2(); // promenljivo!!!
        ss.ef.setPanel(pan);
    }

    @Override
    public void kreirajBrokerBazePodataka(Subject sub) {
        ss.bbp = new BrokerBazePodataka1(sub); // promenljivo!!!
    }

    @Override
    public void kreirajKontroler() {
        ss.kon = new Kontroler1(ss.ef, ss.bbp); // promenljivo!!!
    }

    @Override
    public void prikaziEkranskuFormu() {
        ss.ef.prikaziEkranskuFormu();
    }

}
