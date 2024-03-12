package AbstractProductA;

import javax.swing.JFrame;

public abstract class EkranskaForma extends JFrame {
    //Panel pan;

    public AbstractProductA.Panel getPanel() {
        return (AbstractProductA.Panel) getContentPane();
    }

    public void setPanel(AbstractProductA.Panel pan1) {
        setContentPane(pan1);//pan=pan1;

    }

    public void prikaziEkranskuFormu() {
        setVisible(true);
    }

    abstract public void odrediDekoracijuForme();
}
