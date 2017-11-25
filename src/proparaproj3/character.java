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
		
              JToggleButton [] tb = new JToggleButton[6];
                tb[0] = new JRadioButton( "Cheshire" );
		tb[1] = new JRadioButton( "Jasmine" );
		tb[2] = new JRadioButton( "Ariel" );
                tb[3] = new JRadioButton( "Donald duck" );
		tb[4] = new JRadioButton( "Chip Dale" );
		tb[5] = new JRadioButton( "Pinocchio" );
                
                JLabel [] open_file = new JLabel[6];
		open_file[0]   = new JLabel(new MyImageIcon("char_cheshire.png"));
                open_file[1]   = new JLabel( new MyImageIcon("char_jusmine.png"));
		open_file[2]   = new JLabel(new MyImageIcon("char_arial.png"));
                open_file[3]   = new JLabel(new MyImageIcon("char_donaldduck.png"));
                open_file[4]   = new JLabel(new MyImageIcon("char_chipdale.png"));
                open_file[5]   = new JLabel(new MyImageIcon("char_pinoc.png"));
                
		for (int i=0;i<6;i++)
                {
                    contentpane.add(tb[i]);
                    contentpane.add(open_file[i]);
                    repaint();
                }
                //show_char = new Mycharacter();
		//contentpane.add(show_char);
                addKeyListener(show_char);
                addMouseListener(show_char);
              
		repaint(); //validate
	}
	public static void main(String[] args) 
	{
		//new character(); 
                new level();
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
            /*JToggleButton [] tb = new JToggleButton[6];
                tb[0] = new JRadioButton( "Cheshire" );
		tb[1] = new JRadioButton( "Jasmine" );
		tb[2] = new JRadioButton( "Ariel" );
                tb[3] = new JRadioButton( "Donald duck" );
		tb[4] = new JRadioButton( "Chip Dale" );
		tb[5] = new JRadioButton( "Pinocchio" );
                
                JLabel [] open_file = new JLabel[6];
		open_file[0]   = new JLabel(new MyImageIcon("char_cheshire.png"));
                open_file[1]   = new JLabel( new MyImageIcon("char_jusmine.png"));
		open_file[2]   = new JLabel(new MyImageIcon("char_arial.png"));
                open_file[3]   = new JLabel(new MyImageIcon("char_donaldduck.png"));
                open_file[4]   = new JLabel(new MyImageIcon("char_chipdale.png"));
                open_file[5]   = new JLabel(new MyImageIcon("char_pinoc.png"));*/
               
            
                
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
   

