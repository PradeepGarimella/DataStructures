object App {

  def main(args: Array[String]): Unit = {
    val list=new LinkedList[String]();
    
    list.add("sam")
    list.add("hello")
    list.add("bush")
    
    
    //list.print
    list.reverse
    
    list.print()
  }

}