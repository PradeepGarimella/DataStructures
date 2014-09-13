package Flatten;
import java.util.Queue;
public class FlattenALinkedList {
	
	public Node newNode(Node next, Node child, Integer value) {
		return new Node(next,child,value);
	}
	Node head;
	public class Node {
		Node next;
		Node child;
		Integer value;
		
		public Node(Node next, Node child, Integer value) {
			this.next=next;
			this.child=child;
			this.value=value;
		}
	}
	
	public void printTheList() {
		Node curr = head;
		 String str = "";
		while(curr!=null) {
			str = str + curr.value+",";
			curr = curr.next;
		}
		System.out.println(str);
	}
	
	
	public void  flattenList(Node curr,Node tail, Queue<Node> que) {
		if(curr==null){
			
		}
		else 
		{
			while(curr!=null) {
				que.add(curr);
				curr=curr.next;
			}
			
			while(!que.isEmpty()) {
				final Node deq = que.poll();
				if(tail==null){
					tail = deq;
				}
				else {
					tail.next=deq;
					tail=deq;
				}
				if(deq.child==null) {
					
				}
				else {
					flattenList(deq.child, tail, que);
				}
			}
			
		}
	}
	
}
