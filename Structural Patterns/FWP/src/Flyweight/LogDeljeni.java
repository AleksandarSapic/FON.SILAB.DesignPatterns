package Flyweight;

public class LogDeljeni implements Log { // ConcreteFlyweight

    private final String nazivOperacije;
    private String poruka;

    public LogDeljeni(String nazivOperacije1, String poruka1) {
        nazivOperacije = nazivOperacije1;
        poruka = poruka1;
    }

    @Override
    public String vratiNazivOperacije() {
        return nazivOperacije;
    }

    @Override
    public String vratiDomenskiObjekat() {
        return "";
    }

    @Override
    public String vratiPoruku() {
        return poruka;
    }
}
