package DiGraph_A5;
import java.util.Comparator;
public class MyComparator implements Comparator<Node> {

	public int compare(Node o1, Node o2) {
		if (o1.dist < o2.dist) {
			return -1;
		} else if (o1.dist > o2.dist) {
			return 1;
		} else
			return 0;
	}

}
