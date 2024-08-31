//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


/*Complete the function below*/
class Solution {
    
    public void solve(int[] arr, int index, int key,ArrayList<Integer> temp, ArrayList<Integer> ans){
        if(temp.size()==3){
            ans.clear();
            ans.addAll(temp);
            return;
        }
        if(index>=arr.length) return;
        
        for(int i = index; i<=arr.length - 3 + temp.size();i++){
            if(arr[i]>key){
                temp.add(arr[i]);
                solve(arr, i+1, arr[i], temp, ans);
                if(temp.size() == 3) break;
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public List<Integer> find3Numbers(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(arr, 0, Integer.MIN_VALUE, new ArrayList<>(), ans);
        return ans;
        
    }
}