package Creator;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;
import Product.*;

public abstract class Projektant { // Creator

    SoftverskiSistem ss;

    abstract EkranskaForma kreirajEkranskuFormu();

    abstract BrokerBazePodataka kreirajBrokerBazePodataka();

    abstract Kontroler kreirajKontroler(EkranskaForma ef, BrokerBazePodataka bbp);

    public void Kreiraj() {
        EkranskaForma ef = kreirajEkranskuFormu();
        BrokerBazePodataka bbp = kreirajBrokerBazePodataka();
        Kontroler kon = kreirajKontroler(ef, bbp);
        ss = new SoftverskiSistem1(ef, bbp, kon);
        ss.prikaziEkranskuFormu();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
        ss.zatvoriEkranskuFormu();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
        SoftverskiSistem ss1 = ss.Clone();
        ss1.prikaziEkranskuFormu();
    }
}
