import javax.swing.*;
import java.awt.*;

public class Toolbar {
    JToolBar toolBar;
    JButton buttonConfig;

    public Toolbar (){

        toolBar = new JToolBar();

        buttonConfig = new JButton("Configuration");
        toolBar.add(buttonConfig);

    }
}
