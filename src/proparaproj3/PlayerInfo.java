package proparaproj3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

class PlayerInfo implements Comparable<PlayerInfo>{
    private BufferedWriter printer;
    private String name;
    private MyImageIcon character,background;
    private SoundEffect themesong;
    private int level,score;//0easy 1normal 2insane
    public PlayerInfo(){
        try {
            //set default
            printer = new BufferedWriter(new FileWriter("output.txt", true));
        } catch (IOException ex) {
            Logger.getLogger(PlayerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        character = new MyImageIcon("picture/user_icon/user0.png");
        background = new MyImageIcon("picture/wallpaper/option_wall.png");
        themesong= new SoundEffect("sound/toystory.wav");
        level=0;
        score=0;
    }
    public PlayerInfo(String n,String lvl,int s){
        name=n;
        
        if(lvl.compareTo("Easy")==0)level=0;
        else if(lvl.compareTo("Normal")==0)level=1;
        else level = 2;
        
        score=s;
    }
    public void PrintToFile(){
        String lvl;
        switch (level) {
            case 0: lvl="Easy";break;
            case 1: lvl="Normal";break;
            default:lvl="Insane";break;
        }
        String data = name+" "+lvl+" "+score;
        try {
            printer.write(data);
            printer.newLine();
            printer.flush();
        } catch (IOException ex) {
            Logger.getLogger(PlayerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    public void setCharacter(String c){
        character = new MyImageIcon(c);
    }
    public void setBackground(MyImageIcon bg){
        background = bg;
    }
    public void setThemesong(SoundEffect song){
        themesong = song;
    }
    public void setLevel(int lvl){
        level = lvl;
    }
    public void setScore(int s){
        score = s;
    }
    public void setName(String n){
        name = n;
    }
    public int giveLevel(){
        return level;
    }
    public MyImageIcon giveBackground(){
        return background;
    }
    public MyImageIcon giveCharacter(){
        return character;
    }
    public SoundEffect giveThemesong(){
        return themesong;
    }
    public int giveScore(){
        return score;
    }
    public String giveName(){
        return name;
    }

    @Override
    public int compareTo(PlayerInfo other) {
        if(this.score>other.giveScore()) return -1;
        else if(this.score<other.giveScore())return 1;
        else return 0;
    }
}