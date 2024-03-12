package Iterator;

import AbstractProductB.BrokerBazePodataka;
import DomainClasses.GeneralDObject;

public class DBIterator implements Iterator {

    int recordsNumber;
    int currentRecord;
    BrokerBazePodataka bbp;
    GeneralDObject gdo;

    public DBIterator(BrokerBazePodataka bbp1, GeneralDObject gdo1) {
        bbp = bbp1;
        gdo = gdo1;
        currentRecord = -1;
    }

    @Override
    public Object first() {
        Object ob = null;
        bbp.makeConnection();
        recordsNumber = bbp.getRecordsNumber(gdo);
        if (recordsNumber == 0) {
            currentRecord = -1;
            bbp.closeConnection();
            return ob;
        }

        currentRecord = 0;
        ob = bbp.getRecord(gdo, currentRecord);
        bbp.closeConnection();
        return ob;
    }

    @Override
    public Object next() {
        Object ob = null;
        bbp.makeConnection();
        recordsNumber = bbp.getRecordsNumber(gdo);
        if (recordsNumber == 0) {
            currentRecord = -1;
            bbp.closeConnection();
            return ob;
        }

        if (recordsNumber <= (currentRecord + 1)) {
        } else {
            currentRecord++;
        }
        ob = bbp.getRecord(gdo, currentRecord);
        bbp.closeConnection();
        return ob;
    }

    @Override
    public Object previous() {
        Object ob = null;
        bbp.makeConnection();

        recordsNumber = bbp.getRecordsNumber(gdo);
        if (recordsNumber == 0) {
            currentRecord = -1;
            bbp.closeConnection();
            return ob;
        }

        if (currentRecord - 1 < 0) {
        } else {
            currentRecord--;
        }
        ob = bbp.getRecord(gdo, currentRecord);
        bbp.closeConnection();
        return ob;
    }

    @Override
    public Object last() {
        Object ob = null;
        bbp.makeConnection();
        recordsNumber = bbp.getRecordsNumber(gdo);
        if (recordsNumber == 0) {
            currentRecord = -1;
            bbp.closeConnection();
            return ob;
        }

        currentRecord = recordsNumber - 1;
        ob = bbp.getRecord(gdo, currentRecord);
        bbp.closeConnection();
        return ob;
    }

}
