/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proparaproj3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class level extends JFrame{
    private JLabel          contentpane;
	//private Mycharacter     show_char;
	private int frameWidth = 2000, frameHeight = 1000;

	public level()
	{
		setTitle("Chose level");
		setBounds(50, 50, frameWidth, frameHeight);
		setVisible(true);
		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
                
		// set background image by using JLabel as contentpane
		// Set layout to null because we'll move the label manually
		setContentPane(contentpane = new JLabel());
		MyImageIcon background = new MyImageIcon("level_wall.png");
                contentpane.setIcon( background.resize(contentpane.getWidth(),
			                                   contentpane.getHeight()) );
             
		JButton [] bt = new JButton[4];
                /* bt[0] = new JButton(new MyImageIcon ("easy_but.png"));
		 bt[1] = new JButton(new MyImageIcon ("med_but.png"));
		 bt[2] = new JButton(new MyImageIcon ("ins_but.png"));
                */
                 bt[0] = new JButton( "easy_but.png");
		 bt[1] = new JButton ("med_but.png");
		 bt[2] = new JButton ("ins_but.png");
                contentpane.setLayout( null );
                contentpane.add(bt[0], BorderLayout.NORTH); //add to the contentpane ;need to give the location
		contentpane.add(bt[1], BorderLayout.CENTER); 
		contentpane.add(bt[2], BorderLayout.SOUTH);
                //repaint();
                this.validate();
        }
        
}

class selection extends JLabel implements MouseListener
{
        private int curX  = 250, curY   = 300; //location of X , Y
	private int width = 300, height = 300;

   
   
    @Override
    public void mouseClicked(MouseEvent me) {}

    @Override
    public void mousePressed(MouseEvent me) {}
    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}
    @Override
    public void mouseExited(MouseEvent me) {}
	
        
}