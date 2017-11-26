package proparaproj3;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Credit extends JDialog{
    //components
    private JPanel contentpane;
    private JLabel drawpane;
    private JButton backButton;
    private MyImageIcon credit_bg,gameplayImg[] = new MyImageIcon[5];
    private MyImageIcon backImg;
    private int frameWidth = 1000, frameHeight = 500;
    
    /*public static void main(String[] args) {
        new Credit();
    }*/
    public Credit(){
        //super(owner,"Catch Me : How To Play?",true);
        setTitle("Catch Me : Credit");
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
        credit_bg = new MyImageIcon("picture/wallpaper/credit_bg.gif");
        backImg = new MyImageIcon("picture/button/backward.png").resize(60,60);

        drawpane = new JLabel();
        drawpane.setIcon(credit_bg);
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
        contentpane.add(drawpane,BorderLayout.CENTER);
        validate();
        repaint();  
    }
}
