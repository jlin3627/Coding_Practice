class Solution
{
    public int minAreaRect(int[][] points)
    {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p:points)
        {
            if(!map.containsKey(p[0]))
            {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        
        int min = Integer.MAX_VALUE;
        for (int[] p1 : points)
        {
            for (int[] p2 : points)
            {
                if(p1[0] == p2[0] || p1[1] == p2[1])
                {
                    continue;
                }
                if(map.get(p1[0]).contains(p2[1])&& map.get(p2[0]).contains(p1[1]))
                {
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1]-p2[1]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0:min;
    }
}


// 15ms solution
/*class Solution {
    public int minAreaRect(int[][] points) 
    {
        //Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.sort(points, new Comparator<int[]>()
                    {
                       public int compare(int[] a, int[] b)
                       {
                           if (a[0] == b[0])
                           {
                               return a[1] - b[1];
                           }
                           return a[0] - b[0];
                       }
                    });
        
        Map<Integer, Node> col = new HashMap<>();
        Map<Integer, Node> row = new HashMap<>();
        int N = points.length;

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) 
        {
            int x = points[i][0];
            int y = points[i][1];
            Node cur = new Node(x, y);
            nodes[i] = cur;
            if (col.containsKey(x)) col.get(x).nextc = cur;
            col.put(x, cur);
            if (row.containsKey(y)) row.get(y).nextr = cur;
            row.put(y, cur);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            Node cur = nodes[i];
            int area = Integer.MAX_VALUE;
            for (Node b = cur.nextc; b != null; b = b.nextc) 
            {
                Node c = cur.nextr;
                Node d = b.nextr;
                while (c != null && d != null) {
                    if (c.x == d.x) {
                        area = (b.y - cur.y) * (c.x - cur.x);
                        min = Math.min(min, area);
                        break;
                    } else if (c.x < d.x) {
                        c = c.nextr;
                    } else // d.x < c.x 
                    {
                        d = d.nextr;
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

class Node
{
    int x;
    int y;
    Node nextc;
    Node nextr;

    public Node(int x,int y) {
        this.x = x;
        this.y = y;
    }
}*/