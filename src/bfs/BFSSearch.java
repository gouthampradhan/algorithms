package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import vertex.Vertex;

public class BFSSearch 
{
	private Queue<Vertex> queue = new ArrayDeque<Vertex>();
	
	private List<Vertex> path = new ArrayList<Vertex>();
	
	private int distance = 0;
	
	public void dispaly()
	{
		for(Vertex v : path)
		{
			System.out.print(v.getIndex() + "->");
		}
	}
	
	public void bfs(List<Vertex> vertices, Vertex source)
	{
		//Initialize vertices.
		for(Vertex v : vertices)
		{
			v.setColour(COLOUR.WHITE);
			v.setParent(null);
			v.setDistance(Integer.MAX_VALUE);
		}
		//Enqueue the source
		
		source.setDistance(0);
		queue.add(source);

		while(!queue.isEmpty())
		{
			Vertex v = queue.remove();
			for(Vertex c : v.getChildern())
			{
				//queue.addAll(v.getChildern());	
				if(c.getColour() == COLOUR.WHITE)
				{
					c.setColour(COLOUR.GREY);
					c.setDistance(distance + 1);
					c.setParent(v);
					queue.add(c);
				}
			}
			v.setColour(COLOUR.BLACK);
			path.add(v);
		}
	}
}
