public class test12 {
    public static void main(String[] args) {
        int a = -1;
        System.out.println(Integer.toBinaryString(a));
        a <<= 10;
        System.out.println(Integer.toBinaryString(a));
        for (int i = 0; a != 0; i++) {
            a >>>= 1;
            System.out.println(Integer.toBinaryString(a));
        }
    }
}
