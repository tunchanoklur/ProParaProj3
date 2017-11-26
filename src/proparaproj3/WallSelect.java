
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

    private JPanel      contentpane;
    private JLabel      drawpane;
    private JComboBox   combo;
    private JList       musicList;
    private MyImageIcon aladdin, mulan, mermiad, tangled, toys, BG;
    private MySoundEffect   alaSong, muSong, merSong, tangSong, toySong;
    private String [] name = {"Aladdin", "Mulan", "Mermaid", "Tangled", "Toy Story"};
    private int frameWidth = 2000, frameHeight = 1000;
    
    public static void main(String[] args) {
        new WallSelect();
    }
    
    public WallSelect(){
        setTitle("Select Wallpaper");
        setBounds(50, 50, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        
        AddComponents();
    }
    
    public void AddComponents(){
        BG = new MyImageIcon("picture/wallpaper/selectWall.png").resize(frameWidth,frameHeight);
        aladdin = new MyImageIcon("picture/wallpaper/aladin_wall.png").resize(frameWidth,frameHeight);
        mulan = new MyImageIcon("picture/wallpaper/mulan_wall.png").resize(frameWidth,frameHeight);
        mermiad = new MyImageIcon("picture/wallpaper/arial_wall.png").resize(frameWidth,frameHeight);
        tangled = new MyImageIcon("picture/wallpaper/tangled_wall.png").resize(frameWidth,frameHeight);
        toys = new MyImageIcon("picture/wallpaper/option_wall.png").resize(frameWidth,frameHeight);
        
        alaSong = new MySoundEffect("sound/aladin.wav");
        muSong = new MySoundEffect("sound/mulan.wav");
        merSong = new MySoundEffect("sound/mermaid.wav");
        tangSong = new MySoundEffect("sound/tangled.wav");
        toySong = new MySoundEffect("sound/toystory.wav");

        drawpane = new JLabel();
        drawpane.setIcon(BG);
        drawpane.setLayout(null);
        
        musicList = new JList(name);
        musicList.setVisibleRowCount(5);
        musicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        musicList.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {
              if( !e.getValueIsAdjusting()){  
                if(musicList.getSelectedIndex()==0){
                    alaSong.playOnce();
                }else if(musicList.getSelectedIndex()==1){
                    muSong.playOnce();
                }else if(musicList.getSelectedIndex()==2){
                    merSong.playOnce();
                }else if(musicList.getSelectedIndex()==3){
                    tangSong.playOnce();
                }else if(musicList.getSelectedIndex()==4){
                    toySong.playOnce();
                }
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

        musicList.setSize(musicList.getWidth(),musicList.getHeight());
        musicList.setBounds(0, 0, 400, 600);
        combo.setFont(new Font("Courier", Font.BOLD, 30));
        combo.setSize(combo.getWidth(),combo.getHeight());
        combo.setBounds(1500,0,400,600);
        contentpane.add(new JScrollPane(musicList));
        contentpane.add(combo);
        contentpane.add(drawpane);
        validate();
        repaint();  
        
    }
    
    
}
class MySoundEffect
{
	private java.applet.AudioClip audio;

	public MySoundEffect(String filename)
	{
		try
		{
			java.io.File file = new java.io.File(filename);
			audio = java.applet.Applet.newAudioClip(file.toURL());

		}
		catch (Exception e) { e.printStackTrace(); }
	}
	public void playOnce()   { audio.play(); }
	public void playLoop()   { audio.loop(); }//play in loop
	public void stop()       { audio.stop(); }
}