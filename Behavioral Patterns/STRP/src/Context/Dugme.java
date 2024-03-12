package Context;

import Strategy.SistemskaOperacija;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Dugme { // Context

    public Dugme(SistemskaOperacija so, JButton dugme) {
        dugme.addActionListener((ActionEvent e) -> {
            so.izvrsiSO();
        });
    }
}
