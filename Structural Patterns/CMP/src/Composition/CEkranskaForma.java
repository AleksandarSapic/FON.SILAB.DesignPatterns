package Composition;

import AbstractProductA.EkranskaForma;

public class CEkranskaForma extends Kompozicija {

    EkranskaForma ef;

    public CEkranskaForma(EkranskaForma ef1) {
        ef = ef1;
    }

    @Override
    public Object getTipKomponente() {
        return ef.getClass();
    }
}
