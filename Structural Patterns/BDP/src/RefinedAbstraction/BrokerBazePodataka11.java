package RefinedAbstraction;

import Abstraction.BrokerBazePodataka1;

public class BrokerBazePodataka11 extends BrokerBazePodataka1 {

    @Override
    protected String vratiDrajver() {
        return "com.mysql.cj.jdbc.Driver";
    } // Promenljivo!!!

    @Override
    protected String vratiURL() {
        return "jdbc:mysql://127.0.0.1:3306/afp";
    } // Promenljivo!!!

    @Override
    protected String vratiKorisnickoIme() {
        return "root";
    } // Promenljivo!!!

    @Override
    protected String vratiSifru() {
        return "";
    } // Promenljivo!!!

    @Override
    protected String vratiDBMS() {
        return "MySQL DBMS";
    } // Promenljivo!!!

}
