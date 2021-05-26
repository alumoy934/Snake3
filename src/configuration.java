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


    public configuration() {
        buttonEasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
