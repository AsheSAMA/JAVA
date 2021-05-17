import java.io.*;
import java.util.Vector;
public class WordStatistic{
    Vector allWorsd,noSameWord;
    WordStatistic(){
        allWorsd=new Vector();
        noSameWord=new Vector();
    }
    public void wordStatistic(File file){
        try{
            RandomAccessFile inOne=new RandomAccessFile(file,"r");       //创建指向文件file的inOne 的对象
            RandomAccessFile inTwo=new RandomAccessFile(file,"r");         //创建指向文件file的inTwo 的对象
            long wordStarPostion=0,wordEndPostion=0;
            long length=inOne.length();
            int flag=1;
            int c=-1;
            for(int k=0;k<=length;k++){
                c=inOne.read();        // inOne调用read()方法
                boolean boo=(c<='Z'&&c>='A')||(c<='z'&&c>='a');
                if(boo){
                    if(flag==1){
                        wordStarPostion=inOne.getFilePointer()-1;
                        flag=0;
                    }
                }
                else{
                    if(flag==0){
                        if(c==-1)
                            wordEndPostion=inOne.getFilePointer();
                        else
                            wordEndPostion=inOne.getFilePointer()-1;
                 inTwo.seek(wordStarPostion);// inTwo调用seek方法将读写位置移动到wordStarPostion
                        byte cc[]=new byte[(int)wordEndPostion-(int)wordStarPostion];
                 inTwo.readFully(cc);// inTwo调用readFully(byte a)方法，向a传递cc
                        String word=new String(cc);
                        allWorsd.add(word);
                        if(!(noSameWord.contains(word)))
                            noSameWord.add(word);
                    }
                    flag=1;
                }
            }
            inOne.close();
            inTwo.close();
        }
        catch(Exception e){}
    }
    public Vector getAllWorsd(){
        return allWorsd;
    }
    public Vector getNoSameWord(){
        return noSameWord;
    }
}
