/*
import java.awt.Cursor;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Firstpage extends javax.swing.JFrame {
    
    private JButton credit, howto,play,rank;
    private JLabel jLabel1;
    private MySoundEffect themeSound;
    private MyImageIcon   ply1,ply2,crd1,crd2,rnk1,rnk2,ht1,ht2;
    private boolean moved = false;
    private boolean clicked = false;
    instruction     instr;
    creditpage      crd;
    trophy          trp;
    public Firstpage() {
        setTitle("Catch Me");
        setBounds(0,0,2000,1000);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        themeSound = new MySoundEffect("sound/toystory.wav");
        themeSound.playLoop();
        initComponents();

    }
     private void initComponents() {

        play = new javax.swing.JButton();
        credit = new javax.swing.JButton();
        rank = new javax.swing.JButton();
        howto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        ply1 = new MyImageIcon("picture/button/play_but1.png");        
        play.setIcon(ply1);
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount()==1){
                    ply2 = new MyImageIcon("picture/button/play_but2.png");        
                    play.setIcon(ply2);
                }
            }
        });
        getContentPane().add(play);
        play.setBounds(740, 520, 480, 260);

        crd1 = new MyImageIcon("picture/button/credit_1.png");        
        credit.setIcon(crd1);
        credit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount()==1){
                    crd2 = new MyImageIcon("picture/button/credit_2.png");        
                    credit.setIcon(crd2);
                    crd = new creditpage();
                    crd.setVisible(true);
                }            
            }
        });
        getContentPane().add(credit);
        credit.setBounds(1770, 750, 210, 210);

        rnk1 = new MyImageIcon("picture/button/trophy_but1.png");        
        rank.setIcon(rnk1);
        rank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount()==1){
                    rnk2 = new MyImageIcon("picture/button/rophy_but2.png");        
                    rank.setIcon(rnk2);
                    trp = new trophy();
                    trp.setVisible(true);
                }
            }
        });
        getContentPane().add(rank);
        rank.setBounds(1550, 750, 220, 210);

        ht1 = new MyImageIcon("picture/button/Question_mark_but1.png");        
        howto.setIcon(ht1);
        howto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount()==1){
                    ht2 = new MyImageIcon("picture/button/Question_mark_but2.png");        
                    howto.setIcon(ht2);                    
                    instr = new instruction();
                    instr.setVisible(true);
                }
            }
        });
        getContentPane().add(howto);
        howto.setBounds(1310, 750, 240, 210);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("picture/wallpaper/main_bg.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 2000, 1010);

        pack();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new first().setVisible(true);
            }
        });
    }
                 
}
*/