//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean check(int row,int col,int[][] box){
        int duprow=row,dupcol=col;
        for(int i=0;i<box.length;i++) if(box[i][col]==1) return false;
        for(int j=0;j<box.length;j++) if(box[row][j]==1) return false;
        row=duprow;col=dupcol;
        while(row>=0 && col>=0){
            if(box[row][col]==1) return false;
            row--; col--;
        }
        row=duprow;col=dupcol;
        while(row<box.length && col>=0){
            if(box[row][col]==1) return false;
            row++; col--;
        }
        row=duprow;col=dupcol;
        while(row>=0 && col<box.length){
            if(box[row][col]==1) return false;
            row--;col++;
        }
        row=duprow;col=dupcol;
        while(row<box.length && col<box.length){
            if(box[row][col]==1) return false;
            row++;col++;
        }
        return true;
    }
    public void operation(int col,int n,int[][] box,ArrayList<Integer> temp,
    ArrayList<ArrayList<Integer>> ans){
        if(col==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int row=0;row<n;row++){
            if(check(row,col,box)){
                box[row][col]=1;
                temp.add(row+1);
                operation(col+1,n,box,temp,ans);
                box[row][col]=0;
                temp.remove(temp.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        int[][] box = new int[n][n];
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans  = new ArrayList<>();
        operation(0,n,box,temp,ans);
        return ans;
    }
}