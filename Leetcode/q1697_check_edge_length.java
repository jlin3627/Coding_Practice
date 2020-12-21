/*class Solution {
    
    int curr = 0;
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edges, int[][] queries) {
        Arrays.sort(edges, (a, b) -> (a[2] - b[2]));
		// Add another column to the queries so that we know the index after sorting.
        int[][] qs = new int[queries.length][4];
        for(int i = 0; i < queries.length; i++) 
        {
            qs[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(qs, (a, b) -> (a[2] - b[2]));
        boolean[] res = new boolean[queries.length];
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) roots[i] = i;
        for(int i = 0; i < queries.length; i++) 
        {
            int[] q = qs[i];
            res[q[3]] = helper(edges, q[0], q[1], q[2], roots);
        }
        return res;
    }
    
    private boolean helper(int[][] edges, int start, int end, int limit, int[] roots) {
        for(int i = curr; i < edges.length; i++) {
            int[] e = edges[i];
            if(e[2] >= limit) {
                curr = i;
                break;
            }
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if(root1 != root2) {
                roots[root1] = root2;
            }
        }
        return find(roots, start) == find(roots, end);
    }
    
    private int find(int[] roots, int i) {
        int j = i;
        while(roots[i] != i) {
            i = roots[i];
        }
        roots[j] = i;
        return i;
    }
}*/

/*class Solution
{
      public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
    // DISJOINT SET

    Map<int[], Integer> original = new IdentityHashMap<>();
    for (int i = 0; i < queries.length; i++) {
      original.put(queries[i], i);
    }
    
    
    // start with smaller queries then union allowed edges and so on
    parent = IntStream.rangeClosed(0, n).toArray();

    Map<Integer, Boolean> result = new HashMap<>();
    Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));
    Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
    int qI = 0;
    int eI = 0;
    for (; qI < queries.length; qI++){
      int[] query = queries[qI];
      while (eI < edgeList.length && edgeList[eI][2] < query[2]){
        union(edgeList[eI][0], edgeList[eI][1]);
        eI++;
      }
      result.put(qI, find(query[0]) == find(query[1]));
    }


    boolean[] r= new boolean[queries.length];
    for (int i = 0; i < queries.length; i++) {
      r[original.get(queries[i])] = result.get(i);
    }
    return r;

  }
  
  private int[] parent;

  private void union(int a, int b) {
    parent[find(a)] = find(b);
  }

  private int find(int a) {
    if (a != parent[a]) {
      parent[a] = find(parent[a]);
    }
    return parent[a];
  }
}*/

class Solution {
    class UnionFind {
        int[] arr;
        int[] size;
        
        public UnionFind(int n) {
            arr = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int i) {
            return arr[i] = arr[i] == i ? i : find(arr[i]);
        }
        
        public void union(int i, int j) {
            i = find(i);
            j = find(j);
            if (i == j) {
                return;
            }
            if (size[i] < size[j]) {
                int temp = i;
                i = j;
                j = temp;
            }
            arr[j] = i;
            size[i] += size[j];
        }
    }
    
    public List<Boolean> weightLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int m = edgeList.length;
        int qq = queries.length;
        int[][] indexedQueries = new int[qq][];
        for (int i = 0; i < qq; i++) {
            indexedQueries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        UnionFind uf = new UnionFind(n);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(indexedQueries, (a, b) -> a[2] - b[2]);
        ArrayList<Boolean> answer = new ArrayList<>();
        for (int i = 0; i < qq; i++) {
            answer.add(false);
        }
        int e = 0;
        for (int[] query : indexedQueries) {
            int p = query[0];
            int q = query[1];
            int limit = query[2];
            int i = query[3];
            while (e < m && edgeList[e][2] < limit) {
                uf.union(edgeList[e][0], edgeList[e][1]);
                e++;
            }
            answer.set(i, uf.find(p) == uf.find(q));
        }
        return answer;
    }
}