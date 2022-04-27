package sistem.eb.interfaces.interfaceuserclasses;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FeedBack extends javax.swing.JFrame {

    String username;
    public FeedBack(String username) {
        initComponents();
        this.username = username;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png")));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        title_L = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        configmessage_B = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Poruka administratoru sistema elektrosne biblioteke - SEB");

        jPanel1.setBackground(new java.awt.Color(70, 130, 180));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("POVRATNE INFORMACIJE");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/messagebig.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        title_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        title_L.setForeground(new java.awt.Color(102, 102, 102));
        title_L.setText("Naslov poruke");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setText("Naslov poruke");
        jTextField1.setFocusable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea1.setRows(5);
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        configmessage_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        configmessage_B.setForeground(new java.awt.Color(102, 102, 102));
        configmessage_B.setText("Potvrdi");
        configmessage_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configmessage_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title_L)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(configmessage_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title_L)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(configmessage_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configmessage_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configmessage_BActionPerformed
       if(this.jTextField1.getText().equals("") || this.jTextField1.getText().equals("Naslov poruke")){
           new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti naslov!", "U redu").show();
       }else{
           if(this.jTextArea1.getText().equals("")){
               new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti telo poruke!", "U redu").show();
           }else{
               this.addMessage(jTextArea1.getText(), jTextField1.getText(), username);
               this.jTextArea1.setText("");
               this.jTextField1.setText("");
                 new sistem.eb.login_registration.DialogMessage("Obaveštenje", "<html><p  style=\"line-height:85%;text-align:center;\">Uspešno ste poslali poruku</p><p style=\"line-height:85%;text-align:center;\"> administratoru!</p></html>", "U redu").show();
           }
       }
    }//GEN-LAST:event_configmessage_BActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new FeedBack(null).setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
    }
    protected static void addMessage(String message, String title, String username) {
        try {
            System.out.println(username);
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement ps = con.prepareStatement("insert into messagefeedback(message,title,username) values(?,?,?)");
            ps.setString(1, message);
            ps.setString(2, title);
            ps.setString(3, username);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton configmessage_B;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel title_L;
    // End of variables declaration//GEN-END:variables
}
