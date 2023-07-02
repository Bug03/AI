package quinlan;

import java.util.ArrayList;
import java.util.Map;


public class Vertex implements Comparable<Vertex>{
	private String name;
	private int index;
	private Vertex parent;
	private ArrayList<QuinlanLeaf> leaves;
	private Vrate vRate;
	//Constructor
	public Vertex(String name, int index, Vrate v) {
		this.name = name;
		this.index = index;
		this.parent = null;
		this.leaves = new ArrayList<>();
		this.vRate = v;
	}
	//getter n setter
	public void setParent(Vertex p) {
		this.parent = p;
	}
	public Vertex getParent() {
		return this.parent;
	}
	public int getIndex() {
		return this.index;
	}
	public String getName() {
		return this.name;
	}
	public int getVRate() {
		return this.vRate.getVRateValue();
	}
	//function
	public void addLeaves() {
		Map<String,Map<String, Double>> tempVRate = this.vRate.getVRate();
		ArrayList<QuinlanLeaf> tempLeaves = new ArrayList<>();
		for(String s : tempVRate.keySet()) {
			for(String ss : tempVRate.get(s).keySet())
				if(tempVRate.get(s).get(ss) == 0.0 || tempVRate.get(s).get(ss) == 1.0)
					tempLeaves.add(new QuinlanLeaf(s, ss, this));
		}
		this.leaves = tempLeaves;
	}
	public ArrayList<QuinlanLeaf> getLeaves(){
		return this.leaves;
	}
	public String toString() {
		if(this.parent!=null)
			System.out.println(this.parent);
		String root = "";
		String s = "";
		if(this.parent != null)
			root += "[" + this.parent.name + "] -->> ";
		root+= "[" + this.name +"]\n";
		s = root;
		for(QuinlanLeaf l:this.leaves) {
			s += String.format("%"+root.length()+"s", " ") + l + "\n";
		}
		return s;
	}
	@Override
	public int compareTo(Vertex v) {
		if(this.getVRate() < v.getVRate()) return 1;
		else if (this.getVRate() > v.getVRate()) return -1;
		else return 0;
	}
}
