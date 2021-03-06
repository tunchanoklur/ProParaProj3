package proparaproj3;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePlay extends JFrame {
    // components
    private JPanel contentpane;
    private JLabel drawpane;
    private JTextField scoreText,Time;
    private JLabel characterLabel, dropLabel[],specialLabel[];
    private MyImageIcon backgroundImg, characterImg, dropImg[],specialImg[];
    private SoundEffect hitSound[] = new SoundEffect[3], themeSound;
    
    // working variables - adjust the values as you want
    private Random rand = new Random();
    private DropCharacter dropclass[];
    private SpecialItem specialclass[];
    final private int frameWidth = 2000, frameHeight = 1000;
    private int characterWidth = 180, characterHeight = 250;
    private int characterCurX = 700,characterspeed=20;
    private int dropWidth = 60, dropHeight = 60;
    private int dropCurX = 0;
    private int time=60;
    private boolean playhitsound =true,playing=true;
    private boolean left =false, right=false;
    private int score;
    
    public static void main(String[] args) throws InterruptedException {
        new GamePlay();
    }
    //////////////////////////////////////////////////////////////////////////
    public GamePlay() throws InterruptedException{
        setTitle("Catch Me : Disney");
        setBounds(0, 0, frameWidth, frameHeight);
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
    public void AddComponents() throws InterruptedException {
        //add image
        backgroundImg = new MyImageIcon("picture/wallpaper/option_wall.png").resize(contentpane.getWidth(),contentpane.getHeight());
        characterImg = new MyImageIcon("picture/user_icon/user_cat.png");
        dropImg = new MyImageIcon[22];
        for(int i=0;i<22;i++){
            dropImg[i] = new MyImageIcon("picture/tsum/tsum"+i+".png").resize(dropWidth,dropHeight);
        }
        specialImg = new MyImageIcon[4];
        for(int i=0;i<4;i++){
            specialImg[i] = new MyImageIcon("picture/tsum/special"+i+".gif");
        }

        //add backgound
        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);
        
        //add key listener to handle move left - right
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            //when press left-right
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    System.out.println("Pressing Left");
                    left=true;
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    right=true;
                    System.out.println("Pressing Right");
                }
            }
            //when we release, it stop
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    left=false;
                    System.out.println("Release Left");
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    right=false;
                    System.out.println("Release Right");
                }
            }
        });

        characterLabel = new JLabel(characterImg);
        characterLabel.setBounds(characterCurX, frameHeight-characterHeight-50, characterWidth, characterHeight);
        drawpane.add(characterLabel);

        dropLabel = new JLabel[10];
        for(int i=0;i<10;i++){
            int new_tsum = rand.nextInt(22) + 0;
            dropLabel[i]= new JLabel(dropImg[new_tsum]);
            dropLabel[i].setBounds(dropCurX,-dropHeight, dropWidth, dropHeight );
            drawpane.add(dropLabel[i]);
        }
        
        specialLabel = new JLabel[1];
        specialclass = new SpecialItem[1];

        int new_special = rand.nextInt(3) + 0;
        specialLabel[0] = new JLabel(specialImg[new_special]);
        specialLabel[0].setBounds(rand.nextInt(frameWidth - 150), -150,150,150);
        specialclass[0] = new SpecialItem(new_special);
        drawpane.add(specialLabel[0]);
        
        hitSound[0] = new SoundEffect("sound/wingwing.wav");
        hitSound[1] = new SoundEffect("sound/laugh.wav");
        hitSound[2] = new SoundEffect("sound/storm.wav");
        themeSound = new SoundEffect("sound/toystory.wav");
        themeSound.playLoop();
        
        Time = new JTextField(Integer.toString(time),5);
        Time.setEditable(false);
        scoreText = new JTextField("0", 5);
        scoreText.setEditable(false);

        JPanel control = new JPanel();
        control.setBounds(0, 0, 1000, 50);
        control.add(new JLabel("                 "));
        control.add(new JLabel("Time  : "));
        control.add(Time);
        control.add(new JLabel("                 "));
        control.add(new JLabel("Score : "));
        control.add(scoreText);
        contentpane.add(control, BorderLayout.NORTH);
        contentpane.add(drawpane, BorderLayout.CENTER);
        repaint();
        validate();
        
        dropclass =new DropCharacter[10];
        for(int i=0;i<10;i++){
            dropclass[i] = new DropCharacter(i);
            dropclass[i].start();
            try {
                Thread.sleep(125);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        specialclass[0].start();
        setTimeThread();
        validate();
    }

    ////////////////////////////////Time Thread//////////////////////////////////
    public void setTimeThread() {
        Thread timeThread = new Thread() {
            public void run() {
                while(time>0) {
                    time -= 1;
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){ e.printStackTrace(); }
                    Time.setText(Integer.toString(time));
                    validate();
                }playing=false;
            } // end run
        }; // end thread creation
        timeThread.start();
    }
    /////////////////////////////Character Thread////////////////////////////////
    public void setCharacterThread() {
        Thread characterThread = new Thread() {
            public void run() {
                while(playing) {
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
                    try {
                        Thread.sleep(characterspeed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } // end while
            } // end run
        }; // end thread creation
        characterThread.start();
    }
    ////////////////////////////Drop Class//////////////////////////////////////////////
    class DropCharacter extends Thread{
        int id,dropCurX,dropCurY,dropWidth = 60, dropHeight = 60,speed;
        private DropCharacter(int id_in){
            id=id_in;
            dropCurX=rand.nextInt(frameWidth-dropWidth);
            speed =rand.nextInt(100)+15;
            dropCurY=-dropHeight;
        }
        public void run(){
                while(playing){
                    dropCurY+=5;
                        if(dropCurY+dropHeight>=frameHeight){//unable to catch the tsum tsum
                            time--;
                            dropCurX = rand.nextInt(frameWidth-dropWidth) + 0;
                            dropCurY=-dropHeight;
                            int new_tsum = rand.nextInt(22) + 0;
                            dropLabel[id].setIcon(dropImg[new_tsum]);
                        try {
                            Thread.sleep(10);
                        } 
                        catch (InterruptedException e) {}
                        }
                    dropLabel[id].setBounds(dropCurX, dropCurY, dropWidth, dropHeight);
                    repaint();
                    this.collision();
                    try {
                        Thread.sleep(this.speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } // end while
            } // end run
        synchronized public void collision() {
            if (characterLabel.getBounds().intersects(dropLabel[id].getBounds())) {
                if(playhitsound)hitSound[0].playOnce();
                dropCurY=frameHeight-dropHeight;
                int new_tsum;
                new_tsum = rand.nextInt(22) + 0;
                dropLabel[id].setIcon(dropImg[new_tsum]);
                score++;
                scoreText.setText(Integer.toString(score));
                validate();
            }
        }
    };
    ///////////////////////////////Special Items///////////////////////////////////////
    class SpecialItem extends Thread {
        private int id, specialCurX, specialCurY;
        public SpecialItem(int id_in) {
            id = id_in;
            specialCurX = rand.nextInt(frameWidth - 150); //150 is an estimate size of all gif
            specialCurY = -150;
        }
        public void run() {
            while(playing) {
                specialCurY += 10;
                if(specialCurY+150>=frameHeight){//unable to catch the tsum tsum
                            specialCurX = rand.nextInt(frameWidth-150) + 0;
                            specialCurY=-150;
                            id = rand.nextInt(4) + 0;//make the flash less likely drop
                            specialLabel[0].setIcon(specialImg[id]);
                        try {
                            Thread.sleep(25);
                        } 
                        catch (InterruptedException e) {}
                        }
                specialLabel[0].setBounds(specialCurX, specialCurY,150,150);
                repaint();
                this.collision();
                try {
                    Thread.sleep(55);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } // end while
        } // end run

        synchronized public void collision() {
            if (characterLabel.getBounds().intersects(specialLabel[0].getBounds())) {
                switch (this.id) {
                    case 0:
                        //bomb
                        if (playhitsound) {
                            hitSound[1].playOnce();
                        }
                        score -= 10;
                        break;
                    case 1:
                        //hourglass
                        if (playhitsound) {
                            hitSound[0].playOnce();
                        }
                        time+=10;
                        break;
                    case 2:
                        //lightning
                        if (playhitsound) {
                            hitSound[2].playOnce();
                        }
                        if(characterspeed>100)characterspeed-=30;
                        break;
                    default:
                        if (playhitsound) {
                            hitSound[1].playOnce();
                        }
                        if(characterspeed<350)characterspeed+=40;
                        break;
                        
                }
                validate();
                specialCurX = rand.nextInt(frameWidth-150) + 0;
                specialCurY=-150;
                id = rand.nextInt(3) + 0;
                specialLabel[0].setIcon(specialImg[id]);
                repaint();
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////
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
                    "Catch Me : Disney",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    };
}