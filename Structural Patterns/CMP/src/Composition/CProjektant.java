package Composition;

import AbstractFactory.Projektant;

public class CProjektant extends Kompozicija {

    Projektant proj;

    public CProjektant(Projektant proj1) {
        proj = proj1;
    }

    @Override
    public Object getTipKomponente() {
        return proj.getClass();
    }
}
