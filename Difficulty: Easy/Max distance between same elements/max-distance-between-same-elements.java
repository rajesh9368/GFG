//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    //two approaches brute+map
    public int maxDistance(int[] arr) {
        // Code here
        int n = arr.length;
        int maxi=0;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(i!=j){
        //             if(arr[i]==arr[j]){
        //                 maxi=Math.max(j-i,maxi);
        //             }
        //         }
        //     }
        // }
        // return maxi;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            if(mp.containsKey(arr[i])) maxi=Math.max(maxi,i-mp.get(arr[i]));
            else mp.put(arr[i],i);
        }
        return maxi;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        
System.out.println("~");
}
        sc.close();
    }
}
// } Driver Code Ends