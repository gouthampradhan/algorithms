package bfs;

import java.util.ArrayList;
import java.util.List;

import vertex.Vertex;

/**
 * 
 * @author gouthamvidyapradhan
 *
 * BSF search algorithm
 */
public class DFSSearch 
{
	private int time = 0;
	
	private List<Vertex> dfsTrace = new ArrayList<Vertex>();
	
	public void dfs(List<Vertex> vertices, Vertex source)
	{
		for(Vertex v : vertices)
		{
			v.setColour(COLOUR.WHITE);
			v.setParent(null);
		}
		source.setColour(COLOUR.WHITE);
		source.setParent(null);
		source.setStartTime(time++);
		dfsSearch(source);
	}
	
	private void dfsSearch(Vertex v)
	{
		for(Vertex c : v.getChildern())
		{
			if(c.getColour() == COLOUR.WHITE)
			{
				//discovery
				c.setStartTime(time++);
				//found
				c.setColour(COLOUR.GREY);
				//parent set
				c.setParent(v);
				//recursively invoke dfs search
				dfsSearch(c);
			}
		}
		//node found and complete
		v.setColour(COLOUR.BLACK);
		v.setFinishTime(time++);
		dfsTrace.add(v);
	}
	
	/**
	 * Display dfs trace
	 */
	public void display()
	{
		for(Vertex v : dfsTrace)
		{
			System.out.println(v.getIndex() + "->");
			System.out.print("Discovery Time: " + v.getStartTime() + " ");
			System.out.println("Finish Time: " + v.getFinishTime());
		}
	}
	
}
