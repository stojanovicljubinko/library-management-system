/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package sistem.eb.icons;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static sistem.eb.icons.zub.KontrolerIksOks.novaIgra;
import static sistem.eb.icons.zub.KontrolerIksOks.oznaciti;
import sistem.eb.login_registration.DialogMessage;

/**
 *
 * @author vojvoda
 */
public class zub extends javax.swing.JPanel {

    class KontrolerIksOks {

        static int[][] tabla;
        static int igrac;
        static int oznaceno;

        KontrolerIksOks() {
            this.tabla = new int[3][3];
            this.igrac = 1;
            this.oznaceno = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.tabla[i][j] = 0;
                }
            }
        }

        public static void novaIgra() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tabla[i][j] = 0;
                }
            }
            igrac = 1;
            oznaceno = 0;
        }

        public static int oznaciti(int i, int j, JLabel trenutniIgrac_L) {

            int povratak;
            int tab[][] = tabla;
            if (tab[i][j] != 0) {
                povratak = 0;
            } else {
                int igr = igrac;
                int ozn = oznaceno;
                tabla[i][j] = igr;
                oznaceno = ozn + 1;
                provera();
                povratak = igr;
                if (igr == 1) {
                    igrac = 2;
                } else {
                    igrac = 1;
                }
                trenutniIgrac_L.setText(Integer.toString(igrac));
            }

            return povratak;
        }

        public static void provera() {
            int racun = oznaceno;
            //prvo proveri ima li pobednika
            //da li pobednik postoji
            int pobednik = proveriPobednika();
            if (pobednik != 0) {
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Igrac " + pobednik + " je pobedio!", "U redu").show();
            } else if (racun == 9) {
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Nema pobednika!", "U redu").show();
            }
        }

        public static int proveriPobednika() {
            int povratak = 0;
            int tab[][] = tabla;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(tab[i][j] + " ");
                }
                System.out.print("\n");
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
            return povratak;
        }
    }

    public zub() {
        initComponents();
    }

    public void upozorenje(String poruka) {
        napomena_L.setText(poruka);
        obavestenje_L.setVisible(true);
    }

    public void resetPolja() {
        one.setText("");
        two.setText("");
        three.setText("");
        four.setText("");
        five.setText("");
        six.setText("");
        seven.setText("");
        eight.setText("");
        nines.setText("");
        trenutniIgrac_L.setText("1");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        obavestenje_L = new javax.swing.JDialog();
        novaigra2_B = new javax.swing.JButton();
        napomena_L = new java.awt.Label();
        ugasi_B = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        trenutniIgrac_L = new javax.swing.JLabel();
        JButton6 = new javax.swing.JButton();
        four = new javax.swing.JLabel();
        seven = new javax.swing.JLabel();
        one = new javax.swing.JLabel();
        five = new javax.swing.JLabel();
        eight = new javax.swing.JLabel();
        three = new javax.swing.JLabel();
        six = new javax.swing.JLabel();
        nines = new javax.swing.JLabel();
        two = new javax.swing.JLabel();

        obavestenje_L.setTitle("Obavestenje");
        obavestenje_L.setAlwaysOnTop(true);
        obavestenje_L.setForeground(java.awt.Color.gray);
        obavestenje_L.setLocation(new java.awt.Point(50, 50));
        obavestenje_L.setName("caixaAlerta"); // NOI18N
        obavestenje_L.setResizable(false);
        obavestenje_L.setSize(new java.awt.Dimension(350, 250));
        obavestenje_L.setType(java.awt.Window.Type.POPUP);

        novaigra2_B.setText("Nova igra");
        novaigra2_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                novaigra2_BMousePressed(evt);
            }
        });
        novaigra2_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaigra2_BActionPerformed(evt);
            }
        });

        napomena_L.setAlignment(java.awt.Label.CENTER);
        napomena_L.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        napomena_L.setName(""); // NOI18N
        napomena_L.setText("Obavestenje");

        ugasi_B.setText("Izlaz");
        ugasi_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ugasi_BMousePressed(evt);
            }
        });
        ugasi_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ugasi_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout obavestenje_LLayout = new javax.swing.GroupLayout(obavestenje_L.getContentPane());
        obavestenje_L.getContentPane().setLayout(obavestenje_LLayout);
        obavestenje_LLayout.setHorizontalGroup(
            obavestenje_LLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(obavestenje_LLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(novaigra2_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(ugasi_B)
                .addGap(63, 63, 63))
            .addComponent(napomena_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        obavestenje_LLayout.setVerticalGroup(
            obavestenje_LLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(obavestenje_LLayout.createSequentialGroup()
                .addComponent(napomena_L, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(obavestenje_LLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novaigra2_B)
                    .addComponent(ugasi_B))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setMaximumSize(new java.awt.Dimension(1069, 446));
        setPreferredSize(new java.awt.Dimension(1069, 446));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Igrač II - O");

        jPanel4.setBackground(new java.awt.Color(70, 130, 180));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(70, 130, 180));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(70, 130, 180));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(70, 130, 180));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jPanel20.setBackground(new java.awt.Color(70, 130, 180));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 129, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jPanel21.setBackground(new java.awt.Color(70, 130, 180));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 129, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jPanel22.setBackground(new java.awt.Color(70, 130, 180));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jPanel23.setBackground(new java.awt.Color(70, 130, 180));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Igrač I - X");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Na redu igrač:");

        trenutniIgrac_L.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        trenutniIgrac_L.setForeground(new java.awt.Color(102, 102, 102));
        trenutniIgrac_L.setText("0");

        JButton6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        JButton6.setForeground(new java.awt.Color(102, 102, 102));
        JButton6.setText("Nova igra");
        JButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton6ActionPerformed(evt);
            }
        });

        four.setPreferredSize(new java.awt.Dimension(129, 128));
        four.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fourMousePressed(evt);
            }
        });

        seven.setPreferredSize(new java.awt.Dimension(129, 128));
        seven.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sevenMousePressed(evt);
            }
        });

        one.setPreferredSize(new java.awt.Dimension(129, 128));
        one.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                oneMousePressed(evt);
            }
        });

        five.setPreferredSize(new java.awt.Dimension(129, 128));
        five.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fiveMousePressed(evt);
            }
        });

        eight.setPreferredSize(new java.awt.Dimension(129, 128));
        eight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eightMousePressed(evt);
            }
        });

        three.setPreferredSize(new java.awt.Dimension(129, 128));
        three.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                threeMousePressed(evt);
            }
        });

        six.setPreferredSize(new java.awt.Dimension(129, 128));
        six.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sixMousePressed(evt);
            }
        });

        nines.setPreferredSize(new java.awt.Dimension(129, 128));
        nines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ninesMousePressed(evt);
            }
        });

        two.setPreferredSize(new java.awt.Dimension(129, 128));
        two.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                twoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(trenutniIgrac_L))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(nines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(JButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(trenutniIgrac_L))
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton6ActionPerformed
        KontrolerIksOks.novaIgra();
        this.resetPolja();
        obavestenje_L.setVisible(false);
    }//GEN-LAST:event_JButton6ActionPerformed

    private void oneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneMousePressed
        int igrac = oznaciti(0, 0, trenutniIgrac_L);
        if (igrac == 1) {
            one.setText("X");
        } else if (igrac == 2) {
            one.setText("O");
        }
    }//GEN-LAST:event_oneMousePressed

    private void twoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twoMousePressed
        int igrac = oznaciti(0, 1, trenutniIgrac_L);
        if (igrac == 1) {
            two.setText("X");
        } else if (igrac == 2) {
            two.setText("O");
        }
    }//GEN-LAST:event_twoMousePressed

    private void threeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threeMousePressed
        int igrac = oznaciti(0, 2, trenutniIgrac_L);
        if (igrac == 1) {
            three.setText("X");
        } else if (igrac == 2) {
            three.setText("O");
        }
    }//GEN-LAST:event_threeMousePressed

    private void fourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fourMousePressed
        int igrac = oznaciti(1, 0, trenutniIgrac_L);
        if (igrac == 1) {
            four.setText("X");
        } else if (igrac == 2) {
            four.setText("O");
        }
    }//GEN-LAST:event_fourMousePressed

    private void fiveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fiveMousePressed
        int igrac = oznaciti(1, 1, trenutniIgrac_L);
        if (igrac == 1) {
            five.setText("X");
        } else if (igrac == 2) {
            five.setText("O");
        }
    }//GEN-LAST:event_fiveMousePressed

    private void sixMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sixMousePressed
        int igrac = oznaciti(1, 2, trenutniIgrac_L);
        if (igrac == 1) {
            six.setText("X");
        } else if (igrac == 2) {
            six.setText("O");
        }
    }//GEN-LAST:event_sixMousePressed

    private void sevenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sevenMousePressed
        int igrac = oznaciti(2, 0, trenutniIgrac_L);
        if (igrac == 1) {
            seven.setText("X");
        } else if (igrac == 2) {
            seven.setText("O");
        }
    }//GEN-LAST:event_sevenMousePressed

    private void eightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eightMousePressed
        int igrac = oznaciti(2, 1, trenutniIgrac_L);
        if (igrac == 1) {
            eight.setText("X");
        } else if (igrac == 2) {
            eight.setText("O");
        }
    }//GEN-LAST:event_eightMousePressed

    private void ninesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ninesMousePressed
        int igrac = oznaciti(2, 2, trenutniIgrac_L);
        if (igrac == 1) {
            nines.setText("X");
        } else if (igrac == 2) {
            nines.setText("O");
        }
    }//GEN-LAST:event_ninesMousePressed

    private void novaigra2_BMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_novaigra2_BMousePressed
        novaIgra();
        this.resetPolja();
        obavestenje_L.setVisible(false);
    }//GEN-LAST:event_novaigra2_BMousePressed

    private void novaigra2_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaigra2_BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novaigra2_BActionPerformed

    private void ugasi_BMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ugasi_BMousePressed
        this.setVisible(false);
    }//GEN-LAST:event_ugasi_BMousePressed

    private void ugasi_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ugasi_BActionPerformed
        obavestenje_L.setVisible(false);
        this.setVisible(false);
    }//GEN-LAST:event_ugasi_BActionPerformed
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DialogMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButton6;
    private javax.swing.JLabel eight;
    private javax.swing.JLabel five;
    private javax.swing.JLabel four;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel4;
    private java.awt.Label napomena_L;
    private javax.swing.JLabel nines;
    private javax.swing.JButton novaigra2_B;
    private javax.swing.JDialog obavestenje_L;
    private javax.swing.JLabel one;
    private javax.swing.JLabel seven;
    private javax.swing.JLabel six;
    private javax.swing.JLabel three;
    private javax.swing.JLabel trenutniIgrac_L;
    private javax.swing.JLabel two;
    private javax.swing.JButton ugasi_B;
    // End of variables declaration//GEN-END:variables
}
