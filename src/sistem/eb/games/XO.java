package sistem.eb.games;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author vojvoda
 */
public class XO extends javax.swing.JFrame {

    private boolean gameOver = false;

    class XOControler {

        private int[][] table;
        private int person;
        private int selected;
        private XO screen;

        public XOControler(XO ekran) {
            this.screen = ekran;
            this.table = new int[3][3];
            this.person = 1;
            this.selected = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.table[i][j] = 0;
                }
            }
        }

        public void addXO(String player) {
            try {
                java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
                java.sql.PreparedStatement ps = con.prepareStatement("insert into IOLOG(PLAYER, DATE) values(?,?)");
                ps.setString(1, player);
                ps.setString(2, sistem.eb.interfaces.InterfaceAdministrator.CLOCK);
                ps.executeUpdate();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
            }
        }

        public int[][] getTabla() {
            return table;
        }

        public void setTable(int i, int j, int value) {
            this.table[i][j] = value;
        }

        public int getPerson() {
            return person;
        }

        public void setPerson(int person) {
            this.person = person;
        }

        public int getSelected() {
            return selected;
        }

        public void setSelected(int selected) {
            this.selected = selected;
        }

        public void newGame() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.setTable(i, j, 0);
                }
            }
            this.setPerson(1);
            this.setSelected(0);
        }

        public int select(int i, int j, String player) {

            int back;
            int tab[][] = this.getTabla();
            if (tab[i][j] != 0) {
                back = 0;
            } else {
                int igr = this.getPerson();
                int ozn = this.getSelected();
                this.setTable(i, j, igr);
                this.setSelected(ozn + 1);
                this.check(player);
                back = igr;
                if (igr == 1) {
                    this.setPerson(2);
                } else {
                    this.setPerson(1);
                }
                this.screen.showNextPlayer(this.getPerson());
            }

            return back;
        }

        public void check(String player) {
            int account = this.getSelected();
            //prvo proveri ima li pobednika
            //da li winer postoji
            int winer = this.checkWiner();
            if (winer != 0) {
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Igrac " + winer + " je pobedio!", "U redu").show(); //this.screen.upozorenje();
                gameOver = true;
                one.setIcon(null);
                two.setIcon(null);
                three.setIcon(null);
                four.setIcon(null);
                five.setIcon(null);
                six.setIcon(null);
                seven.setIcon(null);
                eight.setIcon(null);
                nines.setIcon(null);
                this.addXO(player);
            } else if (account == 9) {
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Nema pobednika!", "U redu").show();
                gameOver = true;
                this.addXO(player);
            }
        }

        public int checkWiner() {
            int back = 0;
            int tab[][] = this.getTabla();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // System.out.print(tab[i][j] + " ");
                }
                // System.out.print("\n");
            }
            if (tab[0][0] != 0) {
                if (tab[0][1] == tab[0][0]) {
                    if (tab[0][2] == tab[0][0]) {
                        return tab[0][0];
                    }
                }
                if (tab[1][1] == tab[0][0]) {
                    if (tab[2][2] == tab[0][0]) {
                        return tab[0][0];
                    }
                }
                if (tab[1][0] == tab[0][0]) {
                    if (tab[2][0] == tab[0][0]) {
                        return tab[0][0];
                    }
                }
            }
            if (tab[0][1] != 0) {
                if (tab[1][1] == tab[0][1]) {
                    if (tab[2][1] == tab[0][1]) {
                        return tab[0][1];
                    }
                }
            }
            if (tab[0][2] != 0) {
                if (tab[1][2] == tab[0][2]) {
                    if (tab[2][2] == tab[0][2]) {
                        return tab[0][2];
                    }
                }
            }
            if (tab[1][0] != 0) {
                if (tab[1][1] == tab[1][0]) {
                    if (tab[1][2] == tab[1][0]) {
                        return tab[1][0];
                    }
                }
            }
            if (tab[2][0] != 0) {
                if (tab[1][1] == tab[2][0]) {
                    if (tab[0][2] == tab[2][0]) {
                        return tab[2][0];
                    }
                }
                if (tab[2][1] == tab[2][0]) {
                    if (tab[2][2] == tab[2][0]) {
                        return tab[2][0];
                    }
                }
            }
            return back;
        }
    }

    public XOControler controler;
    String player;

    public XO(String player) {
        initComponents();
        this.player = player;
        setIconImage(Toolkit.getDefaultToolkit().getImage(sistem.eb.interfaces.InterfaceAdministrator.PATH_FOLDER + "\\src\\sistem\\eb\\icons\\logo.png"));
        this.one.setHorizontalAlignment(SwingConstants.CENTER);
        this.one.setVerticalAlignment(SwingConstants.CENTER);
        this.two.setHorizontalAlignment(SwingConstants.CENTER);
        this.two.setVerticalAlignment(SwingConstants.CENTER);
        this.three.setHorizontalAlignment(SwingConstants.CENTER);
        this.three.setVerticalAlignment(SwingConstants.CENTER);
        this.four.setHorizontalAlignment(SwingConstants.CENTER);
        this.four.setVerticalAlignment(SwingConstants.CENTER);
        this.five.setHorizontalAlignment(SwingConstants.CENTER);
        this.five.setVerticalAlignment(SwingConstants.CENTER);
        this.six.setHorizontalAlignment(SwingConstants.CENTER);
        this.six.setVerticalAlignment(SwingConstants.CENTER);
        this.seven.setHorizontalAlignment(SwingConstants.CENTER);
        this.seven.setVerticalAlignment(SwingConstants.CENTER);
        this.eight.setHorizontalAlignment(SwingConstants.CENTER);
        this.eight.setVerticalAlignment(SwingConstants.CENTER);
        this.nines.setHorizontalAlignment(SwingConstants.CENTER);
        this.nines.setVerticalAlignment(SwingConstants.CENTER);
        this.controler = new XO.XOControler(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel18 = new javax.swing.JPanel();
        nines = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        two = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        nowPlayer_L = new javax.swing.JLabel();
        JButton8 = new javax.swing.JButton();
        four = new javax.swing.JLabel();
        seven = new javax.swing.JLabel();
        one = new javax.swing.JLabel();
        five = new javax.swing.JLabel();
        eight = new javax.swing.JLabel();
        three = new javax.swing.JLabel();
        six = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("X-O sistema elektrosne biblioteke - SEB");
        setAlwaysOnTop(true);

        nines.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        nines.setForeground(new java.awt.Color(102, 102, 102));
        nines.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png"))); // NOI18N
        nines.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nines.setPreferredSize(new java.awt.Dimension(129, 128));
        nines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ninesMousePressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Na redu igrač:");

        two.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        two.setForeground(new java.awt.Color(102, 102, 102));
        two.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png"))); // NOI18N
        two.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        two.setPreferredSize(new java.awt.Dimension(129, 128));
        two.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                twoMousePressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Igrač II - O");

        nowPlayer_L.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nowPlayer_L.setForeground(new java.awt.Color(70, 130, 180));
        nowPlayer_L.setText("1");

        JButton8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        JButton8.setForeground(new java.awt.Color(102, 102, 102));
        JButton8.setText("Nova igra");
        JButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton8ActionPerformed(evt);
            }
        });

        four.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        four.setForeground(new java.awt.Color(102, 102, 102));
        four.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png"))); // NOI18N
        four.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        four.setPreferredSize(new java.awt.Dimension(129, 128));
        four.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fourMousePressed(evt);
            }
        });

        seven.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        seven.setForeground(new java.awt.Color(102, 102, 102));
        seven.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png"))); // NOI18N
        seven.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        seven.setPreferredSize(new java.awt.Dimension(129, 128));
        seven.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sevenMousePressed(evt);
            }
        });

        one.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        one.setForeground(new java.awt.Color(102, 102, 102));
        one.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png"))); // NOI18N
        one.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        one.setPreferredSize(new java.awt.Dimension(129, 128));
        one.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                oneMousePressed(evt);
            }
        });

        five.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        five.setForeground(new java.awt.Color(102, 102, 102));
        five.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png"))); // NOI18N
        five.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        five.setPreferredSize(new java.awt.Dimension(129, 128));
        five.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fiveMousePressed(evt);
            }
        });

        eight.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        eight.setForeground(new java.awt.Color(102, 102, 102));
        eight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png"))); // NOI18N
        eight.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eight.setPreferredSize(new java.awt.Dimension(129, 128));
        eight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eightMousePressed(evt);
            }
        });

        three.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        three.setForeground(new java.awt.Color(102, 102, 102));
        three.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png"))); // NOI18N
        three.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        three.setPreferredSize(new java.awt.Dimension(129, 128));
        three.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                threeMousePressed(evt);
            }
        });

        six.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        six.setForeground(new java.awt.Color(102, 102, 102));
        six.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/logointerfaceuser.png"))); // NOI18N
        six.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        six.setPreferredSize(new java.awt.Dimension(129, 128));
        six.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sixMousePressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Igrač I - X");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("igrač");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/iobig.png"))); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(nowPlayer_L)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(nines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(139, 139, 139)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(90, 90, 90))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(JButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(79, 79, 79))))))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {eight, five, four, nines, one, seven, six, three, two});

        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jLabel1))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel20)
                                            .addComponent(nowPlayer_L)
                                            .addComponent(jLabel23))
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21))
                                    .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)))))
                        .addGap(86, 86, 86)
                        .addComponent(JButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {eight, five, four, nines, one, seven, six, three, two});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sixMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sixMousePressed
        this.six.setIcon(null);
        if (this.gameOver == false) {
            int player = this.controler.select(1, 2, this.player);
            if (player == 1) {
                this.six.setText("X");
            } else if (player == 2) {
                this.six.setText("O");
            }
        }
    }//GEN-LAST:event_sixMousePressed

    private void threeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threeMousePressed
        this.three.setIcon(null);
        if (this.gameOver == false) {
            int player = this.controler.select(0, 2, this.player);
            if (player == 1) {
                this.three.setText("X");
            } else if (player == 2) {
                this.three.setText("O");
            }
        }
    }//GEN-LAST:event_threeMousePressed

    private void eightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eightMousePressed
        this.eight.setIcon(null);
        if (this.gameOver == false) {
            int player = this.controler.select(2, 1, this.player);
            if (player == 1) {
                this.eight.setText("X");
            } else if (player == 2) {
                this.eight.setText("O");
            }
        }
    }//GEN-LAST:event_eightMousePressed

    private void fiveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fiveMousePressed
        this.five.setIcon(null);
        if (this.gameOver == false) {
            int player = this.controler.select(1, 1, this.player);
            if (player == 1) {
                this.five.setText("X");
            } else if (player == 2) {
                this.five.setText("O");
            }
        }
    }//GEN-LAST:event_fiveMousePressed

    private void oneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneMousePressed
        this.one.setIcon(null);
        if (this.gameOver == false) {
            int player = this.controler.select(0, 0, this.player);
            if (player == 1) {
                this.one.setText("X");
            } else if (player == 2) {
                this.one.setText("O");
            }
        }
    }//GEN-LAST:event_oneMousePressed

    private void sevenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sevenMousePressed
        this.seven.setIcon(null);
        if (this.gameOver == false) {
            int player = this.controler.select(2, 0, this.player);
            if (player == 1) {
                this.seven.setText("X");
            } else if (player == 2) {
                this.seven.setText("O");
            }
        }
    }//GEN-LAST:event_sevenMousePressed

    private void fourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fourMousePressed
        this.four.setIcon(null);
        if (this.gameOver == false) {
            int player = this.controler.select(1, 0, this.player);
            if (player == 1) {
                this.four.setText("X");
            } else if (player == 2) {
                this.four.setText("O");
            }
        }
    }//GEN-LAST:event_fourMousePressed

    private void JButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton8ActionPerformed
        this.controler.newGame();
        this.resetFields();
    }//GEN-LAST:event_JButton8ActionPerformed

    private void twoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twoMousePressed
        this.two.setIcon(null);
        if (this.gameOver == false) {
            int player = this.controler.select(0, 1, this.player);

            if (player == 1) {
                this.two.setText("X");
            } else if (player == 2) {
                this.two.setText("O");
            }
        }
    }//GEN-LAST:event_twoMousePressed

    private void ninesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ninesMousePressed
        this.nines.setIcon(null);
        if (this.gameOver == false) {
            int player = this.controler.select(2, 2, this.player);
            if (player == 1) {
                this.nines.setText("X");
            } else if (player == 2) {
                this.nines.setText("O");
            }
        }
    }//GEN-LAST:event_ninesMousePressed

    public void showNextPlayer(int player) {
        nowPlayer_L.setText(Integer.toString(player));
    }

    public void resetFields() {
        this.one.setText("");
        this.two.setText("");
        this.three.setText("");
        this.four.setText("");
        this.five.setText("");
        this.six.setText("");
        this.seven.setText("");
        this.eight.setText("");
        this.nines.setText("");
        this.nowPlayer_L.setText("1");
        this.gameOver = false;
    }

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new XO(null).setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButton8;
    private javax.swing.JLabel eight;
    private javax.swing.JLabel five;
    private javax.swing.JLabel four;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JLabel nines;
    private javax.swing.JLabel nowPlayer_L;
    private javax.swing.JLabel one;
    private javax.swing.JLabel seven;
    private javax.swing.JLabel six;
    private javax.swing.JLabel three;
    private javax.swing.JLabel two;
    // End of variables declaration//GEN-END:variables
}
