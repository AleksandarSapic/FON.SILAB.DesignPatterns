package Visitor;

import ConcreteComponent.Kontroler1;
import ConcreteDecorators.*;

public interface Visitor {

    void visitKontroler(Kontroler1 kon1);

    void visitKontrolerA(KonkretniDekoratorKontroleraA kdka);

    void visitKontrolerB(KonkretniDekoratorKontroleraB kdkb);
}
