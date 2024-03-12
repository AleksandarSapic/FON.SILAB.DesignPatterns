package AbstractProductA;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;

public class Panel1 extends Panel {

    /**
     * Creates new form Panel1
     */
    public Panel1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SifraLeta = new javax.swing.JTextField();
        AvioKompanija = new javax.swing.JTextField();
        SifraAviona = new javax.swing.JTextField();
        Pilot = new javax.swing.JTextField();
        MestoUzletanja = new javax.swing.JTextField();
        MestoSletanja = new javax.swing.JTextField();
        Poruka = new javax.swing.JTextField();
        Nadji = new javax.swing.JButton();
        Kreiraj = new javax.swing.JButton();
        Promeni = new javax.swing.JButton();
        Obrisi = new javax.swing.JButton();
        Datum = new datechooser.beans.DateChooserCombo();
        Prvi = new javax.swing.JButton();
        Predhodni = new javax.swing.JButton();
        Sledeci = new javax.swing.JButton();
        Zadnji = new javax.swing.JButton();

        jLabel1.setText("Sifra leta");

        jLabel2.setText("Avio Kompanija");

        jLabel3.setText("Sifra aviona");

        jLabel4.setText("Pilot");

        jLabel5.setText("Mesto uzletanja");

        jLabel6.setText("Mesto sletanja");

        jLabel7.setText("Datum");

        jLabel8.setText("Poruka");

        Nadji.setText("Nadji");

        Kreiraj.setText("Kreiraj");

        Promeni.setText("Promeni");

        Obrisi.setText("Obrisi");

        Prvi.setForeground(new java.awt.Color(255, 255, 255));
        Prvi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button-First-icon.png"))); // NOI18N
        Prvi.setName("Prvi"); // NOI18N
        Prvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrviActionPerformed(evt);
            }
        });

        Predhodni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fast-backward-icon.png"))); // NOI18N
        Predhodni.setName("Predhodni"); // NOI18N

        Sledeci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button-Forward-icon.png"))); // NOI18N
        Sledeci.setName("Sledeci"); // NOI18N

        Zadnji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button-Last-icon.png"))); // NOI18N
        Zadnji.setName("Zadnji"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Poruka, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SifraLeta))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AvioKompanija, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(Nadji))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Kreiraj)
                        .addGap(18, 18, 18)
                        .addComponent(Promeni)
                        .addGap(18, 18, 18)
                        .addComponent(Obrisi))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(SifraAviona))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Pilot))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(MestoUzletanja))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(MestoSletanja, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Prvi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Predhodni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sledeci, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Zadnji, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SifraLeta)
                            .addComponent(Nadji))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AvioKompanija)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SifraAviona)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pilot, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Prvi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Predhodni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MestoUzletanja)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MestoSletanja)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(Datum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Kreiraj)
                            .addComponent(Promeni)
                            .addComponent(Obrisi)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Sledeci, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Zadnji, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Poruka, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PrviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrviActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrviActionPerformed

    @Override
    public String getSifraLeta() {
        return SifraLeta.getText();
    }

    @Override
    public String getAvioKompanija() {
        return AvioKompanija.getText();
    }

    @Override
    public String getSifraAviona() {
        return SifraAviona.getText();
    }

    @Override
    public String getPilot() {
        return Pilot.getText();
    }

    @Override
    public String MestoUzletanja() {
        return MestoUzletanja.getText();
    }

    @Override
    public String MestoSletanja() {
        return MestoSletanja.getText();
    }

    @Override
    public void setSifraLeta(String SifraLeta) {
        this.SifraLeta.setText(SifraLeta);
    }

    @Override
    public void setAvioKompanija(String AvioKompanija) {
        this.AvioKompanija.setText(AvioKompanija);
    }

    @Override
    public void setSifraAviona(String SifraAviona) {
        this.SifraAviona.setText(SifraAviona);
    }

    @Override
    public void setPilot(String Pilot) {
        this.Pilot.setText(Pilot);
    }

    @Override
    public void setMestoUzletanja(String MestoUzletanja) {
        this.MestoUzletanja.setText(MestoUzletanja);
    }

    @Override
    public void setMestoSletanja(String MestoSletanja) {
        this.MestoSletanja.setText(MestoSletanja);
    }

    @Override
    public void setPoruka(String Poruka) {
        this.Poruka.setText(Poruka);
    }

    @Override
    public javax.swing.JButton getKreiraj() {
        return Kreiraj;
    }

    @Override
    public javax.swing.JButton getPromeni() {
        return Promeni;
    }

    @Override
    public javax.swing.JButton getObrisi() {
        return Obrisi;
    }

    @Override
    public javax.swing.JButton getNadji() {
        return Nadji;
    }

    @Override
    public javax.swing.JTextField getSifraLeta1() {
        return SifraLeta;
    }

    @Override
    public Object getDatumLeta() {
        return Datum.getSelectedDate().getTime();
    }

    @Override
    public void setDatumLeta(Object DatumLeta) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime((Date) DatumLeta);
        Datum.setSelectedDate(gc);
    }

    @Override
    public javax.swing.JButton getPrvi() {
        return Prvi;
    }

    @Override
    public javax.swing.JButton getSledeci() {
        return Sledeci;
    }

    @Override
    public javax.swing.JButton getPredhodni() {
        return Predhodni;
    }

    @Override
    public javax.swing.JButton getZadnji() {
        return Zadnji;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AvioKompanija;
    private datechooser.beans.DateChooserCombo Datum;
    private javax.swing.JButton Kreiraj;
    private javax.swing.JTextField MestoSletanja;
    private javax.swing.JTextField MestoUzletanja;
    private javax.swing.JButton Nadji;
    private javax.swing.JButton Obrisi;
    private javax.swing.JTextField Pilot;
    private javax.swing.JTextField Poruka;
    private javax.swing.JButton Predhodni;
    private javax.swing.JButton Promeni;
    private javax.swing.JButton Prvi;
    private javax.swing.JTextField SifraAviona;
    private javax.swing.JTextField SifraLeta;
    private javax.swing.JButton Sledeci;
    private javax.swing.JButton Zadnji;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
