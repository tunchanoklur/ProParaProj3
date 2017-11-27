package proparaproj3;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Trophy extends JFrame{
    MainApplication     MainPage;
    private JPanel      contentpane;
    private JLabel      drawpane;
    private JButton     backButton;
    private MyImageIcon BG, goBack;
    private int frameWidth = 2000, frameHeight = 1000;
    private Scanner scan;
    private ArrayList<PlayerInfo> customers;
    public static void main(String[] args) {
        new Trophy();
    }
    public Trophy(){
        setTitle("High Score");
        setBounds(0, 0, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        scan=new Scanner("output.txt");
        ArrayList<PlayerInfo> customers=new ArrayList<PlayerInfo>();
        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        
        AddComponents();
    }
    public void AddComponents(){
        BG = new MyImageIcon("picture/wallpaper/high_score.png").resize(frameWidth,frameHeight);
        goBack =  new MyImageIcon("picture/button/backward.png").resize(60,60);
        
        drawpane = new JLabel();
        drawpane.setIcon(BG);
        drawpane.setLayout(null);
                
        backButton = new JButton(goBack);
        backButton.addMouseListener( new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        backButton.setBounds(0,0,60,60);
        contentpane.add(backButton);
        contentpane.add(drawpane);
        validate();
        repaint();  
    }
    
}
