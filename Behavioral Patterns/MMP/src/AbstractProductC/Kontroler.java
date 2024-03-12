package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKLet;
import Memento.Memento;
import Originator.Originator;

public abstract class Kontroler {

    EkranskaForma ef;
    BrokerBazePodataka bbp;
    DKLet let;   // Promenljivo!!!  
    Memento memento;
    Originator orig;
    String poruka;

}
