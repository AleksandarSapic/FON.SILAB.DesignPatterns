package AbstractProductA;

import Client.Sef;
import javax.swing.JFrame;

public abstract class EkranskaForma extends JFrame implements Forma {
    //Panel pan;

    @Override
    public Panel getPanel() {
        return (Panel) getContentPane();
    }

    public void setPanel(Panel pan1) {
        setContentPane((Panel) pan1);//pan=pan1;
    }

    @Override
    public void prikaziEkranskuFormu(Sef sef) {
        setVisible(true);
    }

    abstract public void odrediDekoracijuForme();
}
