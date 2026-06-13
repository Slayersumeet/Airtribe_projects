package recursion;

//public class recursion {
//    public static void pi(int n)
//    {
//        if(n==0)
//            return;
//        pi(n-1);
//        System.out.println(n);
//    }
//    public static void main(String[] args){
//        pi(5);
//    }
//}

public class recursion {
    public static int fact(int n){
        if(n==1)
            return 1;
        int r_ans=fact(n-1);
        int my_ans=r_ans*n;
        return my_ans;

    }
    public static void main(String[] args){

        System.out.println(fact(5)
        );

    }
}