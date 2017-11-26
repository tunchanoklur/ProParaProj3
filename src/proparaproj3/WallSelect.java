
package proparaproj3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class WallSelect extends JFrame{

    Level               levelPage;

    private JPanel      contentpane;
    private JLabel      drawpane;
    private JLabel      next;
    private JComboBox   combo;
    private JList       musicList;
    private MyImageIcon aladdin, mulan, mermiad, tangled, toys;
    private MyImageIcon BG, nextPage;
    private SoundEffect   alaSong, muSong, merSong, tangSong, toySong,cur_song;
    private String [] name = {"Aladdin", "Mulan", "Mermaid", "Tangled", "Toy Story"};
    private int frameWidth = 2000, frameHeight = 1000;
    
    public static void main(String[] args) {
        new WallSelect();
    }
    
    public WallSelect(){
        setTitle("Select Wallpaper");
        setBounds(0, 0, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        
        AddComponents();
    }
    
    public void AddComponents(){
        BG = new MyImageIcon("picture/wallpaper/selectWall.png").resize(frameWidth,frameHeight);
        nextPage = new MyImageIcon("picture/button/forward.png").resize(200,200);
        aladdin = new MyImageIcon("picture/wallpaper/aladin_wall.png").resize(frameWidth,frameHeight);
        mulan = new MyImageIcon("picture/wallpaper/mulan_wall.png").resize(frameWidth,frameHeight);
        mermiad = new MyImageIcon("picture/wallpaper/arial_wall.png").resize(frameWidth,frameHeight);
        tangled = new MyImageIcon("picture/wallpaper/tangled_wall.png").resize(frameWidth,frameHeight);
        toys = new MyImageIcon("picture/wallpaper/option_wall.png").resize(frameWidth,frameHeight);
        
        alaSong = new SoundEffect("sound/aladin.wav");
        muSong = new SoundEffect("sound/mulan.wav");
        merSong = new SoundEffect("sound/mermaid.wav");
        tangSong = new SoundEffect("sound/tangled.wav");
        toySong = new SoundEffect("sound/toystory.wav");

        next = new JLabel(nextPage);
        next.addMouseListener(new MouseListener(){
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                if(levelPage==null){
                    try {
                        levelPage = new Level();
                    }
                    catch (Exception ex) {
                        Logger.getLogger(MainApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else levelPage.setVisible(true);
                setVisible(false);
            }
   
        });
        drawpane = new JLabel();
        drawpane.setIcon(BG);
        drawpane.setLayout(null);
        
        musicList = new JList(name);
        musicList.setVisibleRowCount(5);
        musicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        musicList.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {
              if( !e.getValueIsAdjusting()){
                  if(cur_song!=null)cur_song.stop();
                  switch (musicList.getSelectedIndex()) {
                      case 0:
                          cur_song=alaSong;
                          break;
                      case 1:
                          cur_song=muSong;
                          break;
                      case 2:
                          cur_song=merSong;
                          break;
                      case 3:
                          cur_song=tangSong;
                          break;
                      case 4:
                          cur_song=toySong;
                          break;
                      default:
                          break;
                  }
                cur_song.playOnce();
            }
            }
        });
        
        combo = new JComboBox(name);
        combo.addItemListener( new ItemListener() {
            public void itemStateChanged( ItemEvent e )
            {
                if(combo.getSelectedIndex()==0){
                    drawpane.setIcon(aladdin);
                }else if(combo.getSelectedIndex()==1){
                    drawpane.setIcon(mulan);
                }else if(combo.getSelectedIndex()==2){
                    drawpane.setIcon(mermiad);
                }else if(combo.getSelectedIndex()==3){
                    drawpane.setIcon(tangled);
                }else if(combo.getSelectedIndex()==4){
                    drawpane.setIcon(toys);
                }
            }
        });

        next.setBounds(800,500,400,200);
        contentpane.add(next);
        musicList.setBounds(0, 0, 200, 210);
        musicList.setFont(new Font("Courier", Font.BOLD, 30));
        combo.setFont(new Font("Courier", Font.BOLD, 30));
        combo.setSize(combo.getWidth(),combo.getHeight());
        combo.setBounds(1730,0,200,100);
        contentpane.add(musicList);
        contentpane.add(combo);
        contentpane.add(drawpane);
        validate();
        repaint();  
        
    }
  
}
