package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

public interface Projektant {

    Forma kreirajEkranskuFormu();

    BrokerBazePodataka kreirajBrokerBazePodataka();

    Kontroler kreirajKontroler(Forma ef, BrokerBazePodataka dbbr);
}
