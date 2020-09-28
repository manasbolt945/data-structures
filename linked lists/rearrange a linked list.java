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
            head = new gfg().rearrangeEvenOdd(head);
            printList(head); 
            t--;
        }
    } 
} 
// } Driver Code Ends


/*

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
This is method only submission.
You only need to complete the below method.
*/
class gfg
{

   // Should rearrange given linked list such that all even
   // positioned Nodes are before odd positioned.
   // Returns new head of linked List.
    Node rearrangeEvenOdd(Node head)
    {
          //  The task is to complete this method
          Node fast1 = head;
          Node fast2 = head.next;
          Node evenfront = fast2;
          while(true)
          {
              if(fast1==null || fast2==null || fast2.next==null)
              {
                  fast1.next = evenfront;
                  break;
              }
              fast1.next = fast2.next;
              fast1=fast2.next;
              if(fast1.next==null)
              {
                  fast2.next=null;
                  fast1.next=evenfront;
                  break;
              }
              fast2.next = fast1.next;
              fast2 = fast1.next;
          }
          return head;
          
          
    }
}
