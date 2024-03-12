package Observer;

import DomainClasses.DKLet;
import AbstractProductC.Kontroler;

public class ConcreteObserver implements Observer {

    Kontroler kon;

    public ConcreteObserver(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void Update(int brojPrijave) {
        DKLet tekucilet = (DKLet) kon.getDKObject();
        if (tekucilet != null) {
            if (brojPrijave == tekucilet.getSifraLeta()) {
                kon.nadjiDomenskiObjekat();
            }
        }
    }
}
