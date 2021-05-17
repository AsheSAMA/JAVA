public class Test19 {
    public static void main(String[] args){
        Show("a","b","c","d");
    }
    static void Show(String...args){
        for (String s: args) {
            System.out.print(s+" ");
        }
    }

}
