package Iterator;

import Client.Kontroler;
import DomainClasses.GeneralDObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DugmeKretanja {

    public DugmeKretanja(Iterator it, JButton dugme, Kontroler kon) {
        dugme.addActionListener(new OsluskivacDugme(it, dugme, kon));
    }
}

class OsluskivacDugme implements ActionListener {

    Iterator it;
    JButton dugme;
    Kontroler kon;

    OsluskivacDugme(Iterator it1, JButton dugme1, Kontroler kon1) {
        it = it1;
        dugme = dugme1;
        kon = kon1;
        GeneralDObject gdo = (GeneralDObject) it.first();
        if (gdo == null) {
            kon.isprazniGrafickiObjekat();
        } else {
            kon.napuniGrafickiObjekatIzDomenskogObjekta(gdo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GeneralDObject gdo = null;

        switch (dugme.getName()) {
            case "Prvi":
                gdo = (GeneralDObject) it.first();
                break;
            case "Sledeci":
                gdo = (GeneralDObject) it.next();
                break;
            case "Predhodni":
                gdo = (GeneralDObject) it.previous();
                break;
            case "Zadnji":
                gdo = (GeneralDObject) it.last();
                break;
        }
        if (gdo == null) {
            kon.isprazniGrafickiObjekat();
        } else {
            kon.napuniGrafickiObjekatIzDomenskogObjekta(gdo);
        }

    }
}
