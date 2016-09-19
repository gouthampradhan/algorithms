package APSP;

/**
 * 
 * @author gouthamvidyapradhan
 *
 * Class to execute All Pair Shortest Path algorithm
 */
public class APSP {

	public static void main(String[] args) 
	{
		int[][] adjMatrix = new int[5][5];
		
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
		adjMatrix[0][1] = 2;
		adjMatrix[0][2] = 1;
		adjMatrix[0][4] = 3;
		
		adjMatrix[1][3] = 4;
		
		adjMatrix[2][1] = 1;
		adjMatrix[2][4] = 1;
		
		adjMatrix[3][0] = 1;
		adjMatrix[3][2] = 3;
		adjMatrix[3][4] = 5;

		FloydWarshalls fw = new FloydWarshalls(adjMatrix);
		fw.execute();
		fw.showAPSP();
		System.out.println("Shortest path between vertices 3 and 4 is: " + fw.getShortestPath(3, 4));
		//System.out.println(fw.getShortestPath(3, 4));
	}
}
