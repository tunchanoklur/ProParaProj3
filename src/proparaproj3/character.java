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
        private JToggleButton [] tb;
        private ButtonGroup		 bgroup;

	public character()
	{
           // super("Show char");
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
                
       /*JRadioButton [] ra = new JRadioButton[8];
        ra[0] = new JRadioButton ("Cheshire");
        ra[1] = new JRadioButton( "Jasmine");
        ra[2] = new JRadioButton( "Ariel");
        ra[3] = new JRadioButton( "Donald Duck");
        ra[4] = new JRadioButton( "Chip Dale");
        ra[5] = new JRadioButton( "Pinocchio");
        ra[6] = new JRadioButton( "Judy Hops");
        ra[7] = new JRadioButton( "Tazans");
       
       ra[0].setBounds(-600,-250,frameWidth,frameHeight);
       ra[1].setBounds(-90,-250,frameWidth,frameHeight);
       ra[2].setBounds(300,-200,frameWidth,frameHeight);
       ra[3].setBounds(600,-200,frameWidth,frameHeight);
       ra[4].setBounds(-600,150,frameWidth,frameHeight);
       ra[5].setBounds(-90,150,frameWidth,frameHeight);
       ra[6].setBounds(300,150,frameWidth,frameHeight);
       ra[7].setBounds(600,150,frameWidth,frameHeight);
       */
       
       
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
                    contentpane.add(open_file[i]);
                    //getContentPane().add(ra[i]);
                }
               /* ButtonGroup group = new ButtonGroup();
                for(int j=0;j<8;j++)
                {
                    group.add(ra[j]);
                    
                }
               contentpane.add(ra[0]);
            contentpane.add(ra[1]);
            contentpane.add(ra[2]);
            contentpane.add(ra[3]);
            contentpane.add(ra[4]);
            contentpane.add(ra[5]);
            contentpane.add(ra[6]);
            contentpane.add(ra[7]);
                setLocation(null);*/
                setVisible(true);
               repaint();
	}
	public static void main(String[] args) 
	{
		new character(); 
             //new level();
            //new charac();
            //new NewJFrame();
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
   

