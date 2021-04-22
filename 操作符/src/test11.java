public class test11 {
    public static void main(String[] args){
        int a =0x213;
        System.out.println(Integer.toBinaryString(a));
        for(int i=0;a!=0;i++){
            a>>>=1;
            System.out.println(Integer.toBinaryString(a));
        }

    }
}
