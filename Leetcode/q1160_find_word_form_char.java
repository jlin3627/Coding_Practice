
// 16ms
/*class Solution {
    public int countCharacters(String[] words, String chars) 
    {
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        int[] charCount = new int[26];
        int ans = 0;
        for (char c : chars.toCharArray())
        {
            mp.put(c, mp.getOrDefault(c,0) + 1);
        }
        
        for (String w:words)
        {
            charCount = new int[26];
            boolean find = true;
            for (char c:w.toCharArray())
            {
                charCount[c-'a']++;
            }
            
            for (int i = 0; i<26; i++)
            {
                if(charCount[i]>0 )
                {
                    if (!mp.containsKey( (char)('a'+i) ))
                    {
                        //System.out.println( (char)('a'+i) );
                        find = false;
                        break;
                    }
                    else if(mp.get(  (char)('a'+i)  ) < charCount[i])
                    {
                        //System.out.println( (char)('a'+i) );
                        find = false;
                        break;
                    }
                }
            }
            if (find)
            {
                ans+=w.length();
            }
        }
        return ans;
    }
}*/


// 11ms
/*class Solution
{
    public static int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] seen = new int[26];
		//Count char of Chars String
        for (char c : chars.toCharArray())
            seen[c - 'a']++;
		// Comparing each word in words
        for (String word : words) {
			// simple making copy of seen arr
            int[] tSeen = Arrays.copyOf(seen, seen.length); 
            int Tcount = 0;
            for (char c : word.toCharArray()) {
                if (tSeen[c - 'a'] > 0) {
                    tSeen[c - 'a']--;
                    Tcount++;
                }
            }
            if (Tcount == word.length())
                count += Tcount;
        }
        return count;
    }
}*/

// 5ms
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charsMap = new int[26];
        int count = 0;
        for (int i = 0; i < chars.length(); i++) {
            int index = chars.charAt(i) - 97;
            charsMap[index] += 1;
        }
        for (String word : words) {
            int[] copyMap = new int[26];
            for (int i = 0; i < 26; i++) {
                copyMap[i] = charsMap[i];
            }
            boolean formed = true;
            if (word.length() <= chars.length()) {
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 97;
                    if (copyMap[index] == 0) {
                        formed = false;
                        break;
                    } else {
                        copyMap[index] -= 1;
                    }
                }
            } else {
                formed = false;
            }
            if (formed) {
                count += word.length();
            }
        }
        return count;
    }
}