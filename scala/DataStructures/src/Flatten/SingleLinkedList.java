package Flatten;

import java.util.Iterator;

public class SingleLinkedList<T> implements IList<T> {
	public Node head;
		
	private class Node {
		private T data;
		public Node next;
		public Node(T data){
			this.data=data;
			this.next=null;
		}
		
		public Node(T data, Node next) {
			this.data=data;
			this.next=next;
		}
	}

	@Override
	public T get(int index) {
		Node curr=head;
		int pos=0;
		while(curr!=null) {
			if(pos==index) {
				break;
			}
			curr=curr.next;
			pos++;
		}
		return curr.data;		
	}

	public void print() {
		Node curr = head;
		while(curr!=null) {
			System.out.println(curr.data);
			curr=curr.next;
		}
	}
	
	public void pairWiseSwap(int k) {
		Node curr = head;
		Node tHead=null;
		Node tTail=null;
		Node pTip=null;
		int count=0;
		while(curr!=null) {
			if(count==k) {
				tTail.next=curr;
				if(pTip!=null)
					pTip.next=tHead;
				if(tTail==head) {
					head=tHead;
				}
				pTip=tTail;
				count=0;
			}
			else {
				Node temp=curr.next;
				if(count==0) {
					tHead=tTail=curr;
				}
				else {
					curr.next=tHead;
					tHead=curr;
					tTail=tTail.next;
				}
				curr=temp;
				count++;
				
			}
		}
		if(count!=0) {
			tTail.next=curr;
			if(pTip!=null)
				pTip.next=tHead;
			if(tTail==head) {
				head=tTail;
			}
			pTip=tTail;
		}
	}

	public void pairWiseSwapAlternative(int k) {
		Node curr = head;
		Node prevLink=head;
		while(curr!=null) {
			Node temp = getNthNode(k, curr);
			Node tCopy=null;
			if(temp!=null) {
				tCopy=temp.next;
				if(curr!=head) {
					prevLink.next=temp;
				}
				else {
					head=temp;
				}
				prevLink=curr;
				curr.next=temp.next;
				temp.next=curr;
			}
			curr=tCopy;
		}
	}
	
	private Node getNthNode(int n,Node curr)
	{
		int pos=1;
		Node toBeRet=null;
		while(curr!=null) {
			if(n==pos) {
				toBeRet=curr;
			}
			curr=curr.next;
			pos++;
		}
		return toBeRet;
	}
	
	@Override
	public void add(T e) {
		if(head==null) {
			head = new Node(e);
		}
		else {
			Node curr = head;
			while(curr.next!=null) {
				curr=curr.next;
			}
			curr.next=new Node(e);
		}
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new SlIterator(head);
	}

	@Override
	public int compareTo(IList<T> o) {
		if(o==null) return -1;
		else
		return 0;
	}
	
	private class SlIterator implements Iterator<T> {
		private Node handle;
		private SlIterator(Node curr) {
			this.handle=curr;
		}
		@Override
		public boolean hasNext() {
			if(handle==null) {
				return false;
			}
			else {
				return true;
			}
		}

		@Override
		public T next() {
			T val1=null;
			if(handle==head) {
				val1 = handle.data;
			}
			else if(hasNext()) {
				val1 = handle.data;
			}
			handle=handle.next;
			return val1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

	@Override
	public void removeAll(T t) {
		Node curr = head;
		Node prev=head;
		while(curr!=null) {
			Boolean wasElementRemoved=false;
			if(curr.data.equals(t)) {
				if(curr==head) {
					head=curr.next;
					prev=curr.next;
				}
				else if(curr.next!=null) {
					prev.next=curr.next;
				}
				else {
					prev.next = null;
				}
				wasElementRemoved=true;
			}
			
			if(!wasElementRemoved) {
				prev=curr;
			}

			curr=curr.next;
		}
		
	}



}
