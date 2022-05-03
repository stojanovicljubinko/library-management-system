package sistem.eb.games;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Quiz extends javax.swing.JFrame {

    final long SEED = ThreadLocalRandom.current().nextLong(1000000, 100000000);
    List<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();
    List<String> arrayQuestions = new ArrayList<String>();
    List<String> arrayKeys = new ArrayList<String>();

    int questionNumber = 1, questionIndex = 0, correctQuestions = 0;
    String keyString = null, currentString = null;
    String player;

    public Quiz(String player) {
        initComponents();
        this.player = player;
        this.brojPitanja_TF.setHorizontalAlignment(this.brojPitanja_TF.CENTER);
        prepareQuiz();
        try{setValues();}catch(java.lang.IndexOutOfBoundsException e){}
        setIconImage(Toolkit.getDefaultToolkit().getImage(sistem.eb.interfaces.InterfaceAdministrator.PATH_FOLDER + "\\src\\sistem\\eb\\icons\\logo.png"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        obavestenje_L = new javax.swing.JDialog();
        novaigra2_B = new javax.swing.JButton();
        napomena_L = new java.awt.Label();
        ugasi_B = new javax.swing.JButton();
        rezultatNapomena_L = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tekst2_RB = new javax.swing.JRadioButton();
        tekst1_RB = new javax.swing.JRadioButton();
        tekst3_RB = new javax.swing.JRadioButton();
        tekst4_RB = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pitanje_TA = new javax.swing.JTextArea();
        brojPitanja_TF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        config_B = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        nuberofquestion_L = new javax.swing.JLabel();
        answers_L = new javax.swing.JLabel();
        answersNumber_L = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

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

        rezultatNapomena_L.setAlignment(java.awt.Label.CENTER);
        rezultatNapomena_L.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        rezultatNapomena_L.setName(""); // NOI18N
        rezultatNapomena_L.setText("Obavestenje");

        javax.swing.GroupLayout obavestenje_LLayout = new javax.swing.GroupLayout(obavestenje_L.getContentPane());
        obavestenje_L.getContentPane().setLayout(obavestenje_LLayout);
        obavestenje_LLayout.setHorizontalGroup(
            obavestenje_LLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(napomena_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(obavestenje_LLayout.createSequentialGroup()
                .addGroup(obavestenje_LLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(obavestenje_LLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rezultatNapomena_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(obavestenje_LLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(novaigra2_B)
                        .addGap(82, 82, 82)
                        .addComponent(ugasi_B)
                        .addGap(0, 86, Short.MAX_VALUE)))
                .addContainerGap())
        );
        obavestenje_LLayout.setVerticalGroup(
            obavestenje_LLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(obavestenje_LLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(napomena_L, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rezultatNapomena_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(obavestenje_LLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novaigra2_B)
                    .addComponent(ugasi_B))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kviz sistema elektrosne biblioteke - SEB");
        setResizable(false);

        jLabel8.setText("4.");

        buttonGroup1.add(tekst2_RB);
        tekst2_RB.setText("odgovor b");
        tekst2_RB.setFocusable(false);

        buttonGroup1.add(tekst1_RB);
        tekst1_RB.setText("odgovor a");
        tekst1_RB.setFocusable(false);

        buttonGroup1.add(tekst3_RB);
        tekst3_RB.setText("odgovor c");
        tekst3_RB.setFocusable(false);

        buttonGroup1.add(tekst4_RB);
        tekst4_RB.setText("odgovor d");
        tekst4_RB.setFocusable(false);

        pitanje_TA.setColumns(20);
        pitanje_TA.setLineWrap(true);
        pitanje_TA.setRows(5);
        pitanje_TA.setWrapStyleWord(true);
        pitanje_TA.setFocusable(false);
        jScrollPane1.setViewportView(pitanje_TA);

        brojPitanja_TF.setEditable(false);
        brojPitanja_TF.setBackground(new java.awt.Color(255, 255, 255));
        brojPitanja_TF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        brojPitanja_TF.setForeground(new java.awt.Color(102, 102, 102));
        brojPitanja_TF.setText("0");
        brojPitanja_TF.setActionCommand("<Not Set>");
        brojPitanja_TF.setAutoscrolls(false);
        brojPitanja_TF.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        brojPitanja_TF.setFocusable(false);

        jLabel5.setText("1.");

        jLabel6.setText("3.");

        jLabel7.setText("2.");

        jPanel2.setBackground(new java.awt.Color(70, 130, 180));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("elektronske biblioteke");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SISTEMA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KVIZ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))))
        );

        config_B.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        config_B.setForeground(new java.awt.Color(102, 102, 102));
        config_B.setText("Potvrdi");
        config_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                config_BActionPerformed(evt);
            }
        });

        nuberofquestion_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nuberofquestion_L.setForeground(new java.awt.Color(102, 102, 102));
        nuberofquestion_L.setText("Pitanje 0 od 0 ");
        nuberofquestion_L.setFocusable(false);

        answers_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        answers_L.setForeground(new java.awt.Color(102, 102, 102));
        answers_L.setText("Broj tačnih odgovora:");
        answers_L.setFocusable(false);

        answersNumber_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        answersNumber_L.setForeground(new java.awt.Color(102, 102, 102));
        answersNumber_L.setText("0");
        answersNumber_L.setFocusable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(nuberofquestion_L, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(answers_L)
                .addGap(18, 18, 18)
                .addComponent(answersNumber_L)
                .addGap(133, 133, 133))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuberofquestion_L)
                    .addComponent(answers_L)
                    .addComponent(answersNumber_L))
                .addContainerGap())
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/quiz.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(brojPitanja_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tekst3_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tekst1_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(67, 67, 67)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tekst2_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tekst4_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(config_B, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brojPitanja_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tekst2_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tekst4_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(config_B)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tekst1_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tekst3_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void novaigra2_BMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_novaigra2_BMousePressed

    }//GEN-LAST:event_novaigra2_BMousePressed

    private void novaigra2_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaigra2_BActionPerformed

    }//GEN-LAST:event_novaigra2_BActionPerformed

    private void ugasi_BMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ugasi_BMousePressed

    }//GEN-LAST:event_ugasi_BMousePressed

    private void ugasi_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ugasi_BActionPerformed

    }//GEN-LAST:event_ugasi_BActionPerformed

    private void config_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_config_BActionPerformed
        JRadioButton butt = null;
        try {
            if (buttonGroup1.isSelected(tekst1_RB.getModel()) || buttonGroup1.isSelected(tekst2_RB.getModel()) || buttonGroup1.isSelected(tekst3_RB.getModel()) || buttonGroup1.isSelected(tekst4_RB.getModel())) {
                butt = getSelected(this.tekst1_RB, this.tekst2_RB, this.tekst3_RB, this.tekst4_RB);

                if (this.keyString.equals(this.currentString)) {
                    //quiz fix <html> string </html>
                    this.answersNumber_L.setText(String.valueOf(++this.correctQuestions));
                    buttonGroup1.clearSelection();
                }
                if (this.questionNumber <= this.arrayList.size()) {
                    this.questionIndex++;
                    setValues();
                    this.buttonGroup1.clearSelection();
                }
            } else {
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti odgovor!", "U redu").show();
            }
            this.brojPitanja_TF.setText(String.valueOf(++this.questionNumber));
            this.nuberofquestion_L.setText("Pitanje  " + String.valueOf(this.questionNumber) + "  od  " + sistem.eb.interfaces.InterfaceAdministrator.getCountRows("QUIZDATA"));
        } catch (java.lang.IndexOutOfBoundsException e) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
        if (this.questionIndex == this.arrayList.size()) {
            this.config_B.setEnabled(false);
            if (this.correctQuestions == 0) {
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Nažalost nemate ni jedan tačan odgovor!", "U redu").show();
                this.addQuizResult(this.correctQuestions);
            } else {
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "<html><p  style=\"line-height:85%;text-align:center;\">Čestitamo!</p><p style=\"line-height:85%;text-align:center;\">Imate ukupno " + this.correctQuestions + " tačnih odgovora!</p></html>", "U redu").show();
                this.addQuizResult(this.correctQuestions);
            }
        }
    }//GEN-LAST:event_config_BActionPerformed
    protected JRadioButton getSelected(JRadioButton jRadioButton1, JRadioButton jRadioButton2, JRadioButton jRadioButton3, JRadioButton jRadioButton4) {
        JRadioButton newButton = null;
        if (jRadioButton1.isSelected()) {
            this.currentString = jRadioButton1.getText();
            newButton = jRadioButton1;
        } else if (jRadioButton2.isSelected()) {
            this.currentString = jRadioButton2.getText();
            newButton = jRadioButton2;
        } else if (jRadioButton3.isSelected()) {
            this.currentString = jRadioButton3.getText();
            newButton = jRadioButton3;
        } else if (jRadioButton4.isSelected()) {
            this.currentString = jRadioButton4.getText();
            newButton = jRadioButton4;
        }
        return newButton;
    }

    protected void addQuizResult(int corectAnswers) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement ps = con.prepareStatement("insert into QUIZLOG(PLAYER, NUMBEROFCORRECTANSWERS, DATE) values(?,?,?)");
            ps.setString(1, this.player);
            ps.setString(2, String.valueOf(corectAnswers));
            ps.setString(3, sistem.eb.interfaces.InterfaceAdministrator.CLOCK);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    private void prepareQuiz() {
        try {

            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select * from QUIZDATA");

            this.brojPitanja_TF.setText(String.valueOf(this.questionNumber));
            this.nuberofquestion_L.setText("Pitanje  " + String.valueOf(this.questionNumber) + "  od  " + sistem.eb.interfaces.InterfaceAdministrator.getCountRows("QUIZDATA"));

            while (rs.next()) {
                List<String> answerArr = new ArrayList<String>();
                this.arrayQuestions.add(rs.getString("QUESTION"));
                answerArr.add(rs.getString("FIRSTANSWER"));
                answerArr.add(rs.getString("SECUNDANSWER"));
                answerArr.add(rs.getString("THIRDANSWER"));
                answerArr.add(rs.getString("FOURTHANSWER"));
                this.arrayKeys.add(rs.getString("KEYANSWER"));
                Collections.shuffle(answerArr, new Random(SEED));
                this.arrayList.add((ArrayList<String>) answerArr);
            }
            Collections.shuffle(arrayList, new Random(SEED));
            Collections.shuffle(arrayQuestions, new Random(SEED));
            Collections.shuffle(arrayKeys, new Random(SEED));

            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    private void setValues() {
        List<Integer> arrayRandom = new ArrayList<Integer>(
                Arrays.asList(0, 1, 2, 3));

        Collections.shuffle(arrayRandom);
        this.pitanje_TA.setText(this.arrayQuestions.get(this.questionIndex));
        this.tekst1_RB.setText("<html><body><p>" + this.arrayList.get(this.questionIndex).get(arrayRandom.get(0)) + "</p></body></html>");
        this.tekst2_RB.setText("<html><body><p>" + this.arrayList.get(this.questionIndex).get(arrayRandom.get(1)) + "</p></body></html>");
        this.tekst3_RB.setText("<html><body><p>" + this.arrayList.get(this.questionIndex).get(arrayRandom.get(2)) + "</p></body></html>");
        this.tekst4_RB.setText("<html><body><p>" + this.arrayList.get(this.questionIndex).get(arrayRandom.get(3)) + "</p></body></html>");
        this.keyString = this.arrayKeys.get(this.questionIndex);
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Quiz(null).setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel answersNumber_L;
    private javax.swing.JLabel answers_L;
    private javax.swing.JTextField brojPitanja_TF;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JButton config_B;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label napomena_L;
    private javax.swing.JButton novaigra2_B;
    private javax.swing.JLabel nuberofquestion_L;
    private javax.swing.JDialog obavestenje_L;
    private javax.swing.JTextArea pitanje_TA;
    private java.awt.Label rezultatNapomena_L;
    private javax.swing.JRadioButton tekst1_RB;
    private javax.swing.JRadioButton tekst2_RB;
    private javax.swing.JRadioButton tekst3_RB;
    private javax.swing.JRadioButton tekst4_RB;
    private javax.swing.JButton ugasi_B;
    // End of variables declaration//GEN-END:variables
}
