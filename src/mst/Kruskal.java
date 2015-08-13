package mst;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import vertex.Vertex;
import edge.Edge;
import edge.EdgeComparator;

/**
 * 
 * @author gouthamvidyapradhan
 *
 * Krushkal's algorithm
 */
public class Kruskal 
{
	private Queue<Edge> pQ = new PriorityQueue<Edge>(20, new EdgeComparator());

	/**
	 * HashMap key acts as a representative of the disjoint set
	 */
	Map<String, Set<Vertex>> disjointSet = new HashMap<>();
	
	/**
	 * Set to keep track of final set of MST edges
	 */
	Set<Edge> mstEdges = new HashSet<>();
	
	/**
	 * total weight of the MST
	 */
	private int totalWeight;
	
	/**
	 * Constructor will initialize and instantiate the MST
	 * @param edges
	 */
	public Kruskal(List<Edge> edges) 
	{
		pQ.addAll(edges);
		for(Edge e : edges)
		{
			Set<Vertex> s1;
			Set<Vertex> s2;
			if(!disjointSet.containsKey(""+e.getV1().getIndex()))
			{
				s1 = new HashSet<>();
				s1.add(e.getV1());
				disjointSet.put(""+e.getV1().getIndex(), s1);
			}
			if(!disjointSet.containsKey(""+e.getV2().getIndex()))
			{
				s2 = new HashSet<>();
				s2.add(e.getV2());
				disjointSet.put(""+e.getV2().getIndex(), s2);
			}
		}
		run();
	}
	
	/**
	 * Build the MST
	 */
	private void run()
	{
		if(pQ.isEmpty())
		{
			System.out.println("MST cannot be performed on a empty tree");
		}
		else
		{
			while(!pQ.isEmpty())
			{
				Edge e = pQ.remove();
				String k1 = null;
				String k2 = null;
				for(String s : disjointSet.keySet())
				{
					if(disjointSet.get(s).contains(e.getV1()) 
							&& disjointSet.get(s).contains(e.getV2()))
					{
						//Including this edge would form a cycle, hence break
						break;
					}
					else if(disjointSet.get(s).contains(e.getV1()))
					{
						//Save the key
						k1 = s;
					}
					else if(disjointSet.get(s).contains(e.getV2()))
					{
						//Save the key
						k2 = s;
					}
					//if the keys are already found then break;
					if(k1 != null && k2 != null)
					{
						//Perform a union of two sets
						disjointSet.get(k1).addAll(disjointSet.get(k2));
						disjointSet.remove(k2);
						//Keep a count of total weight of the MST
						totalWeight += e.getWeight();
						//Save the MST edges
						mstEdges.add(e);
						break;
					}
				}
			}
		}
	}
	
	/**
	 * Show the MST path
	 */
	public void showMSTEdges()
	{
		if(disjointSet.keySet().size() > 1)
		{
			//If multiple disjoint set exists then there exits no MST
			System.out.println("MST does not exists");
		}
		else
		{
			Iterator<Edge> ite = mstEdges.iterator();
			while(ite.hasNext())
			{
				Edge e = ite.next();
				System.out.println(e.getV1().getIndex() + "->" + e.getV2().getIndex());
			}
		}
	}
	
	/**
	 * Total weight of the MST
	 * @return integer
	 */
	public int getTotalWeight()
	{
		return totalWeight;
	}
}
