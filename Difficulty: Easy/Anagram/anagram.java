//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        // Your code here
        HashMap<Character,Integer> mp1 = new HashMap<>();
        HashMap<Character,Integer> mp2 = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            if(!mp1.containsKey(s1.charAt(i))) mp1.put(s1.charAt(i),1);
            else mp1.put(s1.charAt(i),mp1.get(s1.charAt(i))+1);
        }
        for(int i=0;i<s2.length();i++){
            if(!mp2.containsKey(s2.charAt(i))) mp2.put(s2.charAt(i),1);
            else mp2.put(s2.charAt(i),mp2.get(s2.charAt(i))+1);
        }
        if(mp1.equals(mp2)) return true;
        return false;
    }
}