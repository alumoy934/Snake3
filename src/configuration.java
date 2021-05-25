import javax.swing.*;
import java.awt.*;

public class configuration extends JDialog{
    private JPanel panel1;
    private JTextField username;
    private JButton buttoneasy;
    private JButton buttonmedium;
    private JButton buttonhard;
    private JLabel labelusername;
    private JLabel level;

    public configuration (){


       panel1 = new JPanel();

       labelusername = new JLabel("Enter your username");
       panel1.add(labelusername);

       username = new JTextField();
       username.setColumns(15);
       panel1.add(username);

       level = new JLabel("Choose level");
       panel1.add(level);

       buttoneasy = new JButton("Easy");
       panel1.add(buttoneasy);
       buttonmedium = new JButton("Medium");
       panel1.add(buttonmedium);
       buttonhard = new JButton("Hard");
       panel1.add(buttonhard);

       add(panel1);

       setModalityType(ModalityType.APPLICATION_MODAL);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setSize(250, 150);

       setLocationRelativeTo(null);

    }
}
