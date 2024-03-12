package Client;

import AbstractFactory.Projektant;
import AbstractFactory.*;
import AbstractProductA.*;
import AbstractProductB.*;
import Subject.Kontroler;

public class Sef { // Client

    Projektant proj; // Abstract Factory   

    public class SoftverskiSistem // Complex Product
    {

        public EkranskaForma ef; // AbstractProductA 
        public BrokerBazePodataka bbp; // AbstractProductB 
        public Kontroler kon; // AbstractProductC 

        SoftverskiSistem(EkranskaForma ef1, BrokerBazePodataka bbp1, Kontroler kon1) {
            ef = ef1;
            bbp = bbp1;
            kon = kon1;
        }

        void prikaziEkranskuFormu(Sef sef) {
            ef.prikaziEkranskuFormu(sef);
        }

    }
    public SoftverskiSistem ss;

    Sef(Projektant proj1) {
        proj = proj1;
    }

    public static void main(String args[]) {
        Sef sef;
        // ConcreteFactory1
        Projektant proj = new Projektant1();
        sef = new Sef(proj);
        sef.Kreiraj();
    }

    void Kreiraj() {
        EkranskaForma ef = proj.kreirajEkranskuFormu();
        BrokerBazePodataka bbp = proj.kreirajBrokerBazePodataka();
        Kontroler kon = proj.kreirajKontroler(ef, bbp);
        ss = new SoftverskiSistem(ef, bbp, kon);
        ss.prikaziEkranskuFormu(this);
    }

}
