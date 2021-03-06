import java.util.*;

public class fibTest 
{
    public static void main(String[] args)
    {
        fib fb = new fib();
        System.out.println(fb.fib(2));
        System.out.println(fb.fib(3));
        System.out.println(fb.fib(6));
        System.out.println(fb.fib(30));
        //System.out.println(fb.fib(50, new HashMap<Integer,Long>()));

        System.out.println(fb.fibM(2, new HashMap<Integer,Long>()));
        System.out.println(fb.fibM(3, new HashMap<Integer,Long>()));
        System.out.println(fb.fibM(6, new HashMap<Integer,Long>()));
        System.out.println(fb.fibM(30, new HashMap<Integer,Long>()));
        System.out.println(fb.fibM(50, new HashMap<Integer,Long>()));

        System.out.println(fb.fibA(2, new long[2]));
        System.out.println(fb.fibA(3, new long[3]));
        System.out.println(fb.fibA(6, new long[6]));
        System.out.println(fb.fibA(30, new long[30]));
        System.out.println(fb.fibA(50, new long[50]));
    }    
}
