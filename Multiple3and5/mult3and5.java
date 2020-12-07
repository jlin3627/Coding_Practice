import java.util.*;

public class mult3and5
{
    public static long findMult(int a, int b, int limit)
    {
        long ans = 0;
        Set<Integer> st = new HashSet<Integer>();
        for (int i = 1; a*i<limit; i++)
        {
            st.add(a*i);
        }
        for (int j = 1; j*b<limit; j++)
        {
            st.add(b*j);
        }
        for (int test:st)
        {
            //System.out.println(ans);
            ans+=test;
        }
        return ans;
    }

    public static void main(String args[])
    {
        long answer = findMult(3,5,1000);
        System.out.println(answer);   
    }
}