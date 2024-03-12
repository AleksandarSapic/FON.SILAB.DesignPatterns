package ConcreteVisitor;

import ConcreteComponent.Kontroler1;
import ConcreteDecorators.*;
import Visitor.Visitor;

public class VisitorObrisi implements Visitor {

    @Override
    public void visitKontroler(Kontroler1 kon1) {
        kon1.Obrisi(false);
    }

    @Override
    public void visitKontrolerA(KonkretniDekoratorKontroleraA kdka) {
        kdka.startAudioKlip("delete.wav");
        kdka.setIkonu("delete.jpg");
        kdka.prikaziOsnovnuIkonu();
    }

    @Override
    public void visitKontrolerB(KonkretniDekoratorKontroleraB kdkb) {
    }
}
