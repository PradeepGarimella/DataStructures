package GraphPackage.Interfaces;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

import GraphPackage.Vertex;

public class DirectedGraph<T> implements GraphInterface<T> {
	
	private Dictionary<T,VertexInterface<T>> vertices;
	private int edgeCount;
	public DirectedGraph() {
		clear();
	}

	@Override
	public Queue<T> getBreadthFirstTraversal(T origin) {
		VertexInterface<T> originVertex = vertices.get(origin);
		if(originVertex==null) {
			throw new RuntimeException("vertex not found");
		}
		Queue<VertexInterface<T>> vertexQueue = new LinkedList<>();
		Queue<T> traversalQueue = new LinkedList<>();

		vertexQueue.add(originVertex);
		while(!vertexQueue.isEmpty()) {
			VertexInterface<T> vertex = vertexQueue.remove();
			if(vertex!=null) {
				Iterator<VertexInterface<T>> iter = vertex.getNeighbourIterator();
				while(iter.hasNext()) {
					VertexInterface<T> neighbour = iter.next();
					if(!neighbour.isVisited()) {
						neighbour.visit();
						vertexQueue.add(neighbour);
					}
				}
			}
			traversalQueue.add(vertex.getLabel());
		}
		return traversalQueue;
	}

	@Override
	public Queue<T> getDepthFirstTraversal(T origin) {
		VertexInterface<T> originVertex = vertices.get(origin);
		if(originVertex==null) {
			throw new RuntimeException("vertex not found");
		}
		Stack<VertexInterface<T>> vStack = new Stack<>();
		Queue<T> traversalQueue = new LinkedList<>();
		vStack.push(originVertex);
		traversalQueue.add(originVertex.getLabel());
		originVertex.visit();
		while(!vStack.isEmpty()) {
			VertexInterface<T> vertex = vStack.peek();
			VertexInterface<T> unVisitedNeighbour = vertex.getUnvisitedNeighbour();
			if(unVisitedNeighbour!=null) {
				unVisitedNeighbour.visit();
				vStack.push(unVisitedNeighbour);
				traversalQueue.add(unVisitedNeighbour.getLabel());
			}
			else {
				vStack.pop();
			}
		}
		return traversalQueue;
	}

	/**
	 * The idea is to do a DFS, and insert dead nodes into a stack.  dead nodes are the nodes
	 * whose neighbours if any have been visited. This way, a node will not be pushed onto the stack
	 * unless all of its adjacent {neighbours} have been visited.
	 * In essence, we are doing a reverse post order  traveral on the graph. Reverse because we are
	 * using a stack.
	 */
	@Override
	public Stack<T> getTopologicalOrder() {
		Enumeration<T> keyIterator = vertices.keys();
		Stack<T> outputStack = new Stack<>();
		while(keyIterator.hasMoreElements()) {
			T nextVertexKey = keyIterator.nextElement();
			VertexInterface<T> nextVertex = vertices.get(nextVertexKey);
				if(!nextVertex.isVisited()) {
				Stack<VertexInterface<T>> vStack = new Stack<>();
				vStack.push(nextVertex);
				nextVertex.visit();
				while(!vStack.isEmpty()) {
					VertexInterface<T> topVertex = vStack.peek();
					VertexInterface<T> unVisitedNeighbour = topVertex.getUnvisitedNeighbour();
					if(unVisitedNeighbour!=null) {
						vStack.push(unVisitedNeighbour);
					}
					else {
						VertexInterface<T> deadEndVertex = vStack.pop();
						outputStack.push(deadEndVertex.getLabel());
					}
				}
			}
		}
		return outputStack;
	}

	@Override
	public int getShortestPath(T begin, T end) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCheapestPath(T begin, T end) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addVertex(T vertexLabel) {
		boolean result=false;
		if(vertices.get(vertexLabel)==null) {
			vertices.put(vertexLabel, new Vertex<T>(vertexLabel));
			result=true;
		}
		return result; 
	}

	@Override
	public boolean addEdge(T begin, T end, double edgeWeight) {
		VertexInterface<T> beginVertex = vertices.get(begin);
		VertexInterface<T> endVertex = vertices.get(end);
		Boolean result=false;
		if(beginVertex!=null&&endVertex!=null) {
			result=beginVertex.connect(endVertex,edgeWeight);
		}
		if(result)
			edgeCount++;
		return result;
	}

	@Override
	public boolean addEdge(T begin, T end) {
		// TODO Auto-generated method stub
		return addEdge(begin,end,0);
	}

	@Override
	public boolean hasEdge(T begin, T end) {
		VertexInterface<T> beginVertex = vertices.get(begin);
		VertexInterface<T> endVertex = vertices.get(end);
		if(beginVertex!=null&&endVertex!=null) {
			Iterator<VertexInterface<T>> iterator = beginVertex.getNeighbourIterator();
			while(iterator.hasNext()) {
				VertexInterface<T> neighbour = iterator.next();
				if(neighbour.equals(end)) {
					return true;
				}
 			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return vertices.isEmpty();
	}

	@Override
	public int getNumberOfVertices() {
		return vertices.size();
	}

	@Override
	public int getNumberOfEdges() {
		return edgeCount;
	}

	@Override
	public void clear() {
		vertices=new Hashtable<>();
		edgeCount=0;
		
	}

}
