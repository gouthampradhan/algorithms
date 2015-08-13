package vertex;

import java.util.ArrayList;
import java.util.List;

import bfs.COLOUR;

public class Vertex
{
	private int index;
	private Integer distance;
	private Vertex parent;
	private COLOUR colour;
	private int startTime;
	private int finishTime;
	
	public Vertex()
	{
		
	}
	
 	public Vertex(int index)
	{
		this.index = index;
	}

	private List<Vertex> childern = new ArrayList<Vertex>(); 
	
	public void setChild(Vertex c)
	{
		if(childern == null)
		{
			childern = new ArrayList<Vertex>();
		}
		this.childern.add(c);
	}
	
	public Vertex getChild(int index)
	{
		for(Vertex v : childern)
		{
			if(v.getIndex() == index)
			{
				return v;
			}
		}
		return null;
	}
	
	public List<Vertex> getChildern() {
		return childern;
	}
	public void setChildern(List<Vertex> childern) {
		this.childern = childern;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Vertex getParent() {
		return parent;
	}
	public void setParent(Vertex parent) {
		this.parent = parent;
	}
	public COLOUR getColour() {
		return colour;
	}
	public void setColour(COLOUR colour) {
		this.colour = colour;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	
}
