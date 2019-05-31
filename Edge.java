package DiGraph_A5;

public class Edge {

	public Edge(long weight, long id, Node c1, Node c2) {
		edgeWeight = weight;
		edgeID = id;
		connection1 = c1;
		connection2 = c2;
		
		
	}
	Long edgeWeight;
	Long edgeID;
	Node connection1;
	Node connection2;
}
