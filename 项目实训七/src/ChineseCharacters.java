import java.io.*;
import java.util.StringTokenizer;
public class ChineseCharacters{
    public StringBuffer getChinesecharacters(File file){
        StringBuffer hanzi=new StringBuffer();
        try{
            FileReader  inOne=new FileReader(file);     //创建指向文件f的inOne 的对象
            BufferedReader inTwo=new BufferedReader(inOne);  //创建指向文件inOne的inTwo的对象
            String s=null;
            int i=0;
            while((s=inTwo.readLine())!=null){       //inTwo读取一行
                StringTokenizer tokenizer=new StringTokenizer(s," ,'\n' ");
                while(tokenizer.hasMoreTokens()){
                    hanzi.append(tokenizer.nextToken());
                }
            }
        }
        catch(Exception e){ }
        return hanzi;
    }
}
