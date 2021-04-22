public class test6 {
    static int test(int testval, int target,int begin,int end) {
        if (testval>end||testval<begin){System.out.print("超过范围结果为： ");return 0;}
        if(testval > target)
            return +1;
        else if(testval < target)
            return -1;
        else
            return 0; // Match
    }
    public static void main(String[] args) {
        System.out.println(test(10, 5,1,100));
        System.out.println(test(5, 10,1,100));
        System.out.println(test(5, 5,1,100));
        System.out.println(test(101, 5,1,100));
    }
}


