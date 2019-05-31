package DiGraph_A5;

import java.util.HashMap;
import java.util.PriorityQueue;

public class DiGraph implements DiGraphInterface {

	// in here go all your data and methods for the graph

	public DiGraph() { // default constructor
		// explicitly include this
		// we need to have the default constructor
		// if you then write others, this one will still be there
	}
	
	HashMap <String, Node> nodeMap = new HashMap<>();
	HashMap <Long, Node> idMap = new HashMap<>();
	
	HashMap <String, Edge> edgeMap = new HashMap<>();
	HashMap <Long, Edge> edgeIdMap = new HashMap<>();
	
	PriorityQueue<Node> myQ;
	
	int nodes = 0;
	int edges = 0;

	@Override
	public boolean addNode(long idNum, String label) {
		if(nodeMap.containsKey(label) || label == null) { // checking for existing name of node
			return false;
		}
		if(idMap.containsKey(idNum) || idNum < 0) { // checking for existing id node
			return false;
		} else {
			Node n = new Node(label, idNum);
			nodeMap.put(label, n);
			idMap.put(idNum, n);
			nodes++;
			return true;
		}
	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		
		
		if(nodeMap.containsKey(sLabel) != true) { // checking for source node in graph
			return false;
		}
		if(nodeMap.containsKey(dLabel) != true) { // checking for destination node in graph
			return false;
		}

		if(nodeMap.get(sLabel).outEdges.containsKey(dLabel) && nodeMap.get(dLabel).inEdges.containsKey(sLabel)) {
			return false;
		}
		if(edgeIdMap.containsKey(idNum) || idNum < 0) { // checking for existing id edge
			return false;
		} else {
			
			long w;
			if(weight < 1) {
				w = 1;
			} else {
				w = weight;
			}
			
			Edge e = new Edge(w, idNum, nodeMap.get(sLabel), nodeMap.get(dLabel));

			nodeMap.get(sLabel).addOutEdge(nodeMap.get(dLabel), e); // registering to s node an out edge from s to d node.
			nodeMap.get(dLabel).addInEdge(nodeMap.get(sLabel), e); // registering to d node an in edge comming from s to d node.

			edgeMap.put(eLabel, e);
			edgeIdMap.put(idNum, e);
			
			edges++;
			return true;
		}
	}

	@Override
	public boolean delNode(String label) {
		if(nodeMap.containsKey(label) == true) {
			int counter = 0;
			for(Edge e : nodeMap.get(label).inEdges.values()) {
				e.connection1.inEdges.remove(label);
				counter++;
			}
			for(Edge e : nodeMap.get(label).outEdges.values()) {
				e.connection2.inEdges.remove(label);
				counter++;
			}
			
			nodeMap.get(label).inEdges = null; // removing edges
			nodeMap.get(label).outEdges = null; // removing edges
//			idMap.get(label).inEdges = null; // removing edges  ?????
//			idMap.get(label).outEdges = null; // removing edges  ????
			idMap.remove(nodeMap.get(label).nodeID);
			nodeMap.remove(label);
			nodes--;
			edges -= counter;
			return true;
		} else
		return false;
	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		if(nodeMap.containsKey(sLabel) == true) {
			if(nodeMap.containsKey(dLabel) == true) {
				if(nodeMap.get(sLabel).outEdges.containsKey(dLabel) && nodeMap.get(dLabel).inEdges.containsKey(sLabel)) {
					edgeIdMap.remove(nodeMap.get(sLabel).outEdges.get(dLabel).edgeID);
					nodeMap.get(sLabel).outEdges.remove(dLabel);
					nodeMap.get(dLabel).inEdges.remove(sLabel);
					edges--;
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public long numNodes() {
		return nodes;
	}

	@Override
	public long numEdges() {
		return edges;
	}

	@Override
	public ShortestPathInfo[] shortestPath(String label) {
		myQ = new PriorityQueue<Node>(11, new MyComparator());
		
		for(Node n : nodeMap.values()){
			n.dist = Long.MAX_VALUE;
			n.known = false;
		}
		
		Node newNode = nodeMap.get(label);
		newNode.dist = 0;
		myQ.add(newNode);
		
		while(myQ.isEmpty() != true) {
			Node removeNode = myQ.remove();
			removeNode.known = true;
			
			for(Edge n : removeNode.outEdges.values()) { // ILL GO THROUGH EVERY EDGE IN THE GRAPH - FIX??
				Node node = n.connection2; 
				if(!node.known) {
					long distance = removeNode.dist + n.edgeWeight;
					if(distance < node.dist) {
						node.dist = distance;
						myQ.add(node);
					}
					
				}
				
			}
			
		}
		ShortestPathInfo[] myarray = new ShortestPathInfo[nodeMap.size()];
		
		int counter = 0;
		
		for(String s : nodeMap.keySet()) {
			Node n = nodeMap.get(s);
			if(n.dist == Long.MAX_VALUE) {
				n.dist = -1;
			}
			
			ShortestPathInfo myShort = new ShortestPathInfo(n.nodeName, n.dist);
			myarray[counter] = myShort;
			counter++;
		}
		return myarray;
	}
}