package Builder;

import AbstractProductA.*;
import AbstractProductB.*;
import Client.Kontroler1;

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
    public void kreirajBrokerBazePodataka() {
        ss.bbp = new BrokerBazePodataka1(); // promenljivo!!!
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
