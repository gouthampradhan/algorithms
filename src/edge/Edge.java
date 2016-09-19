package edge;

import vertex.Vertex;

public class Edge
{
	private Vertex v1;
	private Vertex v2;
	private Integer weight;
	
	public Edge(Vertex v1, Vertex v2, Integer weight)
	{
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	public Vertex getV1() {
		return v1;
	}

	public void setV1(Vertex v1) {
		this.v1 = v1;
	}

	public Vertex getV2() {
		return v2;
	}

	public void setV2(Vertex v2) {
		this.v2 = v2;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
