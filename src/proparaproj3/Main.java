package proparaproj3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Main extends JFrame{
    private JPanel contentpane;
    private JLabel drawpane;
    private MyImageIcon main_bg;
    private SoundEffect main_sound;
    private int frameWidth = 1500, frameHeight = 750;
    public static void main(String[] args) {
        new Main();
    }
    public Main(){
        setTitle("Catch Me : Disney");
        setBounds(50, 50, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        
        AddComponents();
    }
    public void AddComponents() {
        main_bg = new MyImageIcon("project_pic/wallpaper/main_bg.png").resize(contentpane.getWidth(),contentpane.getHeight());;
        //main_sound = new SoundEffect("");
        drawpane = new JLabel();
        drawpane.setIcon(main_bg);
        drawpane.setLayout(null);
        
        contentpane.add(drawpane, BorderLayout.CENTER);
        repaint();
        validate();
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