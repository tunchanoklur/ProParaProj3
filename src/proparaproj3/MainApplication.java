package proparaproj3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApplication extends JFrame{
    //pages
    SelectCharacter   charPage;
    Instruction       instructionPage;
    Credit            creditPage;
    Trophy            highscorePage;
    //components
    private JPanel contentpane;
    private JLabel drawpane;
    private JLabel playButton,howtoButton,creditButton,highscoreButton;
    private MyImageIcon main_bg;
    private MyImageIcon playImg[] = new MyImageIcon[2];
    private MyImageIcon howtoImg[] = new MyImageIcon[2];
    private MyImageIcon creditImg[] = new MyImageIcon[2];
    private MyImageIcon highscoreImg[] = new MyImageIcon[2];
    private SoundEffect main_sound;
    private int frameWidth = 2000, frameHeight = 1000;
    
    public static void main(String[] args) {
        new MainApplication();
    }
    public MainApplication(){
        setTitle("Catch Me : Disney");
        setBounds(0, 0, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        
        AddComponents();
    }
    public void AddComponents() {
        main_bg = new MyImageIcon("picture/wallpaper/main_bg.png").resize(frameWidth,frameHeight);;
        
        for(int i=0;i<2;i++){
            playImg[i] = new MyImageIcon("picture/button/play"+i+".png");
            howtoImg[i] = new MyImageIcon("picture/button/howto"+i+".png");
            creditImg[i] = new MyImageIcon("picture/button/credit"+i+".png");
            highscoreImg[i] = new MyImageIcon("picture/button/highscore"+i+".png");
        }
        
        main_sound = new SoundEffect("sound/toystory.wav");
        main_sound.playLoop();
        
        drawpane = new JLabel();
        drawpane.setIcon(main_bg);
        drawpane.setLayout(null);

        playButton = new JLabel(playImg[0]);
        howtoButton = new JLabel(howtoImg[0]);
        creditButton = new JLabel(creditImg[0]);
        highscoreButton = new JLabel(highscoreImg[0]);
        
        playButton.addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                playButton.setIcon(playImg[1]);
            }
            public void mouseExited(MouseEvent e) {
                playButton.setIcon(playImg[0]);
            }
            public void mouseClicked(MouseEvent e) {
                if(charPage==null){
                    try {
                        main_sound.stop();
                        charPage = new SelectCharacter();
                    }
                    catch (Exception ex) {
                        Logger.getLogger(MainApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else charPage.setVisible(true);
                setVisible(false);
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
        
        howtoButton.addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                howtoButton.setIcon(howtoImg[1]);
            }
            public void mouseExited(MouseEvent e) {
                howtoButton.setIcon(howtoImg[0]);
            }
            public void mouseClicked(MouseEvent e) {
                //in case we repress the button while opening it
                //instead of getting new dialog, it pop the old one up
                if(instructionPage==null)instructionPage = new Instruction();
                else instructionPage.setVisible(true);
                
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
        
        highscoreButton.addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                highscoreButton.setIcon(highscoreImg[1]);
            }
            public void mouseExited(MouseEvent e) {
                highscoreButton.setIcon(highscoreImg[0]);
            }
            public void mouseClicked(MouseEvent e) {
                /*Link to page highscore*/
                if(highscorePage==null)highscorePage = new Trophy();
                else highscorePage.setVisible(true);
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
        
        creditButton.addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                creditButton.setIcon(creditImg[1]);
            }
            public void mouseExited(MouseEvent e) {
                creditButton.setIcon(creditImg[0]);
            }
            public void mouseClicked(MouseEvent e) {
                if(creditPage==null)creditPage=new Credit();
                else creditPage.setVisible(true);
                
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
        playButton.setBounds(800,500,400,200);
        contentpane.add(playButton);
        howtoButton.setBounds(1275,750,200,200);
        contentpane.add(howtoButton);
        highscoreButton.setBounds(1500,750,200,200);
        contentpane.add(highscoreButton);
        creditButton.setBounds(1725,750,200,200);
        contentpane.add(creditButton);
        contentpane.add(drawpane,BorderLayout.CENTER);
        validate();
        repaint();  
    }
}

// Auxiliary class to resize image
class MyImageIcon extends ImageIcon {

    public MyImageIcon(String fname) {
        super(fname);
    }

    public MyImageIcon(Image image) {
        super(image);
    }
    public MyImageIcon resize(int width, int height) {
        Image oldimg = this.getImage();
        Image newimg = oldimg.getScaledInstance(width, height,java.awt.Image.SCALE_SMOOTH);
        return new MyImageIcon(newimg);
    }
};

// Auxiliary class to play sound effect (support .wav or .mid file)
class SoundEffect {

    private java.applet.AudioClip audio;

    public SoundEffect(String filename) {
        try {
            java.io.File file = new java.io.File(filename);
            audio = java.applet.Applet.newAudioClip(file.toURL());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playOnce() {
        audio.play();
    }

    public void playLoop() {
        audio.loop();
    }

    public void stop() {
        audio.stop();
    }
}