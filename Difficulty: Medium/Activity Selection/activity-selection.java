//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
class Pair{
    int s,e;
    Pair(int s,int e){
        this.s=s;
        this.e=e;
    }
}
class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here.
        int n=start.length;
        Pair[] arr= new Pair[n];
        int x=0;
        for(int i=0;i<start.length;i++){
            arr[x++]=new Pair(start[i],finish[i]);
        }
        Arrays.sort(arr, (a,b)->Integer.compare(a.e,b.e));
        
        int c=0;
        List<Pair> li=new ArrayList<>();
        li.add(new Pair(arr[0].s, arr[0].e));
        for(int i=1;i<n;i++){
            Pair peek=li.get(li.size()-1);
            Pair curr=arr[i];
            
            if(curr.s>peek.e){
                li.add(new Pair(curr.s,curr.e));
                c++;
            }
        }
        return c+1;
    }
}
