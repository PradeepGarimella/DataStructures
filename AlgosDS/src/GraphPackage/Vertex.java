package GraphPackage;

import java.util.Iterator;
import java.util.LinkedList;

import GraphPackage.Interfaces.VertexInterface;

public class Vertex<T> implements VertexInterface<T> {
	
	private T label;
	private LinkedList<Edge> edgeList;
	private boolean visited;
	private VertexInterface<T> predecessorVertex;
	private double cost;
	
	public Vertex(T vertextLabel) {
		this.label=vertextLabel;
		predecessorVertex=null;
		visited = false;
		edgeList = new LinkedList<Edge>();
		
	}

	@Override
	public T getLabel() {
		return label;
	}

	@Override
	public void visit() {
		visited=true;
	}

	@Override
	public void unvisit() {
		visited = false;
	}

	@Override
	public boolean isVisited() {
		return visited;
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
		boolean result = true;
		if(!this.equals(endVertex)) {
			Iterator<VertexInterface<T>> iterator = getNeighbourIterator();
			while(iterator.hasNext()) {
				VertexInterface<T> vertex = iterator.next();
				if(vertex.equals(endVertex)) {
					result=false; 
					break;
				}
			}
			
		}
		else {
			result=false;
		}
		if(result) {
			this.edgeList.add(new Edge(endVertex,0));
		}
		return result;
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex) {
		return connect(endVertex,0);
	}

	@Override
	public Iterator<VertexInterface<T>> getNeighbourIterator() {
		return new NeighbourIterator();
	}

	@Override
	public Iterator<Double> getWeightIterator() {
		return null;
	}

	@Override
	public boolean hasNeighbor() {
		return edgeList.isEmpty();
	}

	@Override
	public VertexInterface<T> getUnvisitedNeighbour() {
		Iterator<VertexInterface<T>> neighbours=this.getNeighbourIterator();
		while(neighbours.hasNext()&&neighbours!=null) {
			VertexInterface<T> obj = neighbours.next();
			if(!obj.isVisited()) {
				return obj;
			}
		}
		return null;
	}

	@Override
	public void setPredecessor(VertexInterface<T> predecessor) {
		this.predecessorVertex=predecessor;
	}

	@Override
	public VertexInterface<T> getPredecessor() {
		return predecessorVertex;
	}

	@Override
	public boolean hasPredecessor() {
		return predecessorVertex!=null;
	}

	@Override
	public void setCost(double newCost) {
		this.cost=newCost;
	}

	@Override
	public double getCost() {
		return cost;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other==null||this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			VertexInterface<T> t = (VertexInterface<T>) other;
			return t.getLabel().equals(this.getLabel());
		}
		
	}
	
	private class Edge {
		private VertexInterface<T> endVertex;
		private double cost;
		
		protected Edge(VertexInterface<T> endVertex) {
			this.endVertex=endVertex;
		}
		
		protected Edge(VertexInterface<T> endVertex, double cost) {
			this(endVertex);
			this.cost=cost;
		}

	}
	
	
	private class NeighbourIterator implements Iterator<VertexInterface<T>> {
		private Iterator<Edge> edges;
		private NeighbourIterator() {
			this.edges=edgeList.iterator();
		}

		@Override
		public boolean hasNext() {
			return edges.hasNext();
		}

		@Override
		public VertexInterface<T> next() {
			VertexInterface<T> next = null;
			if(edges.hasNext()) {
				Edge edgeToNextNeighbour = edges.next();
				next = edgeToNextNeighbour.endVertex;
			}
			return next;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}
