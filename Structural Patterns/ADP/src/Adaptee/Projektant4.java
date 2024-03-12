package Adaptee;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

// Promenljivo!!!
public class Projektant4 extends Projektant {

    @Override
    public void kreirajSoftverskiSistem() {
        ss = new SoftverskiSistem();
    }

    @Override
    public void kreirajEkranskuFormu() {
        Panel pan = new Panel2(); // promenljivo!!! 
        ss.ef = new EkranskaForma1(); // promenljivo!!!
        ss.ef.setPanel(pan);
    }

    @Override
    public void kreirajBrokerBazePodataka() {
        ss.bbp = new BrokerBazePodataka2(); // promenljivo!!!
    }

    @Override
    public void kreirajKontroler() {
        ss.kon = new Kontroler2(ss.ef, ss.bbp); // promenljivo!!!
    }

    @Override
    public void prikaziEkranskuFormu() {
        ss.ef.prikaziEkranskuFormu();
    }
}
