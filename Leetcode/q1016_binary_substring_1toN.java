class Solution {
    public boolean queryString(String S, int N) 
    {
        for (int i = N; i > N / 2; --i)
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}




/*
class Solution {
    public boolean queryString(String S, int N) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < S.length(); i++){
            for(int j = i + 1; j <= S.length(); j++){
                int v = Integer.parseInt(S.substring(i, j), 2);
                
                if(v > 0 && v <= N){
                    set.add(v);
                } else {
                    break;
                }
            }
        }
        
        return set.size() == N;
    }
}

*/

/*
class Solution {
    public boolean queryString(String S, int N) 
    {
        for (int i = N; i > 0; --i)
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}

*/