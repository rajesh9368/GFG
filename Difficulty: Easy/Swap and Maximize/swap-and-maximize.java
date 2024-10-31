//{ Driver Code Starts
import java.io.*;
import java.util.*;

// Driver class

// } Driver Code Ends
// User function Template for Java

class Solution {
    public long maxSum(Long[] arr) {
        // code here
        //Sort the array
        long maxi=0;
        Arrays.sort(arr);
        // create an auxiliary array 
        Long[] temp = new Long[arr.length];
        //Managing two pointers
        int l=0,r=arr.length-1; 
        for(int i=0;i<arr.length;i++){
            // Put the above elements in others based on even odd indexes
            if(i%2==0){
                temp[i]=arr[l];
                l++;
            }
            else{
                temp[i]=arr[r];
                r--;
            }
        }
        //Now calculate the maxi of all the elments i.e. the maximun absolute difference
        for(int i=0;i<arr.length;i++){
            maxi+=Math.abs(temp[i]-temp[(i+1)%arr.length]);
        }
        return maxi;
    }
}


//{ Driver Code Starts.
class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends