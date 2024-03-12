package Memento;

import DomainClasses.DKLet;

public class Memento {

    DKLet dklet;

    public Memento(DKLet dklet) {
        this.dklet = dklet;
    }

    public DKLet getState() {
        return dklet;
    }

    public void setState(DKLet dklet) {
        this.dklet = dklet;
    }
}
