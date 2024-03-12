package AbstractProductA;

public interface IPanel {

    public String getSifraLeta(); // Promenljivo!!!

    public String getAvioKompanija(); // Promenljivo!!!

    public String getSifraAviona(); // Promenljivo!!!

    public String getPilot(); // Promenljivo!!!

    public String MestoUzletanja(); // Promenljivo!!!

    public String MestoSletanja(); // Promenljivo!!!

    public void setSifraLeta(String SifraLeta); // Promenljivo!!!

    public void setAvioKompanija(String AvioKompanija); // Promenljivo!!!

    public void setSifraAviona(String SifraAviona); // Promenljivo!!!

    public void setPilot(String Pilot); // Promenljivo!!!

    public void setMestoUzletanja(String MestoUzletanja); // Promenljivo!!!

    public void setMestoSletanja(String MestoSletanja); // Promenljivo!!!

    public void setPoruka(String Poruka);

    public Object getKreiraj();

    public Object getPromeni();

    public Object getObrisi();

    public Object getNadji();

    public Object getSifraLeta1();

    public Object getDatumLeta(); // Promenljivo!!

    public void setDatumLeta(Object DatumLeta); // Promenljivo!!!

}
