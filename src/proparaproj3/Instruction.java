package proparaproj3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Instruction extends JDialog{
    //components
    final private JPanel contentpane;
    private JLabel drawpane;
    private JLabel LRbutton,Bomb,Time,Shock,Slot;
    private JButton backButton;
    private MyImageIcon instruction_bg,gameplayImg[] = new MyImageIcon[5];
    private MyImageIcon backImg;
    final private int frameWidth = 1000, frameHeight = 500;
    
    /*public static void main(String[] args) {
        new Instruction();
    }*/
    public Instruction(){
        //super(owner,"Catch Me : How To Play?",true);
        setTitle("Catch Me : How To Play?");
        setBounds(50, 50, frameWidth, frameHeight);
        setResizable(false);
        //setModal(true);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        contentpane = (JPanel)getContentPane();
        contentpane.setLayout(new BorderLayout());
        
        AddComponents();
    }
    public void AddComponents() {
        instruction_bg = new MyImageIcon("picture/wallpaper/ins_1.png").resize(frameWidth,frameHeight);
        backImg = new MyImageIcon("picture/button/backward.png").resize(60,60);
        gameplayImg[0] = new MyImageIcon("picture/button/LRbutton.gif");
       /* for(int i=1;i<4;i++)
        {
            gameplayImg[i] = new MyImageIcon("picture/tsum/special"+i+".gif");
        }
        /*gameplayImg[0] = new MyImageIcon("picture/button/LRbutton.gif");*/
       
        gameplayImg[1] = new MyImageIcon("picture/tsum/special0.gif");
        gameplayImg[2] = new MyImageIcon("picture/tsum/hourg_1.gif");
        gameplayImg[3] = new MyImageIcon("picture/tsum/special2.gif");
        gameplayImg[4] = new MyImageIcon("picture/tsum/slot_3.gif");
        //gameplayImg[4] = new MyImageIcon("picture/tsum/tsum_time.png").resize(75,91);
        
        
        LRbutton = new JLabel(gameplayImg[0]);
        Bomb = new JLabel(gameplayImg[1]);
        Time = new JLabel(gameplayImg[2]);
        Shock = new JLabel(gameplayImg[3]);
        Slot = new JLabel(gameplayImg[4]);
        
        drawpane = new JLabel();
        drawpane.setIcon(instruction_bg);
        drawpane.setLayout(null);
        
        backButton = new JButton(backImg);
        backButton.addMouseListener( new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        backButton.setBounds(0,0,60,60);
        contentpane.add(backButton);
        LRbutton.setBounds(395,100,200,92);
        contentpane.add(LRbutton);
        Bomb.setBounds(535,345,106,122);
        contentpane.add(Bomb);
        Slot.setBounds(200,238,100,100);
        contentpane.add(Slot);
        Time.setBounds(470,238,200,92);
        contentpane.add(Time);
        Shock.setBounds(865,130,150,126);
        contentpane.add(Shock);
        contentpane.add(drawpane,BorderLayout.CENTER);
        validate();
        repaint();  
    }
}
