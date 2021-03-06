package GraphPackage.Interfaces;
import java.util.Queue;
import java.util.Stack;
public interface GraphAlgorithmInteface<T> {
	public Queue<T> getBreadthFirstTraversal(T origin);
	public Queue<T> getDepthFirstTraversal(T origin);
	public Stack<T> getTopologicalOrder();
	public int getShortestPath(T begin,T end);
	public double getCheapestPath(T begin, T end);

}
