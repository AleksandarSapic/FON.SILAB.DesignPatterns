package Composition;

import Component.Komponenta;

public class Kompozicija extends Komponenta {

    Komponenta kom[];
    int brojKomponenti;

    Kompozicija() {
        kom = new Komponenta[5];
        brojKomponenti = 0;
    }

    @Override
    public void add(Komponenta kom1) {
        if (brojKomponenti < 5) {
            kom[brojKomponenti++] = kom1;
        }
    }

    @Override
    public int getBrojKomponenti() {
        return brojKomponenti;
    }

    @Override
    public Komponenta getKomponenta(int i) {
        return kom[i];
    }

    @Override
    public Object getTipKomponente() {
        return this.getClass();
    }
}
