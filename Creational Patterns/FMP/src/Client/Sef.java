package Client;

import Creator.*;

public class Sef { // Client

    Projektant proj; // Creator   

    Sef(Projektant proj1) {
        proj = proj1;
    }

    public static void main(String args[]) {
        Sef sef;
        // ConcreteCreator
        Projektant proj = new Projektant1(); // Promenljivo!!!
        sef = new Sef(proj);
        sef.Kreiraj();
    }

    void Kreiraj() {
        proj.Kreiraj();
    }

}
