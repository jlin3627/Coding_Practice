class Solution {

    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[n * 2 - 1];
        boolean[] visited = new boolean[n + 1];
        calc(0, ans, visited, n);
        return ans;
    }

    private boolean calc(int index, int[] ans, boolean[] visited, int n) {
        if (index == ans.length) {
            return true;
        }
        if (ans[index] != 0) return calc(index + 1, ans, visited, n); // value already assigned in this position. So go ahead with the next index.
        else {
            // we start from n to 1 since we need to find out the lexicographically largest sequence.
            for (int i = n; i >= 1; i--) {
                if (visited[i]) continue;
                visited[i] = true;
                ans[index] = i;
                if (i == 1) {
                    if (calc(index + 1, ans, visited, n)) return true;
                } else if (index + i < ans.length && ans[index + i] == 0) {
                    ans[i + index] = i; // assigning the second occurence of i in the desired position i.e, (current index + i )
                    if (calc(index + 1, ans, visited, n)) return true; // largest possible sequence satisfying the given conditions found.
                    ans[index + i] = 0;
                }
                ans[index] = 0;
                visited[i] = false;
            }

        }
        return false;
    }
}


class Solution {
    public boolean solve(List<Integer> curr, int i, boolean[] left) {
        if (i == curr.size()) {
            return true;
        }
        if (curr.get(i) != 0) {
            return solve(curr, i+1, left);
        }
        for (int e = left.length-1; e >= 1; e--) {
            if (!left[e]) {
                continue;
            }
            left[e] = false;
            if (e != 1 && i+e < curr.size() && curr.get(i+e) == 0) {
                curr.set(i, e);
                curr.set(i+e, e);
                if (solve(curr, i+1, left)) {
                    return true;
                }
                curr.set(i, 0);
                curr.set(i+e, 0);
            } else if (e == 1) {
                curr.set(i, e);
                if (solve(curr, i+1, left)) {
                    return true;
                }
                curr.set(i, 0);
            }
            left[e] = true;
        }
        return false;
    }
    
    public List<Integer> constructDistancedSequence(int n) {
        ArrayList<Integer> curr = new ArrayList<>();
        boolean[] left = new boolean[n+1];
        Arrays.fill(left, true);
        for (int i = 0; i < n*2-1; i++) {
            curr.add(0);
        }
        solve(curr, 0, left);
        return curr;
    }
}

/* not work

class Solution {
    public int[] constructDistancedSequence(int n) 
    {
        int[] ans = new int[n*2-1];
        if (n==5)
        {
            ans[n/2] = 1;
        }
        
        for (int i = n; i>1;i-=2)
        {
            int j = 0;
            while (j+i<n*2-1 && (ans[j] !=0 || ans[j+i]!=0))
            {
                j++;
            }
            if (j+i!=n*2-1)
            {
                ans[j] = i;
                ans[j+i] = i;
            }
        }
        
        for (int i = n-1; i>1;i-=2)
        {
            int j = 0;
            while (j+i<n*2-1 && (ans[j] !=0 || ans[j+i]!=0))
            {
                j++;
            }
            if (j+i!=n*2-1)
            {
                ans[j] = i;
                ans[j+i] = i;
            }
        }
        for (int i = 0; i<n*2-1;i++)
        {
            if (ans[i] == 0) 
            {
                ans[i] = 1;
                break;
            }
        }
        return ans;
    }
}*/