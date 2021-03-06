class Solution {
    public int eatenApples(int[] apples, int[] days) {
       int res = 0;
       int n = apples.length;
                                       
       PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]); //[]{apple count, expiry date}
       
       for(int i=0; i<n || !queue.isEmpty(); ++i) { // || !queue.isEmpty() cos we need to continue even after n
           if(i<n) 
               queue.offer(new int[]{ apples[i], i + days[i] });
           
           while(!queue.isEmpty() && queue.peek()[1] <= i) { // spoiled apples, so remove the tray
               queue.poll();
           }
           
           if(!queue.isEmpty()) {
               ++res;
               if(--queue.peek()[0] == 0) // remove if no apples left on this tray
                   queue.poll();
           }
       }
       
       return res;
   }
}