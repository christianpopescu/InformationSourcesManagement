package fr.vadc.forms;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class MainForm extends JFrame implements ActionListener {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;
    private JMenuItem miShowImage;
    JMenu mainMenu;
    JMenu firstSubMenu;

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

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == this.miShowImage) {
            showMessageDialog(null, "ShowImage menuitem selected");
        } else {
            showMessageDialog(null, ev.getSource().getClass().getName());
        }
    }

    protected void intialize()    {
        JPanel panel;
        JLabel label = new JLabel();
        label.setText("Information Source Management");
        panel = new JPanel();
        panel.add(label);
        add(panel);
        mainMenu = new JMenu("Main Menu");
        firstSubMenu = new JMenu("First Sub Menu");
        miShowImage = new JMenuItem("Show Image");
        miShowImage.addActionListener(this);
        firstSubMenu.add(miShowImage);
        mainMenu.add(miShowImage);
        add(mainMenu);
        JMenuBar mb=new JMenuBar();
        mb.add(mainMenu);
        setJMenuBar(mb);

    }
}
