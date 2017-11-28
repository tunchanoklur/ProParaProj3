package proparaproj3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
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
            MainApplication mainPage;
            GamePlay gamePage;
            private JPanel contentpane;
            private JLabel drawpane,NAME,Score_word,Score_points;
            private JTextField userName;
            private JButton home, play;
            private MyImageIcon BG;
            private SoundEffect   readyGo;
            private int frameWidth = 684, frameHeight = 657;
            private String inputName;

            public Score(JFrame Pframe,PlayerInfo player) {
                super(Pframe,"Catch Me : Score",true);
                setBounds(50, 50, frameWidth, frameHeight);
                setResizable(false);
                setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

                contentpane = (JPanel) getContentPane();
                contentpane.setLayout(new BorderLayout());
                contentpane.setBackground(Color.pink);
                
                AddComponents(Pframe,player);
                setVisible(true);
            }

            public void AddComponents(JFrame Pframe,PlayerInfo player) {
                readyGo = new SoundEffect("sound/readyyy.wav");
                BG = new MyImageIcon("picture/wallpaper/star.png").resize(frameWidth, frameHeight);
                drawpane = new JLabel();
                drawpane.setIcon(BG);
                drawpane.setLayout(null);

                home = new JButton("Home");
                
                home.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                        mainPage = new MainApplication();
                        player.PrintToFile();
                        Pframe.dispose();
                        dispose();
                    }
                    public void mousePressed(MouseEvent e) {}
                    public void mouseReleased(MouseEvent e) {}
                    public void mouseEntered(MouseEvent e) {}
                    public void mouseExited(MouseEvent e) {}
                });
                play = new JButton("Play agian");
                play.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                        try {
                            player.PrintToFile();
                            player.setScore(0);
                            player.setName("");
                            Pframe.dispose();
                            readyGo.playOnce();
                            gamePage = new GamePlay(player);
                            dispose();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    public void mousePressed(MouseEvent e) {}
                    public void mouseReleased(MouseEvent e) {}
                    public void mouseEntered(MouseEvent e) {}
                    public void mouseExited(MouseEvent e) {}
                });
                
                Score_word = new JLabel("SCORE");
                Score_word.setBounds(205,130,300,80);
                Score_word.setFont(new Font("Courier", Font.BOLD, 75));
                
                Score_points = new JLabel(Integer.toString( player.giveScore()));
                Score_points.setBounds(265,225,300,110);
                Score_points.setFont(new Font("Courier", Font.BOLD, 140));
                
                NAME = new JLabel("Name:");
                NAME.setBounds(220,345,250,45);
                NAME.setFont(new Font("Courier", Font.BOLD, 45));
                
                userName = new JTextField(15);
                userName.setBounds(220,390,250,80);
                userName.setFont(new Font("Courier", Font.BOLD, 35));
                userName.addCaretListener(new CaretListener() {
                    public void caretUpdate(CaretEvent e){
                        player.setName(userName.getText());
                        System.out.printf(player.giveName());
                    }
                });

                home.setBounds(0, 60, 90, 100);
                play.setBounds(0, 60, 90, 100);

                //drawpane.add(userName);
                JPanel bt = new JPanel(new BorderLayout());
                bt.add(home,BorderLayout.NORTH);
                bt.add(play,BorderLayout.SOUTH);
                drawpane.add(Score_word);
                drawpane.add(Score_points);
                drawpane.add(NAME);
                drawpane.add(userName);
                contentpane.add(drawpane,BorderLayout.CENTER);
                contentpane.add(bt,BorderLayout.SOUTH);
                validate();
            }
        }
