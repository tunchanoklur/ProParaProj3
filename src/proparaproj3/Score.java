package proparaproj3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


public class Score extends JDialog {

    public static void main(String[] args) {
        new Score();
    }
    MainApplication     mainPage;
    GamePlay            gamePage;
    private JPanel      contentpane;
    private JLabel      drawpane;
    private JTextField  userName;
    private JButton     home,play;
    private MyImageIcon BG;
    private int frameWidth = 1000, frameHeight = 500;
    private String      inputName;
    
    public Score(){
        setTitle("Catch Me : Score");
        setBounds(50, 50, frameWidth, frameHeight);
        setResizable(false);
        //setModal(true);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        contentpane = (JPanel)getContentPane();
        contentpane.setLayout(new BorderLayout());
        
        AddComponents();
    }
    public void AddComponents(){
        BG = new MyImageIcon("picture/wallpaper/selectWall.png").resize(frameWidth, frameHeight);
        drawpane = new JLabel();
        drawpane.setIcon(BG);
        drawpane.setLayout(null);
        
        home = new JButton("Home");
        play = new JButton("Play agian");
        home.addMouseListener( new MouseListener(){
            public void mouseClicked(MouseEvent e) {
               mainPage = new MainApplication();
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        play.addMouseListener( new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                /*try {
                    gamePage = new GamePlay();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        userName = new JTextField(15);
        userName.setSize(20, 50);
        userName.setBounds(0, 0, 100, 100);
        userName.setFont(new Font("Courier", Font.BOLD, 30));
	userName.addCaretListener( new CaretListener() {
			public void caretUpdate( CaretEvent e )
			{
				inputName = userName.getText();
                                //System.out.printf(inputName);
			}
		});
        
        home.setBounds(0,60,60,60);
        play.setBounds(60,60,60,100);
        
        JPanel g = new JPanel();
        g.add(userName);
        g.add(home);
        g.add(play);

        contentpane.add(drawpane);
        contentpane.add(g);
        validate();
    }
}
