
package proparaproj3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class WallSelect extends JFrame{

    Tier               tierPage;

    private JPanel      contentpane;
    private JLabel      drawpane;
    private JLabel      next, soundIcon, wallIcon;
    private JComboBox   combo;
    private JList       musicList;
    private MyImageIcon aladdin, mulan, mermiad, tangled, toys;
    private MyImageIcon BG, nextPage, soundImg, wallImg;
    private SoundEffect   alaSong, muSong, merSong, tangSong, toySong,cur_song = new SoundEffect("sound/toystory.wav");
    private String [] name = {"Aladdin", "Mulan", "Mermaid", "Tangled", "Toy Story"};
    private int frameWidth = 2000, frameHeight = 1000;
    
    /*public static void main(String[] args) {
        new WallSelect();
    }*/
    
    public WallSelect(PlayerInfo player){
        setTitle("Select Wallpaper");
        setBounds(0, 0, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        
        AddComponents(player);
    }
    
    public void AddComponents(PlayerInfo player){
        BG = new MyImageIcon("picture/wallpaper/selectWall.png").resize(frameWidth,frameHeight);
        nextPage = new MyImageIcon("picture/button/forward.png").resize(200,200);
        soundImg = new MyImageIcon("picture/button/sound.png");//.resize(240,120);
        wallImg = new MyImageIcon("picture/button/wall.png");//.resize(300,150);
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
                if(tierPage==null){
                    try {
                        cur_song.stop();
                        tierPage = new Tier(player);
                    }
                    catch (Exception ex) {
                        Logger.getLogger(MainApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else tierPage.setVisible(true);
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
                player.setThemesong(cur_song);
                cur_song.playOnce();
            }
            }
        });
        
        combo = new JComboBox(name);
        combo.setSelectedIndex(-1);
        combo.addItemListener( new ItemListener() {
            public void itemStateChanged( ItemEvent e )
            {
                switch (combo.getSelectedIndex()) {
                    case 0:
                        drawpane.setIcon(aladdin);
                        player.setBackground(aladdin);
                        break;
                    case 1:
                        drawpane.setIcon(mulan);
                        player.setBackground(mulan);
                        break;
                    case 2:
                        drawpane.setIcon(mermiad);
                        player.setBackground(mermiad);
                        break;
                    case 3:
                        drawpane.setIcon(tangled);
                        player.setBackground(tangled);
                        break;
                    case 4:
                        drawpane.setIcon(toys);
                        player.setBackground(toys);
                        break;
                    default:
                        break;
                }
            }
        });

        soundIcon = new JLabel(soundImg);
        soundIcon.setBounds(0, 0, 200, 200);
        wallIcon = new JLabel(wallImg);
        wallIcon.setBounds(1700,0, 200, 200);
        next.setBounds(1600,750,400,200);
        musicList.setBounds(0, 200, 200, 210);
        musicList.setFont(new Font("Courier", Font.BOLD, 30));
        combo.setFont(new Font("Courier", Font.BOLD, 30));
        combo.setSize(combo.getWidth(),combo.getHeight());
        combo.setBounds(1700,200,200,100);
        contentpane.add(next);
        contentpane.add(soundIcon);
        contentpane.add(wallIcon);
        contentpane.add(musicList);
        contentpane.add(combo);
        contentpane.add(drawpane);
        validate();
        repaint();  
        
    }
  
}
