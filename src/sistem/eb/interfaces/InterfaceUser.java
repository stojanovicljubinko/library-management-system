package sistem.eb.interfaces;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sistem.eb.games.Quiz;
import sistem.eb.games.XO;
import sistem.eb.interfaces.interfaceuserclasses.AvailableBooks;
import sistem.eb.interfaces.interfaceuserclasses.FeedBack;

class GraphicInterfaceUser {

    protected static void setSelectedColour(JPanel JSelectedPanel) {
        JSelectedPanel.setBackground(Color.decode("#638FB4"));
    }

    protected static void setUnselectedColour(JPanel JUnselectedPanel) {
        JUnselectedPanel.setBackground(Color.decode("#FFFFFF"));
    }

    protected static void JControler(ArrayList<JPanel> plist, JPanel selectedPanel) {
        for (JPanel JPanel : plist) {
            if (JPanel == selectedPanel) {
                GraphicInterfaceUser.setSelectedColour(JPanel);
            } else {
                GraphicInterfaceUser.setUnselectedColour(JPanel);
            }
        }
    }

    protected static void setSelectedColour(JLabel JSelectedLabel) {
        JSelectedLabel.setForeground(Color.decode("#FFFFFF"));
    }

    protected static void setUnselectedColour(JLabel JUnelectedLabel) {
        JUnelectedLabel.setForeground(Color.decode("#666666"));
    }

    protected static void JControler(ArrayList<JLabel> llist, JLabel selectedLabel) {
        for (JLabel JLabel : llist) {
            if (JLabel == selectedLabel) {
                GraphicInterfaceUser.setSelectedColour(JLabel);
            } else {
                GraphicInterfaceUser.setUnselectedColour(JLabel);
            }
        }
    }
}

public class InterfaceUser extends javax.swing.JFrame {

    ArrayList<JPanel> plist;
    ArrayList<JLabel> llist;
    Thread chatThread;

    sistem.eb.games.XO xo;
    sistem.eb.games.Quiz quiz;
    sistem.eb.interfaces.interfaceuserclasses.AvailableBooks available = new AvailableBooks();
    sistem.eb.interfaces.interfaceuserclasses.FeedBack feedback;

    public InterfaceUser(String username) {
        initComponents();
        quiz = new Quiz(username);
        sistem.eb.messager.Server server = new  sistem.eb.messager.Server(1100);
        chatThread = new Thread(server);
        chatThread.start();
        xo = new XO(username);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png")));
        plist = new ArrayList<JPanel>() {
            {
                add(jPanel2);
                add(jPanel3);
                add(jPanel4);
                add(jPanel5);
                add(jPanel6);
                add(jPanel7);
            }
        };

        llist = new ArrayList<JLabel>() {
            {
                add(home_L);
                add(available_L);
                add(quiz_L);
                add(xo_L);
                add(message_L);
                add(exit_L);
            }
        };
        this.home_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.available_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.quiz_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.xo_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.message_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.exit_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        this.homeicon_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.availableicon_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.quizicon_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.xoicon_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.messageicon_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.exiticon_L.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        feedback = new FeedBack(username);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        homeicon_L = new javax.swing.JLabel();
        home_L = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        available_L = new javax.swing.JLabel();
        availableicon_L = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        quiz_L = new javax.swing.JLabel();
        quizicon_L = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        messageicon_L = new javax.swing.JLabel();
        message_L = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        exit_L = new javax.swing.JLabel();
        exiticon_L = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        xoicon_L = new javax.swing.JLabel();
        xo_L = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem EB - Glavni interfejs korisnika u sistemu elektronske biblioteke");

        jPanel1.setBackground(new java.awt.Color(70, 130, 180));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SISTEM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lako i jednostavno do vaših knjiga");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 260, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("biblioteke");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Elektronske");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PRIČAONICA");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 160, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/chat.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(99, 143, 180));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeicon_LMouseClicked(evt);
            }
        });

        homeicon_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/home.png"))); // NOI18N
        homeicon_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeicon_LMouseClicked(evt);
            }
        });

        home_L.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        home_L.setForeground(new java.awt.Color(255, 255, 255));
        home_L.setText("Početna stranica");
        home_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeicon_LMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home_L, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homeicon_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(homeicon_L)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(home_L)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableicon_LMouseClicked(evt);
            }
        });

        available_L.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        available_L.setForeground(new java.awt.Color(102, 102, 102));
        available_L.setText("Dostupne knjige");
        available_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableicon_LMouseClicked(evt);
            }
        });

        availableicon_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/books.png"))); // NOI18N
        availableicon_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableicon_LMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(available_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(availableicon_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(availableicon_L)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(available_L)
                .addGap(35, 35, 35))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quizicon_LMouseClicked(evt);
            }
        });

        quiz_L.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        quiz_L.setForeground(new java.awt.Color(102, 102, 102));
        quiz_L.setText("Kviz književnosti");
        quiz_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quizicon_LMouseClicked(evt);
            }
        });

        quizicon_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/quiz.png"))); // NOI18N
        quizicon_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quizicon_LMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(quiz_L, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
            .addComponent(quizicon_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(quizicon_L)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quiz_L)
                .addGap(35, 35, 35))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageicon_LMouseClicked(evt);
            }
        });

        messageicon_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/message.png"))); // NOI18N
        messageicon_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageicon_LMouseClicked(evt);
            }
        });

        message_L.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        message_L.setForeground(new java.awt.Color(102, 102, 102));
        message_L.setText("Pošalji poruku");
        message_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageicon_LMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(message_L, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
            .addComponent(messageicon_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(messageicon_L)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(message_L)
                .addGap(35, 35, 35))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exiticon_LMouseClicked(evt);
            }
        });

        exit_L.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        exit_L.setForeground(new java.awt.Color(102, 102, 102));
        exit_L.setText("Izlaz");
        exit_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exiticon_LMouseClicked(evt);
            }
        });

        exiticon_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/exit.png"))); // NOI18N
        exiticon_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exiticon_LMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(exiticon_L, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(exiticon_L)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exit_L)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xoicon_LMouseClicked(evt);
            }
        });

        xoicon_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/xo.png"))); // NOI18N
        xoicon_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xoicon_LMouseClicked(evt);
            }
        });

        xo_L.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        xo_L.setForeground(new java.awt.Color(102, 102, 102));
        xo_L.setText("X-O (u dvoje)");
        xo_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xoicon_LMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(xo_L, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
            .addComponent(xoicon_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(xoicon_L)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xo_L, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void availableicon_LMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableicon_LMouseClicked
        this.available.setVisible(!this.available.isVisible());
        GraphicInterfaceUser.JControler(this.plist, this.jPanel3);
        GraphicInterfaceUser.JControler(llist, this.available_L);
    }//GEN-LAST:event_availableicon_LMouseClicked

    private void quizicon_LMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quizicon_LMouseClicked
        this.quiz.setVisible(!this.quiz.isVisible());
        GraphicInterfaceUser.JControler(this.plist, this.jPanel4);
        GraphicInterfaceUser.JControler(llist, this.quiz_L);
    }//GEN-LAST:event_quizicon_LMouseClicked

    private void homeicon_LMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeicon_LMouseClicked
        GraphicInterfaceUser.JControler(this.plist, this.jPanel2);
        GraphicInterfaceUser.JControler(llist, this.home_L);
    }//GEN-LAST:event_homeicon_LMouseClicked

    private void xoicon_LMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xoicon_LMouseClicked
        this.xo.setVisible(!this.xo.isVisible());
        GraphicInterfaceUser.JControler(this.plist, this.jPanel7);
        GraphicInterfaceUser.JControler(llist, this.xo_L);
    }//GEN-LAST:event_xoicon_LMouseClicked

    private void messageicon_LMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageicon_LMouseClicked
        this.feedback.setVisible(!this.feedback.isVisible());
        GraphicInterfaceUser.JControler(this.plist, this.jPanel6);
        GraphicInterfaceUser.JControler(llist, this.message_L);
    }//GEN-LAST:event_messageicon_LMouseClicked

    private void exiticon_LMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exiticon_LMouseClicked
        GraphicInterfaceUser.JControler(this.plist, this.jPanel5);
        GraphicInterfaceUser.JControler(llist, this.exit_L);
        this.dispose();
        new sistem.eb.login_registration.LoginUserForm().show();
    }//GEN-LAST:event_exiticon_LMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        sistem.eb.messager.interfaces.ClientInterface clientui = new sistem.eb.messager.interfaces.ClientInterface();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        sistem.eb.messager.interfaces.ClientInterface clientui = new sistem.eb.messager.interfaces.ClientInterface();
    }//GEN-LAST:event_jLabel7MouseClicked

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
            }

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new InterfaceUser(null).setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel available_L;
    private javax.swing.JLabel availableicon_L;
    private javax.swing.JLabel exit_L;
    private javax.swing.JLabel exiticon_L;
    private javax.swing.JLabel home_L;
    private javax.swing.JLabel homeicon_L;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel message_L;
    private javax.swing.JLabel messageicon_L;
    private javax.swing.JLabel quiz_L;
    private javax.swing.JLabel quizicon_L;
    private javax.swing.JLabel xo_L;
    private javax.swing.JLabel xoicon_L;
    // End of variables declaration//GEN-END:variables
}
