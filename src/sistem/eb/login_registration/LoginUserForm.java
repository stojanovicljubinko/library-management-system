package sistem.eb.login_registration;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginUserForm extends javax.swing.JFrame {

    int lustart = 0, lpstart = 0;

    public LoginUserForm() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sistem/eb/icons/logo.png")));
        lusername_TF.select(0, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lpassword_TF_pass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        lusername_TF = new javax.swing.JTextField();
        lnalog_L = new javax.swing.JLabel();
        login_B = new javax.swing.JButton();
        regis_L = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lnalog_L2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem EB - Prijavljivanje korisnika u sistemu elektronske biblioteke");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Password");

        lpassword_TF_pass.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lpassword_TF_pass.setForeground(new java.awt.Color(153, 153, 153));
        lpassword_TF_pass.setText("password");
        lpassword_TF_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lpassword_TF_passMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lpassword_TF_passMousePressed(evt);
            }
        });
        lpassword_TF_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lpassword_TF_passKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Username ");

        lusername_TF.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lusername_TF.setForeground(new java.awt.Color(153, 153, 153));
        lusername_TF.setText("Username");
        lusername_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lusername_TFMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lusername_TFMousePressed(evt);
            }
        });
        lusername_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lusername_TFKeyPressed(evt);
            }
        });

        lnalog_L.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lnalog_L.setForeground(new java.awt.Color(102, 102, 102));
        lnalog_L.setText("Nemam nalog?");

        login_B.setBackground(new java.awt.Color(204, 204, 204));
        login_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        login_B.setForeground(new java.awt.Color(102, 102, 102));
        login_B.setText("Prijavi se");
        login_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_BActionPerformed(evt);
            }
        });

        regis_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regis_L.setForeground(new java.awt.Color(58, 131, 191));
        regis_L.setText("Registruj se!");
        regis_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                regis_LMousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/padlock.png"))); // NOI18N

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1))
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lusername_TF)
                                    .addComponent(lpassword_TF_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(LoginPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(LoginPanelLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(login_B, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(LoginPanelLayout.createSequentialGroup()
                                        .addComponent(lnalog_L)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(regis_L, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6))
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addComponent(lusername_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lpassword_TF_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(login_B, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnalog_L)
                    .addComponent(regis_L))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(70, 130, 180));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/monitor.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("(000) 000-0000");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("stojanovicljubinko@outlook.com");

        lnalog_L2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lnalog_L2.setForeground(new java.awt.Color(255, 204, 0));
        lnalog_L2.setText("Prijava za administratora");
        lnalog_L2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lnalog_L2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lnalog_L2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel3))
                        .addComponent(jLabel8)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(jLabel7))))
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
                .addGap(18, 18, 18)
                .addComponent(lnalog_L2)
                .addContainerGap(26, Short.MAX_VALUE))
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

    private void regis_LMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regis_LMousePressed
        new RegisterUserForm().show();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_regis_LMousePressed

    private void login_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_BActionPerformed
        if (this.lusername_TF.getText().equals("") || this.lusername_TF.getText().equals("Username")) {
            new DialogMessage("Obaveštenje", "Neophodno je uneti username!", "U redu").show();
        } else {
            if (this.lpassword_TF_pass.getText().equals("")) {
                new DialogMessage("Obaveštenje", "Neophodno je uneti password!", "U redu").show();
            } else {
                if (checkUserDataName(this.lusername_TF.getText().trim())) {
                    new DialogMessage("Greška", "<html><p  style=\"line-height:85%;text-align:center;\">Neophodno je uneti ispravan</p><p style=\"line-height:85%;text-align:center;\"> username!</p></html>", "U redu").show();
                } else {
                    if (checkUserDataPassword(String.valueOf(this.lpassword_TF_pass.getPassword()), this.lusername_TF.getText())) {
                        new DialogMessage("Greška", "<html><p  style=\"line-height:85%;text-align:center;\">Neophodno je uneti ispravan</p><p style=\"line-height:85%;text-align:center;\"> password!</p></html>", "U redu").show();
                    } else {
                        new sistem.eb.interfaces.InterfaceUser(this.lusername_TF.getText()).show();
                        this.dispose();
                    }
                }
            }
        }
    }//GEN-LAST:event_login_BActionPerformed

    private void lusername_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lusername_TFKeyPressed
        textHolderFunction(this.lpstart++, this.lusername_TF);
    }//GEN-LAST:event_lusername_TFKeyPressed

    private void lpassword_TF_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lpassword_TF_passKeyPressed
        textHolderFunction(this.lustart++, this.lpassword_TF_pass);
    }//GEN-LAST:event_lpassword_TF_passKeyPressed

    private void lnalog_L2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnalog_L2MousePressed
        new LoginAdministratorForm().show();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_lnalog_L2MousePressed

    private void lusername_TFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lusername_TFMousePressed
        textHolderFunction(this.lpstart++, this.lusername_TF);
    }//GEN-LAST:event_lusername_TFMousePressed

    private void lpassword_TF_passMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lpassword_TF_passMousePressed
        textHolderFunction(this.lustart++, this.lpassword_TF_pass);
    }//GEN-LAST:event_lpassword_TF_passMousePressed

    private void lusername_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lusername_TFMouseClicked
        textHolderFunction(this.lpstart++, this.lusername_TF);
    }//GEN-LAST:event_lusername_TFMouseClicked

    private void lpassword_TF_passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lpassword_TF_passMouseClicked
        textHolderFunction(this.lustart++, this.lpassword_TF_pass);
    }//GEN-LAST:event_lpassword_TF_passMouseClicked

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new LoginUserForm().setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
    }

    public static void textHolderFunction(int number, JTextField jTextField1) {
        if (number == 0) {
            jTextField1.setText("");
        }
    }

    public boolean checkUserDataName(String name) {
        boolean checkName = false;
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();

            java.sql.ResultSet rs = st.executeQuery("select name from users where name= '" + name + "'");
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

    public boolean checkUserDataPassword(String password, String username) {
        boolean checkPassword = true;
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();

            java.sql.ResultSet rs = st.executeQuery("select * from users where name= '" + username + "'");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lnalog_L;
    private javax.swing.JLabel lnalog_L2;
    private javax.swing.JButton login_B;
    private javax.swing.JPasswordField lpassword_TF_pass;
    private javax.swing.JTextField lusername_TF;
    private javax.swing.JLabel regis_L;
    // End of variables declaration//GEN-END:variables
}
