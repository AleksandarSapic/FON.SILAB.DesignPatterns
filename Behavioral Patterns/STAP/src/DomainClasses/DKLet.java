package DomainClasses;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DKLet implements Serializable, GeneralDObject {

    private int SifraLeta;
    private String AvioKompanija;
    private int SifraAviona;
    private String Pilot;
    private String MestoUzletanja;
    private String MestoSletanja;
    private Date DatumLeta;
    private String Stanje;

    public DKLet() {
        SifraLeta = 0;
        AvioKompanija = "Nepoznato";
        SifraAviona = 000000;
        Pilot = "Nepoznato";
        MestoUzletanja = "Nepoznato";
        MestoSletanja = "Nepoznato";
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        DatumLeta = java.sql.Date.valueOf(sm.format(dDatum));
        Stanje = "neobradjen";
    }

    public DKLet(int SifraLeta, String AvioKompanija, int SifraAviona, String Pilot, String MestoUzletanja, String MestoSletanja, Date DatumLeta, String Stanje) {
        this.SifraLeta = SifraLeta;
        this.AvioKompanija = AvioKompanija;
        this.SifraAviona = SifraAviona;
        this.Pilot = Pilot;
        this.MestoUzletanja = MestoUzletanja;
        this.MestoSletanja = MestoSletanja;
        this.DatumLeta = DatumLeta;
        this.Stanje = Stanje;
    }

    public DKLet(int SifraLeta) {
        this.SifraLeta = SifraLeta;
    }

    @Override
    public String getAtrValue() {
        return SifraLeta + ", " + (AvioKompanija == null ? null : "'" + AvioKompanija + "'") + ", " + SifraAviona + ", " + (Pilot == null ? null : "'" + Pilot + "'") + ", " + (MestoUzletanja == null ? null : "'" + MestoUzletanja + "'") + ", " + (MestoSletanja == null ? null : "'" + MestoSletanja + "'") + ", " + "'" + DatumLeta + "', '" + Stanje + "'";
    }

    @Override
    public String setAtrValue() {
        return "SifraLeta= " + SifraLeta + ", " + "AvioKompanija= " + (AvioKompanija == null ? null : "'" + AvioKompanija + "'") + ", " + "SifraAviona= " + SifraAviona + ", " + "Pilot= " + (Pilot == null ? null : "'" + Pilot + "'") + ", " + "MestoUzletanja= " + (MestoUzletanja == null ? null : "'" + MestoUzletanja + "'") + ", " + "MestoSletanja= " + (MestoSletanja == null ? null : "'" + MestoSletanja + "'") + ", " + "DatumLeta=" + "'" + DatumLeta + "', " + "Stanje = '" + Stanje + "'";
    }

    @Override
    public String getClassName() {
        return "dklet";
    }

    @Override
    public String getWhereCondition() {
        return "SifraLeta = " + SifraLeta;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"SifraLeta", "AvioKompanija", "SifraAviona", "Pilot", "MestoUzletanja", "MestoSletanja", "DatumLeta", "Stanje"};
        return names[column];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new DKLet(rs.getInt("SifraLeta"), rs.getString("AvioKompanija"), rs.getInt("SifraAviona"), rs.getString("Pilot"), rs.getString("MestoUzletanja"), rs.getString("MestoSletanja"), rs.getDate("DatumLeta"), rs.getString("Stanje"));
    }

    public int getSifraLeta() {
        return SifraLeta;
    }

    public void setSifraLeta(int SifraLeta) {
        this.SifraLeta = SifraLeta;
    }

    public String getAvioKompanija() {
        return AvioKompanija;
    }

    public void setAvioKompanija(String AvioKompanija) {
        this.AvioKompanija = AvioKompanija;
    }

    public int getSifraAviona() {
        return SifraAviona;
    }

    public void setSifraAviona(int SifraAviona) {
        this.SifraAviona = SifraAviona;
    }

    public String getPilot() {
        return Pilot;
    }

    public void setPilot(String Pilot) {
        this.Pilot = Pilot;
    }

    public String getMestoUzletanja() {
        return MestoUzletanja;
    }

    public void setMestoUzletanja(String MestoUzletanja) {
        this.MestoUzletanja = MestoUzletanja;
    }

    public String getMestoSletanja() {
        return MestoSletanja;
    }

    public void setMestoSletanja(String MestoSletanja) {
        this.MestoSletanja = MestoSletanja;
    }

    public Date getDatumLeta() {
        return DatumLeta;
    }

    public void setDatumLeta(Date DatumLeta) {
        this.DatumLeta = DatumLeta;
    }

    public String getStanje() {
        return Stanje;
    }

    public void setStanje(String Stanje) {
        this.Stanje = Stanje;
    }

}
