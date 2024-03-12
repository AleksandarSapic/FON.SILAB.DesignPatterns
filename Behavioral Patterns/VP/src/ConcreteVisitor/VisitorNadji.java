package ConcreteVisitor;

import ConcreteComponent.Kontroler1;
import ConcreteDecorators.*;
import Visitor.Visitor;

public class VisitorNadji implements Visitor {

    @Override
    public void visitKontroler(Kontroler1 kon1) {
        kon1.Nadji(true);
    }

    @Override
    public void visitKontrolerA(KonkretniDekoratorKontroleraA kdka) {
        kdka.startAudioKlip("find.wav");
        kdka.setIkonu("find.jpg");
        kdka.prikaziOsnovnuIkonu();
    }

    @Override
    public void visitKontrolerB(KonkretniDekoratorKontroleraB kdkb) {
    }
}
