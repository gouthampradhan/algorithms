package maxflow;

import java.util.ArrayList;
import java.util.List;

import vertex.Vertex;

/**
 * 
 * @author gouthamvidyapradhan
 * 
 */
public class MaxFlow {

	public static void main(String[] args) 
	{
		List<Vertex> vertices = new ArrayList<Vertex>(20);
		
		for(int i=0; i<6; i++)
		{
			Vertex v = new Vertex();
			v.setIndex(i);
		    //vertices.set(i, v);
			vertices.add(v);
		}
		
		vertices.get(0).setChild(vertices.get(1));
		vertices.get(0).setChild(vertices.get(2));
		
		vertices.get(1).setChild(vertices.get(3));

		vertices.get(2).setChild(vertices.get(1));
		vertices.get(2).setChild(vertices.get(4));

		vertices.get(3).setChild(vertices.get(2));
		vertices.get(3).setChild(vertices.get(5));

		vertices.get(4).setChild(vertices.get(3));
		vertices.get(4).setChild(vertices.get(5));
		
		int[][] adjMatrix = new int[6][6];
		
		for(int i=0; i<adjMatrix.length; i++)
		{
			for(int j=0; j<adjMatrix.length; j++)
			{
				if(i == j)
				{
					adjMatrix[i][j] = 0;	
				}
				else
				{	
					adjMatrix[i][j] = Integer.MAX_VALUE/3;
				}
			}
		}
		
		adjMatrix[0][1] = 16;
		adjMatrix[0][2] = 13;
		adjMatrix[2][1] = 4;
		adjMatrix[2][4] = 14;
		adjMatrix[1][3] = 12;
		adjMatrix[3][2] = 9;
		adjMatrix[3][5] = 20;
		adjMatrix[4][3] = 7;
		adjMatrix[4][5] = 4;

		EdmondKarps ek = new EdmondKarps(vertices, vertices.get(0), vertices.get(5), adjMatrix);
		ek.execute();
		System.out.println(ek.getMaxFlow());
	}
}
