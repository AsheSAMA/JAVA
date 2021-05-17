import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.io.File;
public class StatisticFrame extends Frame implements ActionListener{
    WordStatistic statistic;
    TextArea showMessage;
    Button openFile;
    FileDialog  openFileDialog;
    Vector allWord,noSameWord;
    public StatisticFrame( ){
        statistic=new WordStatistic();
        showMessage=new TextArea();
        openFile=new Button("Open File");
        openFile.addActionListener(this);
        add(openFile,BorderLayout.NORTH);
        add(showMessage,BorderLayout.CENTER);
        openFileDialog=new FileDialog(this,"打开文件话框",FileDialog.LOAD);
        allWord=new Vector();
        noSameWord=new Vector();
        setSize(350,300);
        setVisible(true);

        addWindowListener(new WindowAdapter( ){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        validate();
    }
    public void actionPerformed(ActionEvent e){
        noSameWord.clear();
        allWord.clear();
        showMessage.setText(null);
        openFileDialog.setVisible(true);
        String fileName=openFileDialog.getFile();
        if(fileName!=null){
            statistic.wordStatistic(new File(fileName));
            allWord=statistic.getAllWorsd();
            noSameWord=statistic.getNoSameWord();
            showMessage.append("\n"+fileName+"中有"+allWord.size()+"个英文单词");
            showMessage.append("\n其中有"+noSameWord.size()+"个互不相同英文单词");
            showMessage.append("\n按使用频率排列：\n");
            int count[]=new int[noSameWord.size()];
            for(int i=0;i<noSameWord.size();i++){
                String s1=(String)noSameWord.elementAt(i);
                for(int j=0;j<allWord.size();j++){
                    String s2=(String)allWord.elementAt(j);
                    if(s1.equals(s2))
                        count[i]++;
                }
            }
            for(int m=0;m<noSameWord.size();m++){
                for(int n=m+1;n<noSameWord.size();n++){
                    if(count[n]>count[m]){
                        String temp=(String)noSameWord.elementAt(m);
                        noSameWord.setElementAt((String)noSameWord.elementAt(n),m);
                        noSameWord.setElementAt(temp,n);
                        int t=count[m];
                        count[m]=count[n];
                        count[n]=t;
                    }
                }
            }
            for(int m=0;m<noSameWord.size();m++){
                showMessage.append("\n"+(String)noSameWord.elementAt(m)+
                        ":"+count[m]+"/"+allWord.size()+
                        "="+(1.0*count[m])/allWord.size());
            }
        }
    }
}
