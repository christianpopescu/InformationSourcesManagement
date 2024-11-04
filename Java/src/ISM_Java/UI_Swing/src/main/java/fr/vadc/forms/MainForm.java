package fr.vadc.forms;
import java.awt.event.*;
import javax.swing.*;

public class MainForm extends JFrame
{
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
public MainForm()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        addWindowListener(new WindowAdapter( ) {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        label.setText("Information Source Management");
        panel.add(label);
        add(panel);
    }
}
