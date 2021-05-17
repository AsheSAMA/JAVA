import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;
public class StudyFrame extends JFrame implements ItemListener,ActionListener,Runnable{
    ChineseCharacters chinese;
    Choice choice;
    JButton getCharacters,voiceCharacters;
    JLabel showCharacters;
    StringBuffer trainedChinese=null;
    Clip clip=null;
    Thread voiceThread;
    int k=0;
    JPanel pCenter;
    CardLayout mycard;
    JTextArea textHelp;
    JMenuBar menubar;
    JMenu menu;
    JMenuItem help;
    public StudyFrame( ){
        chinese=new ChineseCharacters();
        choice=new Choice();
        choice.add("training1.txt");
        choice.add("training2.txt");
        choice.add("training3.txt");
        showCharacters=new JLabel("",SwingConstants.CENTER);
        showCharacters.setFont(new Font("宋体",Font.BOLD,72));
        showCharacters.setBackground(Color.green);
        getCharacters=new JButton("下一个汉字");
        voiceCharacters=new JButton("发音");
        voiceThread=new Thread(this);
        choice.addItemListener(this);
        voiceCharacters.addActionListener(this);
        getCharacters.addActionListener(this);
        JPanel pNorth=new JPanel();
        pNorth.add(new JLabel("选择一个汉字字符组成的文件"));
        pNorth.add(choice);
        add(pNorth,BorderLayout.NORTH);
        JPanel pSouth=new JPanel();
        pSouth.add(getCharacters);
        pSouth.add(voiceCharacters);
        add(pSouth,BorderLayout.SOUTH);
        pCenter=new JPanel();
        mycard=new CardLayout();
        pCenter.setLayout(mycard);
        textHelp=new JTextArea();
        pCenter.add("hanzi",showCharacters);
        pCenter.add("help",textHelp);
        add(pCenter,BorderLayout.CENTER);
        menubar=new JMenuBar();
        menu=new JMenu("帮助");
        help=new JMenuItem("关于学汉字");
        help.addActionListener(this);
        menu.add(help);
        menubar.add(menu);
        setJMenuBar(menubar);
        setSize(350,220);
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        validate();
    }
    public void itemStateChanged(ItemEvent e){
        String fileName=choice.getSelectedItem( );
        File file=new File(fileName);
        trainedChinese=chinese.getChinesecharacters(file);
        k=0;
        mycard.show(pCenter,"hanzi") ;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==getCharacters){
            if(trainedChinese!=null){
                char c=trainedChinese.charAt(k);
                k++;
                if(k>=trainedChinese.length())
                    k=0;
                showCharacters.setText(""+c);
            }
            else{
                showCharacters.setText("请选择一个汉字字符文件");
            }
        }
        if(e.getSource()==voiceCharacters){
            if(!(voiceThread.isAlive())){
                voiceThread=new Thread(this);
            }
            try{
                voiceThread.start();
            }
            catch(Exception exp){ }
        }
        if(e.getSource()==help){
            mycard.show(pCenter,"help") ;
            try{
                File helpFile=new File("help.txt");
                FileReader  inOne=new FileReader(helpFile);      //创建指向文件helpFile的inOne 的对象
                BufferedReader inTwo=new BufferedReader(inOne);   //创建指向文件inOne的inTwo 的对象
                String s=null;
                while((s=inTwo.readLine())!=null){
                    textHelp.append(s+"\n");
                }
                inOne.close();
                inTwo.close();
            }
            catch(IOException exp){ }
        }
    }
    public void run(){
        voiceCharacters.setEnabled(false);
        try{
            if(clip!=null){
                clip.close();
            }
            clip=AudioSystem.getClip();
            File voiceFile=new File(showCharacters.getText().trim()+".wav");
            clip.open(AudioSystem.getAudioInputStream(voiceFile));
        }
        catch(Exception exp){  }
        clip.start();
        voiceCharacters.setEnabled(true);
    }
}
