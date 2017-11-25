package proparaproj3;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePlay extends JFrame {
    // components
    private JPanel contentpane;
    private JLabel drawpane;
    private JComboBox combo;
    private JToggleButton[] tb;
    private JButton jumpButton, stopButton;
    private JTextField scoreText;
    private JLabel characterLabel, coneLabel;
    private MyImageIcon backgroundImg, characterImg, coneImg;
    private ButtonGroup bgroup;
    private SoundEffect hitSound, themeSound;
    private Random rand = new Random();
    // working variables - adjust the values as you want
    private int frameWidth = 1500, frameHeight = 750;
    private int characterWidth = 180, characterHeight = 250;
    private int characterCurX = 700, characterCurY = 250;
    private int coneWidth = 150, coneHeight = 150;
    private int coneCurX = 0, coneCurY = 0;
    private int time=45;
    private int zombieSpeed = 1000, coneSpeed = 700;
    private boolean forward = true, jump = false, walk = true;
    private boolean playhitsound =true;
    private boolean left =false, right=false;
    private int score;

    public static void main(String[] args) {
        new GamePlay();
    }

    //////////////////////////////////////////////////////////////////////////
    public GamePlay() {
        setTitle("Catch Me : Game Play");
        setBounds(50, 50, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        addWindowListener( new MyWindowListener() );
        AddComponents();
        setCharacterThread();
    }

    /////////////////////////////////////////////////////////////////////////
    public void AddComponents(){
        //add image
        backgroundImg = new MyImageIcon("andy's_room.png").resize(contentpane.getWidth(),contentpane.getHeight());
        characterImg = new MyImageIcon("user_cat.png")/*.resize(characterWidth, characterHeight)*/;
        coneImg = new MyImageIcon("./project_pic/tsum/tsum0.jpg");

        //add backgound
        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);
        
        //add key listener to handle move left - right
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    left=true;
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    right=true;
                }
            }
            //when we release, it stop
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    left=false;
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    right=false;
                }
            }
        });

        characterLabel = new JLabel(characterImg);
        characterLabel.setBounds(characterCurX, frameHeight-characterHeight, characterWidth, characterHeight);
        drawpane.add(characterLabel);

        coneLabel = new JLabel(coneImg);
        coneLabel.setBounds(rand.nextInt(frameWidth-coneWidth) + 0,-106, coneWidth, coneHeight );
        drawpane.add(coneLabel);

        hitSound = new SoundEffect("loser.wav");
        themeSound = new SoundEffect("toystory.wav");
        themeSound.playLoop();

        setConeThread();
        validate();

        scoreText = new JTextField("0", 5);
        scoreText.setEditable(false);

        JPanel control = new JPanel();
        control.setBounds(0, 0, 1000, 50);
        control.add(new JLabel("                 "));
        control.add(new JLabel("Score : "));
        control.add(scoreText);
        contentpane.add(control, BorderLayout.NORTH);
        contentpane.add(drawpane, BorderLayout.CENTER);
        validate();
    }

    //////////////////////////////////////////////////////////////////////////
    public void setCharacterThread() {
        Thread zombieThread = new Thread() {
            public void run() {
                while(time!=0) {
                    // (6) Add code to update Zombie's location
                    if(left){
                        characterCurX-=5;
                        if(characterCurX+characterWidth<0)characterCurX=frameWidth;
                    }
                    else if(right){
                        characterCurX+=5;
                        if(characterCurX-characterWidth>frameWidth)characterCurX=0-characterWidth;
                    }
                    characterLabel.setBounds(characterCurX, frameHeight-characterHeight-50,characterWidth, characterHeight);
                    repaint();
                    collision();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } // end while
            } // end run
        }; // end thread creation
        zombieThread.start();
    }

    //////////////////////////////////////////////////////////////////////////
    public void setConeThread() {
        Thread coneThread = new Thread() {
            public void run() {
                while (true) {
                    // (7) Add code to update cone's location
                    coneCurY+=10;
                        if(coneCurY+106>=frameHeight){
                            coneCurX = rand.nextInt(frameWidth-coneWidth) + 0;
                            coneCurY=-106;
                            //andom pi
                        }
                    coneLabel.setBounds(coneCurX, coneCurY, coneWidth, coneHeight);
                    repaint();
                    try {
                        Thread.sleep(125);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } // end while
            } // end run
        }; // end thread creation
        coneThread.start();
    }

    //////////////////////////////////////////////////////////////////////////
    synchronized public void collision() {
        if (characterLabel.getBounds().intersects(coneLabel.getBounds())) {
            // (8) If zombie and cone hit each other, play hit sound & update score
            if(playhitsound)hitSound.playOnce();
            coneCurY=frameHeight+10;
            score++;
            scoreText.setText(Integer.toString(score));
            validate();
        }
    }
    
    class MyWindowListener extends WindowAdapter//when we open / close the frame
    {
        public void windowClosing(WindowEvent e) {
            playhitsound=false;
            themeSound.stop();
            JFrame frame = (JFrame) e.getWindow();
            contentpane = (JPanel) frame.getContentPane();
            JOptionPane.showMessageDialog(
                    new JFrame(),
                    "Total Score = " + score,
                    "The walking dead",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    };
}
