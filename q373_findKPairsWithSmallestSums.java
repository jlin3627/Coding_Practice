class Solution
{
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
    {
        Queue<List<Integer>> qp = new PriorityQueue<List<Integer>>
        (
            (a,b) -> - (a.get(0) + a.get(1) - b.get(0) - b.get(1))
        );
        for (int i =0; i<nums1.length; i++)
        {
            for (int j = 0; j<nums2.length; j++)
            {
                List<Integer> test = new ArrayList<>();
                test.add(nums1[i]);
                test.add(nums2[j]);
                qp.offer(test);
                if(qp.size()>k)
                {
                    qp.poll();
                }
            }
        }
        return new ArrayList<>(qp);
    }
}


class Soltuion2
{
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
    {
        PriorityQueue<List<Integer>> que = new PriorityQueue<>((a,b) ->a.get(0)+ a.get(1) - b.get(0) + b.get(1));
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length==0 || k == 0) return res;
        for (int i =0 ; i<nums1.length && i<k; i++)
        {
            List<Integer> t = new ArrayList<Integer>();
            t.add(nums1[i]);
            t.add(nums2[0]);
            t.add(0);
            que.offer(t);
        }
        while (k-->0 && !que.isEmpty())
        {
            List<Integer> t = que.poll();
            List<Integer> ans = new ArrayList<>();
            ans.add(t.get(0));
            ans.add(t.get(1));
            res.add(ans);
            if(t.get(2) == nums2.length-1) continue;
            ans = new ArrayList<>();
            ans.add(t.get(0));
            ans.add(nums2[t.get(2)+1]);
            ans.add(t.get(2)+1);
            que.offer(ans);
        }
        return res;
    }
} 


/*
class Solution
{
    class Pair{
        List<Integer> pair;
        int index;
        long sum;
        Pair(int index,int number1,int number2){        
            this.index=index;
            pair=new ArrayList<Integer>();
            pair.add(number1);
            pair.add(number2);
            sum=(long)number1+(long)number2;
        }
    }
    
    class Compare implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2){
            return Long.compare(p1.sum, p2.sum);
        }
    }
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<List<Integer>> result=new ArrayList<>();
        
      if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0) return result;
        
      int len1=nums1.length;
      int len2=nums2.length;
       
      PriorityQueue<Pair> queue= new PriorityQueue<>(k,new Compare());
        
      for (int i=0; i<nums1.length && i<k ; i++) { // only need first k number in nums1 to start  
            queue.offer( new Pair(0, nums1[i],nums2[0]) );
      }  
        
      for (int i=1; i<=k && !queue.isEmpty(); i++) {
          Pair p=queue.poll();
          result.add(p.pair);        
          if(p.index< len2-1){
              int next=p.index+1;
              queue.offer( new Pair(next, p.pair.get(0),nums2[next]));
          }
      }
        
       return result; 
    }
}*/

class Solution3
{
    class Pair
    {
        List<Integer> pair;
        int index;
        int sum;
        Pair(int index, int num1, int num2)
        {
            this.index = index;
            pair = new ArrayList<Integer>();
            pair.add(num1);
            pair.add(num2);
            sum = num1 + num2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
    {
        List<List<Integer>> result = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k==0)     
            return result;

        int len1 = nums1.length;
        int len2 = nums2.length;

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((n1,n2)-> n1.sum-n2.sum);

        for (int i =0; i<nums1.length && i<k; i++)
        {
            queue.offer(new Pair(0, nums1[i], nums2[0]));
        }

        for (int i =1; i<=k && !queue.isEmpty(); i++)
        {
            Pair p = queue.poll();
            result.add(p.pair);
            if(p.index < len2-1)
            {
                int next = p.index+1;
                queue.offer(new Pair(next, p.pair.get(0), nums2[next]));
            }
        }
        return result;
    }

}