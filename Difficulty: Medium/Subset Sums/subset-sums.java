// User function Template for Java//User function Template for Java
class Solution {
    public void operation(int[] arr,int n,ArrayList<Integer> ans,int sum,int i){
        if(i>=n){
            ans.add(sum);
            return;
        }
        sum+=arr[i];
        operation(arr,n,ans,sum,i+1);
        sum-=arr[i];
        operation(arr,n,ans,sum,i+1);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        operation(arr,n,ans,0,0);
        return ans;
    }
}