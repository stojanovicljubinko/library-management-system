package sistem.eb.interfaces.interfaceuserclasses;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import sistem.eb.interfaces.InterfaceAdministrator;

public class AvailableBooks extends javax.swing.JFrame {

    public AvailableBooks() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png")));
        updateTableBooks(availablebook_T);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        availablebook_T = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dostupne knjige sistema elektrosne biblioteke - SEB");

        availablebook_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Naslov", "Autor", "Datum objavljivanja", "Broj stranica", "Žanr", "Povezane knjige"
            }
        ));
        availablebook_T.setShowGrid(true);
        availablebook_T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availablebook_TMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(availablebook_T);

        jPanel1.setBackground(new java.awt.Color(70, 130, 180));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/userbooks.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DOSTUPNE KNJIGE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void availablebook_TMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availablebook_TMouseClicked
        String title = (String) this.availablebook_T.getModel().getValueAt(this.availablebook_T.getSelectedRow(), 0);
        String autor = (String) this.availablebook_T.getModel().getValueAt(this.availablebook_T.getSelectedRow(), 1);
        String publishingDate = (String) this.availablebook_T.getModel().getValueAt(this.availablebook_T.getSelectedRow(), 2);
        String numberPages = (String) this.availablebook_T.getModel().getValueAt(this.availablebook_T.getSelectedRow(), 3);
        String genre = (String) this.availablebook_T.getModel().getValueAt(this.availablebook_T.getSelectedRow(), 4);
        String relatedBooks = (String) this.availablebook_T.getModel().getValueAt(this.availablebook_T.getSelectedRow(), 5);

        openBook(title, autor, publishingDate, numberPages, genre, relatedBooks);
    }//GEN-LAST:event_availablebook_TMouseClicked

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AvailableBooks().setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
    }

    protected static void updateTableBooks(JTable jTable3) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select * from books");
            DefaultTableModel tableModel = (DefaultTableModel) jTable3.getModel();
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publishingDate = rs.getString("publishingDate");
                String numberPages = rs.getString("numberPages");
                String genre = rs.getString("genre");
                String relatedBooks = rs.getString("relatedBooks");

                String tableData[] = {title, author, publishingDate, numberPages, genre, relatedBooks};
                tableModel.addRow(tableData);
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static void openBook(String title, String author, String publishingDate, String numberPages, String genre, String relatedBooks) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet crs = factory.createCachedRowSet();

            String fileName = "", filePath = "";
            crs.setUrl(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            crs.setCommand("select * from books where TITLE='" + title + "' AND AUTHOR='" + author + "' AND PUBLISHINGDATE='" + publishingDate + "' AND NUMBERPAGES='" + numberPages + "' AND GENRE='" + genre + "' AND RELATEDBOOKS='" + relatedBooks + "'");
            crs.execute();
            while (crs.next()) {
                fileName = crs.getString("fileName");
                filePath = crs.getString("filePath");

            }
            crs.close();

            File file = new File(filePath);
            Desktop des = Desktop.getDesktop();
            des.open(file);
            con.close();
        } catch (SQLException | IOException | java.lang.IllegalArgumentException ex) {
            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Žao nam je, ne možete otvoriti ovu knjigu!", "U redu").show();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable availablebook_T;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
