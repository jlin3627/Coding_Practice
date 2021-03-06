/* TLE
class Solution {
    public int maximumGain(String s, int x, int y) 
    {
        int ans = 0;
        String high = "";
        int hScore = 0;
        String low = "";
        int lScore = 0;
        StringBuilder bs = new StringBuilder(s);
        if (x > y) 
        {
            hScore = x;
            lScore =y;
            high = "ab";
            low = "ba";
        }
        else
        {
            hScore = y;
            lScore =x;
            high = "ba";
            low = "ab";
        }

        while ((bs.indexOf(high) != -1) || (bs.indexOf(low) != -1))
        {
            int idxHigh = bs.indexOf(high);
            int idxLow = bs.indexOf(low);
            
            if (idxHigh!=-1)
            {
                StringBuilder tmp = new StringBuilder(bs.substring(0,idxHigh));
                if (idxHigh+2<s.length()) tmp.append(bs.substring(idxHigh+2));
                bs = tmp;
                ans = ans+hScore;
                //System.out.println(s);
            }
            else if (idxLow!=-1)
            {
                StringBuilder tmp = new StringBuilder(bs.substring(0,idxLow));
                if (idxLow+2<bs.length()) tmp.append(bs.substring(idxLow+2));
                bs = tmp;
                ans = ans+lScore;
                //System.out.println(s);
            }
        }
        return ans;
    }
}

*/

public int maximumGain(String s, int x, int y) {
	Stack<Character> stack = new Stack<>(), stack2 = new Stack<>();
	int result = 0, max=Math.max(x,y), min =Math.min(x,y);
	char first= (x>y)?'a':'b', second=(x>y)?'b':'a';
	for(char c: s.toCharArray()) 
		if(!stack.isEmpty() && stack.peek() == first && c == second) {
			stack.pop(); 
			result +=max;
		} else stack.push(c);
	while(!stack.isEmpty()) {
		char c = stack.pop();
		if(!stack2.isEmpty() && stack2.peek() == first && c == second) {
			stack2.pop(); 
			result +=min;
		} else stack2.push(c);
	}
	return result;
}

class Solution {
    public int maximumGain(String s, int x, int y) {
        Deque<Character> stack = new ArrayDeque<>();
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c != 'a' && c != 'b') {
                int a = 0;
                int b = 0;
                for (char ch : stack) if (ch == 'a') a++; else b++;
                stack.clear();
                ans += Math.min(a, b) * Math.min(x, y);
            } else if (c == 'a') {
                if (x >= y) stack.addLast(c);
                else {
                    if (!stack.isEmpty() && stack.peekLast() == 'b') {
                        stack.removeLast();
                        ans += y;
                    } else stack.addLast(c);
                }
            } else {
                if (x < y) stack.addLast(c);
                else {
                    if (!stack.isEmpty() && stack.peekLast() == 'a') {
                        stack.removeLast();
                        ans += x;
                    } else stack.addLast(c);
                }
            }
        }
        int a = 0;
        int b = 0;
        for (char ch : stack) if (ch == 'a') a++; else b++;
        stack.clear();
        ans += Math.min(a, b) * Math.min(x, y);
        return ans;
    }
}