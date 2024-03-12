package Leaf;

import AbstractProductA.IPanel;

public class CPanel extends List {

    IPanel pan;

    public CPanel(IPanel pan1) {
        pan = pan1;
    }

    @Override
    public Object getTipKomponente() {
        return pan.getClass();
    }
}
