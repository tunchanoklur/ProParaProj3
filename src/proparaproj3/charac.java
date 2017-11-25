/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proparaproj3;

import static java.awt.AWTEventMulticaster.add;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author po-pe
 */
public class charac extends JFrame {
    
    public charac()
    {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("ThaiCreate.Com GUI Tutorial");
        //getContentPane().setLayout(new GridLayout(1, 3, 10, 10)); // 3x2
       JRadioButton ra0 = new JRadioButton ("Cheshire");
       JRadioButton ra1 = new JRadioButton( "Jasmine");
       JRadioButton ra2 = new JRadioButton( "Ariel");
       JRadioButton ra3 = new JRadioButton( "Donald Duck");
       JRadioButton ra4 = new JRadioButton( "Chip Dale");
       JRadioButton ra5 = new JRadioButton( "Pinocchio");
       JRadioButton ra6 = new JRadioButton( "Judy Hops");
       JRadioButton ra7 = new JRadioButton( "Tazans");
       
       ra0.setBounds(119,58,108,23);
       ra1.setBounds(200,58,108,23);
       ra2.setBounds(300,58,108,23);
       ra3.setBounds(400,58,108,23);
       ra4.setBounds(119,100,108,23);
       ra5.setBounds(200,100,108,23);
       ra6.setBounds(300,100,108,23);
       ra7.setBounds(400,100,108,23);
       
        getContentPane().add(ra0);
        getContentPane().add(ra1);
        getContentPane().add(ra2);
        getContentPane().add(ra3);
        getContentPane().add(ra4);
        getContentPane().add(ra5);
        getContentPane().add(ra6);
        getContentPane().add(ra7);
        //add(button1,BorderLayout.NORTH); add(button2,BorderLayout.SOUTH); add(button3);
       
        
       
                setLayout(null);
                setSize(2000,2000);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
                
    }
}
