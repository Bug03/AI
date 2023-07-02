package Taci;

public class Vertex<T> implements Comparable<Vertex>{
    Vertex parent;
    private State state;
    private int g,h = 0, f = 0;
    private int s = 0;
    

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public Vertex(){
        this.state = new State();
        this.parent = null;
    }
    
    public Vertex(State state){
        this.state = state;        
        this.parent = null;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }
    
    public Vertex getParent() {
        return parent;
    }
    
    public Vertex moveUp(int zeroRow , int zeroCol) {
        return new Vertex(state.moveUp(zeroRow,zeroCol));
    }
    
    public Vertex moveDown(int zeroRow , int zeroCol) {
        return new Vertex(state.moveDown(zeroRow,zeroCol));
    }
    
    public Vertex moveLeft(int zeroRow , int zeroCol) {
        return new Vertex(state.moveLeft(zeroRow,zeroCol));
    }
    
    public Vertex moveRight(int zeroRow , int zeroCol) {
        return new Vertex(state.moveRight(zeroRow,zeroCol));
    }
    
    public Path tracePath(){
        Path<Vertex> path = new Path();
        Vertex v = new Vertex();
        
        v = this;
        
        while (v != null){
            path.addVertex(v);
            v = v.getParent();
        }
        
        return path;
    }
    
    public void setF() {
        this.f = g + h;
    }

    public int getF() {
        return f; 
    }

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	@Override
    public String toString(){
        return state.toString();
    }

	
	@Override
	public int compareTo(Vertex o) {
		if (this.getF() > o.getF())
	        return 1;
	    else if (this.getF() < o.getF())
	        return -1;
	    else
	        return 0;
	}
	
    
}