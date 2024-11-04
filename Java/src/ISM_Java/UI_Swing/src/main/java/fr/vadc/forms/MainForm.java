package fr.vadc.forms;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainForm extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;

    public MainForm() {
        intialize();
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    protected void intialize()
    {
        JPanel panel;
        JLabel label = new JLabel();
        label.setText("Information Source Management");
        panel = new JPanel();
        panel.add(label);
        add(panel);
        JMenu mainMenu = new JMenu("Main Menu");
        JMenu firstSubMenu = new JMenu("First Sub Menu");
        JMenuItem miShowImage = new JMenuItem("Show Image");
        firstSubMenu.add(miShowImage);
        mainMenu.add(miShowImage);
        add(mainMenu);
        JMenuBar mb=new JMenuBar();
        mb.add(mainMenu);
        setJMenuBar(mb);

    }
}
