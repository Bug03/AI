package coloring;

import java.util.ArrayList;

public class Vertex<T>{
	private ArrayList adjVertex;
	private int degree;
	private int color = 1;
	private T name;
	private boolean colored;
	

	public Vertex(T name) {
		this.colored = false;
		this.name = name;
		this.adjVertex = new ArrayList<>();
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public ArrayList<Vertex> getAdjVertex() {
		return adjVertex;
	}

	public void addAdj(Vertex adjVertex) {
		this.adjVertex.add(adjVertex);
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public boolean isColored() {
		return colored;
	}

	public void setColored(boolean colored) {
		this.colored = colored;
	}


}