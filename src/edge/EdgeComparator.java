package edge;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> 
{
	@Override
	public int compare(Edge e1, Edge e2) 
	{
		return e1.getWeight().compareTo(e2.getWeight());
	}
}
