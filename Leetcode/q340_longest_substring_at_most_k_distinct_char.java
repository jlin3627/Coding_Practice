// TLE

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) 
    {
        if (k == 0 || s.length() == 0) return 0;
        int ans = 0;
        int tmp = 0;
        Set<Character> st = new HashSet<>();
        boolean[] checked = new boolean[s.length()];
        for (int i = 0; i<s.length(); i++)
        {
            if (checked[i]) continue;
            for (int j = i; j<s.length();j++)
            {
                char c = s.charAt(j);
                if (st.size()<k)
                {
                    st.add(c);
                    tmp++;
                }
                else
                {
                    if (!st.contains(c))
                    {
                        ans = Math.max(ans,tmp);
                        if (checked[j]) break;
                        tmp = 1;
                        st.clear();
                        st.add(c);
                        checked[j] = true;
                    }
                    else
                    {
                        tmp++;
                    }
                }
            }
            checked[i] = true;
            ans = Math.max(ans,tmp);
            tmp = 0;
            st.clear();
        }
        
        ans = Math.max(ans,tmp);
        return ans;
    }
}


class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];     // there are 256 ASCII characters in the world
        
        int i = 0;  // i will be behind j
        int num = 0;
        int res = 0;
        
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) {    // if count[s.charAt(j)] == 0, we know that it is a distinct character
                num++;
            }
            while (num > k && i < s.length()) {     // sliding window
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0){ 
                    num--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
    }


// sliding window + hashMap
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      int n = s.length();
      if (n*k == 0) return 0;
  
      // sliding window left and right pointers
      int left = 0;
      int right = 0;
      // hashmap character -> its rightmost position 
      // in the sliding window
      HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
  
      int max_len = 1;
  
      while (right < n) {
        // add new character and move right pointer
        hashmap.put(s.charAt(right), right);
        right++;
        // slidewindow contains 3 characters
        if (hashmap.size() == k + 1) {
          // delete the leftmost character
          int del_idx = Collections.min(hashmap.values());
          hashmap.remove(s.charAt(del_idx));
          // move left pointer of the slidewindow
          left = del_idx + 1;
        }
  
        max_len = Math.max(max_len, right - left);
      }
      return max_len;
    }
  }

  // sliding window + ordered dict
  class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      int n = s.length();
      if (n*k == 0) return 0;
  
      // sliding window left and right pointers
      int left = 0;
      int right = 0;
      // hashmap character -> its rightmost position 
      // in the sliding window
      LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(k + 1);
  
      int max_len = 1;
  
      while (right < n) {
        Character character = s.charAt(right);
        // if character is already in the hashmap -
        // delete it, so that after insert it becomes
        // the rightmost element in the hashmap
        if (hashmap.containsKey(character))
          hashmap.remove(character);
        hashmap.put(character, right++);
  
        // slidewindow contains k + 1 characters
        if (hashmap.size() == k + 1) {
          // delete the leftmost character
          Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
          hashmap.remove(leftmost.getKey());
          // move left pointer of the slidewindow
          left = leftmost.getValue() + 1;
        }
  
        max_len = Math.max(max_len, right - left);
      }
      return max_len;
    }
  }

