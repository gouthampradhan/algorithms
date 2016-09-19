package sssp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import vertex.Vertex;
import vertex.VertexComparator;

/**
 * 
 * @author gouthamvidyapradhan
 *
 * Dijkstras algorithm
 */
public class Dijkstras 
{

	/**
	 * Priority Queue of minimum distance.
	 */
	private Queue<Vertex> pQ = new PriorityQueue<Vertex>(20, new VertexComparator());
	
	/**
	 * HashMap to keep track of the minimum distance to vertices
	 */
	private Map<String, Integer> sssp = new HashMap<>();
	
	/**
	 * AdjList of vertices
	 */
	private List<Vertex> vertices = new ArrayList<Vertex>();
	/**
	 * Initialize Dijkstra's 
	 * 
	 * @param vertices AdjList
	 * @param source Source vertex
	 */
	public Dijkstras(List<Vertex> vertices, Vertex source) 
	{
		this.vertices = vertices;
		
		if(this.vertices != null && source != null)
		{
			//Initialize the sssp of vertices set to INFINITE
			for(Vertex v : this.vertices)
			{
				if(v != null)
				{
					sssp.put(String.valueOf(v.getIndex()), Integer.MAX_VALUE);
				}
			}
			//initialize the source distance to 0 and add it to the priority queue.
			source.setDistance(0);
			sssp.put(String.valueOf(source.getIndex()), 0);
			pQ.add(source);
		}
		else
		{
			System.out.println("AdjList and source cant be null");
		}
	}
	
	/**
	 * Executes the Dijkstra's algorithm
	 */
	public void execute()
	{
		while(!pQ.isEmpty())
		{
			Vertex v = pQ.remove();
			relax(this.vertices.get(v.getIndex()));
		}
	}
	
	/**
	 * Relax reach vertex
	 * @param v
	 */
	private void relax(Vertex v)
	{
		for(Vertex c : v.getChildern())
		{
			int newDistance = c.getDistance() + sssp.get(String.valueOf(v.getIndex()));
			
			int oldDistance = sssp.get(String.valueOf(c.getIndex()));
			
			//Include the new minimum in the SSSP
			sssp.put(String.valueOf(c.getIndex()), (newDistance < oldDistance) ? newDistance : oldDistance);
			
			//Include in the priority queue
			pQ.add(c);
		}
	}
	/**
	 * 
	 * @param vertexId
	 * @return
	 */
	public int getDistanceTo(int vertexId)
	{
		if(sssp.containsKey(String.valueOf(vertexId)))
		{
			return sssp.get(String.valueOf(vertexId));
		}
		System.out.println("Vertex not found!");
		return -1;
	}
}
