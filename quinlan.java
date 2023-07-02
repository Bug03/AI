package quinlan;

import java.util.*;

public class quinlan {
	public ArrayList<ArrayList<String>> database = new ArrayList<>();
	public ArrayList<String> name = new ArrayList<>();
	
	
	public quinlan(ArrayList<ArrayList<String>> database, ArrayList<String> name) {
		this.database = database;
		this.name = name;
	}
//	public String TestData(ArrayList<ArrayList<String>> database, ArrayList<String> name, ArrayList<String> a  ) {
//		
//	}
	
	public ArrayList<ArrayList<String>> updateDatabase(String s, int index) {
		ArrayList<ArrayList<String>> tempDatabase = new ArrayList<>();
		for(int i = 0; i<database.size(); i++) {
			tempDatabase.add(new ArrayList<>());
			if(i==index) continue;
			else {
				for(int j = 0; j<database.get(i).size(); j++) {
					if(database.get(index).get(j).equals(s)) {
						tempDatabase.get(i).add(database.get(i).get(j));
					}	
				}
	
			}
		}
		tempDatabase.remove(index);
//		for(ArrayList<String> as : tempDatabase)
//			System.out.println(as);
		return tempDatabase;
	}
	public void build(Vertex parent) {
		PriorityQueue<Vertex> pqueue = new PriorityQueue<>();
		for(int i = 1; i<database.size()-1; i++) {
			Vertex vertex = new Vertex(name.get(i), i, new Vrate(database.get(i), database.get(database.size()-1), i));
			vertex.addLeaves();
			pqueue.add(vertex);
			
		}
		
		Vertex currentVertex = pqueue.poll();
		List<String> elements = new ArrayList<>();
		for(String s: database.get(currentVertex.getIndex()))
			if(!elements.contains(s))
				elements.add(s);
		if(parent!=null)
			currentVertex.setParent(parent);
		if(currentVertex.getVRate() == elements.size()) {
			System.out.println(currentVertex);
			return;
		}else {
			List<String> tempElement = new ArrayList<>();
			for(QuinlanLeaf ql : currentVertex.getLeaves())
				tempElement.add(ql.getName());
			System.out.println(tempElement);
			for(String string : database.get(currentVertex.getIndex())) {
				if(!tempElement.contains(string)) {
					tempElement.add(string);
					this.name.remove(currentVertex.getIndex());
					quinlan ql = new quinlan(this.updateDatabase(string, currentVertex.getIndex()), Main.name);
					ql.build(currentVertex);
				}
			}
		}
	}
	
}
