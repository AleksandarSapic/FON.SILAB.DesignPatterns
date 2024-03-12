package Adapter;

import Adaptee.Projektant;
import Target.Prevodilac;

public class Prevodilac1 extends Prevodilac {  // Adapter

    public Prevodilac1(Projektant pr1) {
        super(pr1);
    }

    @Override
    public void createScreenForm() {
        pr.kreirajEkranskuFormu();
    }

    @Override
    public void createDatabaseBroker() {
        pr.kreirajBrokerBazePodataka();
    }

    @Override
    public void createController() {
        pr.kreirajKontroler();
    }

    @Override
    public void createSoftwareSystem() {
        pr.kreirajSoftverskiSistem();
    }

    @Override
    public void showScreenForm() {
        pr.prikaziEkranskuFormu();
    }

}
