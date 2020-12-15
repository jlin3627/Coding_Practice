class Solution
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        
        Map<String, List<String>> allComboMap = new HashMap();
        
        for(String wrd : wordList)
        {
            for (int i = 0; i<wrd.length(); i++)
            {
                String newWord = wrd.substring(0,i) + '*' + wrd.substring(i+1);
                List<String> trans = allComboMap.getOrDefault(newWord, new ArrayList<>());
                trans.add(wrd);
                allComboMap.put(newWord,trans);
            }
        }
        
        Queue<Pair<String, Integer>> que = new LinkedList<>();
        que.add(new Pair(beginWord,1));
        
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        
        while (!que.isEmpty())
        {
            Pair<String, Integer> check = que.poll();
            String word = check.getKey();
            int count = check.getValue();
            for (int i = 0; i<word.length(); i++)
            {
                String newWord = word.substring(0,i) + '*' + word.substring(i+1);
                for (String adjWord : allComboMap.getOrDefault(newWord, new ArrayList<>()))
                {
                    if (adjWord.equals(endWord))
                        return count + 1;
                    if (!visited.containsKey(adjWord))
                    {
                        visited.put(adjWord, true);
                        que.add(new Pair(adjWord, count + 1));
                    }
                }
                
                
            }
        }
        return 0;
    }
    
}


/*class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Set<String> sets = new HashSet<String>();
        sets.add(beginWord);
        wordSet.add(endWord);
        int distance = 1;
        while (!sets.contains(endWord))
        {
            Set<String> toAdd = new HashSet<String>();
            for (String each : sets)
            {
                for (int i = 0; i < each.length(); i++)
                {
                    char[] chars = each.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++)
                    {
                        chars[i] = ch;
                        String word = new String(chars);
                        if(wordSet.contains(word))
                        {
                            toAdd.add(word);
                            wordSet.remove(word);
                        }
                    }
                }
            }
            distance++;
            if(toAdd.size()== 0) return 0;
            sets = toAdd;
        }
        return distance;
    }
}*/

/*

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    // Since all words are of same length.
    int L = beginWord.length();

    // Dictionary to hold combination of words that can be formed,
    // from any given word. By changing one letter at a time.
    Map<String, List<String>> allComboDict = new HashMap<>();

    wordList.forEach(
        word -> {
          for (int i = 0; i < L; i++) {
            // Key is the generic word
            // Value is a list of words which have the same intermediate generic word.
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
            List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
            transformations.add(word);
            allComboDict.put(newWord, transformations);
          }
        });

    // Queue for BFS
    Queue<Pair<String, Integer>> Q = new LinkedList<>();
    Q.add(new Pair(beginWord, 1));

    // Visited to make sure we don't repeat processing same word.
    Map<String, Boolean> visited = new HashMap<>();
    visited.put(beginWord, true);

    while (!Q.isEmpty()) {
      Pair<String, Integer> node = Q.remove();
      String word = node.getKey();
      int level = node.getValue();
      for (int i = 0; i < L; i++) {

        // Intermediate words for current word
        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

        // Next states are all the words which share the same intermediate state.
        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
          // If at any point if we find what we are looking for
          // i.e. the end word - we can return with the answer.
          if (adjacentWord.equals(endWord)) {
            return level + 1;
          }
          // Otherwise, add it to the BFS Queue. Also mark it visited
          if (!visited.containsKey(adjacentWord)) {
            visited.put(adjacentWord, true);
            Q.add(new Pair(adjacentWord, level + 1));
          }
        }
      }
    }

    return 0;
  }
}

*/

/*class Solution {

  private int L;
  private Map<String, List<String>> allComboDict;

  Solution() {
    this.L = 0;

    // Dictionary to hold combination of words that can be formed,
    // from any given word. By changing one letter at a time.
    this.allComboDict = new HashMap<>();
  }

  private int visitWordNode(
      Queue<Pair<String, Integer>> Q,
      Map<String, Integer> visited,
      Map<String, Integer> othersVisited) {

    Pair<String, Integer> node = Q.remove();
    String word = node.getKey();
    int level = node.getValue();

    for (int i = 0; i < this.L; i++) {

      // Intermediate words for current word
      String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

      // Next states are all the words which share the same intermediate state.
      for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {
        // If at any point if we find what we are looking for
        // i.e. the end word - we can return with the answer.
        if (othersVisited.containsKey(adjacentWord)) {
          return level + othersVisited.get(adjacentWord);
        }

        if (!visited.containsKey(adjacentWord)) {

          // Save the level as the value of the dictionary, to save number of hops.
          visited.put(adjacentWord, level + 1);
          Q.add(new Pair(adjacentWord, level + 1));
        }
      }
    }
    return -1;
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    if (!wordList.contains(endWord)) {
      return 0;
    }

    // Since all words are of same length.
    this.L = beginWord.length();

    wordList.forEach(
        word -> {
          for (int i = 0; i < L; i++) {
            // Key is the generic word
            // Value is a list of words which have the same intermediate generic word.
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
            List<String> transformations =
                this.allComboDict.getOrDefault(newWord, new ArrayList<>());
            transformations.add(word);
            this.allComboDict.put(newWord, transformations);
          }
        });

    // Queues for birdirectional BFS
    // BFS starting from beginWord
    Queue<Pair<String, Integer>> Q_begin = new LinkedList<>();
    // BFS starting from endWord
    Queue<Pair<String, Integer>> Q_end = new LinkedList<>();
    Q_begin.add(new Pair(beginWord, 1));
    Q_end.add(new Pair(endWord, 1));

    // Visited to make sure we don't repeat processing same word.
    Map<String, Integer> visitedBegin = new HashMap<>();
    Map<String, Integer> visitedEnd = new HashMap<>();
    visitedBegin.put(beginWord, 1);
    visitedEnd.put(endWord, 1);

    while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

      // One hop from begin word
      int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
      if (ans > -1) {
        return ans;
      }

      // One hop from end word
      ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
      if (ans > -1) {
        return ans;
      }
    }

    return 0;
  }
}*/

/*
class Solution
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        
        Map<String, List<String>> allComboMap = new HashMap();
        
        for(String wrd : wordList)
        {
            for (int i = 0; i<wrd.length(); i++)
            {
                String newWord = wrd.substring(0,i) + '*' + wrd.substring(i+1);
                List<String> trans = allComboMap.getOrDefault(newWord, new ArrayList<>());
                trans.add(wrd);
                allComboMap.put(newWord,trans);
            }
        }
        
        Queue<Pair<String, Integer>> que = new LinkedList<>();
        que.add(new Pair(beginWord,1));
        
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        
        while (!que.isEmpty())
        {
            Pair<String, Integer> check = que.poll();
            String word = check.getKey();
            int count = check.getValue();
            for (int i = 0; i<word.length(); i++)
            {
                String newWord = word.substring(0,i) + '*' + word.substring(i+1);
                for (String adjWord : allComboMap.getOrDefault(newWord, new ArrayList<>()))
                {
                    if (adjWord.equals(endWord))
                        return count + 1;
                    if (!visited.containsKey(adjWord))
                    {
                        visited.put(adjWord, true);
                        que.add(new Pair(adjWord, count + 1));
                    }
                }
                
                
            }
        }
        return 0;
    }
    
}


class Solution
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Map<String, List<String>> mp = new HashMap<>();
        for (String wrd:wrdList)
        {
            for (int i = 0; i<word.length; i++)
            {
                String newWord == wrd.substring(0,i) + '*' + wrd.substring(i+1);
                List<String> trans = mp.getOrDefault(newWord, new ArrayList<>());
                trans.add(wrd);
                mp.put(newWord,trans);
            }
        }

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while(!que.isEmpty(0)
        {
            Pair<String, Integer> check = que.poll();
            String word = check.getKey();
            int count = check.getValue();
            for (int i = 0; i<word.length(); i++)
            {
                String newWord = word.substring(0,i) + '*' + word.substring(i+1);
                for (string adjWord: mp.getOrDefault(newWord, new ArrayList<>()))
                {
                    if (adjWord.equals(endWord))
                    return count+1;
                    if (!visited.containsKey(adjWord))
                    {
                        visited.put(adjWord, true);
                        que.add(new Pair(adjWord, count+1));
                    }
                }
            }
        }
    }
    return 0;
}

*/