//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> entry : sortByValueThenKey(map)){
            int val = entry.getValue();
            while(val-- > 0){
                ans.add(entry.getKey());
            }
        }
        
        return ans;
    }
    
    public List<Map.Entry<Integer, Integer>> sortByValueThenKey(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (e1, e2) -> {
            int valueComparison = e2.getValue().compareTo(e1.getValue());
            if (valueComparison != 0) {
                return valueComparison;
            } else {
                return e1.getKey().compareTo(e2.getKey());
            }
        });
        return entries;
    }
    
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends