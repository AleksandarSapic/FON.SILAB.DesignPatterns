package Composition;

import AbstractProductC.Kontroler;

public class CKontroler extends Kompozicija {

    Kontroler kon;

    public CKontroler(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public Object getTipKomponente() {
        return kon.getClass();
    }
}
