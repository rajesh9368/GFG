//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().subsetSums(arr);
            Collections.sort(result);
            // Printing the result in space-separated format
            for (int i = 0; i < result.size(); i++) {
                if (i != 0) System.out.print(" ");
                System.out.print(result.get(i));
            }
            System.out.println();    // Print new line after each test case
            System.out.println("~"); // Print new line after each test case
        }
    }
}

// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    public void operation(int[] arr,int i,ArrayList<Integer> temp,List<List<Integer>> ans){
        if(i==arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[i]);
        operation(arr,i+1,temp,ans);
        temp.remove(temp.size()-1);
        operation(arr,i+1,temp,ans);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        operation(arr,0,temp,ans);
        int sum=0;
        for(int i=0;i<ans.size();i++){
        sum=0;
        for(int j=0;j<ans.get(i).size();j++)
            sum+=ans.get(i).get(j);
        res.add(sum);
        }
        return res;
    }
}