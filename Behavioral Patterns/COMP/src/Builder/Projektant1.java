package Builder;

import AbstractProductA.*;
import AbstractProductB.*;
import Client.Kontroler1;
import ConcreteCommand.SO;
import Invoker.Invoker;
import Invoker.Invoker1;

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
        SO so = new SO();
        ss.kon = new Kontroler1(ss.ef, ss.bbp, so); // promenljivo!!!
        // povezivanje Invoker i ConcreteCommand
        Invoker in1 = new Invoker(so.sok, ss.kon.getEkranskaForma().getPanel().getKreiraj());
        Invoker in2 = new Invoker(so.sop, ss.kon.getEkranskaForma().getPanel().getPromeni());
        Invoker in3 = new Invoker(so.soo, ss.kon.getEkranskaForma().getPanel().getObrisi());
        Invoker in4 = new Invoker(so.son, ss.kon.getEkranskaForma().getPanel().getNadji());

        Invoker1 in11 = new Invoker1(so.son, ss.kon.getEkranskaForma().getPanel().getSifraLeta1());
    }

    @Override
    public void prikaziEkranskuFormu() {
        ss.ef.prikaziEkranskuFormu();
    }

}
