package AbstractProductA;

public abstract class Panel extends javax.swing.JPanel {

    public abstract String getSifraLeta(); // Promenljivo!!!

    public abstract javax.swing.JButton getSledeci(); // Promenljivo!!!

    public abstract String getAvioKompanija(); // Promenljivo!!!

    public abstract String getSifraAviona(); // Promenljivo!!!

    public abstract String getPilot(); // Promenljivo!!!

    public abstract String MestoUzletanja(); // Promenljivo!!!

    public abstract String MestoSletanja(); // Promenljivo!!!

    public abstract Object getDatumLeta(); // Promenljivo!!

    public abstract void setSifraLeta(String SifraLeta); // Promenljivo!!!

    public abstract void setAvioKompanija(String AvioKompanija); // Promenljivo!!!

    public abstract void setSifraAviona(String SifraAviona); // Promenljivo!!!

    public abstract void setPilot(String Pilot); // Promenljivo!!!

    public abstract void setMestoUzletanja(String MestoUzletanja); // Promenljivo!!!

    public abstract void setMestoSletanja(String MestoSletanja); // Promenljivo!!!

    public abstract void setDatumLeta(Object DatumLeta); // Promenljivo!!!

    public abstract void setPoruka(String Poruka);

    public abstract javax.swing.JButton getKreiraj();

    public abstract javax.swing.JButton getPromeni();

    public abstract javax.swing.JButton getObrisi();

    public abstract javax.swing.JButton getNadji();

    public abstract javax.swing.JButton getPrvi();

    public abstract javax.swing.JButton getPredhodni();

    public abstract javax.swing.JButton getZadnji();

    public abstract javax.swing.JTextField getSifraLeta1();

}