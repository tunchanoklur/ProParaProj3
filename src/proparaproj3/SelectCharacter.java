package proparaproj3;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Logger;
import javax.swing.*;

public class SelectCharacter extends JFrame {
    WallSelect     wall;
    private JPanel contentpane;
    private JLabel drawpane;
    private JLabel next;
    private JLabel[] character = new JLabel[8];
    private MyImageIcon backgroundImg,nextImg,cat,cat2,jas,jas2,pin,pin2,ari,ari2,dol,dol2,chip,chip2,hop,hop2,tan,tan2;
    private String character_dir[]=new String[8];
    private int frameWidth = 2000, frameHeight = 1000;
    private JRadioButton[] radio_but;
    private ButtonGroup bgroup;
    private int selected=0;
    //private boolean move = false;

    /*public static void main(String[] args) {
        new SelectCharacter();
    }*/

    public SelectCharacter(PlayerInfo player) {
        setTitle("Choose player's character");
        setBounds(0, 0, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        backgroundImg = new MyImageIcon("picture/wallpaper/select_char.png").resize(frameWidth,frameHeight);
        nextImg = new MyImageIcon("picture/button/forward.png").resize(200,200);
        
        for(int i=0;i<8;i++){
            character_dir[i] = "picture/user_icon/user"+i+".png";
        }
        
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

        cat2 = new MyImageIcon("picture/character/user_cat.png");    
        cat = new MyImageIcon("picture/character/char_cheshire.png");
        character[0] = new JLabel(cat);
        character[0].setBounds(250, 200, 340, 190);
        character[0].addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                character[0].setIcon(cat2);
            }
            public void mouseExited(MouseEvent e) {
                character[0].setIcon(cat);
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
        
        jas = new MyImageIcon("picture/character/char_jusmine.png");
        jas2 = new MyImageIcon ("picture/character/user_jas.png");
        character[1] = new JLabel(jas);
        character[1].setBounds(780, 150, 200, 300);
        character[1].addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                character[1].setIcon(jas2);
            }
            public void mouseExited(MouseEvent e) {
                character[1].setIcon(jas);
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
                
        ari= new MyImageIcon("picture/character/char_arial.png");
        ari2 = new MyImageIcon("picture/character/user_ari.png");
        character[2] = new JLabel(ari);
        character[2].setBounds(1200, 150, 200, 300);
        character[2].addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                character[2].setIcon(ari2);
            }
            public void mouseExited(MouseEvent e) {
                character[2].setIcon(ari);
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
        
        dol = new MyImageIcon("picture/character/char_donaldduck.png");
        dol2 = new MyImageIcon("picture/character/user_dol.png");
        character[3] = new JLabel(dol);
        character[3].setBounds(1580, 150, 220, 292);
        character[3].addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                character[3].setIcon(dol2);
            }
            public void mouseExited(MouseEvent e) {
                character[3].setIcon(dol);
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
        
        /////////2nd row/////////
        chip= new MyImageIcon("picture/character/char_chipdale.png");
        chip2 = new MyImageIcon("picture/character/chip_d.png");
        character[4] = new JLabel(chip);
        character[4].setBounds(250, 600, 300, 200);
        character[4].addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                character[4].setIcon(chip2);
            }
            public void mouseExited(MouseEvent e) {
                character[4].setIcon(chip);
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });

        pin = new MyImageIcon("picture/character/char_pinoc.png");
        pin2 = new MyImageIcon("picture/character/user_pin.png");
        character[5] = new JLabel(pin);
        character[5].setBounds(780, 550, 200, 300);
        character[5].addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                character[5].setIcon(pin2);
            }
            public void mouseExited(MouseEvent e) {
                character[5].setIcon(pin);
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });

        hop =  new MyImageIcon("picture/character/char_hops.png");
        hop2 =  new MyImageIcon("picture/character/user_hop.png");
        character[6] = new JLabel(hop);
        character[6].setBounds(1200, 550, 200, 301);
         character[6].addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                character[6].setIcon(hop2);
            }
            public void mouseExited(MouseEvent e) {
                character[6].setIcon(hop);
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });

        tan = new MyImageIcon("picture/character/char_tazan.png");
        tan2 = new MyImageIcon("picture/character/user_tan.png");
        character[7] = new JLabel(tan);
        character[7].setBounds(1580, 550, 260, 250);
        character[7].addMouseListener( new MouseListener(){
            public void mouseEntered(MouseEvent e) {
                character[7].setIcon(tan2);
            }
            public void mouseExited(MouseEvent e) {
                character[7].setIcon(tan);
            }
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
        bgroup = new ButtonGroup();
        for (int j = 0; j < 8; j++) {
            bgroup.add(radio_but[j]);
        }
        
        for (int i = 0; i < 8; i++) {
            contentpane.add(character[i]);
            contentpane.add(radio_but[i]);
        }
        
        radio_but[0].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    JRadioButton temp = (JRadioButton) e.getItem();
                    if (temp.isSelected()) {
                        selected = 0;
                    }
                    validate();
                }
        });
        radio_but[1].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    JRadioButton temp = (JRadioButton) e.getItem();
                    if (temp.isSelected()) {
                        selected = 1;
                    }
                    validate();
                }
        });
        radio_but[2].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    JRadioButton temp = (JRadioButton) e.getItem();
                    if (temp.isSelected()) {
                        selected = 2;
                    }
                    validate();
                }
        });
        radio_but[3].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    JRadioButton temp = (JRadioButton) e.getItem();
                    if (temp.isSelected()) {
                        selected = 3;
                    }
                    validate();
                }
        });
        radio_but[4].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    JRadioButton temp = (JRadioButton) e.getItem();
                    if (temp.isSelected()) {
                        selected = 4;
                    }
                    validate();
                }
        });
        radio_but[5].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    JRadioButton temp = (JRadioButton) e.getItem();
                    if (temp.isSelected()) {
                        selected = 5;
                    }
                    validate();
                }
        });
        radio_but[6].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    JRadioButton temp = (JRadioButton) e.getItem();
                    if (temp.isSelected()) {
                        selected = 6;
                    }
                    validate();
                }
        });
        radio_but[7].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    JRadioButton temp = (JRadioButton) e.getItem();
                    if (temp.isSelected()) {
                        selected = 7;
                    }
                    validate();
                }
        });
        
        next = new JLabel(nextImg);
        next.addMouseListener(new MouseListener(){
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                player.setCharacter(character_dir[selected]);
                System.out.println("User selected "+character_dir[selected]);
                if(wall==null){
                    try {
                        wall = new WallSelect(player);
                    }
                    catch (Exception ex) {
                        Logger.getLogger(MainApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }else wall.setVisible(true);
                setVisible(false);
            }
   
        });

        next.setBounds(0, 0,200 , 200);
        contentpane.add(next);
        contentpane.add(drawpane, BorderLayout.CENTER);
        repaint();
        validate();
    }
}
