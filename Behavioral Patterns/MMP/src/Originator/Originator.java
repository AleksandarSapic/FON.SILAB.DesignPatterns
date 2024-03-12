package Originator;

import DomainClasses.DKLet;
import Memento.Memento;

public class Originator {

    DKLet let;

    public Originator(DKLet let) {
        this.let = let;
    }

    public DKLet setMemento(Memento mem) {
        this.let = mem.getState();
        return this.let;
    }

    public Memento createMemento() {
        return new Memento(this.let);
    }

}
