package APSP;

/**
 * 
 * @author gouthamvidyapradhan
 * 
 * FloydWarshall's algorithm
 * Time complexity O(V^3)
 *
 */
public class FloydWarshalls 
{
	/**
	 * AdjMatrix
	 */
	private int[][] adjMatrix;
	
	/**
	 * Initialize input parameters
	 * 
	 * @param adjMatrix
	 */
	public FloydWarshalls(int[][] adjMatrix) 
	{
		this.adjMatrix = adjMatrix;
	}
	
	/**
	 * Execute the FloydWarshall's algorithm
	 */
	public void execute()
	{
		for(int k=0; k<adjMatrix.length; k++)
		{
			for(int i=0; i<adjMatrix.length; i++)
			{
				for(int j=0; j<adjMatrix.length; j++)
				{
					//Check if there is a intermediate path with minimum distance.
					int intermediate = adjMatrix[i][k] + adjMatrix[k][j];
					adjMatrix[i][j] = intermediate < adjMatrix[i][j] ? intermediate : adjMatrix[i][j];
				}
			}
		}
	}
	
	/**
	 * Get the shortest path between two vertices
	 * @param v1 Vertex 1
	 * @param v2 Vertex 2
	 * @return shortest path between vertices OR -1
	 */
	public int getShortestPath(int v1, int v2)
	{
		if(adjMatrix != null && (v1 <= adjMatrix.length && v2<= adjMatrix.length) )
		{
			return adjMatrix[v1][v2];
		}
		return -1;
	}
	
	/**
	 * Display all the shortest paths 
	 */
	public void showAPSP()
	{
		for(int i=0; i<adjMatrix.length; i++)
		{
			for(int j=0; j<adjMatrix.length; j++)
			{
				System.out.print(adjMatrix[i][j] + " ");
				if(j == adjMatrix.length - 1)
					System.out.println("");	
			}
		}	
	}
}
