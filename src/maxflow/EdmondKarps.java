package maxflow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import bfs.COLOUR;
import vertex.Vertex;

/**
 * 
 * @author gouthamvidyapradhan
 * Edmond karp's algorithm
 *
 * Time complexity O(E * V^2)
 */
public class EdmondKarps 
{
	/**
	 * Source vertex
	 */
	private Vertex source;
	
	/**
	 * Sink vertex
	 */
	private Vertex sink;
	
	/**
	 * AdjList
	 */
	private List<Vertex> vertices;

	/**
	 * BFS queue
	 */
	private Queue<Vertex> queue = new ArrayDeque<Vertex>();
	
	/**
	 * AdjMatrix to hold the residue graph values
	 */
	private int[][] adjMatrix;
	
	/**
	 * Max flow
	 */
	private int maxFlow = 0;
	
	/**
	 * Path parameters to the source vertex
	 */
	private List<Vertex> path = new ArrayList<Vertex>();
	
	/**
	 * Initialize the class member variables.
	 * @param vertices AjdList
	 * @param source Source vertex
	 * @param sink Sink vertex
	 * @param adjMatrix AdjMatrix to keep track of residue graph
	 */
	public EdmondKarps(List<Vertex> vertices, Vertex source, Vertex sink, int[][] adjMatrix)
	{
		this.vertices = vertices;
		this.source = source;
		this.sink = sink;
		this.adjMatrix = adjMatrix; 
	}
	
	/**
	 * Execute the Edmond Karp's algorithm
	 */
	public void execute()
	{
		Vertex dest;
		while((dest = search()) != null)
		{
			int minFlow = findAugmentFlow(dest);
			maxFlow += minFlow;
			augmentFlow(minFlow);
		}
	}
	
	/**
	 * Return max flow possible.
	 * @return integer
	 */
	public int getMaxFlow()
	{
		return maxFlow;
	}
	
	/**
	 * Perform a BFS search to identify the shortest path.
	 * This is a slightly modified BFS algorithm which breaks as soon as the sink vertex is identified
	 * @return Sink vertex
	 */
	private Vertex search()
	{
		//Initialize vertices.
		for(Vertex v : vertices)
		{
			v.setColour(COLOUR.WHITE);
			v.setParent(null);
			v.setDistance(Integer.MAX_VALUE);
		}
		//Enqueue the source
		
		source.setDistance(Integer.MAX_VALUE);
		queue.add(source);

		while(!queue.isEmpty())
		{
			Vertex v = queue.remove();
			for(Vertex c : v.getChildern())
			{
				//Check to avoid any cycle
				if(c.getColour() != COLOUR.BLACK)
				{
					if(adjMatrix[v.getIndex()][c.getIndex()] > 0)
					{
						c.setColour(COLOUR.GREY);
						c.setParent(v);
						c.setDistance(adjMatrix[v.getIndex()][c.getIndex()]);
						if(c.getIndex() == sink.getIndex())
						{
							queue.clear();
							return c;
						}
						queue.add(c);
					}
				}
			}
			v.setColour(COLOUR.BLACK);
		}
		queue.clear();
		return null;
	}
	
	/**
	 * Recursively backtrack to find the minimum flow possible.
	 * @param dest Sink vertex
	 * @return minimum possible flow.
	 */
	private int findAugmentFlow(Vertex dest)
	{
		while(dest.getIndex() != source.getIndex())
		{
			//int min = dest.getDistance() <= distance ? dest.getDistance() : distance;
			int distance = findAugmentFlow(dest.getParent());
			path.add(dest);
			return dest.getDistance() <= distance ? dest.getDistance() : distance;
		}
		path.add(dest);
		return dest.getDistance();
	}
	
	/**
	 * Augment the flow
	 * @param flow minimum possible flow
	 */
	private void augmentFlow(int flow)
	{
		for(int i=0; i<path.size()-1; i++)
		{
			Vertex v1 = path.get(i);
			Vertex v2 = path.get(i + 1);
			adjMatrix[v1.getIndex()][v2.getIndex()] = adjMatrix[v1.getIndex()][v2.getIndex()] - flow;
			adjMatrix[v2.getIndex()][v1.getIndex()] = adjMatrix[v2.getIndex()][v1.getIndex()] + flow;
		}
		path.clear();
	}
}
