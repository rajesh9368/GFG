//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


// class Solution {
//     public int myAtoi(String s) {
//         // Your code here
//         int si=0,ans=0;
//         if(s.charAt(0)=='-') si=1;
//         for(int i=si;i<s.length();i++){
//             if(s.charAt(i)>='0' && s.charAt(i)<='9') ans = ans*10+s.charAt(i)-'0';
//             // else 
//             // return -1;
//         }
//         if(si==1) ans*=-1;
//         if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
//         else if(ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
//         return ans;
//     }
// }

class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0, n = s.length(), sign = 1;
        long ans = 0; 
        while (i < n && s.charAt(i) == ' ') i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            ans = ans * 10 + (s.charAt(i) - '0');
            if (ans * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (ans * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            i++;
        }

        return (int) (ans * sign);
    }
}

