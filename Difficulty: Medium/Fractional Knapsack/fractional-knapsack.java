//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]),
                                  Integer.parseInt(inputLine[k++]));
            }
            System.out.println(
                String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution {
    // Function to get the maximum total value in the knapsack.
    public static Comparator<Item> comp = new Comparator<Item>(){
        @Override
        public int compare(Item a,Item b){
        double r1 = (double) a.value/a.weight;
        double r2 = (double) b.value/b.weight;
        return Double.compare(r2,r1);
    }
};
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        Arrays.sort(arr,comp);
        int curwt=0;
        double fv = 0.0;
        for(int i=0;i<n;i++){
            if(curwt+arr[i].weight<=w){
                curwt+=arr[i].weight;
                fv+=arr[i].value;
            }
            else{
                int remain=w-curwt;
                fv+=(arr[i].value/(double)arr[i].weight)*remain;
                break;
            }
        }
        return fv;
    }
}