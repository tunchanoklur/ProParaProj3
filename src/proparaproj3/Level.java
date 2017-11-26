package proparaproj3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;
import javax.swing.*;

public class Level extends JFrame {
<<<<<<< HEAD

    GamePlay    gameplay;
=======
>>>>>>> 590c9eae1dde20ebd2c81c8d050cafb6b0b0a459
    private JPanel contentpane;
    private JLabel drawpane;
    private JLabel      next;
    private MyImageIcon backgroundImg,goImg,nextImg;
    private JButton button[] = new JButton[3];
    private int frameWidth = 2000, frameHeight = 1000;
    
    public static void main(String[] args) {
        new Level();
    }
    
    public Level() {
        setTitle("Choose level");
        setBounds(0,0, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentpane = (JPanel)getContentPane();
        contentpane.setLayout(new BorderLayout());
        backgroundImg = new MyImageIcon("picture/wallpaper/level_wall.png").resize(frameWidth,frameHeight);
        nextImg = new MyImageIcon("picture/button/forward.png").resize(200,200);

        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);
        
        /////////////////////////////
        button[0] = new JButton(new MyImageIcon("picture/button/easy_but.png"));
        button[1] = new JButton(new MyImageIcon("picture/button/med_but.png"));
        button[2]= new JButton(new MyImageIcon("picture/button/ins_but.png"));
        goImg = new MyImageIcon("picture/button/go_but.png");
        
        button[0].setDisabledIcon(goImg);
        button[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JButton button = (JButton) event.getSource();
                button.setEnabled(false);
            }
        }
        );
        ////////////////////////
        button[1].setDisabledIcon(goImg);
        button[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JButton button = (JButton) event.getSource();
                button.setEnabled(false);
            }
        });
        /////////////
        button[2].setDisabledIcon(goImg);
        button[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JButton button = (JButton) event.getSource();
                button.setEnabled(false);
            }
        });
        next = new JLabel(nextImg);
        next.addMouseListener(new MouseListener(){
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                if(gameplay==null){
                    try {
                        gameplay = new GamePlay();
                    }
                    catch (Exception ex) {
                        Logger.getLogger(MainApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }else gameplay.setVisible(true);
                setVisible(false);
            }
   
        });

        next.setBounds(800,500,400,200);
        contentpane.add(next);
        button[0].setBounds(225,800,200,100);
        contentpane.add(button[0]);
        button[1].setBounds(925,800,200,100);
        contentpane.add(button[1]);
        button[2].setBounds(1590,800,200,100);
        contentpane.add(button[2]);
        contentpane.add(drawpane, BorderLayout.CENTER);
        validate();
    }

}
