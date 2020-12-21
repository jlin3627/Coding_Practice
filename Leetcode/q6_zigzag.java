/*class Solution {
    public String convert(String s, int numRows) 
    {
        if (numRows == 1) return s;
        List< List<Character> > lst = new LinkedList<List<Character>>();
        for (int i = 0; i<numRows; i++)
        {
            lst.add(new LinkedList<Character>());
        }
        int i = 0;
        int j = numRows;
        int loc = 0;
        for (char c:s.toCharArray())
        {
            if (loc == j)
            {
                if (i%(numRows-1) == 0)
                {
                    j = numRows;
                    loc = 0;
                }
                else
                {
                    j = 0;
                    loc = numRows - 2;
                }
                
            }
            if (j == numRows)
            {
               lst.get(loc).add(c);
                loc++; 
                if (loc == j)
                {
                    i++;
                }
            }
            else
            {
                lst.get(loc).add(c);
                loc--;
                i++;
            }
        }
        String ans = "";
        for (i = 0; i<lst.size();i++)
        {
            for (j=0;j<lst.get(i).size();j++)
            {
                ans = ans+lst.get(i).get(j);
            }
        }
        return ans;
    }
}*/

/*class Solution 
{
    public String convert(String s, int numRows) 
    {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) 
        {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}*/

/*class Solution 
{
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}*/

/*public String convert(String s, int nRows) 
{
    char[] c = s.toCharArray();
    int len = c.length;
    StringBuffer[] sb = new StringBuffer[nRows];
    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
    
    int i = 0;
    while (i < len) {
        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
            sb[idx].append(c[i++]);
        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
            sb[idx].append(c[i++]);
    }
    for (int idx = 1; idx < sb.length; idx++)
        sb[0].append(sb[idx]);
    return sb[0].toString();
}*/

