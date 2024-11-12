//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long a1[] = new long[(int)(n)];
            long a2[] = new long[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a1[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a2[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Compute obj = new Compute();
            System.out.println(obj.isSubset( a1, a2, n, m));
            
        
System.out.println("~");
}
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        HashMap<Long,Integer> mpp1 = new HashMap<>();
        HashMap<Long,Integer> mpp2 = new HashMap<>();
        if(m>n) return "No";
        for(int i=0;i<n;i++){
            if(!mpp1.containsKey(a1[i])) mpp1.put(a1[i],1);
            else mpp1.put(a1[i],mpp1.get(a1[i])+1);
        }
        for(int i=0;i<m;i++){
            if(!mpp2.containsKey(a2[i])) mpp2.put(a2[i],1);
            else mpp2.put(a2[i],mpp2.get(a2[i])+1);
        }
        // int ans = 0 ;
        // if(mpp1.size()>mpp2.size()) ans = mpp1.size();
        // else ans = mpp2.size();
        for(int i=0;i<m;i++){
            if(!mpp1.containsKey(a2[i]) || mpp1.get(a2[i]) < mpp2.get(a2[i])) return "No";
        }
        return "Yes";
    }
}