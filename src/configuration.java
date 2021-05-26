import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class configuration extends JDialog{

    private JPanel mainPanel;
    private JTextField textFieldUsername;
    private JButton buttonEasy;
    private JButton buttonMedium;
    private JButton buttonHard;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel labelusername;
    private JLabel labelLevel;


    public configuration(){

        mainPanel = new JPanel(new BorderLayout(15,15));
        setSize(300, 300);
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelusername = new JLabel("Enter username");
        topPanel.add(labelusername);

        textFieldUsername = new JTextField(15);
        topPanel.add(textFieldUsername);

        add(topPanel, BorderLayout.NORTH);

        labelLevel = new JLabel("Choose level");
        add(labelLevel, BorderLayout.WEST);
        ;


    }
}
