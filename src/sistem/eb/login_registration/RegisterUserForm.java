package sistem.eb.login_registration;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RegisterUserForm extends javax.swing.JFrame {

    private int rustart = 0, restart = 0, rpstart = 0;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public RegisterUserForm() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sistem/eb/icons/logo.png")));
        username_TF.select(0, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        password_PF = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        email_TF = new javax.swing.JTextField();
        lnalog_L = new javax.swing.JLabel();
        login_B = new javax.swing.JButton();
        lnalog_L1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        username_TF = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem EB - Registrovanje korisnika u sistemu elektronske biblioteke");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Password");

        password_PF.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        password_PF.setForeground(new java.awt.Color(153, 153, 153));
        password_PF.setText("password");
        password_PF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                password_PFMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                password_PFMousePressed(evt);
            }
        });
        password_PF.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                password_PFPropertyChange(evt);
            }
        });
        password_PF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                password_PFKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Email");

        email_TF.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        email_TF.setForeground(new java.awt.Color(153, 153, 153));
        email_TF.setText("Password");
        email_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                email_TFMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                email_TFMousePressed(evt);
            }
        });
        email_TF.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                email_TFPropertyChange(evt);
            }
        });
        email_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                email_TFKeyPressed(evt);
            }
        });

        lnalog_L.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lnalog_L.setForeground(new java.awt.Color(102, 102, 102));
        lnalog_L.setText("Imam nalog?");

        login_B.setBackground(new java.awt.Color(204, 204, 204));
        login_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        login_B.setForeground(new java.awt.Color(102, 102, 102));
        login_B.setText("Registruj se");
        login_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_BActionPerformed(evt);
            }
        });

        lnalog_L1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lnalog_L1.setForeground(new java.awt.Color(58, 131, 191));
        lnalog_L1.setText("Prijavi se!");
        lnalog_L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lnalog_L1MousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/padlock_unlock.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Username");

        username_TF.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        username_TF.setForeground(new java.awt.Color(153, 153, 153));
        username_TF.setText("Username");
        username_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                username_TFMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                username_TFMousePressed(evt);
            }
        });
        username_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                username_TFKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(login_B, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(185, 185, 185))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lnalog_L)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lnalog_L1)
                .addGap(156, 156, 156))
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(password_PF, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(email_TF)
                    .addComponent(username_TF))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(32, 32, 32)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(email_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(password_PF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if (username_TF.getText().equals("")) {
            new DialogMessage("Obaveštenje", "Neophodno je uneti username!", "U redu").show();
        } else {
            if (email_TF.getText().equals("")) {
                new DialogMessage("Obaveštenje", "Neophodno je uneti email!", "U redu").show();
            } else {
                if (password_PF.getText().equals("")) {
                    new DialogMessage("Obaveštenje", "Neophodno je uneti password!", "U redu").show();
                } else {
                    if (checkUsername(username_TF.getText().trim())) {
                        if (checkEmail(email_TF.getText().trim())) {
                            if (validate(email_TF.getText().trim())) {
                                createUser();
                                new DialogMessage("Obaveštenje", "User je uspešno registrovan!", "U redu").show();
                                resetFields();
                            } else {
                                new DialogMessage("Greška", "Pogrešan format emaila!", "U redu").show();
                            }
                        } else {
                            new DialogMessage("Greška", "Korisnik sa ovim emailom već postoji!", "U redu").show();
                        }
                    } else {
                        new DialogMessage("Greška", "Korisnik sa ovim imenom već postoji!", "U redu").show();
                    }
                }
            }
        }
    }//GEN-LAST:event_login_BActionPerformed

    private void username_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_username_TFKeyPressed
        if (rustart == 0) {
            username_TF.setText("");
            rustart++;
        }
    }//GEN-LAST:event_username_TFKeyPressed

    private void email_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_email_TFKeyPressed
        if (restart == 0) {
            email_TF.setText("");
            restart++;
        }
    }//GEN-LAST:event_email_TFKeyPressed

    private void password_PFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password_PFKeyPressed
        if (rpstart == 0) {
            password_PF.setText("");
            rpstart++;
        }
    }//GEN-LAST:event_password_PFKeyPressed

    private void username_TFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_username_TFMousePressed
        if (rustart == 0) {
            username_TF.setText("");
            rustart++;
        }
    }//GEN-LAST:event_username_TFMousePressed

    private void email_TFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_email_TFMousePressed
        if (restart == 0) {
            email_TF.setText("");
            restart++;
        }
    }//GEN-LAST:event_email_TFMousePressed

    private void password_PFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_password_PFMousePressed
        if (rpstart == 0) {
            password_PF.setText("");
            rpstart++;
        }
    }//GEN-LAST:event_password_PFMousePressed

    private void email_TFPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_email_TFPropertyChange

    }//GEN-LAST:event_email_TFPropertyChange

    private void password_PFPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_password_PFPropertyChange

    }//GEN-LAST:event_password_PFPropertyChange

    private void username_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_username_TFMouseClicked
        if (rustart == 0) {
            username_TF.setText("");
            rustart++;
        }
    }//GEN-LAST:event_username_TFMouseClicked

    private void email_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_email_TFMouseClicked
        if (restart == 0) {
            email_TF.setText("");
            restart++;
        }
    }//GEN-LAST:event_email_TFMouseClicked

    private void password_PFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_password_PFMouseClicked
        if (rpstart == 0) {
            password_PF.setText("");
            rpstart++;
        }
    }//GEN-LAST:event_password_PFMouseClicked

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterUserForm().setVisible(true);
            }
        });
    }

    public void createUser() {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement ps = con.prepareStatement("insert into users(name,password,email) values(?,?,?)");
            ps.setString(1, username_TF.getText());
            ps.setString(2, password_PF.getText());
            ps.setString(3, email_TF.getText());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    public boolean checkUsername(String username) {
        boolean checkName = false;
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select name from users where name= '" + username + "'");

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

    public boolean checkEmail(String email) {
        boolean checkEmail = false;
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select email from users where email= '" + email + "'");
            if (rs.next()) {
                checkEmail = false;
            } else {
                checkEmail = true;
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
        return checkEmail;
    }

    public void resetFields() {
        username_TF.setText("");
        password_PF.setText("");
        email_TF.setText("");
    }
    
    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JTextField email_TF;
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
    private javax.swing.JPasswordField password_PF;
    private javax.swing.JTextField username_TF;
    // End of variables declaration//GEN-END:variables
}
