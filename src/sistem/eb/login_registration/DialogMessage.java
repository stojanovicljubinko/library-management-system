package sistem.eb.login_registration;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DialogMessage extends javax.swing.JFrame {

    JFrame JFrame1;

    public DialogMessage(String title, String message, String button) {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sistem/eb/icons/logo.png")));
        this.title_TF.setHorizontalAlignment(SwingConstants.CENTER);
        this.message_TF.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFocusable(true);

        this.title_TF.setText(title);
        this.message_TF.setText(message);
        this.ok_B.setText(button);

    }

    public DialogMessage(String title, String message, String button, JFrame frame) {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sistem/eb/icons/logo.png")));
        this.title_TF.setHorizontalAlignment(SwingConstants.CENTER);
        this.message_TF.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFocusable(true);

        this.title_TF.setText(title);
        this.message_TF.setText(message);
        this.ok_B.setText(button);
        JFrame1 = frame;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_TF = new javax.swing.JLabel();
        message_TF = new javax.swing.JLabel();
        ok_B = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistem EB - Dialog prozor u sistemu elektronske biblioteke");
        setAlwaysOnTop(true);

        title_TF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title_TF.setForeground(new java.awt.Color(102, 102, 102));
        title_TF.setText("Title");

        message_TF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        message_TF.setForeground(new java.awt.Color(102, 102, 102));
        message_TF.setText("message");

        ok_B.setBackground(new java.awt.Color(70, 130, 180));
        ok_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ok_B.setForeground(new java.awt.Color(255, 255, 255));
        ok_B.setText("button");
        ok_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(title_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(message_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(ok_B, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(title_TF)
                .addGap(18, 18, 18)
                .addComponent(message_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ok_B, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ok_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_BActionPerformed
        this.setVisible(false);
        this.dispose();

        if (JFrame1 != null) {
            JFrame1.setVisible(false);
            JFrame1.dispose();
        }
    }//GEN-LAST:event_ok_BActionPerformed

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel message_TF;
    private javax.swing.JButton ok_B;
    private javax.swing.JLabel title_TF;
    // End of variables declaration//GEN-END:variables
}
