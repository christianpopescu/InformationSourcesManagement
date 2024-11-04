package fr.vadc;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import fr.vadc.forms.MainForm;

/**
 * Call Swing Main Window
 */
public class App {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            var frame = new MainForm();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
