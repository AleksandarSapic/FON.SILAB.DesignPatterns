package ConcreteState;

import AbstractProductC.Kontroler;
import State.Stanje;

public class NullStanje extends Stanje {

    public NullStanje(Kontroler kon1) {
        kon = kon1;
    }

    @Override
    public void obradiDomenskiObjekat() {
        kon.setPoruka("Ne moze da se obradi nepostojeci let!");
        kon.prikaziPoruku();
    }

    @Override
    public void stornirajDomenskiObjekat() {
        kon.setPoruka("Ne moze da se stornira nepostojeci let!");
        kon.prikaziPoruku();
    }

    @Override
    public void promeniDomenskiObjekat() {
        kon.setPoruka("Ne moze da se promeni ne postojeci let!");
        kon.prikaziPoruku();
    }

}
