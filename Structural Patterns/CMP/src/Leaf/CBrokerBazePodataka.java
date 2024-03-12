package Leaf;

import AbstractProductB.BrokerBazePodataka;

public class CBrokerBazePodataka extends List {

    BrokerBazePodataka bbp;

    public CBrokerBazePodataka(BrokerBazePodataka bbp1) {
        bbp = bbp1;
    }

    @Override
    public Object getTipKomponente() {
        return bbp.getClass();
    }
}
