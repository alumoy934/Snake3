import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Configuration extends JDialog{

    private JPanel mainPanel;
    private JTextField textFieldUsername;
    private JButton buttonEasy;
    private JButton buttonMedium;
    private JButton buttonHard;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel labelusername;
    private JLabel labelLevel;
    private Board board;



    public Configuration(Board board , JFrame frame){

        super(frame, "Configuration", true);
        this.board = board;

        setResizable(false);
        setTitle("Configuration Details");
        setBounds(300, 300, 350, 150);
        setLocationRelativeTo(null);

        //Panel principal
        mainPanel = new JPanel(new BorderLayout(15,15));


        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        createWestPanel();
        createCenterPanel();
        createSouthPanel();


    }

    private void createSouthPanel() {
        JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonOK = new JButton("Ok");
        buttonCancel = new JButton("Cancel");

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatesConfig.username = textFieldUsername.getText();
                board.initGame();
                dispose();

            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               System.exit(0);

            }
        });

        lowerPanel.add(buttonOK);
        lowerPanel.add(buttonCancel);

        add(lowerPanel,BorderLayout.SOUTH);
    }



    private void createCenterPanel() {
        buttonEasy = new JButton("Easy");
        buttonMedium = new JButton("Medium");
        buttonHard = new JButton("Hard");

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        buttonEasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() == "Easy"){
                    DatesConfig.setDELTA(1);


                }
            }
        });

        buttonMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() == "Medium"){
                    DatesConfig.setDELTA(2);


                }
            }
        });

        buttonHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() == "Hard"){
                    DatesConfig.setDELTA(3);


                }
            }
        });

        centerPanel.add(buttonEasy);
        centerPanel.add(buttonMedium);
        centerPanel.add(buttonHard);

        add(centerPanel, BorderLayout.CENTER);
    }

    private void createWestPanel() {
        labelLevel = new JLabel("Choose level");
        add(labelLevel, BorderLayout.WEST);
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelusername = new JLabel("Enter username");
        topPanel.add(labelusername);
        textFieldUsername = new JTextField(15);
        topPanel.add(textFieldUsername);

        textFieldUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatesConfig.username = e.getActionCommand();

            }
        });
        return topPanel;

    }



}
