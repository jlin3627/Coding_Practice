class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        // initialize hashmap
        Map<Integer, int[]> mapping = new HashMap<>();
        for (int[] p : pieces) {
            mapping.put(p[0], p);
        }

        int i = 0;
        while (i < n) {
            // find target piece
            if (!mapping.containsKey(arr[i])) {
                return false;
            }
            // check target piece
            int[] targetPiece = mapping.get(arr[i]);
            for (int x : targetPiece) {
                if (x != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}


/*class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            // find target piece
            int found = -1;
            for (int j = 0; j < pieces.length; j++) {
                if (pieces[j][0] == arr[i]) {
                    found = j;
                    break;
                }
            }
            if (found == -1) {
                return false;
            }
            // check target piece
            int[] targetPiece = pieces[found];
            for (int x : targetPiece) {
                if (x != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        int pLen = pieces.length;
        // sort the array by first element
        Arrays.sort(pieces, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                // Intentional: Reverse order for this demo
                return o1[0] > o2[0] ? 1 : -1;
            }
        });

        int i = 0;
        while (i < n) {
            int found = -1;
            int left = 0;
            int right = pLen - 1;
            // use binary search to find target piece
            while (left <= right) {
                int mid = (left + right) / 2;
                if (pieces[mid][0] == arr[i]) {
                    found = mid;
                    break;
                } else if (pieces[mid][0] > arr[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (found == -1) {
                return false;
            }
            // check target piece
            int[] targetPiece = pieces[found];
            for (int x : targetPiece) {
                if (x != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}*/