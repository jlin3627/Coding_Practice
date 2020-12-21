class FreqStack {

    HashMap<Integer,List<Integer>> mp;
    int max;
    int ind;
    public FreqStack() 
    {
        mp = new HashMap<>();
        ind = 0;
    }
    
    public void push(int x) 
    {
        if (!mp.containsKey(x))
        {
            List<Integer> test = new LinkedList<>();
            test.add(ind);
            mp.put(x,test);
        }
        else
        {
            mp.get(x).add(ind);
        }
        ind++;
        max = x;
    }
    
    public int pop() 
    {
        for (int k:mp.keySet())
        {
            if (max == -1) max = k;
            else if (mp.get(k).size()!=0)
            {
                //System.out.println(k);
                if (mp.get(k).size()>mp.get(max).size())
                {
                    max = k;
                }
                else if (mp.get(k).size() == mp.get(max).size())
                {
                    List<Integer> test1 = mp.get(k);
                    List<Integer> test2 = mp.get(max);

                    if ( test1.get(test1.size()-1) > test2.get(test2.size()-1)) max = k;
                }
            }
            
        }
        List rem = mp.get(max);
        rem.remove(rem.size()-1);

        //if (rem.size() == 0)
        //{
          //mp.remove(max); 
        //}
        //else
        {
            mp.put(max,rem);
        }
        int tmp = max;
        max = -1;
        return tmp;
    }
   
}


class Solution
{
    private LinkedList<Integer> queue;
    private HashMap<Integer, Integer> counter;
    private LinkedList<LinkedList<Integer>> frequencyAndItems;// it holds queue of element in the same frequency
    int max = 0;

    public FreqStack() {
        queue = new LinkedList<>();
        counter = new HashMap<>();
        frequencyAndItems = new LinkedList<>();
        LinkedList<Integer> init = new LinkedList<>();
        init.add(Integer.MAX_VALUE);
        frequencyAndItems.add(init);

    }

    public void push(int x) {
        queue.add(x);
        Integer count = counter.get(x);
        if (count == null) {
            count = 1;
            counter.put(x, count);
        } else {
            count = count + 1;
            counter.put(x, count);
        }
        if (count == frequencyAndItems.size()) {
            LinkedList<Integer> a = new LinkedList<>();
            a.add(Integer.MAX_VALUE);
            frequencyAndItems.add(a);
        }
        try{
            frequencyAndItems.get(count).add(x);
        }catch (IndexOutOfBoundsException iex){
            System.out.println(x+" "+ count);
        }

    }

    public int pop() {

        int size = frequencyAndItems.size() - 1;
        // Get the max frequency
        LinkedList<Integer> maxFrequency = frequencyAndItems.get(size);
        // find the element to remove
        Integer item = maxFrequency.getLast();
        // Update the counter
        int c = counter.get(item);
        c=c-1;
        counter.put(item,c);

        // get the position of the item in the queue
        int index = queue.lastIndexOf(item);
        //remove from the queue
        queue.remove(index);
        //remove the item from the frequency and item queue
        maxFrequency.removeLast();

        if (maxFrequency.size() == 1 & maxFrequency.getLast() == Integer.MAX_VALUE) {
            frequencyAndItems.removeLast();
        }
        return item;

    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */



class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq)
            maxfreq = f;

        group.computeIfAbsent(f, z-> new Stack()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }
}


class FreqStack {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> m = new HashMap<>();
    int maxfreq = 0;

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        maxfreq = Math.max(maxfreq, f);
        if (!m.containsKey(f)) m.put(f, new Stack<Integer>());
        m.get(f).add(x);
    }

    public int pop() {
        int x = m.get(maxfreq).pop();
        freq.put(x, maxfreq - 1);
        if (m.get(maxfreq).size() == 0) maxfreq--;
        return x;
    }
}