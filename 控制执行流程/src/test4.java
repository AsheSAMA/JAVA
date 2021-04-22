public class test4 {
    public static void main(String[] args){
        boolean abc=true;
        int i = 10000;
        for (; i > 0; i--) {
            for (int a = 2; a < i; a++) {
                if (i % a == 0) {
                    abc=false;
                    break;
                }
            }
            if(abc==true){System.out.println(i);}
            abc=true;
        }
    }
}
