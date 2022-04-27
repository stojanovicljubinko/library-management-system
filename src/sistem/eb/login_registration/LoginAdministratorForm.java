package sistem.eb.login_registration;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.UIManager;
import sistem.eb.interfaces.InterfaceAdministrator;

public class LoginAdministratorForm extends javax.swing.JFrame {

    int anstast = 0, asstart = 0, apstart = 0;
    public LoginAdministratorForm() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sistem/eb/icons/logo.png")));
        aname_TF.select(0, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        apassword_TF = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        asurname_TF = new javax.swing.JTextField();
        lnalog_L = new javax.swing.JLabel();
        login_B = new javax.swing.JButton();
        lnalog_L1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        aname_TF = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem EB - Prijavljivanje administratora u sistemu elektronske biblioteke");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Password");

        apassword_TF.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        apassword_TF.setForeground(new java.awt.Color(153, 153, 153));
        apassword_TF.setText("password");
        apassword_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apassword_TFMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                apassword_TFMousePressed(evt);
            }
        });
        apassword_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apassword_TFKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Surname");

        asurname_TF.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        asurname_TF.setForeground(new java.awt.Color(153, 153, 153));
        asurname_TF.setText("Surname");
        asurname_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asurname_TFMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                asurname_TFMousePressed(evt);
            }
        });
        asurname_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                asurname_TFKeyPressed(evt);
            }
        });

        lnalog_L.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lnalog_L.setForeground(new java.awt.Color(102, 102, 102));
        lnalog_L.setText("Nisam administrator?");

        login_B.setBackground(new java.awt.Color(204, 204, 204));
        login_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        login_B.setForeground(new java.awt.Color(102, 102, 102));
        login_B.setText("Prijavi se");
        login_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_BActionPerformed(evt);
            }
        });

        lnalog_L1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lnalog_L1.setForeground(new java.awt.Color(58, 131, 191));
        lnalog_L1.setText("Prijavi se kao korisnik!");
        lnalog_L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lnalog_L1MousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/padlock.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Name");

        aname_TF.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        aname_TF.setForeground(new java.awt.Color(153, 153, 153));
        aname_TF.setText("Name");
        aname_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aname_TFMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aname_TFMousePressed(evt);
            }
        });
        aname_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aname_TFKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(lnalog_L)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lnalog_L1))
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(apassword_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(asurname_TF)
                            .addComponent(aname_TF))))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(login_B, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(185, 185, 185))))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aname_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(32, 32, 32)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(asurname_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(apassword_TF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(login_B, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnalog_L)
                    .addComponent(lnalog_L1))
                .addGap(37, 37, 37))
        );

        jPanel1.setBackground(new java.awt.Color(70, 130, 180));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/monitor.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("(000) 000-0000");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("stojanovicljubinko@outlook.com");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel7)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lnalog_L1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnalog_L1MousePressed
        new LoginUserForm().show();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_lnalog_L1MousePressed

    private void login_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_BActionPerformed
        //PROVERA POPUNJAVANJA POLJA
        if (aname_TF.getText().equals("") || aname_TF.getText().equals("Name")) {
            new DialogMessage("Obaveštenje", "Neophodno je uneti name!", "U redu").show();
        } else {
            if (asurname_TF.getText().equals("") || asurname_TF.getText().equals("Surname")) {
                new DialogMessage("Obaveštenje", "Neophodno je uneti surname!", "U redu").show();
            } else {
                if (apassword_TF.getText().equals("") || apassword_TF.getText().equals("Password")) {
                    new DialogMessage("Obaveštenje", "Neophodno je uneti password!", "U redu").show();
                } else {
                    //PROVERA ISPRAVNOSTI PODATAKA
                    if (checkAdminDataName(aname_TF.getText().trim())) {
                        new DialogMessage("Greška", "Neophodno je uneti ispravno name!", "U redu").show();
                    } else {
                        if (checkAdminDataSurname(asurname_TF.getText().trim())) {
                            new DialogMessage("Greška", "Neophodno je uneti ispravno surname!", "U redu").show();
                        } else {
                            if (checkAdminDataPassword(String.valueOf(apassword_TF.getPassword()), aname_TF.getText(), asurname_TF.getText())) {
                                new DialogMessage("Greška", "<html><p  style=\"line-height:85%;text-align:center;\">Neophodno je uneti ispravan</p><p style=\"line-height:85%;text-align:center;\"> password!</p></html>", "U redu").show();
                            } else {
                                new InterfaceAdministrator(aname_TF.getText() + " " + asurname_TF.getText()).show();
                                this.setVisible(false);
                                this.dispose();
                            }
                        }
                    }
                }

            }
        }
    }//GEN-LAST:event_login_BActionPerformed

    private void aname_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aname_TFKeyPressed
        if (anstast == 0) {
            aname_TF.setText("");
            anstast++;
        }
    }//GEN-LAST:event_aname_TFKeyPressed

    private void asurname_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_asurname_TFKeyPressed
        if (asstart == 0) {
            asurname_TF.setText("");
            asstart++;
        }
    }//GEN-LAST:event_asurname_TFKeyPressed

    private void apassword_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apassword_TFKeyPressed
        if (apstart == 0) {
            apassword_TF.setText("");
            apstart++;
        }
    }//GEN-LAST:event_apassword_TFKeyPressed

    private void aname_TFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aname_TFMousePressed
        if (anstast == 0) {
            aname_TF.setText("");
            anstast++;
        }
    }//GEN-LAST:event_aname_TFMousePressed

    private void asurname_TFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asurname_TFMousePressed
        if (asstart == 0) {
            asurname_TF.setText("");
            asstart++;
        }
    }//GEN-LAST:event_asurname_TFMousePressed

    private void apassword_TFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apassword_TFMousePressed
        if (apstart == 0) {
            apassword_TF.setText("");
            apstart++;
        }
    }//GEN-LAST:event_apassword_TFMousePressed

    private void aname_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aname_TFMouseClicked
        if (anstast == 0) {
            aname_TF.setText("");
            anstast++;
        }
    }//GEN-LAST:event_aname_TFMouseClicked

    private void asurname_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asurname_TFMouseClicked
        if (asstart == 0) {
            asurname_TF.setText("");
            asstart++;
        }
    }//GEN-LAST:event_asurname_TFMouseClicked

    private void apassword_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apassword_TFMouseClicked
        if (apstart == 0) {
            apassword_TF.setText("");
            apstart++;
        }
    }//GEN-LAST:event_apassword_TFMouseClicked

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdministratorForm().setVisible(true);
            }
        });
    }

    public boolean checkAdminDataName(String name) {
        boolean checkName = false;
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();

            java.sql.ResultSet rs = st.executeQuery("select realname from administrators where realname= '" + name + "'");
            if (rs.next()) {
                checkName = false;
            } else {
                checkName = true;

            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
        return checkName;
    }

    public boolean checkAdminDataSurname(String surname) {
        boolean checkSurname = false;
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();

            java.sql.ResultSet rs = st.executeQuery("select surname from administrators where surname= '" + surname + "'");
            if (rs.next()) {
                checkSurname = false;
            } else {
                checkSurname = true;

            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
        return checkSurname;
    }

   public boolean checkAdminDataPassword(String password, String realname, String surname) {
        boolean checkPassword = true;
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();

            java.sql.ResultSet rs = st.executeQuery("select * from administrators where REALNAME= '" + realname + "' AND SURNAME = '" + surname + "'");
            if (rs.next()) {
                //treba biti password promenjiva
                if (password.equals(rs.getString("password"))) {
                    checkPassword = false;
                } else {
                    checkPassword = true;
                }
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
        return checkPassword;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JTextField aname_TF;
    private javax.swing.JPasswordField apassword_TF;
    private javax.swing.JTextField asurname_TF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lnalog_L;
    private javax.swing.JLabel lnalog_L1;
    private javax.swing.JButton login_B;
    // End of variables declaration//GEN-END:variables
}
