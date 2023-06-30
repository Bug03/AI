package ID3;
import java.util.*;


public class Vertex {
	String Label;
	HashMap<String, HashMap<String, Integer>> AttributesHash = new HashMap<>();
	ArrayList <HashMap<String,Vertex>> AdjacentVer= new ArrayList<HashMap<String,Vertex>>();
	public Vertex() {
		Label = null;
	}
	public Vertex(String Label,String[] Attributes,String[] results) {
		this.Label = Label;
		for(int i=0; i< results.length;i++) {
			HashMap<String, Integer> hashMap1 = new HashMap<>();
			if(AttributesHash.get(Attributes[i]) != null) {
				if(AttributesHash.get(Attributes[i]).get(results[i])!=null) {
					int value = AttributesHash.get(Attributes[i]).get(results[i]);
					AttributesHash.get(Attributes[i]).put(results[i], value +1);
				}else {
					AttributesHash.get(Attributes[i]).put(results[i], 1);
				}
			}else {
		        hashMap1.put(results[i], 1);
		        AttributesHash.put(Attributes[i], hashMap1);
			}
		}
	}
	public Vertex(String label, HashMap<String, HashMap<String, Integer>> attributesHash,ArrayList <HashMap<String,Vertex>> adjacentVer) {
		Label = label;
		AttributesHash = attributesHash;
		AdjacentVer = adjacentVer;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public HashMap<String, HashMap<String, Integer>> getAttributesHash() {
		return AttributesHash;
	}
	public void setAttributesHash(HashMap<String, HashMap<String, Integer>> attributesHash) {
		AttributesHash = attributesHash;
	}
	public ArrayList <HashMap<String,Vertex>> getAdjacentVer() {
		return AdjacentVer;
	}
	public void setAdjacentVer(ArrayList <HashMap<String,Vertex>> adjacentVer) {
		AdjacentVer = adjacentVer;
	}
	public void addAdjacentVertex(HashMap<String,Vertex> vertex) {
	    AdjacentVer.add(vertex);
	}
	
	public int getSumAttributesValue() {
	    int totalValue = 0;
	    for (HashMap<String, Integer> h : getAttributesHash().values()) {
	        for (int value : h.values()) {
	            totalValue += value;
	        }
	    }
	    return totalValue;
	}
	public int getSumValue(HashMap<String, Integer> Attribute) {
		int sum = 0;
		for (int value : Attribute.values()) {
            sum += value;
        }
		return sum;
	}
	public double getSumLog2(HashMap<String, Integer> Attribute) {
		double sumLog2 = 0;
		int sumValue = getSumValue(Attribute);
		for  (int value : Attribute.values()) 
			sumLog2 += (-(double)value/sumValue) * (Math.log((double)value/sumValue) / Math.log(2));
        
		return sumLog2;
	}
	
	public double entropy() {
		double en = 0;
		for  (HashMap<String, Integer> attr : getAttributesHash().values())
			en+= ((double)getSumValue(attr)/getSumAttributesValue())*getSumLog2(attr);
		return en;
	}
	
	public HashMap<String, String> getLeaves() {
		HashMap<String, String> uniqueValuesMap = new HashMap<>();
        for (Map.Entry<String, HashMap<String, Integer>> entry : AttributesHash.entrySet()) {
            String key1 = entry.getKey();
            HashMap<String, Integer> newMap = entry.getValue();

            if (newMap.size() == 1) {
                String key2 = newMap.keySet().iterator().next();
                uniqueValuesMap.put(key1, key2);
            }
        }
		return uniqueValuesMap;
	}
	public HashMap<String, HashMap<String, Integer>> getMapSumLog2HashMapEquals0() {
	    HashMap<String, HashMap<String, Integer>> results = new HashMap<>();
	    for (Map.Entry<String, HashMap<String, Integer>> entry : AttributesHash.entrySet()) {
	        String key1 = entry.getKey();
	        HashMap<String, Integer> attribute = entry.getValue();
	        
	        if (getSumLog2(attribute) != 0) {
	            results.put(key1, attribute);
	        }
	    }
	    
	    return results;
	}
	public boolean isLeaf() {
	    for (HashMap<String, Integer> attribute : AttributesHash.values()) {
	        if (attribute.size() != 1) {
	            return false;
	        }
	    }
	    return true;
	}
	public boolean checkAttributes(String text) {
	    if (AttributesHash.containsKey(text)) {
	        HashMap<String, Integer> innerHash = AttributesHash.get(text);
	        return innerHash.size() == 1;
	    }
	    return false;
	}
	public String toString() {
		String s="";
		
		s+= "*"+Label +" (entropy= "+entropy()+" )" + "\n" +"\t|" ;
		HashMap<String, String> leaves = getLeaves();
		for (Map.Entry<String, String> entry : leaves.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    s +="\n\t|----"+ key + " -> " + value + "";
		   
		    
		}
		if (!isLeaf()) {
			for (HashMap<String,Vertex> map1 : AdjacentVer) 
	            s += "\n-" + map1.keySet()+ map1.values().toString() ;
		}
	
		return s;
	}
	public String toString1(String s) {
		String S ="";
		for (Map.Entry<String,String> entry : getLeaves().entrySet()) {
			String newS = s; 
			S+= newS+ getLabel() + ":" +entry.getKey() + " thi " + entry.getValue() +"\n";
		}
		for(HashMap<String,Vertex> newMap:AdjacentVer) {
			for (Map.Entry<String,Vertex> entry : newMap.entrySet()) {
				String newString = getLabel() + ":" +entry.getKey();
				S+=s + entry.getValue().toString1(newString + " va ");
			}
			
		}
			return  S;
		}
		
		
	
}
