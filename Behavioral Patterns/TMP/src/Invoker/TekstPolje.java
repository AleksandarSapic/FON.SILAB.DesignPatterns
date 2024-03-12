package Invoker;

import AbstractClass.OpstaDBSO;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class TekstPolje { // Invoker

    public TekstPolje(OpstaDBSO odbso, JTextField polje) {
        {
            polje.addFocusListener(new OsluskivacPolje(odbso));
        }
    }
}

class OsluskivacPolje implements FocusListener {

    OpstaDBSO odbso;

    OsluskivacPolje(OpstaDBSO odbso1) {
        odbso = odbso1;
    }

    @Override
    public void focusLost(java.awt.event.FocusEvent e) {
        odbso.opstaDBSO();

    }

    @Override
    public void focusGained(FocusEvent e) {

    }
}
