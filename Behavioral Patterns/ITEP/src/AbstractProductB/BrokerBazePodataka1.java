package AbstractProductB;

import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import DomainClasses.GeneralDObject;
import Iterator.DBIterator;
import Iterator.Iterator;

public class BrokerBazePodataka1 extends BrokerBazePodataka {

    Connection conn = null;

    // Promenljivo!!! 
    @Override
    public boolean makeConnection() {
        String Url;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Url = "jdbc:mysql://127.0.0.1:3306/afp";
            conn = DriverManager.getConnection(Url, "root", "");
            conn.setAutoCommit(false); // Ako se ovo ne uradi nece moci da se radi roolback.
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean insertRecord(GeneralDObject odo) {
        String upit = "INSERT INTO " + odo.getClassName() + " VALUES (" + odo.getAtrValue() + ")";
        return executeUpdate(upit);
    }

    @Override
    public boolean getCounter(GeneralDObject odo, AtomicInteger counter) {
        String sql = "SELECT Counter FROM counter WHERE TableName = '" + odo.getClassName() + "'";

        ResultSet rs = null;
        Statement st = null;

        boolean signal = false; // record doesn't exist
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            signal = rs.next();
            counter.set(rs.getInt("Counter") + 1);
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
            signal = false;
        } finally {
            close(null, st, rs);
        }
        return signal;

    }

    @Override
    public boolean increaseCounter(GeneralDObject odo, AtomicInteger counter) {
        String upit = "UPDATE counter SET Counter =" + counter.get() + " WHERE TableName = '" + odo.getClassName() + "'";
        return executeUpdate(upit);
    }

    @Override
    public boolean deleteRecord(GeneralDObject odo) {
        String upit = "DELETE FROM " + odo.getClassName() + " WHERE " + odo.getWhereCondition();
        return executeUpdate(upit);
    }

    @Override
    public boolean updateRecord(GeneralDObject odo, GeneralDObject odoold) {
        String upit = "UPDATE " + odo.getClassName() + " SET " + odo.setAtrValue() + " WHERE " + odoold.getWhereCondition();
        return executeUpdate(upit);
    }

    @Override
    public boolean updateRecord(GeneralDObject odo) {
        String upit = "UPDATE " + odo.getClassName() + " SET " + odo.setAtrValue() + " WHERE " + odo.getWhereCondition();
        return executeUpdate(upit);
    }

    public boolean executeUpdate(String upit) {
        Statement st = null;
        boolean signal = false;
        try {
            st = conn.prepareStatement(upit);
            int rowcount = st.executeUpdate(upit);
            if (rowcount > 0) {
                signal = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
            signal = false;
        } finally {
            close(null, st, null);
        }
        return signal;
    }

    @Override
    public GeneralDObject findRecord(GeneralDObject odo) {
        ResultSet rs = null;
        Statement st = null;
        String upit = "SELECT * FROM " + odo.getClassName() + " WHERE " + odo.getWhereCondition();
        boolean signal;
        try {
            st = conn.prepareStatement(upit);
            rs = st.executeQuery(upit);
            signal = rs.next(); // rs.next() vraca true ako ima postoji rezultat upita.
            if (signal == true) {
                odo = odo.getNewRecord(rs);
            } else {
                odo = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return odo;
    }

    @Override
    public boolean commitTransation() {
        try {
            conn.commit();
        } catch (SQLException esql) {
            return false;
        }
        return true;
    }

    @Override
    public boolean rollbackTransation() {
        try {
            conn.rollback();
        } catch (SQLException esql) {
            return false;
        }

        return true;
    }

    @Override
    public void closeConnection() {
        close(conn, null, null);
    }

    public void close(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public int getRecordsNumber(GeneralDObject odo) {
        ResultSet rs = null;
        Statement st = null;
        int recordsNumber = 0;
        String upit = "SELECT * FROM " + odo.getClassName();
        boolean signal;
        try {
            st = conn.prepareStatement(upit);
            rs = st.executeQuery(upit);
            if (rs.last()) {
                recordsNumber = rs.getRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return recordsNumber;
    }

    @Override
    public GeneralDObject getRecord(GeneralDObject odo, int index) {
        ResultSet rs = null;
        Statement st = null;
        String upit = "SELECT * FROM " + odo.getClassName();
        upit = upit + " order by " + odo.getNameByColumn(0) + " ASC LIMIT " + index + ",1";
        boolean signal;
        try {
            st = conn.prepareStatement(upit);
            rs = st.executeQuery(upit);
            signal = rs.next(); // rs.next() vraca true ako ima postoji rezultat upita.
            if (signal == true) {
                odo = odo.getNewRecord(rs);
            } else {
                odo = null;
            }
        } catch (SQLException ex) {
            odo = null;
            Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return odo;
    }

    @Override
    public Iterator getIterator(GeneralDObject odo) {
        return new DBIterator(this, odo);
    }
}
