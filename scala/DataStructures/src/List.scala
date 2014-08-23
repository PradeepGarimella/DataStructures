trait List[T] {
  var count:Int=0;
  def isEmpty:Boolean=count==0
  def add(e:T)
  def get(i:Int):Node[T]
//  def add(index:Int, e:T)
//  def get(index:Int)
    def removeAll(e:T)
  def incrementSize={
    count=count+1
  }
}