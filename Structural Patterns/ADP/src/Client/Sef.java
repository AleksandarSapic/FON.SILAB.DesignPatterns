package Client;

import Adaptee.Projektant;
import Adaptee.Projektant2;
import Adapter.Prevodilac1;
import Target.Prevodilac;

public class Sef { // Client

    Prevodilac pse; //    

    Sef(Prevodilac pse1) {
        pse = pse1;
    }

    public static void main(String args[]) {

        Projektant proj = new Projektant2(); // promenljivo!!!
        Prevodilac pse = new Prevodilac1(proj);
        Sef sef = new Sef(pse);
        sef.Konstruisi();
    }

    void Konstruisi() {
        pse.createSoftwareSystem();
        pse.createScreenForm();
        pse.createDatabaseBroker();
        pse.createController();
        pse.showScreenForm();
    }

}
