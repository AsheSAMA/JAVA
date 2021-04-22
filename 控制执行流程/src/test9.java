public class test9 {
    public static void main(String[] args){
        int[] arr=new int[Integer.parseInt(args[0])];
        arr[0]=1;arr[1]=1;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        for(int i=2;i<Integer.parseInt(args[0]);i++){
            System.out.println(arr[i]=arr[i-1]+arr[i-2]);
        }
    }
}
