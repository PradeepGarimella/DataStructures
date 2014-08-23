class Node[T](data: T, var next: Node[T]) {
  def getNext: Node[T] = next;
  def setNext(node: Node[T]) = next = node;
  
  def getData=data
  
  override def toString=data.toString
}

class LinkedList[T] extends List[T] {
  var head: Node[T] = null
  
  override def get(i: Int) = {
    var curr=head
    def func(node:Node[T], pos:Integer):Node[T] = {
      if(pos==i)
        node
      else
       func(node.getNext, pos+1)
    }
    func(curr,0)
  }

  override def add(e: T) = {
    if (head == null) {
      head = new Node[T](e, null)
    } else {
      var curr = head;
      while (curr.getNext != null) {
        curr = curr.getNext;
      }
      curr.setNext(new Node(e, null));
    }
    incrementSize
  }
  
  override def removeAll(e:T) {
    if(isEmpty) new LinkedList else {
      var curr=head
      var prev=head
      var idex=0;
      while(curr!=null) {
        idex=idex+1
        if(curr.getData.equals(e)) {
          
          if(curr==prev) {
            curr=curr.next
            prev.next=null
            prev=curr;
            head=curr;
          }
          else {
          var tmp = curr;
          prev.setNext(curr.getNext);
          curr=curr.getNext
          tmp.next=null;
          }
        }
        else {
          prev=curr
          curr=curr.getNext
        }
      }
      
    }
  }
  
  
  def reverse() {
    var prev:Node[T]=null;
    def reverseTheList(curr:Node[T]):Node[T] = {
      if(curr!=null) {
        var cop = curr.getNext
        if(prev==null) {
          prev=curr
          curr.setNext(null)

        }
        else {
          curr.setNext(prev)
          prev=curr
          
        }
        reverseTheList(cop)
        
      }
      else {
        prev
      }
      
    }
    head=reverseTheList(head)
  }
  
  
  def print():Unit = {
    var curr = head;
    while(curr!=null) {
      println(curr.toString)
      curr=curr.next
    }
  }
}