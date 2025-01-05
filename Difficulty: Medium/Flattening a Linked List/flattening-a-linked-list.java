//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to flatten a linked list
    Node merge(Node root1,Node root2){
        Node dummy = new Node(0);
        Node res = dummy;
        while(root1!=null && root2!=null){
            if(root1.data>=root2.data){
                dummy.bottom = root2;
                root2=root2.bottom;
            }
            else{
                dummy.bottom=root1;
                root1=root1.bottom;
            }
            dummy=dummy.bottom;
        }
        while(root1!=null){
            dummy.bottom=root1;
            root1=root1.bottom;
            dummy=dummy.bottom;
        }
         while(root2!=null){
            dummy.bottom=root2;
            root2=root2.bottom;
            dummy=dummy.bottom;
        }
        return res.bottom;
    }
    Node flatten(Node root) {
        // code here
        if(root.next==null) return root;
        Node curr = flatten(root.next);
        root=merge(root,curr);
        return root;
    }
}

//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        while (t-- > 0) {
            String[] workArray = sc.nextLine().trim().split(" ");
            int n = workArray.length;

            Node head = null;
            Node pre = null;

            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(workArray[i]);
                int data = sc.nextInt();
                Node temp = new Node(data);
                if (head == null) {
                    head = temp;
                    pre = temp;
                } else {
                    pre.next = temp;
                    pre = temp;
                }

                Node preB = temp;
                for (int j = 0; j < m - 1; j++) {
                    int tempData = sc.nextInt();
                    Node tempB = new Node(tempData);
                    preB.bottom = tempB;
                    preB = tempB;
                }
            }

            // Consume the remaining newline if there's any
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            Solution ob = new Solution();
            Node root = ob.flatten(head);
            printList(root);
        
System.out.println("~");
}
        sc.close();
    }
}

// } Driver Code Ends