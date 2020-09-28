import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}
class GFG
 {  
	public static void main (String[] args)
	 {
	    
	Scanner s=new Scanner(System.in);
	int t=s.nextInt();
	while(t-->0)
	{
	     Node head=null,tail=null;
	    int n=s.nextInt();
	    for(int i=0;i<n;i++)
	    {
	        Node temp=new Node(s.nextInt());
	        if(head==null){
	        head=temp;
	        tail=temp;
	        }
	        else{
	         tail.next=temp;
	         tail=temp;
	        }
	    }
	    Node  g = seg(head);
	    while(g!=null)
	    {
	        System.out.print(g.data+" ");
	        g = g.next;
	    }
	    System.out.println();
	}
}
	 public static Node seg(Node head)
	 {
	     Node temp = new Node(0);
	     Node odd = new Node(0);
	     Node oddhead = odd;
	     Node res = temp;
	     Node curr = head;
	     while(curr!=null)
	     {
	         if(curr.data%2==0)
	         {
	             temp.next = curr;
	             temp =  temp.next;
	         }
	         else
	         {
	             odd.next = curr;
	             odd = odd.next;
	         }
	         curr = curr.next;
	     }
	     Node next = oddhead.next;
	     temp.next = next;
	     odd.next = null;
	     return res.next;
	 }
 }
