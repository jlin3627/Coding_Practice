class Solution {
    public int myAtoi(String s) 
    {
        long ans = 0;
        boolean neg = false;
        if (s.length() == 0) return 0;
        int space = 0;
        while (space<s.length() && s.charAt(space) == ' ')
        {
            space++;
        }
        if (space == s.length()) return 0;
        s = s.substring(space);
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
        {
            if ( s.charAt(0) == '-' )neg = true;
            if (s.length()>1)
            {
                s = s.substring(1);
            }
            else
            {
                return 0;
            }
        }
        for (char c:s.toCharArray())
        {
            if (c-'0' >=0 && c-'0'<=9)
            {
                ans = ans*10 + c-'0';
                if (ans>Integer.MAX_VALUE) break;
            }
            else if (c == '.')
            {
                break;
            }
            else
            {
                if (ans != 0) break;
                return 0;
            }
        }
        if (neg) ans = ans * -1;
        if (ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if (ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)ans;
    }
}


class Solution {
    public int myAtoi(String str) {
        int i = 0;
        int sign = 1;
        int result = 0;
        if (str.length() == 0) return 0;

        //Discard whitespaces in the beginning
        while (i < str.length() && str.charAt(i) == ' ')
            i++;

        // Check if optional sign if it exists
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            sign = (str.charAt(i++) == '-') ? -1 : 1;

        // Build the result and check for overflow/underflow condition
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(i++) - '0');
        }
        return result * sign;

    }
}