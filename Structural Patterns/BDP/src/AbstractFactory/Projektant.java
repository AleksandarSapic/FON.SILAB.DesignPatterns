package AbstractFactory;

import AbstractProductA.*;
import AbstractProductC.*;
import Abstraction.BrokerBazePodataka;

public interface Projektant {

    EkranskaForma kreirajEkranskuFormu();

    BrokerBazePodataka kreirajBrokerBazePodataka();

    Kontroler kreirajKontroler(EkranskaForma ef, BrokerBazePodataka dbbr);
}
