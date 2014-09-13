package Flatten;

 class Node {
	int data;
	Node next;
	Node rand;
	public Node(int x, Node next, Node prev) {
		this.data=x;
		this.next=next;
		this.rand=prev;
	}
	
	public Node(int x) {
		this.data=x;
	}
}
public class RandomLinkedList {
	Node head;
	
	public void add(int d) {
		if(head==null) {
			head = new Node(d);
		}
		else {
			Node curr = head;
			while(curr.next!=null) {
				curr = curr.next;
			}
			curr=new Node(d);
		}
	}


}
