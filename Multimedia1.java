/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multimedia.pkg1;

/**
 *
 * @author shath
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.prefs.Preferences;
import javax.imageio.ImageIO;
import javax.tools.Tool;

public class Multimedia1 extends JFrame implements ActionListener, ItemListener {

    private BufferedImage photo2;
    private Image newImage2;

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // scene #1
    private static class MainRunnable implements Runnable {

        @Override
        public void run() {

            JButton Button1 = new JButton("Go to the image!!!");
            Button1.addActionListener(new ChangeContentPaneListener());
            JPanel frameContents = new JPanel();
            Button1.setFont(new Font("Arial", Font.PLAIN, 28));
            frameContents.setLayout(null);
            Button1.setBounds(100, 120, 300, 100);
            Button1.setBackground(Color.ORANGE);
           
              frameContents.add(Button1);
    
            //     frameContents.add(label1);
            //   frameContents.setBackground(Color.CYAN);
            //    frameContents.setBackground(Color);
            JFrame frame = new JFrame("Multimedia Homework#1");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(frameContents);
            frame.pack();

            //  frame.setLocationRelativeTo(null);  
            frame.setSize(500, 500);
            frame.setVisible(true);
        }

    }
    // scene #2

    private static class ChangeContentPaneListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {

            JPanel newFrameContents = new JPanel();

            newFrameContents.add(new Animation1());

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((JButton) e.getSource());
            frame.setSize(500, 500);

            frame.setContentPane(newFrameContents);
            frame.revalidate();
            frame.setLocationRelativeTo(null); // frame in the center of the screen.
            frame.repaint();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new MainRunnable()); //Swing code must always be used in the Event Dispatch Thread.

    }
}

 