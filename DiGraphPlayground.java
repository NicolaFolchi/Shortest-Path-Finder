package DiGraph_A5;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
//      exTest();
	  test();
    }
  
  public static void test() {
	  DiGraph d = new DiGraph();
//	  d.addNode(1,"f");
//	  d.addNode(3,"s");
//	  d.addEdge(0,"f","s", 1, null);
//	  System.out.println(d.delEdge("f", "s"));
	  
//	  System.out.println(d.delEdge("f","s")); // ==False
//			  d.addNode(1,"f");
//			  d.addNode(3,"s");
//			  d.addEdge(0,"f","s", 1, null);
//			  System.out.println(d.delEdge("f","s")); // ==True
//			  System.out.println(d.delEdge("f","s")); // ==False
//			  System.out.println(d.addEdge(0,"f","s", 1, null)); // ==True
//			  System.out.println(d.delEdge("f","s")); // ==True
	  
//	  d.addNode(1,"f"); //add node 1
//	  d.addNode(3,"s");
//	  d.addNode(7,"t");
//	  d.addEdge(0,"f","s", 1, null);
//	  System.out.println(d.addEdge(0, "f", "t", 1, null)); // ==False
			  
			 // NumNodeTest1

			  d.addNode(1, "f");
			  d.addNode(3, "s");
			  d.addNode(7, "t");
			  d.addNode(0, "fo");
			  d.delNode("f");
			  System.out.println(d.numNodes()); // ==3
  }
    public static void exTest(){
      DiGraph d = new DiGraph();
      d.addNode(1, "f");
      d.addNode(3, "s");
      d.addNode(7, "t");
      d.addNode(0, "fo");
      d.addNode(4, "fi");
      d.addNode(6, "si");
      d.addEdge(1, "f", "s", 0, null);
      d.addEdge(1, "f", "si", 0, null);
      d.addEdge(2, "s", "t", 0, null);
      d.addEdge(3, "fo", "fi", 0, null);
      d.addEdge(4, "fi", "si", 0, null);
      System.out.println("numEdges: "+d.numEdges());
      System.out.println("numNodes: "+d.numNodes());
    }
}