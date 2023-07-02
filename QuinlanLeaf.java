package quinlan;

public class QuinlanLeaf {
	private String name;
	private String result;
	private Vertex parent;
	
	public QuinlanLeaf(String name, String result, Vertex parent) {
		this.name = name;
		this.result = result;
		this.parent = parent;
	}
	public void setParent(Vertex v) {
		this.parent = v;
	}
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return "--(" + this.name + ") -->> " + this.result;
	}
}
