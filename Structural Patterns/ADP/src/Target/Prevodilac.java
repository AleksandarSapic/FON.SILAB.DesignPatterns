package Target;

import Adaptee.Projektant;

public abstract class Prevodilac { // Target

    protected Projektant pr;

    public Prevodilac(Projektant pr1) {
        pr = pr1;
    }

    public abstract void createScreenForm();

    public abstract void createDatabaseBroker();

    public abstract void createController();

    public abstract void createSoftwareSystem();

    public abstract void showScreenForm();
}
