//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int length = arr.length;
        if (length == 0 || arr == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int currentSum = 0;
        while (right < length) {
            currentSum += arr[right];
            while (left < length && currentSum > target) {
                currentSum -= arr[left];
                left++;
            }
            if (currentSum == target) {
                result.add(left + 1);
                result.add(right + 1);
                return result;
            }
            right++;
        }
        result.add(-1);
        return result;
    }
}

