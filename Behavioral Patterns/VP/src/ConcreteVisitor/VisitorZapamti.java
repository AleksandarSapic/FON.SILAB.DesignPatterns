package ConcreteVisitor;

import ConcreteComponent.Kontroler1;
import ConcreteDecorators.*;
import Visitor.Visitor;

public class VisitorZapamti implements Visitor {

    @Override
    public void visitKontroler(Kontroler1 kon1) {
        kon1.Zapamti(false);
    }

    @Override
    public void visitKontrolerA(KonkretniDekoratorKontroleraA kdka) {
        kdka.startAudioKlip("create.wav");
        kdka.setIkonu("create.jpg");
        kdka.prikaziOsnovnuIkonu();
    }

    @Override
    public void visitKontrolerB(KonkretniDekoratorKontroleraB kdkb) {
    }
}
