/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multimedia.pkg1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author shath
 */
public class Animation1 extends JPanel {

    private BufferedImage photo1;
    private BufferedImage photo2;
    private Image newImage1;
    private Image newImage2;
    private int image_height;
    private int image_width;
    private int yPos =  0;
    private int yPos1;
    private int direction = 1;

    public Animation1() {
        try {

            photo1 = ImageIO.read(new File("photo1.jpeg"));

            photo2 = ImageIO.read(new File("photo2.jpeg"));
            newImage1 = photo1.getScaledInstance(533, 300, Image.SCALE_DEFAULT);
            newImage2 = photo2.getScaledInstance(533, 300, Image.SCALE_DEFAULT);
            image_height = 300;
            image_width = 533;

            System.out.println("wwwwwwwwwwwwww" + getWidth());
            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    yPos += direction;
                    if (yPos + image_height > getHeight()) {

                        yPos = getHeight() - image_height;
                        //  System.out.println("dddddddddddddddddddddddddddddddddH"+ getHeight());
                        direction *= +1;
                    } else if (yPos < 0) {
                        yPos = 0;
                        direction *= +1;
                    }
                    yPos1 =yPos + 1 ;
                    System.out.println("RRRRRR" + yPos);
                    System.out.println("RRRRRR1111111" + yPos1);
                    System.out.println("wwwwwwwwwwwwww" + getWidth());

                    repaint();
                }

            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return newImage1 == null ? super.getPreferredSize() : new Dimension(image_height * 2, image_width * 2);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = getWidth() - image_width;
        int x1 = getWidth() - image_width ;
         

        if (yPos1 > 0 && yPos1 < 300 ) { // to make steady photo2   // work perfect
            g.drawImage(newImage2, x1, 300, this);
        }   
        
         if (yPos < 300 ) { // photo 1 come down then get steady // work perfect
       //     Graphics g1 = combined.getGraphics();
          //  g.drawImage(newImage2, x1, yPos1, this);
            g.drawImage(newImage1, x, yPos, this) ;

        }else if (yPos >= 300) {  // to make steady picture  // work perfect
            g.drawImage(newImage1, x, 300, this);
       // continue ;
        }
       
        
         // photo2 must go down.
         
   
    }

}
