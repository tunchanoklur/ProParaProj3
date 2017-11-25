/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proparaproj3;

/**
 *
 * @author po-pe
 */

import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import javax.swing.*;
import java.util.Random;
public class character extends JFrame {
 
	private JLabel          contentpane;
	private Mycharacter     show_char;
	private int frameWidth = 2000, frameHeight = 1000;

	public character()
	{
            super("Show char");
            JRadioButton ra0 = new JRadioButton ("Cheshire");
       JRadioButton ra1 = new JRadioButton( "Jasmine");
       JRadioButton ra2 = new JRadioButton( "Ariel");
       JRadioButton ra3 = new JRadioButton( "Donald Duck");
       JRadioButton ra4 = new JRadioButton( "Chip Dale");
       JRadioButton ra5 = new JRadioButton( "Pinocchio");
       JRadioButton ra6 = new JRadioButton( "Judy Hops");
       JRadioButton ra7 = new JRadioButton( "Tazans");
       
       ra0.setBounds(-600,-250,frameWidth,frameHeight);
       ra1.setBounds(-90,-250,frameWidth,frameHeight);
       ra2.setBounds(300,-200,frameWidth,frameHeight);
       ra3.setBounds(600,-200,frameWidth,frameHeight);
       ra4.setBounds(-600,150,frameWidth,frameHeight);
       ra5.setBounds(-90,150,frameWidth,frameHeight);
       ra6.setBounds(300,150,frameWidth,frameHeight);
       ra7.setBounds(600,150,frameWidth,frameHeight);
       
       
        JLabel [] open_file = new JLabel[8];
		open_file[0]   = new JLabel(new MyImageIcon("char_cheshire.png"));
                open_file[0].setBounds(-600,-200,frameWidth,frameHeight);
                
                open_file[1]   = new JLabel( new MyImageIcon("char_jusmine.png"));
                open_file[1].setBounds(-90,-200,frameWidth,frameHeight);
		
                open_file[2]   = new JLabel(new MyImageIcon("char_arial.png"));
                open_file[2].setBounds(300,-200,frameWidth,frameHeight);
                
                open_file[3]   = new JLabel(new MyImageIcon("char_donaldduck.png"));
                open_file[3].setBounds(600,-200,frameWidth,frameHeight);
                /////////2nd row/////////
                
                open_file[4]   = new JLabel(new MyImageIcon("char_chipdale.png"));
                open_file[4].setBounds(-600,150,frameWidth,frameHeight);
                
                open_file[5]   = new JLabel(new MyImageIcon("char_pinoc.png"));
                open_file[5].setBounds(-90,150,frameWidth,frameHeight);
                
                open_file[6] = new JLabel(new MyImageIcon("hops.png"));
                open_file[6].setBounds(300,150,frameWidth,frameHeight);
                
                open_file[7] = new JLabel(new MyImageIcon("tazan_1.png"));
                open_file[7].setBounds(600,150,frameWidth,frameHeight);
                
                
       
                for(int i=0; i<8;i++)
                {
                    add(open_file[i]);
                }
		setTitle("Chose player's character");
		setBounds(50, 50, frameWidth, frameHeight);
		setVisible(true);
		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

		// set background image by using JLabel as contentpane
		// Set layout to null because we'll move the label manually
		setContentPane(contentpane = new JLabel());
		MyImageIcon background = new MyImageIcon("char_selected_wall.png");
		contentpane.setIcon( background.resize(contentpane.getWidth(),
			                                   contentpane.getHeight()) );

                    getContentPane().add(ra0);
                    getContentPane().add(ra1);
                    getContentPane().add(ra2);
                    getContentPane().add(ra3);
                    getContentPane().add(ra4);
                    getContentPane().add(ra5);
                    getContentPane().add(ra6);
                    getContentPane().add(ra7);
            
		repaint(); //validate
	}
	public static void main(String[] args) 
	{
		new character(); 
             //new level();
            //new charac();
	}	
}
class Mycharacter extends JLabel implements KeyListener, MouseListener
{
        private int curX  = 250, curY   = 300; //location of X , Y
	private int width = 300, height = 300;
	private MyImageIcon pinoc, donal,cat,chip,jasmin,ariel;
	//private boolean set=true;
        
	public Mycharacter()				
	{ 
            
               
            
                
        }
        public void mouseClicked(MouseEvent e) { 
         
		}
        
        
        public void keyReleased(KeyEvent e){}
        public void mousePressed( MouseEvent e )	{ }
	public void mouseReleased( MouseEvent e )	{ }
	public void mouseEntered( MouseEvent e )	{ }	
	public void mouseExited( MouseEvent e )		{ }
	public void mouseMoved( MouseEvent e )		{ }//in MouseMotionListener 
        public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent ke) { }
           
}



class MyImageIcon extends ImageIcon
{
	public MyImageIcon(String fname)  { super(fname); }
	public MyImageIcon(Image image)   { super(image); }

	public MyImageIcon resize(int width, int height)
	{
		Image oldimg = this.getImage();
		Image newimg = oldimg.getScaledInstance(width, height,
			                                    java.awt.Image.SCALE_SMOOTH);
		return new MyImageIcon(newimg);
	}
};
   

