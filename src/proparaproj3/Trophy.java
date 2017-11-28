package proparaproj3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
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
    private JLabel      drawpane,playerLabel[];
    private JButton     backButton;
    private MyImageIcon BG, goBack;
    private int frameWidth = 2000, frameHeight = 1000;
    private Scanner scan;
    private ArrayList<PlayerInfo> players;
    /*public static void main(String[] args) {
        new Trophy();
    }*/
    public Trophy(){
        setTitle("High Score");
        setBounds(0, 0, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        try {
            scan=new Scanner(new File("output.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Trophy.class.getName()).log(Level.SEVERE, null, ex);
        }
        players = new ArrayList<PlayerInfo>();
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
                MainPage = new MainApplication();
                dispose();
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        
        String line;
        String[] buf;
        int score=0;
        PlayerInfo player_tmp;
        while(scan.hasNext()){//get info from file
            line = scan.nextLine();
            buf = line.split("\\s+");
            player_tmp = new PlayerInfo(buf[0],buf[1],Integer.parseInt(buf[2]));
            players.add(player_tmp);
        }
        Collections.sort(players);
        playerLabel = new JLabel[10];
        int loop,y = 250;
        if(players.size()<5)loop = players.size();
        else loop=5;
        for(int i=0;i<loop;i++){
            String lvl;
            switch(players.get(i).giveLevel()) {
                case 0:lvl = "Easy";break;
                case 1:lvl = "Normal";break;
                default:lvl = "Insane";break;
            }
            String data =(i+1)+") "+players.get(i).giveName()+"  "+lvl+"  "+players.get(i).giveScore();
            playerLabel[i]=new JLabel(data);
            playerLabel[i].setBounds(830,y,1500,90);
            playerLabel[i].setFont(new Font("Courier", Font.BOLD, 65));
            playerLabel[i].setForeground(Color.white);
            contentpane.add(playerLabel[i]);
            y+=125;
        }
        
        backButton.setBounds(0,0,60,60);
        contentpane.add(backButton);
        contentpane.add(drawpane);
        validate();
        repaint();  
    }
    
}
