// https://interviewing.io/recordings/Java-Facebook-2

import java.util.*;


public class generatePow2
{
    public void generatePow2(int n)
    {
        Queue<String> que = new LinkedList<String>();

        que.add("0");
        que.add("1");

        while (n-- > 0)
        {
            String s1 = que.peek();
            que.remove();
            System.out.println(s1);

            String s2 = s1;
            que.add(s1 + "0");
            que.add(s2 + "1");
        }
    }

    private static void generatePow(int n)
    {
        Queue<String> que = new LinkedList<String>();

        que.add("0");
        que.add("1");

        while (n-- > 0)
        {
            String s1 = que.peek();
            que.remove();
            System.out.println(s1);

            String s2 = s1;
            que.add(s1 + "0");
            que.add(s2 + "1");
        }
    }

    public static void main(String args[])
    {
        generatePow2 test = new generatePow2();
        test.generatePow2(100);
        generatePow(100);
    }
}