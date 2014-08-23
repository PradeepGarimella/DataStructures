package GraphPackage.Interfaces;

import java.util.Stack;

public class GraphTestingApp {
	
	public void testGraph() {
		DirectedGraph<String> directedGraph = new DirectedGraph<String>();
		directedGraph.addVertex("cs1");
		directedGraph.addVertex("cs2");
		directedGraph.addVertex("cs3");
		directedGraph.addVertex("cs4");
		directedGraph.addVertex("cs5");
		directedGraph.addVertex("cs6");
		directedGraph.addVertex("cs7");
		directedGraph.addVertex("cs8");
		directedGraph.addVertex("cs9");
		directedGraph.addVertex("cs10");
		directedGraph.addEdge("cs1", "cs2");
		directedGraph.addEdge("cs2", "cs4");
		directedGraph.addEdge("cs4", "cs7");
		directedGraph.addEdge("cs7", "cs9");
		directedGraph.addEdge("cs9", "cs10");
		directedGraph.addEdge("cs2", "cs5");
		directedGraph.addEdge("cs2", "cs3");
		directedGraph.addEdge("cs4", "cs6");
		directedGraph.addEdge("cs7", "cs8");
		directedGraph.addEdge("cs6", "cs8");







		
	






//		directedGraph.addVertex("40");
//		directedGraph.addVertex("10");
//		directedGraph.addVertex("20");
//		directedGraph.addVertex("8");
//		directedGraph.addVertex("23");
//		directedGraph.addVertex("30");
//
//		directedGraph.addEdge("40","10");
//		directedGraph.addEdge("40","20");
//		directedGraph.addEdge("10","8");
//		directedGraph.addEdge("10","23");
//		directedGraph.addEdge("20","30");

		

		
//		System.out.println(directedGraph.addVertex("A"));
//		System.out.println(directedGraph.addVertex("B"));
//		System.out.println(directedGraph.addVertex("C"));
//		System.out.println(directedGraph.addVertex("D"));
////		directedGraph.addEdge("A", "B");
////		directedGraph.addEdge("B", "C");
////		directedGraph.addEdge("B", "D");
////		directedGraph.addEdge("D", "C");
//
//
//		System.out.println(directedGraph.addVertex("E"));
//		System.out.println(directedGraph.addVertex("F"));
//		System.out.println(directedGraph.addVertex("G"));
//		System.out.println(directedGraph.addVertex("H"));
//		System.out.println(directedGraph.addVertex("I"));
//
//		
//
//
//
//		System.out.println(directedGraph.addEdge("A", "B"));
//		System.out.println(directedGraph.addEdge("A", "D"));
//		System.out.println(directedGraph.addEdge("A", "E"));
//		System.out.println(directedGraph.addEdge("B", "E"));
//		System.out.println(directedGraph.addEdge("D", "G"));
//		System.out.println(directedGraph.addEdge("E", "H"));
//		System.out.println(directedGraph.addEdge("G", "H"));
//		System.out.println(directedGraph.addEdge("H", "I"));
//		System.out.println(directedGraph.addEdge("I", "F"));
//		System.out.println(directedGraph.addEdge("E", "F"));
//		System.out.println(directedGraph.addEdge("F", "C"));
//		System.out.println(directedGraph.addEdge("C", "B"));
//		System.out.println(directedGraph.addEdge("F", "H"));









		Stack<String> q = directedGraph.getTopologicalOrder();
//		String str = "";
//		while(!q.isEmpty()) {
//			str += ","+q.pop();
//		}
		
		System.out.println(q);
		
	}

}
