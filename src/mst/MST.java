package mst;

import java.util.ArrayList;
import java.util.List;

import vertex.Vertex;
import edge.Edge;

public class MST 
{
	public static void main(String[] args) 
	{
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		Vertex v7 = new Vertex(7);
		Vertex v8 = new Vertex(8);
		Vertex v9 = new Vertex(9);
		Edge e1 = new Edge(v1, v2, 4);
		Edge e2 = new Edge(v1, v3, 8);
		Edge e3 = new Edge(v2, v3, 11);
		Edge e4 = new Edge(v2, v4, 8);
		Edge e5 = new Edge(v3, v5, 7);
		Edge e6 = new Edge(v4, v5, 2);
		Edge e7 = new Edge(v5, v6, 6);
		Edge e8 = new Edge(v3, v6, 1);
		Edge e9 = new Edge(v4, v8, 4);
		Edge e10 = new Edge(v6, v8, 2);
		Edge e11 = new Edge(v7, v8, 14);
		Edge e12 = new Edge(v7, v9, 9);
		Edge e13 = new Edge(v8, v9, 10);
		Edge e14 = new Edge(v4, v7, 7);
		List<Edge> list = new ArrayList<Edge>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		list.add(e10);
		list.add(e11);
		list.add(e12);
		list.add(e13);
		list.add(e14);
		
		Kruskal k = new Kruskal(list);
		System.out.println(k.getTotalWeight());
		k.showMSTEdges();
	}
}
