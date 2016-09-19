package bfs;

import java.util.ArrayList;
import java.util.List;

import vertex.Vertex;

public class Search {

	public static void main(String[] args) 
	{
		BFSSearch bfs = new BFSSearch();
		List<Vertex> vertices = new ArrayList<Vertex>(20);
		
		for(int i=0; i<15; i++)
		{
			Vertex v = new Vertex();
			v.setIndex(i);
		    //vertices.set(i, v);
			vertices.add(v);
		}
		
		vertices.get(0).setChild(vertices.get(1));
		vertices.get(0).setChild(vertices.get(2));
		vertices.get(0).setChild(vertices.get(3));
		
		vertices.get(1).setChild(vertices.get(5));
		vertices.get(1).setChild(vertices.get(6));
		
		vertices.get(2).setChild(vertices.get(7));
		vertices.get(2).setChild(vertices.get(8));
		
		vertices.get(3).setChild(vertices.get(4));
		vertices.get(3).setChild(vertices.get(9));
		
		vertices.get(5).setChild(vertices.get(10));
		vertices.get(6).setChild(vertices.get(11));
		vertices.get(7).setChild(vertices.get(12));
		vertices.get(8).setChild(vertices.get(13));
		vertices.get(9).setChild(vertices.get(14));
		
		bfs.bfs(vertices, vertices.get(0));
		System.out.println("BFS trace");
		bfs.dispaly();
		
		DFSSearch dfs = new DFSSearch();
		dfs.dfs(vertices, vertices.get(0));
		System.out.println("DFS trace");
		dfs.display();
	}

}
