package proparaproj3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Level extends JFrame{
    private JLabel          contentpane;
	//private Mycharacter     show_char;
	private int frameWidth = 2000, frameHeight = 1000;
        public static void main(String[] args) {
            new Level();
        }
////
	public Level()
	{
		setTitle("Chose level");
		setBounds(200, 100, frameWidth, frameHeight);
		setVisible(true);
		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
                
		// set background image by using JLabel as contentpane
		// Set layout to null because we'll move the label manually
		setContentPane(contentpane = new JLabel());
		MyImageIcon background = new MyImageIcon("level_wall.png");
                contentpane.setIcon( background.resize(contentpane.getWidth(),
			                                   contentpane.getHeight()) );
             
           
       GridLayout layout = new GridLayout();
       getContentPane().setLayout(layout);
       // 3x2
       layout.setColumns(3);
       layout.setRows(1);
       layout.setHgap(50);
       layout.setVgap(0);
       /////////////////////////////
       JButton button1 = new JButton(new MyImageIcon("easy_but.png"));
       JButton button2 = new JButton( new MyImageIcon("med_but.png"));
       JButton button3 = new JButton( new MyImageIcon("ins_but.png"));
 
       button1.setPressedIcon(new MyImageIcon("easy_but.png"));
       button2.setPressedIcon(new MyImageIcon("med_but.png"));
       button3.setPressedIcon(new MyImageIcon("ins_but.png"));

       button1.setDisabledIcon(new MyImageIcon("go_but.png"));
       button1.addActionListener(new ActionListener()
               {
                   public void actionPerformed (ActionEvent event)
                   {
                       JButton button = (JButton) event.getSource();
                       button.setEnabled (false);
                   }
               }
       );
       ////////////////////////
       button2.setDisabledIcon(new MyImageIcon("go_but.png"));
       button2.addActionListener(new ActionListener()
               {
                   public void actionPerformed (ActionEvent event)
                   {
                       JButton button = (JButton) event.getSource();
                       button.setEnabled (false);
                   }
               }
       );
       /////////////
       button3.setDisabledIcon(new MyImageIcon("go_but.png"));
       button3.addActionListener(new ActionListener()
               {
                   public void actionPerformed (ActionEvent event)
                   {
                       JButton button = (JButton) event.getSource();
                       button.setEnabled (false);
                   }
               }
       );
            getContentPane().add(button1);
            getContentPane().add(button2);
            getContentPane().add(button3);
            pack();
                setLayout(null);
                setSize(2000,1000);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
        }
        
}

