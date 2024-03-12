package Director;

import Builder.*;
import Observer.ConcreteObserver;
import Observer.Observer;
import Subject.Subject;

public class Sef { // Director

    Projektant proj; // Builder   

    Sef(Projektant proj1) {
        proj = proj1;
    }

    public static void main(String args[]) {
        Sef sef;
        Subject sub = new Subject();

        Projektant proj = new Projektant1();
        sef = new Sef(proj);
        sef.Konstruisi(sub);
        Observer ob1 = new ConcreteObserver(proj.vratiKontroler());
        sub.setObserver(0, ob1);

        Projektant proj1 = new Projektant1();
        sef = new Sef(proj1);
        sef.Konstruisi(sub);
        Observer ob2 = new ConcreteObserver(proj1.vratiKontroler());
        sub.setObserver(1, ob2);

        Projektant proj2 = new Projektant1();
        sef = new Sef(proj2);
        sef.Konstruisi(sub);
        Observer ob3 = new ConcreteObserver(proj2.vratiKontroler());
        sub.setObserver(2, ob3);
    }

    void Konstruisi(Subject sub) {
        proj.kreirajSoftverskiSistem();
        proj.kreirajEkranskuFormu();
        proj.kreirajBrokerBazePodataka(sub);
        proj.kreirajKontroler();
        proj.prikaziEkranskuFormu();
    }
}
