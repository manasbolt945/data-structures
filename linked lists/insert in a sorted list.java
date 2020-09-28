// { Driver Code Starts


import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution g = new Solution();
            head = g.sortedInsert(head,k);
            
            printList(head); 
            t--;
        }
    } 
} 
// } Driver Code Ends




/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head, int key) {
        // Add your code here.
        Node temp = new Node(key);
        int flag=0;
        if(head==null)return temp;
        if(key<head.data)
        {
            temp.next = head;
            head = temp;
            return head;
        }
        Node curr = head;
        while(curr.next!=null)
        {
            if(key<curr.next.data)
            {
                flag=1;
                Node next = curr.next;
                curr.next = temp;
                curr = curr.next;
                curr.next = next;
                break;
            }
            curr = curr.next;
        }
        if(flag==0)
        curr.next=temp;
        return head;
        
    }
}
