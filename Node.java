package DiGraph_A5;

import java.util.HashMap;

public class Node {
	HashMap<String, Edge> outEdges = new HashMap<>();
	HashMap<String, Edge> inEdges = new HashMap<>();

	String nodeName;
	Long nodeID;
	long dist;
	boolean known;
	
	public Node(String name, Long id) {
		nodeName = name;
		nodeID = id;
		
	}

	public void addOutEdge(Node n, Edge e) {
		outEdges.put(n.nodeName, e);
	}

	public void addInEdge(Node n, Edge e) {
		inEdges.put(n.nodeName, e);
	}

}
