package proparaproj3;

import java.awt.*;
import javax.swing.*;

public class Character extends JFrame {
    private JPanel contentpane;
    private JLabel drawpane;
    private JLabel[] character = new JLabel[8];
    private MyImageIcon backgroundImg;
    private int frameWidth = 2000, frameHeight = 1000;
    private JRadioButton[] radio_but;
    private ButtonGroup bgroup;

     public static void main(String[] args) {
        new Character();
    }

    public Character() {
        // super("Show char");
        setTitle("Choose player's character");
        setBounds(0, 0, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set background image by using JLabel as contentpane
        // Set layout to null because we'll move the label manually
        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        backgroundImg = new MyImageIcon("picture/wallpaper/select_char.png").resize(frameWidth,frameHeight);

        drawpane = new JLabel();
        drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);
        
        radio_but = new JRadioButton[8];
        bgroup = new ButtonGroup();
        radio_but[0] = new JRadioButton("Cheshire");
        radio_but[1] = new JRadioButton("Jasmine");
        radio_but[2] = new JRadioButton("Ariel");
        radio_but[3] = new JRadioButton("Donald Duck");
        radio_but[4] = new JRadioButton("Chip Dale");
        radio_but[5] = new JRadioButton("Pinocchio");
        radio_but[6] = new JRadioButton("Judy Hops");
        radio_but[7] = new JRadioButton("Tazans");
        for (int i = 0; i < 8; i++) {
            bgroup.add(radio_but[i]);
        }
        radio_but[0].setSelected(true);
        
        radio_but[0].setBounds(395, 480, 100, 35);
        radio_but[1].setBounds(830, 480, 100, 35);
        radio_but[2].setBounds(1245, 480, 100, 35);
        radio_but[3].setBounds(1675, 480, 100, 35);
        radio_but[4].setBounds(395, 880, 100, 35);
        radio_but[5].setBounds(830, 880, 100, 35);
        radio_but[6].setBounds(1245, 880, 100, 35);
        radio_but[7].setBounds(1675, 880, 100, 35);

        character[0] = new JLabel(new MyImageIcon("picture/character/char_cheshire.png"));
        character[0].setBounds(250, 200, 340, 190);

        character[1] = new JLabel(new MyImageIcon("picture/character/char_jusmine.png"));
        character[1].setBounds(780, 150, 200, 300);

        character[2] = new JLabel(new MyImageIcon("picture/character/char_arial.png"));
        character[2].setBounds(1200, 150, 200, 300);

        character[3] = new JLabel(new MyImageIcon("picture/character/char_donaldduck.png"));
        character[3].setBounds(1580, 150, 220, 292);
        /////////2nd row/////////

        character[4] = new JLabel(new MyImageIcon("picture/character/char_chipdale.png"));
        character[4].setBounds(250, 600, 300, 200);

        character[5] = new JLabel(new MyImageIcon("picture/character/char_pinoc.png"));
        character[5].setBounds(780, 550, 200, 300);

        character[6] = new JLabel(new MyImageIcon("picture/character/char_hops.png"));
        character[6].setBounds(1200, 550, 200, 301);

        character[7] = new JLabel(new MyImageIcon("picture/character/char_tazan.png"));
        character[7].setBounds(1580, 550, 260, 250);

        bgroup = new ButtonGroup();
        for (int j = 0; j < 8; j++) {
            bgroup.add(radio_but[j]);
        }
        
        for (int i = 0; i < 8; i++) {
            contentpane.add(character[i]);
            contentpane.add(radio_but[i]);
        }
        
        contentpane.add(drawpane, BorderLayout.CENTER);
        repaint();
        validate();
    }
}
