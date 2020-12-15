class Solution 
{
    
     /*public int[] prisonAfterNDays(int[] cells, int N) 
     {
        while (N > 0) 
        {
            N--;
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
        }
        return cells;
    }*/
    
    
    public int[] prisonAfterNDays(int[] cells, int N)
    {
        Map<String, Integer> mp = new HashMap<>();
        while (N>0)
        {
            int[] cells2 = new int[cells.length];
            mp.put(Arrays.toString(cells), N);
            N--;
            for (int i = 1;i<cells.length-1;i++ )
            {
                cells2[i] = cells[i-1] == cells[i+1] ? 1:0;
            }
            cells = cells2;
            if (mp.containsKey(Arrays.toString(cells)))
            {
                N %= (mp.get(Arrays.toString(cells)) - N);
            }
        }
        return cells;
    }
}


class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
		if(cells==null || cells.length==0 || N<=0) return cells;
        boolean hasCycle = false;
        int cycle = 0;
        HashSet<String> set = new HashSet<>(); 
        for(int i=0;i<N;i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){ //store cell state
                set.add(key);
                cycle++;
            }
            else{ //hit a cycle
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle){
            N%=cycle;
            for(int i=0;i<N;i++){
                cells = nextDay(cells);
            }   
        }
        return cells;
    }
    
    private int[] nextDay(int[] cells){
        int[] tmp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            tmp[i]=cells[i-1]==cells[i+1]?1:0;
        }
        return tmp;
    }
}


/*
public int[] prisonAfterNDays(int[] cells, int N)
{
    Map<String, Integer> mp = new HashMap<>();
    while (N>0)
    {
        int[] cells2 = new int[cells.length];
        mp.put(Arrays.toString(cells), N);
        N--;
        for (int i = 1; i<cells.length-1; i++)
        {
            cells2[i] = cells[i-1] == cells[i+1] ? 1:0;
        }
        cells = cells2;
        if (mp.containsKey(Arrays.toString(cells)))
        {
            N %= (mp.get(Arrays.toString(cells)) - N);
        }
    }
    return cells;
}


public int[] prisonAfterNDays(int[] cells, int N)
{
    Map<String, Integer> mp = new HashMap<>();
    while (N>0)
    {
        int[] cells2 = new int[cells.length];
        mp.put(Arrays.toString(cells), N);
        N--;
        for (int i =1; i<cells.length-1; i++)
        {
            cells2[i] = cells[i-1] == cells[i+1] ? 1:0;
        }
        cells = cells2;
        if (mp.containsKey(Arrays.toString(cells)))
        {
            N%= (mp.get(Arrays.toString(cells)) -N);
        }
    }
    return cells;
}

*/