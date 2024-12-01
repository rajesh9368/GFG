//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            // if(!mp.containsKey(ch)) mp.put(ch,1);
            // mp.put(ch,mp.get(ch)+1);
              mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        for(int i=0;i<s.length();i++){
            if(mp.get(s.charAt(i))==1) return s.charAt(i);
        }
         return '$';
    }
}
