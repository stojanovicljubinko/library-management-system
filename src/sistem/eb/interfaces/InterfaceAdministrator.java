package sistem.eb.interfaces;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import sistem.eb.games.Quiz;
import sistem.eb.games.XO;

class ThreadStopStart implements Runnable {

    boolean flag;

    public ThreadStopStart(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        System.out.println("Programska nit je pokrenuta!");

        while (!flag) {

            // tijelo njegovog zadatka
        }

        System.out.println("Programska nit je zaustavljena!");

    }

    public void stop() {
        flag = true;
    }

}

class TextEditor {

    //title case
    protected static String toTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }

    protected static String toProperCase(final String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    protected static String toUpperCase(final String s) {
        return s.toUpperCase();
    }

    protected static String toLowerCase(final String s) {
        return s.toLowerCase();
    }

    protected static String toSentanceCase(final String s) {
        return s.substring(0, 1).toUpperCase() + s.toLowerCase().substring(1);
    }

    protected static String toCapitalizeCase(String s) {
        char[] charArray = s.toCharArray();
        boolean foundSpace = true;

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                if (foundSpace) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            } else {
                foundSpace = true;
            }
        }
        s = String.valueOf(charArray);
        return s;
    }

    protected static String toAlternatecase(String s) {
        StringBuffer updatedString = new StringBuffer();
        char[] characters = s.toCharArray();
        for (int index = 0; index < characters.length; index++) {
            char c = characters[index];
            if (index % 2 != 0) {
                c = Character.toUpperCase(c);
            }
            updatedString.append(c);
        }
        return updatedString.toString();
    }

    protected static String toInverseCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }

    protected static String toReverseCase(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    protected static String toWideCase(String binary, int blockSize, String separator) {

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }

        return result.stream().collect(Collectors.joining(separator));
    }

    protected static String toMorseCode(String s) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            ',', '.', '?'};

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.."};

        String userInput = toLowerCase(s);

        char[] chars = userInput.toCharArray();

        String str = "";
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < letters.length; j++) {

                if (letters[j] == chars[i]) {
                    str = str + morse[j] + " ";
                }
            }
        }
        return str;
    }

    protected static String toTextMorse(String s) {

        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", "!", ",", "?", ".", "'"};
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "-.-.--", "--..--", "..--..", ".-.-.-", ".----.",};

        String build = "";
        String change = s.trim();
        String[] words = change.split("   ");
        for (String word : words) {
            for (String letter : word.split(" ")) {
                for (int x = 0; x < morse.length; x++) {
                    if (letter.equals(morse[x])) {
                        build = build + letters[x];
                    }
                }
            }
            build += " ";
        }

        return build;
    }

    protected static String toBinary(String s) {

        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))
                            .replaceAll(" ", "0")
            );
        }
        return result.toString();

    }

    protected static String toTextBinary(String s) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(s.replaceAll("\\s", "").split("(?<=\\G.{8})")).forEach(l -> sb.append((char) Integer.parseInt(l, 2)));

        return sb.toString();
    }

    protected static String toOctal(String s) {
        return s.chars().boxed().map(Integer::toOctalString)
                .collect(Collectors.joining(" "));
    }

    protected static String toTextOctal(String s) {
        Integer iOctal = 0;
        char cOctal = 'n';
        String[] words = s.split(" ");
        String all = "";

        for (String word : words) {
            iOctal = Integer.parseInt(word, 8);
            cOctal = (char) iOctal.intValue();
            all = all + cOctal;
        }
        return all;
    }

    protected static String toHex(String s) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            String charToHex = Integer.toHexString(c);
            stringBuilder.append(charToHex);
        }
        return stringBuilder.toString();
    }

    protected static String toTextHex(String b) {
        int l = b.length();
        byte[] data = new byte[l / 2];
        for (int i = 0; i < l; i += 2) {
            data[i / 2] = (byte) ((Character.digit(b.charAt(i), 16) << 4)
                    + Character.digit(b.charAt(i + 1), 16));
        }
        byte[] bytes = data;
        String st = new String(bytes, StandardCharsets.UTF_8);
        return st;
    }
}

class PathSEB {

    public static String returnDatabasePath() {
        return Paths.get("").toAbsolutePath().toString() + "\\dtbseb";
    }

    public static String returnFolderPath() {
        return Paths.get("").toAbsolutePath().toString();
    }
}

class EditQuiz {

    //return the number of selected radio buttons
    protected static int getSelected(JRadioButton jRadioButton1, JRadioButton jRadioButton2, JRadioButton jRadioButton3, JRadioButton jRadioButton4) {
        int number = 0;
        if (jRadioButton1.isSelected()) {
            number = 1;
        } else if (jRadioButton2.isSelected()) {
            number = 2;
        } else if (jRadioButton3.isSelected()) {
            number = 3;
        } else if (jRadioButton4.isSelected()) {
            number = 4;
        }
        return number;
    }

    //deletes the contents of text fields
    protected static void resetFields(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JTextField jTextField4, JTextField jTextField5) {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }

    //making quiz questions in the database 
    protected static void makeQuestion(String question, String answerone, String answertwo, String answerthree, String answerfour, String answerkey) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement ps = con.prepareStatement("insert into QUIZDATA(QUESTION,FIRSTANSWER,SECUNDANSWER,THIRDANSWER,FOURTHANSWER,KEYANSWER) values(?,?,?,?,?,?)");
            ps.setString(1, question);
            ps.setString(2, answerone);
            ps.setString(3, answertwo);
            ps.setString(4, answerthree);
            ps.setString(5, answerfour);
            ps.setString(6, answerkey);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Withdraw quiz table data from the database 
    protected static void updateTableQuizData(JTable jTable1) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select * from QUIZDATA");
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            while (rs.next()) {
                String ID = rs.getString("ID");
                String question = rs.getString("QUESTION");
                String firstanswer = rs.getString("FIRSTANSWER");
                String secundanswer = rs.getString("SECUNDANSWER");
                String thirdanswe = rs.getString("THIRDANSWER");
                String fourthanswer = rs.getString("FOURTHANSWER");
                String keyanswer = rs.getString("KEYANSWER");

                String tableData[] = {ID, question, firstanswer, secundanswer, thirdanswe, fourthanswer, keyanswer};
                tableModel.addRow(tableData);
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    //Delete quiz questions from the database from the table 
    protected static void deleteQuizTable(JTable jTable1) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement st = con.prepareStatement("delete from QUIZDATA where id =" + jTable1.getValueAt(jTable1.getSelectedRow(), 0));

            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.removeRow(jTable1.getSelectedRow());
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    //Delete quiz questions from the database from the list 
    protected static void deleteQuizList(JList jList1) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement st = con.prepareStatement("delete from QUIZDATA where QUESTION ='" + jList1.getSelectedValue() + "'");
            st.executeUpdate();
            jList1.removeAll();
            EditQuiz.getAllQuestions(jList1);
            st.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
    }

    //Taking all questions from the database and placing them in a list 
    protected static void getAllQuestions(JList jList1) {
        try {
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet crs = factory.createCachedRowSet();

            String question = "";
            crs.setUrl(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            crs.setCommand("select QUESTION from QUIZDATA");
            crs.execute();
            DefaultListModel listModel = new DefaultListModel();
            while (crs.next()) {
                question = crs.getString("QUESTION");
                listModel.addElement(question);
                jList1.setModel(listModel);
            }
            crs.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

}

class Messages {

    protected static void updateTableMessages(JTable jTable1) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select * from messagefeedback");
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            while (rs.next()) {
                String title = rs.getString("title");
                String username = rs.getString("username");

                String tableData[] = {title, username};

                tableModel.addRow(tableData);
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static void updateTextPane(JTextPane jTextPane1) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select * from messagefeedback");
            while (rs.next()) {
                jTextPane1.setText(rs.getString("message"));
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static void updateJTextPane(JTextPane jTextPane1, String id) {
        try {
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet crs = factory.createCachedRowSet();

            String message;
            crs.setCommand("select * from books where id=" + id + "");
            crs.execute();
            while (crs.next()) {
                message = crs.getString("message");
                jTextPane1.getDocument().insertString(0, message, null);
            }
            crs.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        } catch (BadLocationException ex) {
            new sistem.eb.login_registration.DialogMessage("Obavještenje!", "Pogrešna putanja informacije!", "U redu");
        }
    }
}

class FindWords {

    private static final long serialVersionUID = 1L;

    //Making a text copy of the file 
    protected static void makeFile(ArrayList<String> seList, String nameFile) {
        try {
            Path file = Paths.get(sistem.eb.interfaces.InterfaceAdministrator.PATH_FOLDER + "/bookreader/" + nameFile + ".txt");
            Files.write(file, seList, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće pristupiti datoteci!", "U redu");
        }
    }

    //Loading words into the dictionary 
    protected static int loadWords(String adr, List<String> ls) {
        int ret = 0;
        try {
            byte tekst[] = Files.readAllBytes(Paths.get(adr));
            String t = new String(tekst);
            t = t.toLowerCase();
            t = t.replace("\n", " ").replace("\r", " ").replace("-", " ").replace(":", " ");
            StringTokenizer st = new StringTokenizer(t, " ");
            while (st.hasMoreTokens()) {
                ls.add(st.nextToken());
            }
            ret = ls.size();
        } catch (java.nio.file.NoSuchFileException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "<html><p  style=\"line-height:85%;text-align:center;\">Datoteka ne postoji"
                    + " ili je putanja </p><p style=\"line-height:85%;text-align:center;\">pogrešna!</p></html>", "U redu").show();
        } catch (IOException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
        return ret;
    }

    protected static int loadWordsPDF(String adr, List<String> ls) {
        int ret = 0;
        try {
            FileInputStream obj = new FileInputStream(adr);
            PDDocument objDoc = PDDocument.load(obj);
            PDFTextStripper objPDFStrip = new PDFTextStripper();
            String pdfContent = objPDFStrip.getText(objDoc);
            pdfContent.toLowerCase();
            pdfContent = pdfContent.replace("\n", " ").replace("\r", " ").replace("-", " ").replace(":", " ");
            StringTokenizer st = new StringTokenizer(pdfContent, " ");
            while (st.hasMoreTokens()) {
                ls.add(st.nextToken());
            }
            ret = ls.size();
            objDoc.close();
        } catch (IOException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }

        return ret;
    }

    protected static int loadWordsWord(String adr, List<String> ls) {
        int ret = 0;
        try {
            FileInputStream obj = new FileInputStream(adr);
            XWPFDocument document = new XWPFDocument(obj);
            XWPFWordExtractor extract = new XWPFWordExtractor(document);

            String t = new String(extract.getText());

            t = t.toLowerCase();
            t = t.replace("\n", " ").replace("\r", " ").replace("-", " ").replace(":", " ").replace("...", " ").replace(";", " ").replace(".", " ").replace(",", " ").replace("...", " ");
            StringTokenizer st = new StringTokenizer(t, " ");
            while (st.hasMoreTokens()) {
                ls.add(st.nextToken());
            }
            ret = ls.size();
        } catch (IOException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
        return ret;
    }

    //Counting words in a dictionary 
    protected static void calculateWords(ArrayList<String> ls, JTextArea jTextArea1) {
        HashMap<String, Integer> brojacReci = new HashMap<String, Integer>();
        for (Iterator<String> iterator = ls.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            if (brojacReci.containsKey(next)) {
                brojacReci.put(next, brojacReci.get(next) + 1);
            } else {
                brojacReci.put(next, 1);
            }
        }

        Map<String, Integer> sortiranaMapa = sortByValue(brojacReci);
        for (Map.Entry entry : sortiranaMapa.entrySet()) {
            jTextArea1.append(entry.getKey() + " (" + entry.getValue() + " puta)" + "\n");
        }

    }

    //Sort words in the dictionary 
    protected static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list
                = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap 
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    //Check for duplicate words in the dictionary 
    protected static boolean duplicateCheck(ArrayList<String> recnik, String x) {
        boolean status = false;
        for (Iterator<String> iterator = recnik.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            if (x.equals(next)) {
                status = true;
                break;
            }
        }
        return status;
    }

    //dictionary generation 
    protected static int generateDictionary(ArrayList<String> ls) {

        ArrayList<String> dictionary = new ArrayList<String>();
        for (Iterator<String> iterator = ls.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            if (!duplicateCheck(dictionary, next)) {
                dictionary.add(next);
            }
        }
        return dictionary.size();
    }

    //Search the dictionary 
    protected static void searchDictionary(ArrayList<String> dictionary) {
        for (Iterator<String> iterator = dictionary.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}

class Printer {

    //Adding files to the ComboBox 
    protected static void addFiles(JComboBox jComboBox1) {
        try {
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet crs = factory.createCachedRowSet();

            crs.setUrl(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            crs.setCommand("select name from notepad");
            crs.execute();
            while (crs.next()) {
                jComboBox1.addItem(crs.getString("name"));
            }
            crs.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
    }

    protected static void resetFields(JTextField jTextField1, JTextField jTextField2, JTextArea jTextArea1) {
        jTextField1.setText("");
        jTextField2.setText("0 karaktera");
        jTextArea1.setText("");
    }

    //Adding data to the database 
    protected static void addData(JTextField jTextField1, String size, JTextArea jTextArea3, JComboBox jComboBox) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement ps = con.prepareStatement("insert into notepad(name,size,data) values(?,?,?)");
            ps.setString(1, jTextField1.getText());
            ps.setString(2, size);
            ps.setString(3, jTextArea3.getText());
            jComboBox.addItem(jTextField1.getText());
            ps.executeUpdate();
            try {
                ArrayList<String> maList = new ArrayList<String>();
                maList.add(jTextArea3.getText());
                Path file = Paths.get(sistem.eb.interfaces.InterfaceAdministrator.PATH_FOLDER + "/notepad/" + jTextField1.getText() + ".txt");
                Files.write(file, maList, StandardCharsets.UTF_8);
            } catch (IOException ex) {
                new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }

    }

    //Restore already added data from the database for re-display 
    protected static void returnData(String name, JTextField JTextField1, JTextArea JTextArea) {

        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();

            java.sql.ResultSet rs = st.executeQuery("select size,data from notepad where name='" + name + "'");
            while (rs.next()) {
                JTextField1.setText(rs.getString("size"));
                JTextArea.setText(rs.getString("data"));
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    //Delete data from the database 
    protected static void deleteData(String name, JComboBox jComboBox, JTextArea jTextArea, JTextField jTextField) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement st = con.prepareStatement("delete from notepad where name='" + name + "'");

            jComboBox.removeItem(name);
            jTextArea.setText("");
            jTextField.setText("");
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    //Update data in ComboBox 
    protected static void updateComboBox(JComboBox jComboBox1) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();

            java.sql.ResultSet rs = st.executeQuery("select name from notepad");
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("name"));
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

}

class GraphicInterfaceAdministrator {

    protected static void updateIOState(JTable jTable1) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select * from IOLOG");
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("ID"));
                String player = rs.getString("PLAYER");
                String date = rs.getString("DATE");

                String tableData[] = {id, player, date};

                tableModel.addRow(tableData);
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static void updateQuizState(JTable jTable1) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select * from quizlog");
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("ID"));
                String player = rs.getString("PLAYER");
                String numberofcorectanswers = rs.getString("NUMBEROFCORRECTANSWERS");
                String date = rs.getString("DATE");

                String tableData[] = {id, player, numberofcorectanswers, date};

                tableModel.addRow(tableData);
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    //Check if the data is entered in the text fields, because otherwise there is nothing to mark 
    protected static void radiobuttonControler(JTextField jTextField2, JTextField jTextField3, JTextField jTextField4, JTextField jTextField5, JRadioButton jRadioButton1, JRadioButton jRadioButton2, JRadioButton jRadioButton3, JRadioButton jRadioButton4, JLabel jLabel1, ButtonGroup buttonGroup1) {
        if (jTextField2.getText().equals("") || jTextField2.getText().equals("Odgovor I")) {
            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "<html><p  style=\"line-height:85%;text-align:center;\">Neophodno uneti odgovor! </p><p style=\"line-height:85%;text-align:center;\">Kako bi bili u mogućnosti odabrati isti.</p></html>", "U redu").show();
            buttonGroup1.clearSelection();
        } else {
            if (jTextField3.getText().equals("") || jTextField3.getText().equals("Odgovor II")) {
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "<html><p  style=\"line-height:85%;text-align:center;\">Neophodno uneti odgovor! </p><p style=\"line-height:85%;text-align:center;\">Kako bi bili u mogućnosti odabrati isti.</p></html>", "U redu").show();
                buttonGroup1.clearSelection();
            } else {
                if (jTextField4.getText().equals("") || jTextField4.getText().equals("Odgovor III")) {
                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "<html><p  style=\"line-height:85%;text-align:center;\">Neophodno uneti odgovor! </p><p style=\"line-height:85%;text-align:center;\">Kako bi bili u mogućnosti odabrati isti.</p></html>", "U redu").show();
                    buttonGroup1.clearSelection();
                } else {
                    if (jTextField5.getText().equals("") || jTextField5.getText().equals("Odgovor IV")) {
                        new sistem.eb.login_registration.DialogMessage("Obaveštenje", "<html><p  style=\"line-height:85%;text-align:center;\">Neophodno uneti odgovor! </p><p style=\"line-height:85%;text-align:center;\">Kako bi bili u mogućnosti odabrati isti.</p></html>", "U redu").show();
                        buttonGroup1.clearSelection();
                    } else {
                        switch (EditQuiz.getSelected(jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton4)) {
                            case 1:
                                jLabel1.setText("Odgovor " + "I" + " je izabran kao tačan odgovor");
                                break;
                            case 2:
                                jLabel1.setText("Odgovor " + "II" + " je izabran kao tačan odgovor");
                                break;
                            case 3:
                                jLabel1.setText("Odgovor " + "III" + " je izabran kao tačan odgovor");
                                break;
                            case 4:
                                jLabel1.setText("Odgovor " + "IV" + " je izabran kao tačan odgovor");
                                break;
                        }
                        jLabel1.setVisible(true);
                    }
                }
            }
        }
    }

    //Checks which button is currently selected so that the corresponding JPanel can be opened 
    protected static void buttonControler(ArrayList<JButton> blist, JButton selectedButton) {
        for (JButton jButton : blist) {
            if (jButton == selectedButton) {
                GraphicInterfaceAdministrator.setSelectedColour(jButton);
            } else {
                GraphicInterfaceAdministrator.setUnselectedColour(jButton);
            }
        }

    }

    protected static void buttonControlerEditor(ArrayList<JButton> editor, JButton selectedButton) {
        for (JButton jButton : editor) {
            if (jButton == selectedButton) {
                GraphicInterfaceAdministrator.setSelectedColour(jButton);
            } else {
                GraphicInterfaceAdministrator.setUnselectedColour(jButton);
            }
        }

    }

    //Display the last ID in the database in books 
    protected static void getLastID(JTextField jTextField1) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();

            java.sql.ResultSet rs = st.executeQuery("SELECT MAX(id) FROM books");
            if (rs.next()) {
                jTextField1.setText(String.valueOf(rs.getInt(1)));
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    //Hiding JPanel on the corresponding index 
    protected static void hidePanel(JTabbedPane JTabbedPane1, int index) {
        JTabbedPane1.setEnabledAt(index, false);
        JTabbedPane1.setName("");
    }

    //Hiding JPanel on the corresponding index 
    protected static void showPanel(JTabbedPane JTabbedPane1, int index, String panelName) {
        JTabbedPane1.setEnabledAt(index, true);
        JTabbedPane1.setName(panelName);
    }

    //Control the home page and display certain data (number of books, number of users, number of administrators) in the database 
    protected static void setHomePageLabels(JLabel books_L, JLabel users_L, JLabel administrators_L, JLabel bookst_L, JLabel userst_L, JLabel administratorst_L, JLabel io0_L, JLabel io1_L, JLabel quiz1_L1, JLabel quiz0_L1, JLabel quizwin_L) {
        books_L.setText(String.valueOf(InterfaceAdministrator.getCountRows("books")));
        users_L.setText(String.valueOf(InterfaceAdministrator.getCountRows("users")));
        administrators_L.setText(String.valueOf(InterfaceAdministrator.getCountRows("administrators")));
        userst_L.setText("Trenutno imamo " + String.valueOf(InterfaceAdministrator.getCountRows("users")) + " korisnika");
        bookst_L.setText("Trenutno imamo " + String.valueOf(InterfaceAdministrator.getCountRows("books")) + " knjiga");
        administratorst_L.setText("Trenutno imamo " + String.valueOf(InterfaceAdministrator.getCountRows("administrators")) + " administratora");
        io0_L.setText(String.valueOf(InterfaceAdministrator.getCountRows("iolog")));
        io1_L.setText("Odigrano ukupno " + String.valueOf(InterfaceAdministrator.getCountRows("iolog")) + " puta");

        quiz0_L1.setText(String.valueOf(InterfaceAdministrator.getCountRows("quizlog")));
        quiz1_L1.setText("Odigrano ukupno " + String.valueOf(InterfaceAdministrator.getCountRows("quizlog")) + " puta");
        quizwin_L.setText("Prosecno znanje igraca " + InterfaceAdministrator.df.format(getProcentage()) + "%");
        users_L.setHorizontalAlignment(users_L.CENTER);
        users_L.setVerticalAlignment(users_L.CENTER);
        books_L.setHorizontalAlignment(books_L.CENTER);
        books_L.setVerticalAlignment(books_L.CENTER);
        administrators_L.setHorizontalAlignment(administrators_L.CENTER);
        administrators_L.setVerticalAlignment(administrators_L.CENTER);
        io0_L.setVerticalAlignment(administrators_L.CENTER);
        io1_L.setVerticalAlignment(administrators_L.CENTER);
        io0_L.setHorizontalAlignment(administrators_L.CENTER);
        io1_L.setHorizontalAlignment(administrators_L.CENTER);

        quiz1_L1.setVerticalAlignment(administrators_L.CENTER);
        quiz0_L1.setVerticalAlignment(administrators_L.CENTER);
        quiz1_L1.setHorizontalAlignment(administrators_L.CENTER);
        quiz0_L1.setHorizontalAlignment(administrators_L.CENTER);
        quizwin_L.setHorizontalAlignment(administrators_L.CENTER);
        quizwin_L.setVerticalAlignment(administrators_L.CENTER);
    }

    protected static float getProcentage() {
        float sum = 0;
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select NUMBEROFCORRECTANSWERS from QUIZLOG");
            while (rs.next()) {
                String ID = rs.getString("NUMBEROFCORRECTANSWERS");
                sum += Double.valueOf(ID);
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
        float numberQuestion = InterfaceAdministrator.getCountRows("quizdata");
        float numberPlayers = InterfaceAdministrator.getCountRows("quizlog");

        return (float) (((sum / numberPlayers) * 100) / numberQuestion);
    }

    protected static void tableColumnResizeAdministrator(JTable jTable2) {
        TableColumnModel columnModel = jTable2.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(0).setMaxWidth(30);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(1).setMaxWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(2).setMaxWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(5).setMaxWidth(100);
        columnModel.getColumn(6).setPreferredWidth(200);
        columnModel.getColumn(6).setMaxWidth(220);
    }

    protected static void tableColumnResizeBooks(JTable jTable3) {
        TableColumnModel columnModel = jTable3.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(0).setMaxWidth(30);
    }

    protected static void setSelectedColour(JButton sjbt) {
        sjbt.setBackground(Color.decode("#4682B4"));
        sjbt.setForeground(Color.decode("#FFFFFF"));
    }

    protected static void setUnselectedColour(JButton ujbt) {
        ujbt.setBackground(Color.decode("#FFFFFF"));
        ujbt.setForeground(Color.decode("#666666"));
    }

    public static void textHolderFunction(int number, JTextField jTextField1) {
        if (number == 0) {
            jTextField1.setText("");
        }
    }

    protected static void resetTextFields(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JTextField jTextField4, JTextField jTextField5, JTextField jTextField6, JTextField jTextField7, JComboBox jComboBox1) {
        try {
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            jComboBox1.setSelectedItem("Nema");
        } catch (Exception e) {
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
        }

    }
}

class Clock implements Runnable {

    private JLabel jLabel1;

    public Clock(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    
    public static String returnDateTime() {
        Date d = new Date();

        DecimalFormat other = new DecimalFormat("00");

        return other.format(d.getHours()) + ":" + other.format(d.getMinutes()) + ":" + other.format(d.getSeconds()) + " " + other.format(d.getDay() + 13) + "." + other.format(d.getMonth() + 1) + "." + (d.getYear() + 1900) + "";
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Date d = new Date();

                DecimalFormat other = new DecimalFormat("00");

                jLabel1.setText(other.format(d.getHours()) + ":" + other.format(d.getMinutes()) + ":" + other.format(d.getSeconds()) + " " + other.format(d.getDay() + 20) + "." + other.format(d.getMonth() + 1) + "." + (d.getYear() + 1900) + "");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
            }
        }
    }


}

class Administrators {

    protected static void updateTableAdministrators(JTable jTable2) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select * from administrators");
            DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("ID"));
                String realname = rs.getString("REALNAME");
                String surname = rs.getString("SURNAME");
                String purpose = rs.getString("PURPOSE");
                String phone = rs.getString("PHONE");
                String nickname = rs.getString("NICKNAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");

                String tableData[] = {id, realname, surname, purpose, phone, nickname, email, password};

                tableModel.addRow(tableData);
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static void deleteAdministrator(JTable jTable2) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement st = con.prepareStatement("delete from administrators where id =" + jTable2.getValueAt(jTable2.getSelectedRow(), 0));

            DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
            tableModel.removeRow(jTable2.getSelectedRow());
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static void createAdministrator(JTextField realname, JTextField surname, JTextField purpose, JTextField phone, JTextField nickname, JTextField email, JPasswordField password) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement ps = con.prepareStatement("insert into administrators(realname,surname,purpose,phone,nickname,email,password) values(?,?,?,?,?,?,?)");
            ps.setString(1, realname.getText());
            ps.setString(2, surname.getText());
            ps.setString(3, purpose.getText());
            ps.setString(4, phone.getText());
            ps.setString(5, nickname.getText());
            ps.setString(6, email.getText());
            ps.setString(7, String.valueOf(password.getPassword()));
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static String getAdministratorEmail(String username) {
        try {
            String[] words = username.split(" ");

            try {
                java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery("select * from administrators where REALNAME= '" + words[0] + "' AND SURNAME = '" + words[1] + "'");
                while (rs.next()) {
                    String email = rs.getString("EMAIL");
                    return email;
                }
                st.close();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
            }

        } catch (java.lang.NullPointerException e) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
        return null;
    }

}

class Users {

    protected static void updateTableUsers(JTable jTable1) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select * from users");
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("ID"));
                String username = rs.getString("NAME");
                String password = rs.getString("PASSWORD");
                String email = rs.getString("EMAIL");
                String tableData[] = {id, username, password, email};
                tableModel.addRow(tableData);
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static void deleteUser(JTable jTable1) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement st = con.prepareStatement("delete from users where id =" + jTable1.getValueAt(jTable1.getSelectedRow(), 0));

            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.removeRow(jTable1.getSelectedRow());
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

}

class Books {

    public static final Pattern getPattern(String purpose) {
        Pattern VALID_WORD_PATTERN = Pattern.compile("^[\\p{L}\\. \'-]+$");
        if (purpose == "word") {
            VALID_WORD_PATTERN = Pattern.compile("^[a-zA-Z0-9šđčć'žŠĐČĆŽ\\s.,-–:/()!?\\\"]+$");
        } else if (purpose == "email") {
            VALID_WORD_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        } else if (purpose == "number") {
            VALID_WORD_PATTERN = Pattern.compile("[0-9]+");
        } else if (purpose == "name") {
            VALID_WORD_PATTERN = Pattern.compile("^[a-zA-Z0-9šđčćžŠĐČĆŽ]+$");
        } else if (purpose == "password") {
            VALID_WORD_PATTERN = Pattern.compile("^[a-zA-Z0-9].{8,25}+$");
        }
        return VALID_WORD_PATTERN;
    }

    public static boolean validateWord(String word, Pattern VALID_PATTERN) {
        Matcher matcher = VALID_PATTERN.matcher(word);
        return matcher.find();
    }

    protected static void addBooks(String title, String subtitle, String author, String publisher, String publishingDate, String numberPages, String genre, String relatedBooks, String fileName, String filePath) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement ps = con.prepareStatement("insert into books(title,subtitle,author,publisher,publishingDate,numberPages,genre,relatedBooks,fileName,filePath) values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, title);
            ps.setString(2, subtitle);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.setString(5, publishingDate);
            ps.setString(6, numberPages);
            ps.setString(7, genre);
            ps.setString(8, relatedBooks);
            ps.setString(9, fileName);
            ps.setString(10, filePath);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }

    }

    protected static void deleteBook(JTable jTable3, JTable jTable4) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.PreparedStatement st = con.prepareStatement("delete from books where id =" + jTable3.getValueAt(jTable3.getSelectedRow(), 0));

            DefaultTableModel tableModel = (DefaultTableModel) jTable3.getModel();
            DefaultTableModel tableModelFile = (DefaultTableModel) jTable4.getModel();
            tableModelFile.setRowCount(0);
            tableModel.removeRow(jTable3.getSelectedRow());
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static void updateTableBooks(JTable jTable3) {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery("select * from books");
            DefaultTableModel tableModel = (DefaultTableModel) jTable3.getModel();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String title = rs.getString("title");
                String subtitle = rs.getString("subtitle");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String publishingDate = rs.getString("publishingDate");
                String numberPages = rs.getString("numberPages");
                String genre = rs.getString("genre");
                String relatedBooks = rs.getString("relatedBooks");

                String tableData[] = {id, title, subtitle, author, publisher, publishingDate, numberPages, genre, relatedBooks};
                tableModel.addRow(tableData);
            }
            st.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static void addRelatedBooks(JComboBox jComboBox1) {
        try {
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet crs = factory.createCachedRowSet();

            crs.setUrl(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            crs.setCommand("select title from books");
            crs.execute();
            while (crs.next()) {
                jComboBox1.addItem(crs.getString("title"));
            }
            crs.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static void getAllFilesName(JList jList2) {
        try {
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet crs = factory.createCachedRowSet();

            String fileName = "", filePath = "";
            crs.setUrl(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            crs.setCommand("select filename from books");
            crs.execute();
            DefaultListModel listModel = new DefaultListModel();
            while (crs.next()) {
                fileName = crs.getString("fileName");

                listModel.addElement(fileName);
                jList2.setModel(listModel);

            }
            crs.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static void getFilePathsToTable(JTable jTable1, String id) {
        try {
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet crs = factory.createCachedRowSet();

            String fileName = "", filePath = "";
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            crs.setUrl(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            crs.setCommand("select * from books where id=" + id + "");
            crs.execute();
            DefaultListModel listModel = new DefaultListModel();
            while (crs.next()) {
                fileName = crs.getString("fileName");
                filePath = crs.getString("filePath");

                String tableData[] = {fileName, filePath};
                tableModel.addRow(tableData);
            }
            crs.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
    }

    protected static String getFileNamePath(String fileName) {
        String filePath = "";
        try {
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet crs = factory.createCachedRowSet();

            crs.setUrl(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            crs.setCommand("select * from books where filename='" + fileName + "'");
            crs.execute();
            DefaultListModel listModel = new DefaultListModel();
            while (crs.next()) {
                filePath = crs.getString("filePath");
            }
            crs.close();
        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
        return filePath;
    }

    protected static ArrayList<ArrayList<String>> loadFile(JTextArea jTextArea1, JTextField jTextField1, JTextField jTextField2, JList jList2, JTextField jTextField3) {
        jTextArea1.setText("");
        int numberL = 0, numberD = 0;
        ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
        ArrayList<String> l = new ArrayList<String>();
        ArrayList<String> d = new ArrayList<String>();
        if ((getFileNamePath((String) jList2.getSelectedValue())).contains(".txt")) {

            try {
                numberL = FindWords.loadWords(getFileNamePath((String) jList2.getSelectedValue()), l);
                FindWords.calculateWords(l, jTextArea1);
                numberD = FindWords.generateDictionary(l);
                FindWords.searchDictionary(d);

                output.add(l);
                output.add(d);
                jTextField1.setText(String.valueOf(numberL) + " reči");
                jTextField2.setText(String.valueOf(numberD) + " reči");
            } catch (Exception e) {
                new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
            }

        } else if ((getFileNamePath((String) jList2.getSelectedValue())).contains(".pdf")) {
            numberL = FindWords.loadWordsPDF(getFileNamePath((String) jList2.getSelectedValue()), l);
            FindWords.calculateWords(l, jTextArea1);
            numberD = FindWords.generateDictionary(l);
            FindWords.searchDictionary(d);

            output.add(l);
            output.add(d);
            jTextField1.setText(String.valueOf(numberL) + " reči");
            jTextField2.setText(String.valueOf(numberD) + " reči");

        } else {
            new sistem.eb.login_registration.DialogMessage("Greška", "<html><p  style=\"line-height:85%;text-align:center;\">Neophodno je izabrati datoteku sa</p><p style=\"line-height:85%;text-align:center;\">odgovarajućim formatom.</p></html>", "U redu").show();
            jTextArea1.setText("");
            jTextField1.setText("Ukupan broj reči");
            jTextField2.setText("Broj reči u rečniku");
            jTextField3.setText("Naziv datoteke");
        }
        return output;
    }

    protected static void setBooksTable(JTable book, JTable docs) {
        {
            DefaultTableModel tableModel = (DefaultTableModel) docs.getModel();
            tableModel.setRowCount(0);
        }
        DefaultTableModel tableModel = (DefaultTableModel) book.getModel();
        tableModel.setRowCount(0);
        Books.updateTableBooks(book);
    }
}

public class InterfaceAdministrator extends javax.swing.JFrame implements URCommand {

    public static final DecimalFormat df = new DecimalFormat("0.0");
    protected ArrayList<ArrayList<String>> ser;
    boolean radioflag = false, caseflag = false;
    char textCode = 'n';
    ArrayList<JButton> blist = new ArrayList<JButton>();

    ArrayList<JButton> editor = new ArrayList<JButton>();
    int related = 0, titlep = 0, subtitlep = 0, authorp = 0, publisherp = 0, publishingDatep = 0, numberPagesp = 0, genrep = 0, nameFilep = 0, notep = 0, ntext = 0, ncombo = 0, realname = 0, surname = 0, purpose = 0, phone = 0, nickname = 0, email = 0, passwordr = 0, quest = 0, answone = 0, answtwo = 0, answthree = 0, answfour = 0;
    Stack<String> undo = new Stack<>();
    Stack<String> redo = new Stack<>();

    //graphic inferface administrator
    Graphics g;
    Thread animationThread, clockThread;

    //define the boundary
    static final int MAX_X = 1056;
    static final int MAX_Y = 485;

    //imported value 
    public static String loggedInAdministrator;
    public static String CLOCK = sistem.eb.interfaces.Clock.returnDateTime();

    //paths 
    public static final String PATH_DATABASE = "jdbc:derby:" + PathSEB.returnDatabasePath();
    public static final String PATH_FOLDER = PathSEB.returnFolderPath();

    //jframe objects
    sistem.eb.games.XO xo;
    sistem.eb.games.Quiz quiz;

    public InterfaceAdministrator(String administrator) {
        initComponents();
        this.xo = new XO(administrator);
        this.quiz = new Quiz(administrator);

        //grab administrator name 
        this.loggedInAdministrator = administrator;

        //pre-set graphic interface
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sistem/eb/icons/logo.png")));
        GraphicInterfaceAdministrator.setSelectedColour(this.homepage_B);
        this.useremail_L.setHorizontalAlignment(SwingConstants.RIGHT);
        this.username_L.setHorizontalAlignment(SwingConstants.RIGHT);

        this.username_L.setText(this.loggedInAdministrator);
        this.useremail_L.setText(Administrators.getAdministratorEmail(this.loggedInAdministrator));
        this.filechooser_FC.addChoosableFileFilter(new FileNameExtensionFilter("Book file readable formats", "txt", "pdf"));
        GraphicInterfaceAdministrator.tableColumnResizeAdministrator(this.administrator_T);
        GraphicInterfaceAdministrator.tableColumnResizeBooks(availablebook_T);
        GraphicInterfaceAdministrator.setHomePageLabels(this.apopupnuber_P, this.upopupnumber_L, this.adminpopupnumber_L, this.apopupmessage_L, this.upopupmessage_L, this.adminpopupmessage_L, this.io0_L, this.io1_L, this.quiz1_L1, this.quiz0_L1, this.quizwin_L);
        GraphicInterfaceAdministrator.getLastID(this.lastID_TF);
        TableColumnModel columnModel = this.quiz_T.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(0).setMaxWidth(30);
        this.corectanswer_L.setVisible(false);
        GraphicInterfaceAdministrator.hidePanel(this.JTabbedPane1, 10);
        GraphicInterfaceAdministrator.hidePanel(this.JTabbedPane1, 11);
        GraphicInterfaceAdministrator.hidePanel(this.JTabbedPane1, 12);
        GraphicInterfaceAdministrator.hidePanel(this.JTabbedPane1, 13);
        GraphicInterfaceAdministrator.hidePanel(this.JTabbedPane1, 14);

        //inicialize jbutton arraylists
        blist = new ArrayList<JButton>() {
            {
                add(homepage_B);
                add(homepage_B);
                add(availablebooks_B);
                add(addbooks_B);
                add(wordreader_B);
                add(editbooks_B);
                add(registeradministrator_B);
                add(games_B);
                add(users_B);
                add(administrators_B);
                add(registeradministrator_B);
                add(messages_B);
            }
        };
        editor = new ArrayList<JButton>() {
            {
                add(sentance_B);
                add(lower_B);
                add(upper_B);
                add(capitalized_B);
                add(alternating_B);
                add(title_B);
                add(inverse_B);
                add(wide_B);
                add(reverse_B);
                add(morse_B);
                add(binary_B);
                add(octal_B);
                add(hex_B);
                add(proper_B);
            }
        };

        //get JPanel graphics
        this.g = this.games_P.getGraphics();
        this.games_P.paintComponents(g);

        //get Clock 
        Clock s = new Clock(clock_L);
        this.clockThread = new Thread(s);
        this.clockThread.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        quizbuttons_BG = new javax.swing.ButtonGroup();
        titlebar_P = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        username_L = new javax.swing.JLabel();
        useremail_L = new javax.swing.JLabel();
        sidebar_P = new javax.swing.JPanel();
        homepage_B = new javax.swing.JButton();
        availablebooks_B = new javax.swing.JButton();
        addbooks_B = new javax.swing.JButton();
        users_B = new javax.swing.JButton();
        administrators_B = new javax.swing.JButton();
        editbooks_B = new javax.swing.JButton();
        wordreader_B = new javax.swing.JButton();
        games_B = new javax.swing.JButton();
        registeradministrator_B = new javax.swing.JButton();
        messages_B = new javax.swing.JButton();
        JTabbedPane1 = new javax.swing.JTabbedPane();
        homepage_P = new javax.swing.JPanel();
        availablepopup_P = new javax.swing.JPanel();
        apopuptitlebar_P = new javax.swing.JPanel();
        apopuptitle_L = new javax.swing.JLabel();
        apopupnuber_P = new javax.swing.JLabel();
        apopupmessage_L = new javax.swing.JLabel();
        userspopup_P = new javax.swing.JPanel();
        upopuptitlebar_P = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        upopupnumber_L = new javax.swing.JLabel();
        upopupmessage_L = new javax.swing.JLabel();
        administratorspopup_P = new javax.swing.JPanel();
        adminpopuptitlebar_P = new javax.swing.JPanel();
        adminpopuptitle_L = new javax.swing.JLabel();
        adminpopupnumber_L = new javax.swing.JLabel();
        adminpopupmessage_L = new javax.swing.JLabel();
        clock_L = new javax.swing.JLabel();
        availablebook_P = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        availablebook_T = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        bookdocs_T = new javax.swing.JTable();
        booksrefresh_B = new javax.swing.JButton();
        removebook_B = new javax.swing.JButton();
        addbook_P = new javax.swing.JPanel();
        lastID_L = new javax.swing.JLabel();
        lastID_TF = new javax.swing.JTextField();
        title_L = new javax.swing.JLabel();
        subtitle_L = new javax.swing.JLabel();
        author_L = new javax.swing.JLabel();
        numberofpages_L = new javax.swing.JLabel();
        publisher_L = new javax.swing.JLabel();
        publishingdate_L = new javax.swing.JLabel();
        relatedbooks_L = new javax.swing.JLabel();
        genre_L = new javax.swing.JLabel();
        genre_TF = new javax.swing.JTextField();
        publishingdate_TF = new javax.swing.JTextField();
        subtitle_TF = new javax.swing.JTextField();
        publisher_TF = new javax.swing.JTextField();
        author_TF = new javax.swing.JTextField();
        title_TF = new javax.swing.JTextField();
        numberofpages_TF = new javax.swing.JTextField();
        relatedbooks_CB = new javax.swing.JComboBox<>();
        filechooser_FC = new javax.swing.JFileChooser();
        aconfig_B = new javax.swing.JButton();
        editbook_P = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        undo_B = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        editedbookcontent_TA = new javax.swing.JTextArea();
        editebookname_TF = new javax.swing.JTextField();
        sizeofdocument_TF = new javax.swing.JTextField();
        editedbookdocs_L = new javax.swing.JLabel();
        editedbookdocs_CB = new javax.swing.JComboBox<>();
        showeditedbook_B = new javax.swing.JButton();
        saveeditedbook_B = new javax.swing.JButton();
        removeeditedbook_B = new javax.swing.JButton();
        redo_L = new javax.swing.JButton();
        removeeditedbook_B1 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        bookdocslist_LI = new javax.swing.JList<>();
        jPanel15 = new javax.swing.JPanel();
        takedwords_L = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        takedwordscontent_TA = new javax.swing.JTextArea();
        countofwods_L = new javax.swing.JLabel();
        countofwods_TF = new javax.swing.JTextField();
        countofwodsindictionary_L = new javax.swing.JLabel();
        countofwodsindictionary_TF = new javax.swing.JTextField();
        takedwordssave_B = new javax.swing.JButton();
        takedwordsname_TF = new javax.swing.JTextField();
        games_P = new javax.swing.JPanel();
        IOpopup_P = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        io2_L2 = new javax.swing.JLabel();
        io0_L = new javax.swing.JLabel();
        io1_L = new javax.swing.JLabel();
        quizpopup_P = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        quiz2_L1 = new javax.swing.JLabel();
        quiz0_L1 = new javax.swing.JLabel();
        quiz1_L1 = new javax.swing.JLabel();
        quizwin_L = new javax.swing.JLabel();
        booksrefresh_B1 = new javax.swing.JButton();
        booksrefresh_B2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        statequiz_B = new javax.swing.JButton();
        stateio_B = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        messages_T = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        registeradministrator_P = new javax.swing.JPanel();
        realname_TF = new javax.swing.JTextField();
        realname_L = new javax.swing.JLabel();
        surname_L = new javax.swing.JLabel();
        surname_TF = new javax.swing.JTextField();
        purpose_TF = new javax.swing.JTextField();
        purpose_L = new javax.swing.JLabel();
        phone_L = new javax.swing.JLabel();
        phone_TF = new javax.swing.JTextField();
        nickname_TF = new javax.swing.JTextField();
        nickname_L = new javax.swing.JLabel();
        email_L = new javax.swing.JLabel();
        email_TF = new javax.swing.JTextField();
        password_L = new javax.swing.JLabel();
        password_TF = new javax.swing.JPasswordField();
        registeradministratorconfig_B = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        users_P = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        users_T = new javax.swing.JTable();
        deleteuser_B = new javax.swing.JButton();
        usersrefresh_B = new javax.swing.JButton();
        administrators_P = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        administrator_T = new javax.swing.JTable();
        deleteadministrator_B = new javax.swing.JButton();
        administratorrefresh_B = new javax.swing.JButton();
        editquestions_P = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        question_L = new javax.swing.JLabel();
        answertwo_L = new javax.swing.JLabel();
        answerone_L = new javax.swing.JLabel();
        answerthree_L = new javax.swing.JLabel();
        answerthree_TF = new javax.swing.JTextField();
        answerone_TF = new javax.swing.JTextField();
        question_TF = new javax.swing.JTextField();
        answertwo_TF = new javax.swing.JTextField();
        answerfour_TF = new javax.swing.JTextField();
        answerfour_L = new javax.swing.JLabel();
        configquiz_B = new javax.swing.JButton();
        deletequestion_B = new javax.swing.JButton();
        answerone_RB = new javax.swing.JRadioButton();
        answertwo_RB = new javax.swing.JRadioButton();
        answerthree_RB = new javax.swing.JRadioButton();
        answerfour_RB = new javax.swing.JRadioButton();
        corectanswer_L = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        quiz_T = new javax.swing.JTable();
        deleteadministrator_B1 = new javax.swing.JButton();
        deleteadministrator_B2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        io_T = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        quizstate_T = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        capitalized_B = new javax.swing.JButton();
        alternating_B = new javax.swing.JButton();
        lower_B = new javax.swing.JButton();
        upper_B = new javax.swing.JButton();
        wide_B = new javax.swing.JButton();
        sentance_B = new javax.swing.JButton();
        inverse_B = new javax.swing.JButton();
        title_B = new javax.swing.JButton();
        morse_B = new javax.swing.JButton();
        reverse_B = new javax.swing.JButton();
        hex_B = new javax.swing.JButton();
        binary_B = new javax.swing.JButton();
        octal_B = new javax.swing.JButton();
        proper_B = new javax.swing.JButton();
        title_B1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem EB - Glavni interfejs administratora u sistemu elektronske biblioteke");
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        titlebar_P.setBackground(new java.awt.Color(70, 130, 180));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SISTEM");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Elektronske");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("biblioteke");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/logointerfaceadministrator.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/unlockpad.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        username_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        username_L.setForeground(new java.awt.Color(255, 255, 255));
        username_L.setText("Korisničko ime");
        username_L.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        useremail_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        useremail_L.setForeground(new java.awt.Color(255, 255, 255));
        useremail_L.setText("Email");

        javax.swing.GroupLayout titlebar_PLayout = new javax.swing.GroupLayout(titlebar_P);
        titlebar_P.setLayout(titlebar_PLayout);
        titlebar_PLayout.setHorizontalGroup(
            titlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlebar_PLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(titlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(556, 556, 556)
                .addComponent(username_L, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(titlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(titlebar_PLayout.createSequentialGroup()
                    .addGap(852, 852, 852)
                    .addComponent(useremail_L, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );
        titlebar_PLayout.setVerticalGroup(
            titlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlebar_PLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlebar_PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, titlebar_PLayout.createSequentialGroup()
                        .addGroup(titlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username_L, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(titlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(titlebar_PLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(useremail_L, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        sidebar_P.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        homepage_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        homepage_B.setForeground(new java.awt.Color(102, 102, 102));
        homepage_B.setText("Početna");
        homepage_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homepage_BMouseClicked(evt);
            }
        });
        homepage_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homepage_BActionPerformed(evt);
            }
        });

        availablebooks_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        availablebooks_B.setForeground(new java.awt.Color(102, 102, 102));
        availablebooks_B.setText("Dostupne knjige");
        availablebooks_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availablebooks_BMouseClicked(evt);
            }
        });
        availablebooks_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availablebooks_BActionPerformed(evt);
            }
        });

        addbooks_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addbooks_B.setForeground(new java.awt.Color(102, 102, 102));
        addbooks_B.setText("Dodavanje knjige");
        addbooks_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbooks_BMouseClicked(evt);
            }
        });
        addbooks_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbooks_BActionPerformed(evt);
            }
        });

        users_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        users_B.setForeground(new java.awt.Color(102, 102, 102));
        users_B.setText("Korisnici");
        users_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                users_BMouseClicked(evt);
            }
        });
        users_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                users_BActionPerformed(evt);
            }
        });

        administrators_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        administrators_B.setForeground(new java.awt.Color(102, 102, 102));
        administrators_B.setText("Administratori");
        administrators_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                administrators_BMouseClicked(evt);
            }
        });
        administrators_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrators_BActionPerformed(evt);
            }
        });

        editbooks_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editbooks_B.setForeground(new java.awt.Color(102, 102, 102));
        editbooks_B.setText("Uređivanje knjige");
        editbooks_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbooks_BMouseClicked(evt);
            }
        });
        editbooks_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbooks_BActionPerformed(evt);
            }
        });

        wordreader_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        wordreader_B.setForeground(new java.awt.Color(102, 102, 102));
        wordreader_B.setText("Čitač reči");
        wordreader_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wordreader_BMouseClicked(evt);
            }
        });
        wordreader_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordreader_BActionPerformed(evt);
            }
        });

        games_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        games_B.setForeground(new java.awt.Color(102, 102, 102));
        games_B.setText("Igraonica ");
        games_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                games_BMouseClicked(evt);
            }
        });
        games_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                games_BActionPerformed(evt);
            }
        });

        registeradministrator_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registeradministrator_B.setForeground(new java.awt.Color(102, 102, 102));
        registeradministrator_B.setText("<html><p  style=\"line-height:85%;text-align:center;\">Registracija</p><p style=\"line-height:85%;text-align:center;\">administratora</p></html>");
        registeradministrator_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registeradministrator_BMouseClicked(evt);
            }
        });
        registeradministrator_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registeradministrator_BActionPerformed(evt);
            }
        });

        messages_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        messages_B.setForeground(new java.awt.Color(102, 102, 102));
        messages_B.setText("Povratne informacije");
        messages_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messages_BMouseClicked(evt);
            }
        });
        messages_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messages_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebar_PLayout = new javax.swing.GroupLayout(sidebar_P);
        sidebar_P.setLayout(sidebar_PLayout);
        sidebar_PLayout.setHorizontalGroup(
            sidebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homepage_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(availablebooks_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addbooks_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(users_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(administrators_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editbooks_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wordreader_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(games_B, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(registeradministrator_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(messages_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidebar_PLayout.setVerticalGroup(
            sidebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebar_PLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(homepage_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(availablebooks_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addbooks_B, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editbooks_B)
                .addGap(71, 71, 71)
                .addComponent(wordreader_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(games_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(messages_B, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registeradministrator_B, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(users_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(administrators_B)
                .addContainerGap())
        );

        JTabbedPane1.setAlignmentX(0.0F);
        JTabbedPane1.setAlignmentY(0.0F);
        JTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTabbedPane1MouseClicked(evt);
            }
        });

        availablepopup_P.setBackground(new java.awt.Color(255, 255, 255));
        availablepopup_P.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        apopuptitlebar_P.setBackground(new java.awt.Color(70, 130, 180));

        apopuptitle_L.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        apopuptitle_L.setForeground(new java.awt.Color(255, 255, 255));
        apopuptitle_L.setText("Dostupne knjige");

        javax.swing.GroupLayout apopuptitlebar_PLayout = new javax.swing.GroupLayout(apopuptitlebar_P);
        apopuptitlebar_P.setLayout(apopuptitlebar_PLayout);
        apopuptitlebar_PLayout.setHorizontalGroup(
            apopuptitlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apopuptitlebar_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(apopuptitle_L)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        apopuptitlebar_PLayout.setVerticalGroup(
            apopuptitlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apopuptitlebar_PLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(apopuptitle_L)
                .addContainerGap())
        );

        apopupnuber_P.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        apopupnuber_P.setForeground(new java.awt.Color(102, 102, 102));
        apopupnuber_P.setText("0");

        apopupmessage_L.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        apopupmessage_L.setForeground(new java.awt.Color(102, 102, 102));
        apopupmessage_L.setText("Trenutno imamo 0 knjiga");

        javax.swing.GroupLayout availablepopup_PLayout = new javax.swing.GroupLayout(availablepopup_P);
        availablepopup_P.setLayout(availablepopup_PLayout);
        availablepopup_PLayout.setHorizontalGroup(
            availablepopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(apopuptitlebar_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(availablepopup_PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(availablepopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(availablepopup_PLayout.createSequentialGroup()
                        .addComponent(apopupmessage_L)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(apopupnuber_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        availablepopup_PLayout.setVerticalGroup(
            availablepopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(availablepopup_PLayout.createSequentialGroup()
                .addComponent(apopuptitlebar_P, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apopupnuber_P, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apopupmessage_L)
                .addContainerGap())
        );

        userspopup_P.setBackground(new java.awt.Color(255, 255, 255));
        userspopup_P.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        upopuptitlebar_P.setBackground(new java.awt.Color(70, 130, 180));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Korisnici");

        javax.swing.GroupLayout upopuptitlebar_PLayout = new javax.swing.GroupLayout(upopuptitlebar_P);
        upopuptitlebar_P.setLayout(upopuptitlebar_PLayout);
        upopuptitlebar_PLayout.setHorizontalGroup(
            upopuptitlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upopuptitlebar_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        upopuptitlebar_PLayout.setVerticalGroup(
            upopuptitlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, upopuptitlebar_PLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        upopupnumber_L.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        upopupnumber_L.setForeground(new java.awt.Color(102, 102, 102));
        upopupnumber_L.setText("0");

        upopupmessage_L.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        upopupmessage_L.setForeground(new java.awt.Color(102, 102, 102));
        upopupmessage_L.setText("Trenutno imamo 0 korisnika");

        javax.swing.GroupLayout userspopup_PLayout = new javax.swing.GroupLayout(userspopup_P);
        userspopup_P.setLayout(userspopup_PLayout);
        userspopup_PLayout.setHorizontalGroup(
            userspopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(upopuptitlebar_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(userspopup_PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userspopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upopupnumber_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(userspopup_PLayout.createSequentialGroup()
                        .addComponent(upopupmessage_L)
                        .addGap(0, 121, Short.MAX_VALUE)))
                .addContainerGap())
        );
        userspopup_PLayout.setVerticalGroup(
            userspopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userspopup_PLayout.createSequentialGroup()
                .addComponent(upopuptitlebar_P, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(upopupnumber_L, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(upopupmessage_L)
                .addContainerGap())
        );

        administratorspopup_P.setBackground(new java.awt.Color(255, 255, 255));
        administratorspopup_P.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        adminpopuptitlebar_P.setBackground(new java.awt.Color(70, 130, 180));

        adminpopuptitle_L.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        adminpopuptitle_L.setForeground(new java.awt.Color(255, 255, 255));
        adminpopuptitle_L.setText("Administratori");

        javax.swing.GroupLayout adminpopuptitlebar_PLayout = new javax.swing.GroupLayout(adminpopuptitlebar_P);
        adminpopuptitlebar_P.setLayout(adminpopuptitlebar_PLayout);
        adminpopuptitlebar_PLayout.setHorizontalGroup(
            adminpopuptitlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminpopuptitlebar_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminpopuptitle_L)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminpopuptitlebar_PLayout.setVerticalGroup(
            adminpopuptitlebar_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminpopuptitlebar_PLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminpopuptitle_L)
                .addContainerGap())
        );

        adminpopupnumber_L.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        adminpopupnumber_L.setForeground(new java.awt.Color(102, 102, 102));
        adminpopupnumber_L.setText("0");

        adminpopupmessage_L.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        adminpopupmessage_L.setForeground(new java.awt.Color(102, 102, 102));
        adminpopupmessage_L.setText("Trenutno imamo 0 administratora");

        javax.swing.GroupLayout administratorspopup_PLayout = new javax.swing.GroupLayout(administratorspopup_P);
        administratorspopup_P.setLayout(administratorspopup_PLayout);
        administratorspopup_PLayout.setHorizontalGroup(
            administratorspopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminpopuptitlebar_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(administratorspopup_PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(administratorspopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminpopupnumber_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(administratorspopup_PLayout.createSequentialGroup()
                        .addComponent(adminpopupmessage_L)
                        .addGap(0, 119, Short.MAX_VALUE)))
                .addContainerGap())
        );
        administratorspopup_PLayout.setVerticalGroup(
            administratorspopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(administratorspopup_PLayout.createSequentialGroup()
                .addComponent(adminpopuptitlebar_P, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminpopupnumber_L, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminpopupmessage_L)
                .addContainerGap())
        );

        clock_L.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clock_L.setForeground(new java.awt.Color(102, 102, 102));
        clock_L.setText("00:00:00, 00.00.0000.");

        javax.swing.GroupLayout homepage_PLayout = new javax.swing.GroupLayout(homepage_P);
        homepage_P.setLayout(homepage_PLayout);
        homepage_PLayout.setHorizontalGroup(
            homepage_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepage_PLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(availablepopup_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(userspopup_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
            .addGroup(homepage_PLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(administratorspopup_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homepage_PLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clock_L)
                .addContainerGap())
        );
        homepage_PLayout.setVerticalGroup(
            homepage_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepage_PLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(homepage_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userspopup_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availablepopup_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(administratorspopup_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clock_L)
                .addGap(8, 8, 8))
        );

        JTabbedPane1.addTab("1", homepage_P);

        availablebook_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Naslov", "Podnaslov", "Autor", "Izdavač", "Datum objavljivanja", "Broj stranica", "Žanr", "Povezane knjige"
            }
        ));
        availablebook_T.setShowGrid(true);
        availablebook_T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availablebook_TMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(availablebook_T);

        bookdocs_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Ime datoteke", "Putanja"
            }
        ));
        bookdocs_T.setShowGrid(true);
        bookdocs_T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookdocs_TMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(bookdocs_T);

        booksrefresh_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        booksrefresh_B.setForeground(new java.awt.Color(102, 102, 102));
        booksrefresh_B.setText("Osveži");
        booksrefresh_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksrefresh_BActionPerformed(evt);
            }
        });

        removebook_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        removebook_B.setForeground(new java.awt.Color(102, 102, 102));
        removebook_B.setText("Ukloni");
        removebook_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebook_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout availablebook_PLayout = new javax.swing.GroupLayout(availablebook_P);
        availablebook_P.setLayout(availablebook_PLayout);
        availablebook_PLayout.setHorizontalGroup(
            availablebook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(availablebook_PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(availablebook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, availablebook_PLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(removebook_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(booksrefresh_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );
        availablebook_PLayout.setVerticalGroup(
            availablebook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(availablebook_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(availablebook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(booksrefresh_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removebook_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        JTabbedPane1.addTab("2", availablebook_P);

        lastID_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lastID_L.setForeground(new java.awt.Color(102, 102, 102));
        lastID_L.setText("last ID");

        lastID_TF.setEditable(false);
        lastID_TF.setBackground(new java.awt.Color(255, 255, 255));
        lastID_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lastID_TF.setForeground(new java.awt.Color(102, 102, 102));

        title_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        title_L.setForeground(new java.awt.Color(102, 102, 102));
        title_L.setText("Naslov ");

        subtitle_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        subtitle_L.setForeground(new java.awt.Color(102, 102, 102));
        subtitle_L.setText("Podnaslov ");

        author_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        author_L.setForeground(new java.awt.Color(102, 102, 102));
        author_L.setText("Autor");

        numberofpages_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        numberofpages_L.setForeground(new java.awt.Color(102, 102, 102));
        numberofpages_L.setText("Broj stranica");

        publisher_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        publisher_L.setForeground(new java.awt.Color(102, 102, 102));
        publisher_L.setText("Izdavač");

        publishingdate_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        publishingdate_L.setForeground(new java.awt.Color(102, 102, 102));
        publishingdate_L.setText("Datum objavljivanja");

        relatedbooks_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        relatedbooks_L.setForeground(new java.awt.Color(102, 102, 102));
        relatedbooks_L.setText("Povezane knjige");

        genre_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        genre_L.setForeground(new java.awt.Color(102, 102, 102));
        genre_L.setText("Žanr");

        genre_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        genre_TF.setForeground(new java.awt.Color(102, 102, 102));
        genre_TF.setText("Žanr");
        genre_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                genre_TFMouseClicked(evt);
            }
        });
        genre_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                genre_TFKeyPressed(evt);
            }
        });

        publishingdate_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        publishingdate_TF.setForeground(new java.awt.Color(102, 102, 102));
        publishingdate_TF.setText("Datum objavljivanja");
        publishingdate_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                publishingdate_TFMouseClicked(evt);
            }
        });
        publishingdate_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                publishingdate_TFKeyPressed(evt);
            }
        });

        subtitle_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        subtitle_TF.setForeground(new java.awt.Color(102, 102, 102));
        subtitle_TF.setText("Podnaslov");
        subtitle_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subtitle_TFMouseClicked(evt);
            }
        });
        subtitle_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                subtitle_TFKeyPressed(evt);
            }
        });

        publisher_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        publisher_TF.setForeground(new java.awt.Color(102, 102, 102));
        publisher_TF.setText("Izdavač");
        publisher_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                publisher_TFMouseClicked(evt);
            }
        });
        publisher_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                publisher_TFKeyPressed(evt);
            }
        });

        author_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        author_TF.setForeground(new java.awt.Color(102, 102, 102));
        author_TF.setText("Autor");
        author_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                author_TFMouseClicked(evt);
            }
        });
        author_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                author_TFKeyPressed(evt);
            }
        });

        title_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        title_TF.setForeground(new java.awt.Color(102, 102, 102));
        title_TF.setText("Naslov");
        title_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                title_TFMouseClicked(evt);
            }
        });
        title_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                title_TFKeyPressed(evt);
            }
        });

        numberofpages_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        numberofpages_TF.setForeground(new java.awt.Color(102, 102, 102));
        numberofpages_TF.setText("Broj stranica");
        numberofpages_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numberofpages_TFMouseClicked(evt);
            }
        });
        numberofpages_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numberofpages_TFKeyPressed(evt);
            }
        });

        relatedbooks_CB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        relatedbooks_CB.setForeground(new java.awt.Color(102, 102, 102));
        relatedbooks_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Povezane knjige", "Nema" }));
        relatedbooks_CB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                relatedbooks_CBMousePressed(evt);
            }
        });

        filechooser_FC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filechooser_FCActionPerformed(evt);
            }
        });

        aconfig_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        aconfig_B.setForeground(new java.awt.Color(102, 102, 102));
        aconfig_B.setText("Potvrdi");
        aconfig_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aconfig_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addbook_PLayout = new javax.swing.GroupLayout(addbook_P);
        addbook_P.setLayout(addbook_PLayout);
        addbook_PLayout.setHorizontalGroup(
            addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addbook_PLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subtitle_L)
                    .addComponent(title_L)
                    .addComponent(publisher_L)
                    .addComponent(author_L)
                    .addComponent(genre_L)
                    .addComponent(relatedbooks_L)
                    .addComponent(publishingdate_L)
                    .addComponent(numberofpages_L))
                .addGap(39, 39, 39)
                .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(title_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(publisher_TF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(author_TF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subtitle_TF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(genre_TF)
                            .addComponent(relatedbooks_CB, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(publishingdate_TF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(numberofpages_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filechooser_FC, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addbook_PLayout.createSequentialGroup()
                        .addComponent(lastID_L)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addbook_PLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(aconfig_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        addbook_PLayout.setVerticalGroup(
            addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addbook_PLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastID_L)
                    .addComponent(lastID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title_L)
                    .addComponent(title_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addbook_PLayout.createSequentialGroup()
                        .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subtitle_L)
                            .addComponent(subtitle_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(author_L)
                            .addComponent(author_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(publisher_L)
                            .addComponent(publisher_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(publishingdate_L)
                            .addComponent(publishingdate_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numberofpages_L)
                            .addComponent(numberofpages_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genre_L)
                            .addComponent(genre_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(addbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(relatedbooks_L)
                            .addComponent(relatedbooks_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(filechooser_FC, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(aconfig_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        JTabbedPane1.addTab("3", addbook_P);

        undo_B.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        undo_B.setForeground(new java.awt.Color(102, 102, 102));
        undo_B.setText("Undo");
        undo_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undo_BActionPerformed(evt);
            }
        });

        editedbookcontent_TA.setColumns(20);
        editedbookcontent_TA.setRows(5);
        editedbookcontent_TA.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                editedbookcontent_TACaretUpdate(evt);
            }
        });
        jScrollPane6.setViewportView(editedbookcontent_TA);

        editebookname_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editebookname_TF.setForeground(new java.awt.Color(102, 102, 102));
        editebookname_TF.setText("Naziv");
        editebookname_TF.setPreferredSize(new java.awt.Dimension(64, 28));
        editebookname_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editebookname_TFMouseClicked(evt);
            }
        });
        editebookname_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editebookname_TFKeyPressed(evt);
            }
        });

        sizeofdocument_TF.setEditable(false);
        sizeofdocument_TF.setBackground(new java.awt.Color(255, 255, 255));
        sizeofdocument_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sizeofdocument_TF.setForeground(new java.awt.Color(102, 102, 102));
        sizeofdocument_TF.setText("Veličina");
        sizeofdocument_TF.setPreferredSize(new java.awt.Dimension(64, 28));

        editedbookdocs_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        editedbookdocs_L.setForeground(new java.awt.Color(102, 102, 102));
        editedbookdocs_L.setText("Dokumenti");

        editedbookdocs_CB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editedbookdocs_CB.setForeground(new java.awt.Color(102, 102, 102));
        editedbookdocs_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dokumenti", "Nema" }));
        editedbookdocs_CB.setPreferredSize(new java.awt.Dimension(64, 28));
        editedbookdocs_CB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editedbookdocs_CBMousePressed(evt);
            }
        });

        showeditedbook_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        showeditedbook_B.setForeground(new java.awt.Color(102, 102, 102));
        showeditedbook_B.setText("Prikaži");
        showeditedbook_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showeditedbook_BActionPerformed(evt);
            }
        });

        saveeditedbook_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        saveeditedbook_B.setForeground(new java.awt.Color(102, 102, 102));
        saveeditedbook_B.setText("Sačuvaj");
        saveeditedbook_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveeditedbook_BActionPerformed(evt);
            }
        });

        removeeditedbook_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        removeeditedbook_B.setForeground(new java.awt.Color(102, 102, 102));
        removeeditedbook_B.setText("Ukloni");
        removeeditedbook_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeeditedbook_BActionPerformed(evt);
            }
        });

        redo_L.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        redo_L.setForeground(new java.awt.Color(102, 102, 102));
        redo_L.setText("Redo");
        redo_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redo_LActionPerformed(evt);
            }
        });

        removeeditedbook_B1.setBackground(new java.awt.Color(70, 130, 180));
        removeeditedbook_B1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        removeeditedbook_B1.setForeground(new java.awt.Color(255, 255, 255));
        removeeditedbook_B1.setText("NAPREDNI UREĐIVAČ TEKSTA");
        removeeditedbook_B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeeditedbook_B1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(0, 69, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(showeditedbook_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(removeeditedbook_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(editedbookdocs_L, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(editedbookdocs_CB, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(editebookname_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(undo_B, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(redo_L, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(saveeditedbook_B, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sizeofdocument_TF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeeditedbook_B1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editebookname_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeofdocument_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(undo_B)
                    .addComponent(redo_L))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editedbookdocs_L)
                    .addComponent(editedbookdocs_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveeditedbook_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showeditedbook_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeeditedbook_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeeditedbook_B1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout editbook_PLayout = new javax.swing.GroupLayout(editbook_P);
        editbook_P.setLayout(editbook_PLayout);
        editbook_PLayout.setHorizontalGroup(
            editbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editbook_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        editbook_PLayout.setVerticalGroup(
            editbook_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editbook_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabbedPane1.addTab("4", editbook_P);

        jSplitPane1.setDividerSize(2);
        jSplitPane1.setResizeWeight(0.5);

        bookdocslist_LI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookdocslist_LIMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(bookdocslist_LI);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel14);

        takedwords_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        takedwords_L.setForeground(new java.awt.Color(102, 102, 102));
        takedwords_L.setText("Uhvaćene reči");

        takedwordscontent_TA.setEditable(false);
        takedwordscontent_TA.setBackground(new java.awt.Color(255, 255, 255));
        takedwordscontent_TA.setColumns(20);
        takedwordscontent_TA.setRows(5);
        jScrollPane5.setViewportView(takedwordscontent_TA);

        countofwods_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        countofwods_L.setForeground(new java.awt.Color(102, 102, 102));
        countofwods_L.setText("Ukupan broj reči u datoteci");

        countofwods_TF.setEditable(false);
        countofwods_TF.setBackground(new java.awt.Color(255, 255, 255));
        countofwods_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        countofwods_TF.setForeground(new java.awt.Color(102, 102, 102));
        countofwods_TF.setText("Ukupan broj reči");
        countofwods_TF.setPreferredSize(new java.awt.Dimension(64, 28));

        countofwodsindictionary_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        countofwodsindictionary_L.setForeground(new java.awt.Color(102, 102, 102));
        countofwodsindictionary_L.setText("Broj reči u rečniku");

        countofwodsindictionary_TF.setEditable(false);
        countofwodsindictionary_TF.setBackground(new java.awt.Color(255, 255, 255));
        countofwodsindictionary_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        countofwodsindictionary_TF.setForeground(new java.awt.Color(102, 102, 102));
        countofwodsindictionary_TF.setText("Broj reči u rečniku");
        countofwodsindictionary_TF.setPreferredSize(new java.awt.Dimension(64, 28));

        takedwordssave_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        takedwordssave_B.setForeground(new java.awt.Color(102, 102, 102));
        takedwordssave_B.setText("Sačuvaj");
        takedwordssave_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takedwordssave_BActionPerformed(evt);
            }
        });

        takedwordsname_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        takedwordsname_TF.setForeground(new java.awt.Color(102, 102, 102));
        takedwordsname_TF.setText("Naziv datoteke");
        takedwordsname_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                takedwordsname_TFMouseClicked(evt);
            }
        });
        takedwordsname_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                takedwordsname_TFKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(countofwodsindictionary_L)
                    .addComponent(countofwods_L))
                .addGap(66, 66, 66)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(countofwods_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countofwodsindictionary_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 221, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(takedwords_L, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takedwordsname_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(takedwordssave_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5))
                .addGap(27, 27, 27))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(takedwords_L)
                        .addGap(18, 18, 18)
                        .addComponent(takedwordsname_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(takedwordssave_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 30, Short.MAX_VALUE)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countofwods_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countofwods_L))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countofwodsindictionary_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countofwodsindictionary_L))
                .addGap(65, 65, 65))
        );

        jSplitPane1.setRightComponent(jPanel15);

        JTabbedPane1.addTab("5", jSplitPane1);

        IOpopup_P.setBackground(new java.awt.Color(255, 255, 255));
        IOpopup_P.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IOpopup_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IOpopup_PMouseClicked(evt);
            }
        });

        jPanel19.setBackground(new java.awt.Color(70, 130, 180));

        io2_L2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        io2_L2.setForeground(new java.awt.Color(255, 255, 255));
        io2_L2.setText("IKS OKS SEB (u dvoje) ");
        io2_L2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                io2_L2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(io2_L2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(io2_L2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        io0_L.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        io0_L.setForeground(new java.awt.Color(102, 102, 102));
        io0_L.setText("0");
        io0_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                io0_LMouseClicked(evt);
            }
        });

        io1_L.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        io1_L.setForeground(new java.awt.Color(102, 102, 102));
        io1_L.setText("Odigrano ukupno 0 puta");
        io1_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                io1_LMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout IOpopup_PLayout = new javax.swing.GroupLayout(IOpopup_P);
        IOpopup_P.setLayout(IOpopup_PLayout);
        IOpopup_PLayout.setHorizontalGroup(
            IOpopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(IOpopup_PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IOpopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IOpopup_PLayout.createSequentialGroup()
                        .addComponent(io1_L)
                        .addGap(0, 126, Short.MAX_VALUE))
                    .addComponent(io0_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        IOpopup_PLayout.setVerticalGroup(
            IOpopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IOpopup_PLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(io0_L, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(io1_L)
                .addContainerGap())
        );

        quizpopup_P.setBackground(new java.awt.Color(255, 255, 255));
        quizpopup_P.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel21.setBackground(new java.awt.Color(70, 130, 180));

        quiz2_L1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        quiz2_L1.setForeground(new java.awt.Color(255, 255, 255));
        quiz2_L1.setText("KVIZ SEB");
        quiz2_L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quiz2_L1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quiz2_L1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quiz2_L1)
                .addContainerGap())
        );

        quiz0_L1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        quiz0_L1.setForeground(new java.awt.Color(102, 102, 102));
        quiz0_L1.setText("0");
        quiz0_L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quiz0_L1MouseClicked(evt);
            }
        });

        quiz1_L1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        quiz1_L1.setForeground(new java.awt.Color(102, 102, 102));
        quiz1_L1.setText("Odigrano ukupno 0 puta");

        quizwin_L.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        quizwin_L.setForeground(new java.awt.Color(102, 102, 102));
        quizwin_L.setText("Ukupno znanje 0,0% igraca");

        javax.swing.GroupLayout quizpopup_PLayout = new javax.swing.GroupLayout(quizpopup_P);
        quizpopup_P.setLayout(quizpopup_PLayout);
        quizpopup_PLayout.setHorizontalGroup(
            quizpopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(quizpopup_PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quizpopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quiz0_L1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(quizpopup_PLayout.createSequentialGroup()
                        .addGap(0, 117, Short.MAX_VALUE)
                        .addComponent(quizwin_L))
                    .addGroup(quizpopup_PLayout.createSequentialGroup()
                        .addComponent(quiz1_L1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        quizpopup_PLayout.setVerticalGroup(
            quizpopup_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quizpopup_PLayout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quizwin_L)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quiz0_L1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quiz1_L1)
                .addContainerGap())
        );

        booksrefresh_B1.setBackground(new java.awt.Color(102, 102, 102));
        booksrefresh_B1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        booksrefresh_B1.setForeground(new java.awt.Color(255, 255, 255));
        booksrefresh_B1.setText("UREĐIVAČ PITANJA KVIZA");
        booksrefresh_B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksrefresh_B1ActionPerformed(evt);
            }
        });

        booksrefresh_B2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        booksrefresh_B2.setForeground(new java.awt.Color(102, 102, 102));
        booksrefresh_B2.setText("TABELA PITANJA KVIZA");
        booksrefresh_B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksrefresh_B2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(70, 130, 180));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PITANJA KVIZA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        statequiz_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        statequiz_B.setForeground(new java.awt.Color(102, 102, 102));
        statequiz_B.setText("TABELA STANJA KVIZA");
        statequiz_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statequiz_BActionPerformed(evt);
            }
        });

        stateio_B.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        stateio_B.setForeground(new java.awt.Color(102, 102, 102));
        stateio_B.setText("TABELA STANJA IKS OKSA");
        stateio_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateio_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout games_PLayout = new javax.swing.GroupLayout(games_P);
        games_P.setLayout(games_PLayout);
        games_PLayout.setHorizontalGroup(
            games_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(games_PLayout.createSequentialGroup()
                .addGroup(games_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(games_PLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(IOpopup_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addGroup(games_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(booksrefresh_B1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(booksrefresh_B2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(games_PLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quizpopup_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addGroup(games_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stateio_B, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statequiz_B, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        games_PLayout.setVerticalGroup(
            games_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(games_PLayout.createSequentialGroup()
                .addGroup(games_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(games_PLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(IOpopup_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(games_PLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(booksrefresh_B1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(booksrefresh_B2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(games_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, games_PLayout.createSequentialGroup()
                        .addComponent(quizpopup_P, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, games_PLayout.createSequentialGroup()
                        .addComponent(stateio_B, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statequiz_B, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        JTabbedPane1.addTab("6", games_P);

        messages_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Naslov", "Korisnik"
            }
        ));
        messages_T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messages_TMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(messages_T);

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane15.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
                    .addComponent(jScrollPane15))
                .addGap(29, 29, 29))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        JTabbedPane1.addTab("7", jPanel8);

        realname_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        realname_TF.setForeground(new java.awt.Color(102, 102, 102));
        realname_TF.setText("Realname");
        realname_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                realname_TFMouseClicked(evt);
            }
        });
        realname_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                realname_TFKeyPressed(evt);
            }
        });

        realname_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        realname_L.setForeground(new java.awt.Color(102, 102, 102));
        realname_L.setText("Realname");

        surname_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        surname_L.setForeground(new java.awt.Color(102, 102, 102));
        surname_L.setText("Surname");

        surname_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        surname_TF.setForeground(new java.awt.Color(102, 102, 102));
        surname_TF.setText("Surname");
        surname_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                surname_TFMouseClicked(evt);
            }
        });
        surname_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                surname_TFKeyPressed(evt);
            }
        });

        purpose_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        purpose_TF.setForeground(new java.awt.Color(102, 102, 102));
        purpose_TF.setText("Purpose");
        purpose_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purpose_TFMouseClicked(evt);
            }
        });
        purpose_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                purpose_TFKeyPressed(evt);
            }
        });

        purpose_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        purpose_L.setForeground(new java.awt.Color(102, 102, 102));
        purpose_L.setText("Purpose");

        phone_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        phone_L.setForeground(new java.awt.Color(102, 102, 102));
        phone_L.setText("Phone");

        phone_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phone_TF.setForeground(new java.awt.Color(102, 102, 102));
        phone_TF.setText("Phone");
        phone_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phone_TFMouseClicked(evt);
            }
        });
        phone_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phone_TFKeyPressed(evt);
            }
        });

        nickname_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nickname_TF.setForeground(new java.awt.Color(102, 102, 102));
        nickname_TF.setText("Nickname");
        nickname_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nickname_TFMouseClicked(evt);
            }
        });
        nickname_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nickname_TFKeyPressed(evt);
            }
        });

        nickname_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        nickname_L.setForeground(new java.awt.Color(102, 102, 102));
        nickname_L.setText("Nickname");

        email_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        email_L.setForeground(new java.awt.Color(102, 102, 102));
        email_L.setText("Email");

        email_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        email_TF.setForeground(new java.awt.Color(102, 102, 102));
        email_TF.setText("Email");
        email_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                email_TFMouseClicked(evt);
            }
        });
        email_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                email_TFKeyPressed(evt);
            }
        });

        password_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        password_L.setForeground(new java.awt.Color(102, 102, 102));
        password_L.setText("Password");

        password_TF.setText("Password");
        password_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                password_TFMouseClicked(evt);
            }
        });
        password_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                password_TFKeyPressed(evt);
            }
        });

        registeradministratorconfig_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        registeradministratorconfig_B.setForeground(new java.awt.Color(102, 102, 102));
        registeradministratorconfig_B.setText("Potvrdi");
        registeradministratorconfig_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registeradministratorconfig_BActionPerformed(evt);
            }
        });

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistem/eb/icons/padlock_unlock.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("REGISTRACIJA");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel31.setForeground(java.awt.SystemColor.activeCaption);
        jLabel31.setText("A D M I N I S T R A T O R A");

        javax.swing.GroupLayout registeradministrator_PLayout = new javax.swing.GroupLayout(registeradministrator_P);
        registeradministrator_P.setLayout(registeradministrator_PLayout);
        registeradministrator_PLayout.setHorizontalGroup(
            registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registeradministrator_PLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surname_L)
                    .addComponent(realname_L)
                    .addComponent(phone_L)
                    .addComponent(purpose_L)
                    .addComponent(password_L)
                    .addComponent(nickname_L)
                    .addComponent(email_L))
                .addGap(102, 102, 102)
                .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registeradministrator_PLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(registeradministratorconfig_B, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(registeradministrator_PLayout.createSequentialGroup()
                        .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phone_TF)
                            .addComponent(nickname_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(purpose_TF)
                            .addComponent(surname_TF)
                            .addComponent(email_TF)
                            .addComponent(password_TF)
                            .addComponent(realname_TF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registeradministrator_PLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registeradministrator_PLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(95, 95, 95))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registeradministrator_PLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(209, 209, 209))))))
        );
        registeradministrator_PLayout.setVerticalGroup(
            registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registeradministrator_PLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registeradministrator_PLayout.createSequentialGroup()
                        .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(realname_L)
                            .addComponent(realname_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surname_L)
                            .addComponent(surname_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(purpose_L)
                            .addComponent(purpose_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phone_L)
                            .addComponent(phone_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nickname_L)
                            .addComponent(nickname_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email_L)
                            .addComponent(email_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registeradministrator_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(password_L)
                            .addComponent(password_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(registeradministrator_PLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(registeradministratorconfig_B, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        JTabbedPane1.addTab("8", registeradministrator_P);

        users_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Password", "Email"
            }
        ));
        users_T.setShowGrid(true);
        jScrollPane1.setViewportView(users_T);

        deleteuser_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deleteuser_B.setForeground(new java.awt.Color(102, 102, 102));
        deleteuser_B.setText("Ukloni");
        deleteuser_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteuser_BActionPerformed(evt);
            }
        });

        usersrefresh_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        usersrefresh_B.setForeground(new java.awt.Color(102, 102, 102));
        usersrefresh_B.setText("Osveži");
        usersrefresh_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersrefresh_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout users_PLayout = new javax.swing.GroupLayout(users_P);
        users_P.setLayout(users_PLayout);
        users_PLayout.setHorizontalGroup(
            users_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(users_PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(users_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, users_PLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(usersrefresh_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteuser_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        users_PLayout.setVerticalGroup(
            users_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(users_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(users_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteuser_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usersrefresh_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        JTabbedPane1.addTab("9", users_P);

        administrator_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Realname", "Surname", "Purpose", "Phone", "Nickname", "Email", "Password"
            }
        ));
        administrator_T.setDragEnabled(true);
        administrator_T.setShowGrid(true);
        jScrollPane2.setViewportView(administrator_T);

        deleteadministrator_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deleteadministrator_B.setForeground(new java.awt.Color(102, 102, 102));
        deleteadministrator_B.setText("Ukloni");
        deleteadministrator_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteadministrator_BActionPerformed(evt);
            }
        });

        administratorrefresh_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        administratorrefresh_B.setForeground(new java.awt.Color(102, 102, 102));
        administratorrefresh_B.setText("Osveži");
        administratorrefresh_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administratorrefresh_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout administrators_PLayout = new javax.swing.GroupLayout(administrators_P);
        administrators_P.setLayout(administrators_PLayout);
        administrators_PLayout.setHorizontalGroup(
            administrators_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(administrators_PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(administrators_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, administrators_PLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(administratorrefresh_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteadministrator_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        administrators_PLayout.setVerticalGroup(
            administrators_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(administrators_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(administrators_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteadministrator_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(administratorrefresh_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        JTabbedPane1.addTab("10", administrators_P);

        jPanel2.setBackground(new java.awt.Color(70, 130, 180));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("UREĐIVAČ PITANJA KVIZA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap())
        );

        question_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        question_L.setForeground(new java.awt.Color(102, 102, 102));
        question_L.setText("Pitanje");

        answertwo_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        answertwo_L.setForeground(new java.awt.Color(102, 102, 102));
        answertwo_L.setText("Odgovor II");

        answerone_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        answerone_L.setForeground(new java.awt.Color(102, 102, 102));
        answerone_L.setText("Odgovor I");

        answerthree_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        answerthree_L.setForeground(new java.awt.Color(102, 102, 102));
        answerthree_L.setText("Odgovor III");

        answerthree_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerthree_TF.setForeground(new java.awt.Color(102, 102, 102));
        answerthree_TF.setText("Odgovor III");
        answerthree_TF.setFocusable(false);
        answerthree_TF.setMaximumSize(new java.awt.Dimension(64, 22));
        answerthree_TF.setPreferredSize(new java.awt.Dimension(64, 22));
        answerthree_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answerthree_TFMouseClicked(evt);
            }
        });
        answerthree_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                answerthree_TFKeyPressed(evt);
            }
        });

        answerone_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerone_TF.setForeground(new java.awt.Color(102, 102, 102));
        answerone_TF.setText("Odgovor I");
        answerone_TF.setFocusable(false);
        answerone_TF.setMaximumSize(new java.awt.Dimension(64, 22));
        answerone_TF.setPreferredSize(new java.awt.Dimension(64, 22));
        answerone_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answerone_TFMouseClicked(evt);
            }
        });
        answerone_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                answerone_TFKeyPressed(evt);
            }
        });

        question_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        question_TF.setForeground(new java.awt.Color(102, 102, 102));
        question_TF.setText("Pitanje");
        question_TF.setFocusable(false);
        question_TF.setMaximumSize(new java.awt.Dimension(64, 22));
        question_TF.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                question_TFCaretUpdate(evt);
            }
        });
        question_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                question_TFMouseClicked(evt);
            }
        });
        question_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                question_TFKeyPressed(evt);
            }
        });

        answertwo_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answertwo_TF.setForeground(new java.awt.Color(102, 102, 102));
        answertwo_TF.setText("Odgovor II");
        answertwo_TF.setFocusable(false);
        answertwo_TF.setMaximumSize(new java.awt.Dimension(64, 22));
        answertwo_TF.setPreferredSize(new java.awt.Dimension(64, 22));
        answertwo_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answertwo_TFMouseClicked(evt);
            }
        });
        answertwo_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                answertwo_TFKeyPressed(evt);
            }
        });

        answerfour_TF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerfour_TF.setForeground(new java.awt.Color(102, 102, 102));
        answerfour_TF.setText("Odgovor IV");
        answerfour_TF.setFocusable(false);
        answerfour_TF.setMaximumSize(new java.awt.Dimension(64, 22));
        answerfour_TF.setPreferredSize(new java.awt.Dimension(64, 22));
        answerfour_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answerfour_TFMouseClicked(evt);
            }
        });
        answerfour_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                answerfour_TFKeyPressed(evt);
            }
        });

        answerfour_L.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        answerfour_L.setForeground(new java.awt.Color(102, 102, 102));
        answerfour_L.setText("Odgovor IV");

        configquiz_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        configquiz_B.setForeground(new java.awt.Color(102, 102, 102));
        configquiz_B.setText("Potvrdi");
        configquiz_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configquiz_BActionPerformed(evt);
            }
        });

        deletequestion_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deletequestion_B.setForeground(new java.awt.Color(102, 102, 102));
        deletequestion_B.setText("Ukloni");
        deletequestion_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletequestion_BActionPerformed(evt);
            }
        });

        quizbuttons_BG.add(answerone_RB);
        answerone_RB.setFocusable(false);
        answerone_RB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                answerone_RBItemStateChanged(evt);
            }
        });

        quizbuttons_BG.add(answertwo_RB);
        answertwo_RB.setFocusable(false);
        answertwo_RB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                answertwo_RBItemStateChanged(evt);
            }
        });

        quizbuttons_BG.add(answerthree_RB);
        answerthree_RB.setFocusable(false);
        answerthree_RB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                answerthree_RBItemStateChanged(evt);
            }
        });

        quizbuttons_BG.add(answerfour_RB);
        answerfour_RB.setFocusable(false);
        answerfour_RB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                answerfour_RBItemStateChanged(evt);
            }
        });

        corectanswer_L.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        corectanswer_L.setForeground(new java.awt.Color(70, 130, 180));
        corectanswer_L.setText("Odgovor  je izabran kao tačan odgovor");

        jList1.setFocusable(false);
        jScrollPane8.setViewportView(jList1);

        javax.swing.GroupLayout editquestions_PLayout = new javax.swing.GroupLayout(editquestions_P);
        editquestions_P.setLayout(editquestions_PLayout);
        editquestions_PLayout.setHorizontalGroup(
            editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editquestions_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editquestions_PLayout.createSequentialGroup()
                .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editquestions_PLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(editquestions_PLayout.createSequentialGroup()
                                .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editquestions_PLayout.createSequentialGroup()
                                        .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(question_L)
                                            .addComponent(answerfour_L))
                                        .addGap(65, 65, 65))
                                    .addGroup(editquestions_PLayout.createSequentialGroup()
                                        .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(answerone_L)
                                            .addComponent(answerthree_L)
                                            .addComponent(answertwo_L))
                                        .addGap(66, 66, 66)))
                                .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(answerfour_TF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                    .addComponent(answerone_TF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(answertwo_TF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(answerthree_TF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(question_TF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(corectanswer_L))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(answerfour_RB)
                            .addComponent(answerone_RB)
                            .addComponent(answertwo_RB)
                            .addComponent(answerthree_RB))
                        .addGap(101, 101, 101)
                        .addComponent(jScrollPane8))
                    .addGroup(editquestions_PLayout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(configquiz_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                        .addComponent(deletequestion_B, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        editquestions_PLayout.setVerticalGroup(
            editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editquestions_PLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editquestions_PLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(deletequestion_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(editquestions_PLayout.createSequentialGroup()
                        .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(editquestions_PLayout.createSequentialGroup()
                                .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(answerone_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(answerone_RB))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(answertwo_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(answertwo_RB))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(answerthree_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(answerthree_RB)))
                            .addGroup(editquestions_PLayout.createSequentialGroup()
                                .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(question_L)
                                    .addComponent(question_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addComponent(answerone_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answertwo_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answerthree_L)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editquestions_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(answerfour_L)
                                .addComponent(answerfour_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(answerfour_RB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(corectanswer_L)
                        .addGap(35, 35, 35)
                        .addComponent(configquiz_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        JTabbedPane1.addTab("", editquestions_P);

        quiz_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Pitanje", "Odgovor I", "Odgovor II", "Odgovor III", "Odgovor IV", "Tačan odgovor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(quiz_T);

        deleteadministrator_B1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deleteadministrator_B1.setForeground(new java.awt.Color(102, 102, 102));
        deleteadministrator_B1.setText("Ukloni");
        deleteadministrator_B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteadministrator_B1ActionPerformed(evt);
            }
        });

        deleteadministrator_B2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deleteadministrator_B2.setForeground(new java.awt.Color(102, 102, 102));
        deleteadministrator_B2.setText("Osveži");
        deleteadministrator_B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteadministrator_B2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteadministrator_B2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteadministrator_B1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteadministrator_B1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteadministrator_B2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        JTabbedPane1.addTab("", jPanel1);

        io_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Korisnik", "Vreme"
            }
        ));
        jScrollPane9.setViewportView(io_T);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );

        JTabbedPane1.addTab("", jPanel4);

        quizstate_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Korisnik", "Broj tacnih odgovora", "Vreme"
            }
        ));
        jScrollPane11.setViewportView(quizstate_T);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        JTabbedPane1.addTab("", jPanel5);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane12.setViewportView(jTextArea1);

        jPanel7.setBackground(new java.awt.Color(70, 130, 180));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NAPREDNI UREĐIVAČ TEKSTA");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(676, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap())
        );

        capitalized_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        capitalized_B.setForeground(new java.awt.Color(102, 102, 102));
        capitalized_B.setText("Capitalized Case");
        capitalized_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                capitalized_BMouseClicked(evt);
            }
        });
        capitalized_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capitalized_BActionPerformed(evt);
            }
        });

        alternating_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        alternating_B.setForeground(new java.awt.Color(102, 102, 102));
        alternating_B.setText("aLtErNaTiNg cAsE");
        alternating_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alternating_BMouseClicked(evt);
            }
        });
        alternating_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternating_BActionPerformed(evt);
            }
        });

        lower_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lower_B.setForeground(new java.awt.Color(102, 102, 102));
        lower_B.setText("lower case");
        lower_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lower_BMouseClicked(evt);
            }
        });
        lower_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lower_BActionPerformed(evt);
            }
        });

        upper_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        upper_B.setForeground(new java.awt.Color(102, 102, 102));
        upper_B.setText("UPPER CASE");
        upper_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upper_BMouseClicked(evt);
            }
        });
        upper_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upper_BActionPerformed(evt);
            }
        });

        wide_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        wide_B.setForeground(new java.awt.Color(102, 102, 102));
        wide_B.setText("W i d e   c a s e");
        wide_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wide_BMouseClicked(evt);
            }
        });
        wide_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wide_BActionPerformed(evt);
            }
        });

        sentance_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        sentance_B.setForeground(new java.awt.Color(102, 102, 102));
        sentance_B.setText("Sentance case");
        sentance_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sentance_BMouseClicked(evt);
            }
        });
        sentance_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sentance_BActionPerformed(evt);
            }
        });

        inverse_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        inverse_B.setForeground(new java.awt.Color(102, 102, 102));
        inverse_B.setText("InVeRsE CaSe");
        inverse_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inverse_BMouseClicked(evt);
            }
        });
        inverse_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inverse_BActionPerformed(evt);
            }
        });

        title_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        title_B.setForeground(new java.awt.Color(102, 102, 102));
        title_B.setText("Title Case");
        title_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                title_BMouseClicked(evt);
            }
        });
        title_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title_BActionPerformed(evt);
            }
        });

        morse_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        morse_B.setForeground(new java.awt.Color(102, 102, 102));
        morse_B.setText("Morse code");
        morse_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                morse_BMouseClicked(evt);
            }
        });
        morse_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                morse_BActionPerformed(evt);
            }
        });

        reverse_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        reverse_B.setForeground(new java.awt.Color(102, 102, 102));
        reverse_B.setText("esac esreveR");
        reverse_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reverse_BMouseClicked(evt);
            }
        });
        reverse_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reverse_BActionPerformed(evt);
            }
        });

        hex_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        hex_B.setForeground(new java.awt.Color(102, 102, 102));
        hex_B.setText("Hex code");
        hex_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hex_BMouseClicked(evt);
            }
        });
        hex_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hex_BActionPerformed(evt);
            }
        });

        binary_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        binary_B.setForeground(new java.awt.Color(102, 102, 102));
        binary_B.setText("Binary code");
        binary_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                binary_BMouseClicked(evt);
            }
        });
        binary_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binary_BActionPerformed(evt);
            }
        });

        octal_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        octal_B.setForeground(new java.awt.Color(102, 102, 102));
        octal_B.setText("Octal code");
        octal_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                octal_BMouseClicked(evt);
            }
        });
        octal_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                octal_BActionPerformed(evt);
            }
        });

        proper_B.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        proper_B.setForeground(new java.awt.Color(102, 102, 102));
        proper_B.setText("Proper case");
        proper_B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proper_BMouseClicked(evt);
            }
        });
        proper_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proper_BActionPerformed(evt);
            }
        });

        title_B1.setBackground(new java.awt.Color(70, 130, 180));
        title_B1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        title_B1.setForeground(new java.awt.Color(255, 255, 255));
        title_B1.setText("Back to Text");
        title_B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                title_B1MouseClicked(evt);
            }
        });
        title_B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title_B1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(title_B1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(title_B, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sentance_B, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lower_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wide_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(morse_B, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inverse_B, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(upper_B, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(binary_B, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(octal_B, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alternating_B, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capitalized_B, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(proper_B, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reverse_B, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hex_B, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capitalized_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upper_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lower_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sentance_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proper_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inverse_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reverse_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alternating_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wide_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(morse_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hex_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(binary_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(octal_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title_B1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        JTabbedPane1.addTab("", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlebar_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebar_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JTabbedPane1)
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlebar_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidebar_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTabbedPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homepage_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepage_BMouseClicked
        GraphicInterfaceAdministrator.setHomePageLabels(this.apopupnuber_P, this.upopupnumber_L, this.adminpopupnumber_L, this.apopupmessage_L, this.upopupmessage_L, this.adminpopupmessage_L, this.io0_L, this.io1_L, this.quiz1_L1, this.quiz0_L1, this.quizwin_L);
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.homepage_B);
    }//GEN-LAST:event_homepage_BMouseClicked

    private void availablebooks_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availablebooks_BMouseClicked
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.availablebooks_B);
    }//GEN-LAST:event_availablebooks_BMouseClicked

    private void addbooks_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbooks_BMouseClicked
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.addbooks_B);
    }//GEN-LAST:event_addbooks_BMouseClicked

    private void users_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_users_BMouseClicked
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.users_B);
    }//GEN-LAST:event_users_BMouseClicked

    private void administrators_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_administrators_BMouseClicked
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.administrators_B);
    }//GEN-LAST:event_administrators_BMouseClicked

    private void availablebooks_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availablebooks_BActionPerformed
        Books.setBooksTable(availablebook_T, bookdocs_T);
        this.JTabbedPane1.setSelectedIndex(1);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_availablebooks_BActionPerformed

    private void administrators_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrators_BActionPerformed
        this.administrator_T.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        DefaultTableModel tableModel = (DefaultTableModel) this.administrator_T.getModel();
        tableModel.setRowCount(0);
        this.JTabbedPane1.setSelectedIndex(9);
        Administrators.updateTableAdministrators(this.administrator_T);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_administrators_BActionPerformed

    private void users_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_users_BActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) this.users_T.getModel();
        tableModel.setRowCount(0);
        this.JTabbedPane1.setSelectedIndex(8);
        Users.updateTableUsers(this.users_T);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_users_BActionPerformed

    private void addbooks_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbooks_BActionPerformed
        this.JTabbedPane1.setSelectedIndex(2);
        Books.addRelatedBooks(this.relatedbooks_CB);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_addbooks_BActionPerformed

    private void homepage_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homepage_BActionPerformed
        GraphicInterfaceAdministrator.setHomePageLabels(this.apopupnuber_P, this.upopupnumber_L, this.adminpopupnumber_L, this.apopupmessage_L, this.upopupmessage_L, this.adminpopupmessage_L, this.io0_L, this.io1_L, this.quiz1_L1, this.quiz0_L1, this.quizwin_L);
        this.JTabbedPane1.setSelectedIndex(0);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_homepage_BActionPerformed

    private void editbooks_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbooks_BMouseClicked
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.editbooks_B);
    }//GEN-LAST:event_editbooks_BMouseClicked

    private void editbooks_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbooks_BActionPerformed
        this.JTabbedPane1.setSelectedIndex(3);
        Printer.updateComboBox(this.editedbookdocs_CB);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_editbooks_BActionPerformed

    private void wordreader_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wordreader_BMouseClicked
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.wordreader_B);
    }//GEN-LAST:event_wordreader_BMouseClicked

    private void wordreader_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordreader_BActionPerformed
        this.bookdocslist_LI.setListData(new String[0]);
        Books.getAllFilesName(this.bookdocslist_LI);
        this.JTabbedPane1.setSelectedIndex(4);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_wordreader_BActionPerformed

    private void games_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_games_BActionPerformed
        this.JTabbedPane1.setSelectedIndex(5);
        GraphicInterfaceAdministrator.setHomePageLabels(this.apopupnuber_P, this.upopupnumber_L, this.adminpopupnumber_L, this.apopupmessage_L, this.upopupmessage_L, this.adminpopupmessage_L, this.io0_L, this.io1_L, this.quiz1_L1, this.quiz0_L1, this.quizwin_L);

        //Moving objects using jThread class and runnable interface
        this.animationThread = new Thread(new Runnable() {
            //Generate random numbers
            Random ranX = new Random();
            Random ranY = new Random();
            Random r = new Random();

            Color colourList[] = {Color.decode("#f1f1f1"), Color.decode("#e4e4e4"), Color.decode("#454545"), Color.decode("#4484bc")};

            @Override
            public void run() {
                while (true) {
                    //Generate random x and y
                    int x = ranX.nextInt(MAX_X);
                    int y = ranY.nextInt(MAX_Y);
                    int i = r.nextInt(colourList.length);
                    g.setColor(colourList[i]);

                    g.fillRect(x, y, 40, 40); //draw squere
                    try {
                        Thread.sleep(40);
                        games_P.repaint();
                        Thread.sleep(300);
                    } catch (Exception e) {
                        new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
                    }
                }
            }
        });
        //Start the tread
        this.animationThread.start();

    }//GEN-LAST:event_games_BActionPerformed

    private void games_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_games_BMouseClicked
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.games_B);
    }//GEN-LAST:event_games_BMouseClicked

    private void registeradministrator_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registeradministrator_BMouseClicked
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.registeradministrator_B);
    }//GEN-LAST:event_registeradministrator_BMouseClicked

    private void registeradministrator_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registeradministrator_BActionPerformed
        this.JTabbedPane1.setSelectedIndex(7);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_registeradministrator_BActionPerformed

    private void configquiz_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configquiz_BActionPerformed
        if (this.question_TF.getText().equals("") || this.question_TF.getText().equals("Pitanje")) {
            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti pitanje!", "U redu").show();
        } else {
            if (Books.validateWord(this.question_TF.getText(), Books.getPattern("word"))) {
                if (this.answerone_TF.getText().equals("") || this.answerone_TF.getText().equals("Odgovor I")) {
                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti odgovor I!", "U redu").show();
                } else {
                    if (Books.validateWord(this.answerone_TF.getText(), Books.getPattern("word"))) {
                        if (this.answertwo_TF.getText().equals("") || this.answertwo_TF.getText().equals("Odgovor II")) {
                            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti odgovor II!", "U redu").show();
                        } else {
                            if (Books.validateWord(this.answertwo_TF.getText(), Books.getPattern("word"))) {
                                if (this.answerthree_TF.getText().equals("") || this.answerthree_TF.getText().equals("Odgovor III")) {
                                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti odgovor III!", "U redu").show();
                                } else {
                                    if (Books.validateWord(this.answerthree_TF.getText(), Books.getPattern("word"))) {
                                        if (this.answerfour_TF.getText().equals("") || this.answerfour_TF.getText().equals("Odgovor IV")) {
                                            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti odgovor IV!", "U redu").show();
                                        } else {
                                            String key = "";
                                            if (Books.validateWord(this.answerfour_TF.getText(), Books.getPattern("word"))) {
                                                switch (EditQuiz.getSelected(this.answerone_RB, this.answertwo_RB, this.answerthree_RB, this.answerfour_RB)) {
                                                    case 1:
                                                        key = this.answerone_TF.getText();
                                                        break;
                                                    case 2:
                                                        key = this.answertwo_TF.getText();
                                                        break;
                                                    case 3:
                                                        key = this.answerthree_TF.getText();
                                                        break;
                                                    case 4:
                                                        key = this.answerfour_TF.getText();
                                                        break;
                                                }
                                                if (key.equals("")) {
                                                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno je označiti tačan odgovor!", "U redu").show();
                                                } else {
                                                    EditQuiz.makeQuestion(this.question_TF.getText(), this.answerone_TF.getText(), this.answertwo_TF.getText(), this.answerthree_TF.getText(), this.answerfour_TF.getText(), key);
                                                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Pitanje za kviz je uspešno kreirano!", "U redu").show();
                                                    this.jList1.setListData(new String[0]);
                                                    EditQuiz.getAllQuestions(this.jList1);
                                                    EditQuiz.updateTableQuizData(this.quiz_T);

                                                    quizbuttons_BG.clearSelection();
                                                    EditQuiz.resetFields(this.question_TF, this.answerone_TF, this.answertwo_TF, this.answerthree_TF, this.answerfour_TF);
                                                }
                                            } else {
                                                new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format odgovora IV!", "U redu").show();
                                            }
                                        }
                                    } else {
                                        new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format odgovora III!", "U redu").show();
                                    }
                                }
                            } else {
                                new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format odgovora II!", "U redu").show();
                            }
                        }
                    } else {
                        new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format odgovora I!", "U redu").show();
                    }
                }
            } else {
                new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format pitanja!", "U redu").show();
            }
        }
    }//GEN-LAST:event_configquiz_BActionPerformed

    private void answerfour_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_answerfour_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.answfour++, this.answerfour_TF);
    }//GEN-LAST:event_answerfour_TFKeyPressed

    private void answerfour_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answerfour_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.answfour++, this.answerfour_TF);
    }//GEN-LAST:event_answerfour_TFMouseClicked

    private void answertwo_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_answertwo_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.answtwo++, this.answertwo_TF);
    }//GEN-LAST:event_answertwo_TFKeyPressed

    private void answertwo_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answertwo_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.answtwo++, this.answertwo_TF);
    }//GEN-LAST:event_answertwo_TFMouseClicked

    private void question_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_question_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.quest++, this.question_TF);
    }//GEN-LAST:event_question_TFKeyPressed

    private void question_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_question_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.quest++, this.question_TF);
    }//GEN-LAST:event_question_TFMouseClicked

    private void answerone_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_answerone_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.answone++, this.answerone_TF);
    }//GEN-LAST:event_answerone_TFKeyPressed

    private void answerone_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answerone_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.answone++, this.answerone_TF);
    }//GEN-LAST:event_answerone_TFMouseClicked

    private void answerthree_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_answerthree_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.answthree++, this.answerthree_TF);
    }//GEN-LAST:event_answerthree_TFKeyPressed

    private void answerthree_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answerthree_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.answthree++, this.answerthree_TF);
    }//GEN-LAST:event_answerthree_TFMouseClicked

    private void administratorrefresh_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administratorrefresh_BActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) this.administrator_T.getModel();
        tableModel.setRowCount(0);
        Administrators.updateTableAdministrators(this.administrator_T);
    }//GEN-LAST:event_administratorrefresh_BActionPerformed

    private void deleteadministrator_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteadministrator_BActionPerformed
        Administrators.deleteAdministrator(this.administrator_T);
    }//GEN-LAST:event_deleteadministrator_BActionPerformed

    private void usersrefresh_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersrefresh_BActionPerformed
        Users.updateTableUsers(this.users_T);
    }//GEN-LAST:event_usersrefresh_BActionPerformed

    private void deleteuser_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteuser_BActionPerformed
        Users.deleteUser(this.users_T);
    }//GEN-LAST:event_deleteuser_BActionPerformed

    private void booksrefresh_B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksrefresh_B1ActionPerformed
        this.JTabbedPane1.setSelectedIndex(10);
        this.jList1.setListData(new String[0]);
        EditQuiz.getAllQuestions(jList1);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_booksrefresh_B1ActionPerformed

    private void IOpopup_PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IOpopup_PMouseClicked
        xo.setVisible(!xo.isVisible());
    }//GEN-LAST:event_IOpopup_PMouseClicked

    private void io1_LMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_io1_LMouseClicked
        xo.setVisible(!xo.isVisible());
    }//GEN-LAST:event_io1_LMouseClicked

    private void io0_LMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_io0_LMouseClicked
        xo.setVisible(!xo.isVisible());
    }//GEN-LAST:event_io0_LMouseClicked

    private void takedwordsname_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_takedwordsname_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.nameFilep++, this.takedwordsname_TF);
    }//GEN-LAST:event_takedwordsname_TFKeyPressed

    private void takedwordsname_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_takedwordsname_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.nameFilep++, this.takedwordsname_TF);
    }//GEN-LAST:event_takedwordsname_TFMouseClicked

    private void takedwordssave_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takedwordssave_BActionPerformed
        if (this.takedwordscontent_TA.getText().equals("") && this.countofwods_TF.getText().equals("") || this.countofwods_TF.getText().equals("Ukupan broj reči") && this.countofwodsindictionary_TF.getText().equals("") || this.countofwodsindictionary_TF.getText().equals("Broj reči u rečniku")) {
            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno je izabrati datoteku sa liste!", "U redu").show();
        } else {
            if (this.takedwordsname_TF.getText().equals("") || this.takedwordsname_TF.getText().equals("Naziv datoteke")) {
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno je uneti naziv datoteke!", "U redu").show();
            } else {
                if (Books.validateWord(this.takedwordsname_TF.getText(), Books.getPattern("word"))) {
                    FindWords.makeFile(ser.get(0), this.takedwordsname_TF.getText().trim());
                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Uspešno sačuvana datoteka " + this.takedwordsname_TF.getText() + "!", "U redu").show();
                    this.takedwordscontent_TA.setText("");
                    this.countofwods_TF.setText("");
                    this.countofwodsindictionary_TF.setText("");
                    this.takedwordsname_TF.setText("");
                } else {
                    new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format naziva datoteke!", "U redu").show();
                }
            }
        }
    }//GEN-LAST:event_takedwordssave_BActionPerformed

    private void bookdocslist_LIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookdocslist_LIMouseClicked
        ser = Books.loadFile(this.takedwordscontent_TA, this.countofwods_TF, this.countofwodsindictionary_TF, this.bookdocslist_LI, takedwordsname_TF);
    }//GEN-LAST:event_bookdocslist_LIMouseClicked

    private void registeradministratorconfig_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registeradministratorconfig_BActionPerformed
        if (this.realname_TF.getText().equals("")) {
            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti realname!", "U redu").show();
        } else {
            if (Books.validateWord(this.realname_TF.getText(), Books.getPattern("word"))) {
                if (this.surname_TF.getText().equals("")) {
                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti surname!", "U redu").show();
                } else {
                    if (Books.validateWord(this.surname_TF.getText(), Books.getPattern("word"))) {
                        if (this.purpose_TF.getText().equals("")) {
                            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti purpose!", "U redu").show();
                        } else {
                            if (Books.validateWord(this.purpose_TF.getText(), Books.getPattern("word"))) {
                                if (this.phone_TF.getText().equals("")) {
                                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti phone!", "U redu").show();
                                } else {
                                    if (Books.validateWord(this.phone_TF.getText(), Books.getPattern("number"))) {
                                        if (this.nickname_TF.getText().equals("")) {
                                            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti nickname!", "U redu").show();
                                        } else {
                                            if (Books.validateWord(this.nickname_TF.getText(), Books.getPattern("word"))) {
                                                if (this.email_TF.getText().equals("")) {
                                                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti email!", "U redu").show();
                                                } else {
                                                    if (Books.validateWord(this.email_TF.getText(), Books.getPattern("email"))) {
                                                        if (String.valueOf(this.password_TF.getPassword()).equals("")) {
                                                            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti password!", "U redu").show();
                                                        } else {
                                                            if (Books.validateWord(String.valueOf(this.password_TF.getPassword()), Books.getPattern("password"))) {
                                                                Administrators.createAdministrator(this.realname_TF, this.surname_TF, this.purpose_TF, this.phone_TF, this.nickname_TF, this.email_TF, this.password_TF);
                                                                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Administrator je uspešno registrovan!", "U redu").show();
                                                                GraphicInterfaceAdministrator.resetTextFields(this.realname_TF, this.surname_TF, this.purpose_TF, this.phone_TF, this.nickname_TF, this.email_TF, this.password_TF, null);
                                                            } else {
                                                                new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format password!", "U redu").show();
                                                            }
                                                        }
                                                    } else {
                                                        new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format email!", "U redu").show();
                                                    }
                                                }
                                            } else {
                                                new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format nickname!", "U redu").show();
                                            }
                                        }
                                    } else {
                                        new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format phone!", "U redu").show();
                                    }
                                }
                            } else {
                                new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format purpose!", "U redu").show();
                            }
                        }
                    } else {
                        new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format surname!", "U redu").show();
                    }
                }
            } else {
                new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format realname!", "U redu").show();
            }
        }
    }//GEN-LAST:event_registeradministratorconfig_BActionPerformed

    private void password_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.passwordr++, this.password_TF);
    }//GEN-LAST:event_password_TFKeyPressed

    private void password_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_password_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.passwordr++, this.password_TF);
    }//GEN-LAST:event_password_TFMouseClicked

    private void email_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_email_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.email++, this.email_TF);
    }//GEN-LAST:event_email_TFKeyPressed

    private void email_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_email_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.email++, this.email_TF);
    }//GEN-LAST:event_email_TFMouseClicked

    private void nickname_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nickname_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.nickname++, this.nickname_TF);
    }//GEN-LAST:event_nickname_TFKeyPressed

    private void nickname_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nickname_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.nickname++, this.nickname_TF);
    }//GEN-LAST:event_nickname_TFMouseClicked

    private void phone_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phone_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.phone++, this.phone_TF);
    }//GEN-LAST:event_phone_TFKeyPressed

    private void phone_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phone_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.phone++, this.phone_TF);
    }//GEN-LAST:event_phone_TFMouseClicked

    private void purpose_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purpose_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.purpose++, this.purpose_TF);
    }//GEN-LAST:event_purpose_TFKeyPressed

    private void purpose_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purpose_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.purpose++, this.purpose_TF);
    }//GEN-LAST:event_purpose_TFMouseClicked

    private void surname_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_surname_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.surname++, this.surname_TF);
    }//GEN-LAST:event_surname_TFKeyPressed

    private void surname_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_surname_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.surname++, this.surname_TF);
    }//GEN-LAST:event_surname_TFMouseClicked

    private void realname_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_realname_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.realname++, this.realname_TF);
    }//GEN-LAST:event_realname_TFKeyPressed

    private void realname_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_realname_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.realname++, this.realname_TF);
    }//GEN-LAST:event_realname_TFMouseClicked

    private void redo_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redo_LActionPerformed
        redo();
    }//GEN-LAST:event_redo_LActionPerformed

    private void removeeditedbook_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeeditedbook_BActionPerformed
        Printer.deleteData(this.editedbookdocs_CB.getSelectedItem().toString(), this.editedbookdocs_CB, this.editedbookcontent_TA, this.sizeofdocument_TF);
    }//GEN-LAST:event_removeeditedbook_BActionPerformed

    private void saveeditedbook_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveeditedbook_BActionPerformed
        if (this.editebookname_TF.equals("") || this.editebookname_TF.equals("Naziv")) {
            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno je uneti naziv!", "U redu").show();
        } else {
            if (this.editedbookcontent_TA.getText().length() != 0) {
                if (Books.validateWord(this.editebookname_TF.getText(), Books.getPattern("name"))) {
                    Printer.addData(this.editebookname_TF, String.valueOf(this.editedbookcontent_TA.getText().length()), this.editedbookcontent_TA, this.editedbookdocs_CB);
                    Printer.resetFields(editebookname_TF, sizeofdocument_TF, editedbookcontent_TA);
                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Uspešno ste sačuvali belešku!", "U redu").show();
                } else {
                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Nevažeći format imena!", "U redu").show();
                }
            } else {
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno je uneti sadržaj!", "U redu").show();
            }

        }
    }//GEN-LAST:event_saveeditedbook_BActionPerformed

    private void showeditedbook_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showeditedbook_BActionPerformed
        Printer.returnData(this.editedbookdocs_CB.getSelectedItem().toString(), this.sizeofdocument_TF, this.editedbookcontent_TA);
    }//GEN-LAST:event_showeditedbook_BActionPerformed

    private void editedbookdocs_CBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editedbookdocs_CBMousePressed
        if (this.notep == 0) {
            this.notep++;
            this.editedbookdocs_CB.removeItemAt(0);
        }
    }//GEN-LAST:event_editedbookdocs_CBMousePressed

    private void editebookname_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editebookname_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.ntext++, editebookname_TF);
    }//GEN-LAST:event_editebookname_TFKeyPressed

    private void editebookname_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editebookname_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.ntext++, this.editebookname_TF);
    }//GEN-LAST:event_editebookname_TFMouseClicked

    private void editedbookcontent_TACaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_editedbookcontent_TACaretUpdate
        this.sizeofdocument_TF.setText(String.valueOf(this.editedbookcontent_TA.getText().length()) + " karaktera");
        this.undo.push(this.editedbookcontent_TA.getText());
    }//GEN-LAST:event_editedbookcontent_TACaretUpdate

    private void undo_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undo_BActionPerformed
        undo();
    }//GEN-LAST:event_undo_BActionPerformed

    private void aconfig_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aconfig_BActionPerformed
        if (this.title_TF.getText().equals("")) {
            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti naslov!", "U redu").show();
        } else {
            if (Books.validateWord(this.title_TF.getText(), Books.getPattern("word"))) {
                if (this.subtitle_TF.getText().equals("")) {
                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti podnaslov!", "U redu").show();
                } else {
                    if (Books.validateWord(this.subtitle_TF.getText(), Books.getPattern("word"))) {
                        if (this.author_TF.getText().equals("")) {
                            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti autora!", "U redu").show();
                        } else {
                            if (Books.validateWord(this.author_TF.getText(), Books.getPattern("word"))) {
                                if (this.publisher_TF.getText().equals("")) {
                                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti izdavača!", "U redu").show();
                                } else {
                                    if (Books.validateWord(this.publisher_TF.getText(), Books.getPattern("word"))) {
                                        if (this.publishingdate_TF.getText().equals("")) {
                                            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti datum objavljivanja!", "U redu").show();
                                        } else {
                                            if (Books.validateWord(this.publishingdate_TF.getText(), Books.getPattern("number"))) {
                                                if (this.numberofpages_TF.getText().equals("")) {
                                                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti broj stranica!", "U redu").show();
                                                } else {
                                                    if (Books.validateWord(this.numberofpages_TF.getText(), Books.getPattern("number"))) {
                                                        if (this.genre_TF.getText().equals("")) {
                                                            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno uneti žanr!", "U redu").show();
                                                        } else {
                                                            if (Books.validateWord(this.genre_TF.getText(), Books.getPattern("word"))) {
                                                                if (this.relatedbooks_CB.getSelectedItem().toString() == "Povezane knjige") {
                                                                    new sistem.eb.login_registration.DialogMessage("Obaveštenje", "<html><p  style=\"line-height:85%;text-align:center;\">Neophodno izabrati stanje povezane</p><p style=\"line-height:85%;text-align:center;\"> knjige!</p></html>", "U redu").show();
                                                                } else {
                                                                    if (this.filechooser_FC.getSelectedFile() == null) {
                                                                        new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Neophodno izabrati datoteku!", "U redu").show();
                                                                    } else {
                                                                        Books.addBooks(this.title_TF.getText().trim(), this.subtitle_TF.getText().trim(), this.author_TF.getText().trim(), this.publisher_TF.getText().trim(), this.publishingdate_TF.getText().trim(), this.numberofpages_TF.getText().trim(), this.genre_TF.getText().trim(), (String) this.relatedbooks_CB.getSelectedItem(), this.filechooser_FC.getSelectedFile().getName(), this.filechooser_FC.getSelectedFile().getAbsolutePath());
                                                                        GraphicInterfaceAdministrator.resetTextFields(this.title_TF, this.subtitle_TF, this.author_TF, this.publisher_TF, this.publishingdate_TF, this.numberofpages_TF, this.genre_TF, this.relatedbooks_CB);
                                                                        new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Uspešno ste kreirali knjigu " + this.title_TF.getText() + "!", "U redu").show();
                                                                    }
                                                                }
                                                            } else {
                                                                new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format žanra!", "U redu").show();
                                                            }
                                                        }
                                                    } else {
                                                        new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format broja stranica!", "U redu").show();
                                                    }
                                                }
                                            } else {
                                                new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format datuma objavljivanja!", "U redu").show();
                                            }
                                        }
                                    } else {
                                        new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format izdavača!", "U redu").show();
                                    }
                                }
                            } else {
                                new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format autora!", "U redu").show();
                            }
                        }
                    } else {
                        new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format podnaslova!", "U redu").show();
                    }
                }
            } else {
                new sistem.eb.login_registration.DialogMessage("Greška", "Nevažeći format naslova!", "U redu").show();
            }
        }
    }//GEN-LAST:event_aconfig_BActionPerformed

    private void filechooser_FCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filechooser_FCActionPerformed
        if (evt.getActionCommand().equals(javax.swing.JFileChooser.APPROVE_OPTION)) {
            if (this.filechooser_FC.getSelectedFile().getName().equals("")) {
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Izaberite datoteku.", "U redu").show();
            } else {
                String name = this.filechooser_FC.getSelectedFile().getName();
                new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Usprešno ste izabrali " + name + ".", "U redu").show();
            }
        } else if (evt.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
            new sistem.eb.login_registration.DialogMessage("Obaveštenje", "Usprešno ste otkazali biranje datoteke.", "U redu").show();
        }
    }//GEN-LAST:event_filechooser_FCActionPerformed

    private void relatedbooks_CBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relatedbooks_CBMousePressed
        if (this.related == 0) {
            this.related++;
            this.relatedbooks_CB.removeItemAt(0);
        }
    }//GEN-LAST:event_relatedbooks_CBMousePressed

    private void numberofpages_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberofpages_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.numberPagesp++, this.numberofpages_TF);
    }//GEN-LAST:event_numberofpages_TFKeyPressed

    private void numberofpages_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numberofpages_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.numberPagesp++, this.numberofpages_TF);
    }//GEN-LAST:event_numberofpages_TFMouseClicked

    private void title_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_title_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.titlep++, this.title_TF);
    }//GEN-LAST:event_title_TFKeyPressed

    private void title_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_title_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.titlep++, this.title_TF);
    }//GEN-LAST:event_title_TFMouseClicked

    private void author_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_author_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.authorp++, this.author_TF);
    }//GEN-LAST:event_author_TFKeyPressed

    private void author_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_author_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.authorp++, this.author_TF);
    }//GEN-LAST:event_author_TFMouseClicked

    private void publisher_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_publisher_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.publisherp++, this.publisher_TF);
    }//GEN-LAST:event_publisher_TFKeyPressed

    private void publisher_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_publisher_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.publisherp++, this.publisher_TF);
    }//GEN-LAST:event_publisher_TFMouseClicked

    private void subtitle_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtitle_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.subtitlep++, this.subtitle_TF);
    }//GEN-LAST:event_subtitle_TFKeyPressed

    private void subtitle_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subtitle_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.subtitlep++, this.subtitle_TF);
    }//GEN-LAST:event_subtitle_TFMouseClicked

    private void publishingdate_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_publishingdate_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.publishingDatep++, this.publishingdate_TF);
    }//GEN-LAST:event_publishingdate_TFKeyPressed

    private void publishingdate_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_publishingdate_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.publishingDatep++, this.publishingdate_TF);
    }//GEN-LAST:event_publishingdate_TFMouseClicked

    private void genre_TFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_genre_TFKeyPressed
        GraphicInterfaceAdministrator.textHolderFunction(this.genrep++, this.genre_TF);
    }//GEN-LAST:event_genre_TFKeyPressed

    private void genre_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genre_TFMouseClicked
        GraphicInterfaceAdministrator.textHolderFunction(this.genrep++, this.genre_TF);
    }//GEN-LAST:event_genre_TFMouseClicked

    private void removebook_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebook_BActionPerformed
        Books.deleteBook(this.availablebook_T, this.bookdocs_T);
    }//GEN-LAST:event_removebook_BActionPerformed

    private void booksrefresh_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksrefresh_BActionPerformed
        {
            DefaultTableModel tableModel = (DefaultTableModel) this.bookdocs_T.getModel();
            tableModel.setRowCount(0);
        }
        DefaultTableModel tableModel = (DefaultTableModel) this.availablebook_T.getModel();
        tableModel.setRowCount(0);
        this.JTabbedPane1.setSelectedIndex(1);
        Books.updateTableBooks(this.availablebook_T);
    }//GEN-LAST:event_booksrefresh_BActionPerformed

    private void bookdocs_TMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookdocs_TMouseClicked
        this.bookdocs_T.setRowSelectionAllowed(true);
        int selectedRow = this.bookdocs_T.getSelectedRow();
        DefaultTableModel tableModel = (DefaultTableModel) this.bookdocs_T.getModel();
        String path = (String) tableModel.getValueAt(selectedRow, 1);

        File file = new File(path);
        Desktop des = Desktop.getDesktop();
        try {
            des.open(file);
        } catch (java.lang.IllegalArgumentException e) {
            new sistem.eb.login_registration.DialogMessage("Greška", "<html><p  style=\"line-height:85%;text-align:center;\">Datoteka ne postoji"
                    + " ili je putanja </p><p style=\"line-height:85%;text-align:center;\">pogrešna!</p></html>", "U redu").show();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookdocs_TMouseClicked

    private void availablebook_TMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availablebook_TMouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) this.bookdocs_T.getModel();
        tableModel.setRowCount(0);
        String id = (String) this.availablebook_T.getModel().getValueAt(this.availablebook_T.getSelectedRow(), 0);
        Books.getFilePathsToTable(bookdocs_T, (String) this.availablebook_T.getModel().getValueAt(this.availablebook_T.getSelectedRow(), 0));
    }//GEN-LAST:event_availablebook_TMouseClicked

    private void deletequestion_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletequestion_BActionPerformed
        EditQuiz.deleteQuizList(jList1);
    }//GEN-LAST:event_deletequestion_BActionPerformed

    private void answerone_RBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answerone_RBItemStateChanged
        if (answerone_RB.isSelected())
            GraphicInterfaceAdministrator.radiobuttonControler(this.answerone_TF, this.answertwo_TF, this.answerthree_TF, this.answerfour_TF, this.answerone_RB, this.answertwo_RB, this.answerthree_RB, this.answerfour_RB, this.corectanswer_L, this.quizbuttons_BG);
    }//GEN-LAST:event_answerone_RBItemStateChanged

    private void answertwo_RBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answertwo_RBItemStateChanged
        if (answertwo_RB.isSelected())
            GraphicInterfaceAdministrator.radiobuttonControler(this.answerone_TF, this.answertwo_TF, this.answerthree_TF, this.answerfour_TF, this.answerone_RB, this.answertwo_RB, this.answerthree_RB, this.answerfour_RB, this.corectanswer_L, this.quizbuttons_BG);
    }//GEN-LAST:event_answertwo_RBItemStateChanged

    private void answerthree_RBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answerthree_RBItemStateChanged
        if (answerthree_RB.isSelected())
            GraphicInterfaceAdministrator.radiobuttonControler(this.answerone_TF, this.answertwo_TF, this.answerthree_TF, this.answerfour_TF, this.answerone_RB, this.answertwo_RB, this.answerthree_RB, this.answerfour_RB, this.corectanswer_L, this.quizbuttons_BG);
    }//GEN-LAST:event_answerthree_RBItemStateChanged

    private void answerfour_RBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_answerfour_RBItemStateChanged
        if (answerfour_RB.isSelected())
            GraphicInterfaceAdministrator.radiobuttonControler(this.answerone_TF, this.answertwo_TF, this.answerthree_TF, this.answerfour_TF, this.answerone_RB, this.answertwo_RB, this.answerthree_RB, this.answerfour_RB, this.corectanswer_L, this.quizbuttons_BG);
    }//GEN-LAST:event_answerfour_RBItemStateChanged

    private void booksrefresh_B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksrefresh_B2ActionPerformed
        this.JTabbedPane1.setSelectedIndex(11);
        DefaultTableModel tableModel = (DefaultTableModel) this.quiz_T.getModel();
        tableModel.setRowCount(0);
        EditQuiz.updateTableQuizData(this.quiz_T);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_booksrefresh_B2ActionPerformed

    private void JTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTabbedPane1MouseClicked
        try {
            switch (JTabbedPane1.getSelectedIndex()) {
                case 0:
                    GraphicInterfaceAdministrator.buttonControler(this.blist, this.homepage_B);
                    GraphicInterfaceAdministrator.setHomePageLabels(this.apopupnuber_P, this.upopupnumber_L, this.adminpopupnumber_L, this.apopupmessage_L, this.upopupmessage_L, this.adminpopupmessage_L, this.io0_L, this.io1_L, this.quiz1_L1, this.quiz0_L1, this.quizwin_L);
                    this.JTabbedPane1.setSelectedIndex(0);
                    if (!(this.animationThread == null)) {
                        this.animationThread.stop();
                    }
                    break;
                case 1:
                    GraphicInterfaceAdministrator.buttonControler(this.blist, this.availablebooks_B);
                    Books.setBooksTable(availablebook_T, bookdocs_T);
                    this.JTabbedPane1.setSelectedIndex(1);
                    if (!(this.animationThread == null)) {
                        this.animationThread.stop();
                    }
                    break;
                case 2:
                    GraphicInterfaceAdministrator.buttonControler(this.blist, this.addbooks_B);
                    this.JTabbedPane1.setSelectedIndex(2);
                    Books.addRelatedBooks(this.relatedbooks_CB);
                    if (!(this.animationThread == null)) {
                        this.animationThread.stop();
                    }
                    break;
                case 3:
                    GraphicInterfaceAdministrator.buttonControler(this.blist, this.editbooks_B);
                    this.JTabbedPane1.setSelectedIndex(3);
                    Printer.updateComboBox(this.editedbookdocs_CB);
                    if (!(this.animationThread == null)) {
                        this.animationThread.stop();
                    }
                    break;
                case 4:
                    GraphicInterfaceAdministrator.buttonControler(this.blist, this.wordreader_B);
                    this.bookdocslist_LI.setListData(new String[0]);
                    Books.getAllFilesName(this.bookdocslist_LI);
                    this.JTabbedPane1.setSelectedIndex(4);
                    if (!(this.animationThread == null)) {
                        this.animationThread.stop();
                    }
                    break;
                case 5:
                    GraphicInterfaceAdministrator.buttonControler(this.blist, this.games_B);
                    this.JTabbedPane1.setSelectedIndex(5);
                    GraphicInterfaceAdministrator.setHomePageLabels(this.apopupnuber_P, this.upopupnumber_L, this.adminpopupnumber_L, this.apopupmessage_L, this.upopupmessage_L, this.adminpopupmessage_L, this.io0_L, this.io1_L, this.quiz1_L1, this.quiz0_L1, this.quizwin_L);
                    //Moving objects using jThread class and runnable interface
                    this.animationThread = new Thread(new Runnable() {
                        //Generate random numbers
                        Random ranX = new Random();
                        Random ranY = new Random();
                        Random r = new Random();

                        Color colourList[] = {Color.decode("#f1f1f1"), Color.decode("#e4e4e4"), Color.decode("#454545"), Color.decode("#4484bc")};

                        @Override
                        public void run() {
                            while (true) {
                                //Generate random x and y
                                int x = ranX.nextInt(MAX_X);
                                int y = ranY.nextInt(MAX_Y);
                                int i = r.nextInt(colourList.length);
                                g.setColor(colourList[i]);

                                g.fillRect(x, y, 40, 40); //draw squere
                                try {
                                    Thread.sleep(40);
                                    games_P.repaint();
                                    Thread.sleep(300);
                                } catch (Exception e) {
                                    new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
                                }
                            }
                        }
                    });
                    //Start the tread
                    this.animationThread.start();

                    break;
                case 6:
                    GraphicInterfaceAdministrator.buttonControler(this.blist, this.messages_B);
                    DefaultTableModel tableModel = (DefaultTableModel) this.messages_T.getModel();
                    tableModel.setRowCount(0);
                    Messages.updateTableMessages(messages_T);
                    this.JTabbedPane1.setSelectedIndex(6);
                    if (!(this.animationThread == null)) {
                        this.animationThread.stop();
                    }
                    break;
                case 7:
                    GraphicInterfaceAdministrator.buttonControler(this.blist, this.registeradministrator_B);
                    this.JTabbedPane1.setSelectedIndex(7);
                    if (!(this.animationThread == null)) {
                        this.animationThread.stop();
                    }
                    break;
                case 8:
                    GraphicInterfaceAdministrator.buttonControler(this.blist, this.users_B);
                    DefaultTableModel tableModelUsers = (DefaultTableModel) this.users_T.getModel();
                    tableModelUsers.setRowCount(0);
                    this.JTabbedPane1.setSelectedIndex(8);
                    Users.updateTableUsers(this.users_T);
                    if (!(this.animationThread == null)) {
                        this.animationThread.stop();
                    }
                    break;
                case 9:
                    GraphicInterfaceAdministrator.buttonControler(this.blist, this.administrators_B);
                    this.administrator_T.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    DefaultTableModel tableModelAdministrators = (DefaultTableModel) this.administrator_T.getModel();
                    tableModelAdministrators.setRowCount(0);
                    this.JTabbedPane1.setSelectedIndex(9);
                    Administrators.updateTableAdministrators(this.administrator_T);
                    if (!(this.animationThread == null)) {
                        this.animationThread = null;
                    }
                    break;
            }
        } catch (java.lang.NullPointerException e) {
            new sistem.eb.login_registration.DialogMessage("Greška", "Desila se neočekivana greška!", "U redu").show();
        }
    }//GEN-LAST:event_JTabbedPane1MouseClicked

    private void io2_L2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_io2_L2MouseClicked
        xo.setVisible(!xo.isVisible());
    }//GEN-LAST:event_io2_L2MouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        GraphicInterfaceAdministrator.setHomePageLabels(this.apopupnuber_P, this.upopupnumber_L, this.adminpopupnumber_L, this.apopupmessage_L, this.upopupmessage_L, this.adminpopupmessage_L, this.io0_L, this.io1_L, this.quiz1_L1, this.quiz0_L1, this.quizwin_L);
    }//GEN-LAST:event_formWindowGainedFocus

    private void quiz2_L1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quiz2_L1MouseClicked
        this.quiz.setVisible(!this.quiz.isVisible());
    }//GEN-LAST:event_quiz2_L1MouseClicked

    private void quiz0_L1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quiz0_L1MouseClicked
        quiz.setVisible(!this.quiz.isVisible());
    }//GEN-LAST:event_quiz0_L1MouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        GraphicInterfaceAdministrator.setHomePageLabels(this.apopupnuber_P, this.upopupnumber_L, this.adminpopupnumber_L, this.apopupmessage_L, this.upopupmessage_L, this.adminpopupmessage_L, this.io0_L, this.io1_L, this.quiz1_L1, this.quiz0_L1, this.quizwin_L);
    }//GEN-LAST:event_formFocusGained

    private void deleteadministrator_B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteadministrator_B1ActionPerformed
        EditQuiz.deleteQuizTable(this.quiz_T);
    }//GEN-LAST:event_deleteadministrator_B1ActionPerformed

    private void deleteadministrator_B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteadministrator_B2ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) this.quiz_T.getModel();
        tableModel.setRowCount(0);
        EditQuiz.updateTableQuizData(this.quiz_T);

    }//GEN-LAST:event_deleteadministrator_B2ActionPerformed

    private void question_TFCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_question_TFCaretUpdate
        question_TF.setPreferredSize(new java.awt.Dimension(64, 28));
    }//GEN-LAST:event_question_TFCaretUpdate

    private void statequiz_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statequiz_BActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) this.quizstate_T.getModel();
        tableModel.setRowCount(0);
        GraphicInterfaceAdministrator.updateQuizState(this.quizstate_T);
        this.JTabbedPane1.setSelectedIndex(13);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_statequiz_BActionPerformed

    private void stateio_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateio_BActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) this.io_T.getModel();
        tableModel.setRowCount(0);
        GraphicInterfaceAdministrator.updateIOState(this.io_T);
        this.JTabbedPane1.setSelectedIndex(12);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_stateio_BActionPerformed

    private void removeeditedbook_B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeeditedbook_B1ActionPerformed
        this.JTabbedPane1.setSelectedIndex(14);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_removeeditedbook_B1ActionPerformed

    private void capitalized_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capitalized_BActionPerformed
        if (this.caseflag) {
            this.jTextArea1.setText(TextEditor.toLowerCase(jTextArea1.getText()));
        }
        jTextArea1.setText(TextEditor.toCapitalizeCase(jTextArea1.getText()));
    }//GEN-LAST:event_capitalized_BActionPerformed

    private void alternating_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternating_BActionPerformed
        if (this.caseflag) {
            this.jTextArea1.setText(TextEditor.toLowerCase(jTextArea1.getText()));
        }
        jTextArea1.setText(TextEditor.toAlternatecase(jTextArea1.getText()));
    }//GEN-LAST:event_alternating_BActionPerformed

    private void lower_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lower_BActionPerformed
        jTextArea1.setText(TextEditor.toLowerCase(jTextArea1.getText()));
    }//GEN-LAST:event_lower_BActionPerformed

    private void upper_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upper_BActionPerformed
        this.caseflag = true;
        jTextArea1.setText(TextEditor.toUpperCase(jTextArea1.getText()));
    }//GEN-LAST:event_upper_BActionPerformed

    private void wide_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wide_BActionPerformed
        jTextArea1.setText(TextEditor.toWideCase(jTextArea1.getText(), 1, " "));
    }//GEN-LAST:event_wide_BActionPerformed

    private void sentance_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sentance_BActionPerformed
        if (this.caseflag) {
            this.jTextArea1.setText(TextEditor.toLowerCase(jTextArea1.getText()));
        }
        this.jTextArea1.setText(TextEditor.toSentanceCase(jTextArea1.getText()));

    }//GEN-LAST:event_sentance_BActionPerformed

    private void inverse_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inverse_BActionPerformed
        this.jTextArea1.setText(TextEditor.toInverseCase(jTextArea1.getText()));
    }//GEN-LAST:event_inverse_BActionPerformed

    private void title_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title_BActionPerformed
        if (this.caseflag) {
            this.jTextArea1.setText(TextEditor.toLowerCase(jTextArea1.getText()));
        }
        jTextArea1.setText(TextEditor.toTitleCase(jTextArea1.getText()));
    }//GEN-LAST:event_title_BActionPerformed

    private void morse_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_morse_BActionPerformed
        jTextArea1.setText(TextEditor.toMorseCode(jTextArea1.getText()));
        textCode = 'm';
    }//GEN-LAST:event_morse_BActionPerformed

    private void reverse_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reverse_BActionPerformed
        jTextArea1.setText(TextEditor.toReverseCase(jTextArea1.getText()));
    }//GEN-LAST:event_reverse_BActionPerformed

    private void hex_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hex_BActionPerformed
        try {
            jTextArea1.setText(TextEditor.toHex(jTextArea1.getText()));
            textCode = 'h';
        } catch (UnsupportedEncodingException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška", "<html><p  style=\"line-height:85%;text-align:center;\">Nemoguće izvršiti konverziju u </p><p style=\"line-height:85%;text-align:center;\">heksadecimalni sistem!</p></html>", "U redu").show();
        }
    }//GEN-LAST:event_hex_BActionPerformed

    private void binary_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binary_BActionPerformed
        jTextArea1.setText(TextEditor.toWideCase(TextEditor.toBinary(jTextArea1.getText()), 4, " "));
        textCode = 'b';
    }//GEN-LAST:event_binary_BActionPerformed

    private void octal_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_octal_BActionPerformed
        jTextArea1.setText(TextEditor.toOctal(jTextArea1.getText()));
        textCode = 'o';
    }//GEN-LAST:event_octal_BActionPerformed

    private void sentance_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sentance_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.sentance_B);
    }//GEN-LAST:event_sentance_BMouseClicked

    private void lower_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lower_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.lower_B);
    }//GEN-LAST:event_lower_BMouseClicked

    private void upper_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upper_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.upper_B);
    }//GEN-LAST:event_upper_BMouseClicked

    private void capitalized_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capitalized_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.capitalized_B);
    }//GEN-LAST:event_capitalized_BMouseClicked

    private void alternating_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alternating_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.alternating_B);
    }//GEN-LAST:event_alternating_BMouseClicked

    private void title_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_title_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.title_B);
    }//GEN-LAST:event_title_BMouseClicked

    private void inverse_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inverse_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.inverse_B);
    }//GEN-LAST:event_inverse_BMouseClicked

    private void wide_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wide_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.wide_B);
    }//GEN-LAST:event_wide_BMouseClicked

    private void reverse_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reverse_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.reverse_B);
    }//GEN-LAST:event_reverse_BMouseClicked

    private void morse_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_morse_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.morse_B);
    }//GEN-LAST:event_morse_BMouseClicked

    private void binary_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_binary_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.binary_B);
    }//GEN-LAST:event_binary_BMouseClicked

    private void octal_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_octal_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.octal_B);
    }//GEN-LAST:event_octal_BMouseClicked

    private void hex_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hex_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.hex_B);
    }//GEN-LAST:event_hex_BMouseClicked

    private void proper_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proper_BMouseClicked
        GraphicInterfaceAdministrator.buttonControlerEditor(this.editor, this.proper_B);
    }//GEN-LAST:event_proper_BMouseClicked

    private void proper_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proper_BActionPerformed
        if (this.caseflag) {
            this.jTextArea1.setText(TextEditor.toLowerCase(jTextArea1.getText()));
        }
        this.jTextArea1.setText(TextEditor.toProperCase(jTextArea1.getText()));
    }//GEN-LAST:event_proper_BActionPerformed

    private void title_B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_title_B1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_title_B1MouseClicked

    private void title_B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title_B1ActionPerformed
        try {
            switch (this.textCode) {
                case 'm': {
                    jTextArea1.setText(TextEditor.toTextMorse(jTextArea1.getText()));
                    break;
                }
                case 'b': {
                    jTextArea1.setText(TextEditor.toTextBinary(jTextArea1.getText()));
                    break;
                }
                case 'o': {
                    jTextArea1.setText(TextEditor.toTextOctal(jTextArea1.getText()));
                    break;
                }
                case 'h': {
                    jTextArea1.setText(TextEditor.toTextHex(jTextArea1.getText()));
                    break;
                }
            }
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            new sistem.eb.login_registration.DialogMessage("Greška", "<html><p  style=\"line-height:85%;text-align:center;\">Nemoguće pretvoriti u tekst zbog"
                    + "</p><p style=\"line-height:85%;text-align:center;\">koruptiranog sadržaja!</p></html>", "U redu").show();
        } catch (Exception e) {
            new sistem.eb.login_registration.DialogMessage("Greška", "<html><p  style=\"line-height:85%;text-align:center;\">Nemoguće pretvoriti u tekst zbog"
                    + "</p><p style=\"line-height:85%;text-align:center;\">koruptiranog sadržaja!</p></html>", "U redu").show();
        }
    }//GEN-LAST:event_title_B1ActionPerformed

    private void messages_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messages_BActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) this.messages_T.getModel();
        tableModel.setRowCount(0);
        Messages.updateTableMessages(messages_T);
        this.JTabbedPane1.setSelectedIndex(6);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_messages_BActionPerformed

    private void messages_BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messages_BMouseClicked
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.messages_B);
    }//GEN-LAST:event_messages_BMouseClicked

    private void messages_TMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messages_TMouseClicked
        Messages.updateTextPane(jTextPane1);
    }//GEN-LAST:event_messages_TMouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        this.JTabbedPane1.setSelectedIndex(0);
        if (!(this.animationThread == null)) {
            this.animationThread.stop();
        }
        GraphicInterfaceAdministrator.setHomePageLabels(this.apopupnuber_P, this.upopupnumber_L, this.adminpopupnumber_L, this.apopupmessage_L, this.upopupmessage_L, this.adminpopupmessage_L, this.io0_L, this.io1_L, this.quiz1_L1, this.quiz0_L1, this.quizwin_L);
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.homepage_B);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        GraphicInterfaceAdministrator.setHomePageLabels(this.apopupnuber_P, this.upopupnumber_L, this.adminpopupnumber_L, this.apopupmessage_L, this.upopupmessage_L, this.adminpopupmessage_L, this.io0_L, this.io1_L, this.quiz1_L1, this.quiz0_L1, this.quizwin_L);
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.homepage_B);
        this.JTabbedPane1.setSelectedIndex(0);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        GraphicInterfaceAdministrator.setHomePageLabels(this.apopupnuber_P, this.upopupnumber_L, this.adminpopupnumber_L, this.apopupmessage_L, this.upopupmessage_L, this.adminpopupmessage_L, this.io0_L, this.io1_L, this.quiz1_L1, this.quiz0_L1, this.quizwin_L);
        GraphicInterfaceAdministrator.buttonControler(this.blist, this.homepage_B);
        this.JTabbedPane1.setSelectedIndex(0);
        if (!(this.animationThread == null))
            this.animationThread.stop();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.dispose();
        new sistem.eb.login_registration.LoginAdministratorForm().show();
    }//GEN-LAST:event_jLabel7MouseClicked

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new InterfaceAdministrator(loggedInAdministrator).setVisible(true);
                }
            });

        } catch (UnsupportedLookAndFeelException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće primjeniti podrazumijevani stil!", "U redu");
        }
    }

    public static int getCountRows(String table) {
        int count = 0;
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection(sistem.eb.interfaces.InterfaceAdministrator.PATH_DATABASE);
            java.sql.Statement s = con.createStatement();
            java.sql.ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM " + table);
            r.next();
            count = r.getInt("rowcount");

            r.close();
            s.close();
            con.close();

        } catch (SQLException ex) {
            new sistem.eb.login_registration.DialogMessage("Greška!", "Nemoguće uspostaviti vezu sa bazom!", "U redu");
        }
        return count;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel IOpopup_P;
    private javax.swing.JTabbedPane JTabbedPane1;
    private javax.swing.JButton aconfig_B;
    private javax.swing.JPanel addbook_P;
    private javax.swing.JButton addbooks_B;
    private javax.swing.JTable administrator_T;
    private javax.swing.JButton administratorrefresh_B;
    private javax.swing.JButton administrators_B;
    private javax.swing.JPanel administrators_P;
    private javax.swing.JPanel administratorspopup_P;
    private javax.swing.JLabel adminpopupmessage_L;
    private javax.swing.JLabel adminpopupnumber_L;
    private javax.swing.JLabel adminpopuptitle_L;
    private javax.swing.JPanel adminpopuptitlebar_P;
    private javax.swing.JButton alternating_B;
    private javax.swing.JLabel answerfour_L;
    private javax.swing.JRadioButton answerfour_RB;
    private javax.swing.JTextField answerfour_TF;
    private javax.swing.JLabel answerone_L;
    private javax.swing.JRadioButton answerone_RB;
    private javax.swing.JTextField answerone_TF;
    private javax.swing.JLabel answerthree_L;
    private javax.swing.JRadioButton answerthree_RB;
    private javax.swing.JTextField answerthree_TF;
    private javax.swing.JLabel answertwo_L;
    private javax.swing.JRadioButton answertwo_RB;
    private javax.swing.JTextField answertwo_TF;
    private javax.swing.JLabel apopupmessage_L;
    private javax.swing.JLabel apopupnuber_P;
    private javax.swing.JLabel apopuptitle_L;
    private javax.swing.JPanel apopuptitlebar_P;
    private javax.swing.JLabel author_L;
    private javax.swing.JTextField author_TF;
    private javax.swing.JPanel availablebook_P;
    private javax.swing.JTable availablebook_T;
    private javax.swing.JButton availablebooks_B;
    private javax.swing.JPanel availablepopup_P;
    private javax.swing.JButton binary_B;
    private javax.swing.JTable bookdocs_T;
    private javax.swing.JList<String> bookdocslist_LI;
    private javax.swing.JButton booksrefresh_B;
    private javax.swing.JButton booksrefresh_B1;
    private javax.swing.JButton booksrefresh_B2;
    private javax.swing.JButton capitalized_B;
    private javax.swing.JLabel clock_L;
    private javax.swing.JButton configquiz_B;
    private javax.swing.JLabel corectanswer_L;
    private javax.swing.JLabel countofwods_L;
    private javax.swing.JTextField countofwods_TF;
    private javax.swing.JLabel countofwodsindictionary_L;
    private javax.swing.JTextField countofwodsindictionary_TF;
    private javax.swing.JButton deleteadministrator_B;
    private javax.swing.JButton deleteadministrator_B1;
    private javax.swing.JButton deleteadministrator_B2;
    private javax.swing.JButton deletequestion_B;
    private javax.swing.JButton deleteuser_B;
    private javax.swing.JPanel editbook_P;
    private javax.swing.JButton editbooks_B;
    private javax.swing.JTextField editebookname_TF;
    private javax.swing.JTextArea editedbookcontent_TA;
    private javax.swing.JComboBox<String> editedbookdocs_CB;
    private javax.swing.JLabel editedbookdocs_L;
    private javax.swing.JPanel editquestions_P;
    private javax.swing.JLabel email_L;
    protected javax.swing.JTextField email_TF;
    private javax.swing.JFileChooser filechooser_FC;
    private javax.swing.JButton games_B;
    private javax.swing.JPanel games_P;
    private javax.swing.JLabel genre_L;
    private javax.swing.JTextField genre_TF;
    private javax.swing.JButton hex_B;
    private javax.swing.JButton homepage_B;
    private javax.swing.JPanel homepage_P;
    private javax.swing.JButton inverse_B;
    private javax.swing.JLabel io0_L;
    private javax.swing.JLabel io1_L;
    private javax.swing.JLabel io2_L2;
    private javax.swing.JTable io_T;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lastID_L;
    private javax.swing.JTextField lastID_TF;
    private javax.swing.JButton lower_B;
    private javax.swing.JButton messages_B;
    private javax.swing.JTable messages_T;
    private javax.swing.JButton morse_B;
    private javax.swing.JLabel nickname_L;
    protected javax.swing.JTextField nickname_TF;
    private javax.swing.JLabel numberofpages_L;
    private javax.swing.JTextField numberofpages_TF;
    private javax.swing.JButton octal_B;
    private javax.swing.JLabel password_L;
    protected javax.swing.JPasswordField password_TF;
    private javax.swing.JLabel phone_L;
    protected javax.swing.JTextField phone_TF;
    private javax.swing.JButton proper_B;
    private javax.swing.JLabel publisher_L;
    private javax.swing.JTextField publisher_TF;
    private javax.swing.JLabel publishingdate_L;
    private javax.swing.JTextField publishingdate_TF;
    private javax.swing.JLabel purpose_L;
    protected javax.swing.JTextField purpose_TF;
    private javax.swing.JLabel question_L;
    private javax.swing.JTextField question_TF;
    private javax.swing.JLabel quiz0_L1;
    private javax.swing.JLabel quiz1_L1;
    private javax.swing.JLabel quiz2_L1;
    private javax.swing.JTable quiz_T;
    private javax.swing.ButtonGroup quizbuttons_BG;
    private javax.swing.JPanel quizpopup_P;
    private javax.swing.JTable quizstate_T;
    private javax.swing.JLabel quizwin_L;
    private javax.swing.JLabel realname_L;
    protected javax.swing.JTextField realname_TF;
    private javax.swing.JButton redo_L;
    private javax.swing.JButton registeradministrator_B;
    private javax.swing.JPanel registeradministrator_P;
    private javax.swing.JButton registeradministratorconfig_B;
    private javax.swing.JComboBox<String> relatedbooks_CB;
    private javax.swing.JLabel relatedbooks_L;
    private javax.swing.JButton removebook_B;
    private javax.swing.JButton removeeditedbook_B;
    private javax.swing.JButton removeeditedbook_B1;
    private javax.swing.JButton reverse_B;
    private javax.swing.JButton saveeditedbook_B;
    private javax.swing.JButton sentance_B;
    private javax.swing.JButton showeditedbook_B;
    private javax.swing.JPanel sidebar_P;
    private javax.swing.JTextField sizeofdocument_TF;
    private javax.swing.JButton stateio_B;
    private javax.swing.JButton statequiz_B;
    private javax.swing.JLabel subtitle_L;
    private javax.swing.JTextField subtitle_TF;
    private javax.swing.JLabel surname_L;
    protected javax.swing.JTextField surname_TF;
    private javax.swing.JLabel takedwords_L;
    private javax.swing.JTextArea takedwordscontent_TA;
    private javax.swing.JTextField takedwordsname_TF;
    private javax.swing.JButton takedwordssave_B;
    private javax.swing.JButton title_B;
    private javax.swing.JButton title_B1;
    private javax.swing.JLabel title_L;
    private javax.swing.JTextField title_TF;
    private javax.swing.JPanel titlebar_P;
    private javax.swing.JButton undo_B;
    private javax.swing.JLabel upopupmessage_L;
    private javax.swing.JLabel upopupnumber_L;
    private javax.swing.JPanel upopuptitlebar_P;
    private javax.swing.JButton upper_B;
    private javax.swing.JLabel useremail_L;
    private javax.swing.JLabel username_L;
    private javax.swing.JButton users_B;
    private javax.swing.JPanel users_P;
    private javax.swing.JTable users_T;
    private javax.swing.JPanel userspopup_P;
    private javax.swing.JButton usersrefresh_B;
    private javax.swing.JButton wide_B;
    private javax.swing.JButton wordreader_B;
    // End of variables declaration//GEN-END:variables
 
    @Override
    public void undo() {
        if (!this.undo.empty()) {
            this.redo.push(this.undo.pop());
            if (!this.undo.empty()) {
                this.editedbookcontent_TA.setText(this.undo.peek());
            }
        }
    }

    @Override
    public void redo() {
        if (!this.redo.empty()) {
            this.undo.push(this.redo.pop());
            if (!this.redo.empty()) {
                this.editedbookcontent_TA.setText(this.redo.peek());
            }
        }
    }

}
