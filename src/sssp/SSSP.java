package sssp;

import java.util.ArrayList;
import java.util.List;

import vertex.Vertex;

public class SSSP {

	public static void main(String[] args) 
	{
		List<Vertex> vertices = new ArrayList<Vertex>(20);
		
		Vertex v1 = new Vertex(1);
		v1.setChild(new Vertex(3));
		v1.setChild(new Vertex(4));
		
		v1.getChild(3).setDistance(3);
		v1.getChild(4).setDistance(6);
		//-----------------------------------------------		
		Vertex v2 = new Vertex(2);
		v2.setChild(new Vertex(1));
		v2.setChild(new Vertex(3));
		v2.setChild(new Vertex(5));
		
		v2.getChild(1).setDistance(2);
		v2.getChild(3).setDistance(7);
		v2.getChild(5).setDistance(6);
		//-----------------------------------------------
		Vertex v3 = new Vertex(3);
		v3.setChild(new Vertex(4));
		
		v3.getChild(4).setDistance(5);
		//-----------------------------------------------
		Vertex v4 = new Vertex(4);
		//-----------------------------------------------
		Vertex v5 = new Vertex(5);
		v5.setChild(new Vertex(4));

		v5.getChild(4).setDistance(1);

		vertices.add(0, null);
		vertices.add(v1.getIndex(), v1);
		vertices.add(v2.getIndex(), v2);
		vertices.add(v3.getIndex(), v3);
		vertices.add(v4.getIndex(), v4);
		vertices.add(v5.getIndex(), v5);
		
		Dijkstras sssp = new Dijkstras(vertices, v2);
		sssp.execute();
		System.out.println("Distance to 1: " + sssp.getDistanceTo(1));
		System.out.println("Distance to 3: " + sssp.getDistanceTo(3));
		System.out.println("Distance to 4: " + sssp.getDistanceTo(4));
		System.out.println("Distance to 5: " + sssp.getDistanceTo(5));
	}
}
