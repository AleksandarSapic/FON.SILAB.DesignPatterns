package Builder;

import AbstractProductB.BrokerBazePodataka;
import AbstractProductA.*;
import AbstractProductC.*;
import Subject.Subject;

public abstract class Projektant {

    class SoftverskiSistem // Complex Product
    {

        EkranskaForma ef; // AbstractProductA 
        BrokerBazePodataka bbp; // AbstractProductB 
        Kontroler kon; // AbstractProductC 
    }

    SoftverskiSistem ss;

    abstract public void kreirajEkranskuFormu();

    abstract public void kreirajBrokerBazePodataka(Subject sub);

    abstract public void kreirajKontroler();

    abstract public void kreirajSoftverskiSistem();

    abstract public void prikaziEkranskuFormu();

    public Kontroler vratiKontroler() {
        return ss.kon;
    }
}
