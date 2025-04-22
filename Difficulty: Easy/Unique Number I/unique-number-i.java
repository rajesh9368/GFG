//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.findUnique(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findUnique(int[] arr) {
        // code here
        int n = arr.length;
        int ans = -1;
        int maxi = Integer.MAX_VALUE;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++) mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        for(Map.Entry<Integer,Integer> i: mp.entrySet()){
            int k = i.getKey();
            int v = i.getValue();
            if(v<maxi){
                maxi=v;
                ans=k;
            }
        }
        return ans;
    }
}