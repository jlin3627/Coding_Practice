class Solution {
    // Find the amount of zero in the string,
 //by first zero occurence, determine the desired index to put the 0 if exist, and fill the rest as 1
     public String maximumBinaryString(String binary) 
     {
         char[] curr = binary.toCharArray();
         int zero = 0;
         int index = -1;
         for(int i = 0; i < curr.length; i++) 
         {            
             if(curr[i] == '0') {
                 zero++;
                 if(index == -1)
                     index = i;
             }
         }
         Arrays.fill(curr, '1');
         if(index != -1) {
             curr[index + zero - 1] = '0';
         }
         return new String(curr);
     }
 }