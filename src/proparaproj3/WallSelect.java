
package proparaproj3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WallSelect extends JFrame{

    private JPanel      contentpane;
    private JLabel      drawpane;
    private JComboBox   combo;
    private MyImageIcon aladdin, mulan, mermiad, tangled, BG;
    private String [] name = {"Aladdin", "Mulan", "Mermaid", "Tangled"};
    private int frameWidth = 2000, frameHeight = 1000;
    
    public static void main(String[] args) {
        new WallSelect();
    }
    
    public void WallSelect(){
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
        
        drawpane = new JLabel();
        drawpane.setIcon(BG);
        drawpane.setLayout(null);
        
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
                }
            }
        });
        
        contentpane.add(combo);
        contentpane.add(drawpane);
        validate();
        repaint();  
        
    }
    
    
}
