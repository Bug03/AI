package quinlan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Vrate {
	private ArrayList<String> currentCase;
	private ArrayList<String> caseResult;
	private Map<String,Map<String, Double>> vRate = new HashMap<>();
	
	public Vrate(ArrayList<String> currentCase, ArrayList<String> caseResult, int index) {
		this.currentCase = new ArrayList<String>();
		this.caseResult = new ArrayList<String>();
		this.currentCase = currentCase;
		this.caseResult = caseResult;
		this.findVRate(Main.name.get(index));
	}
	public Map<String,Map<String, Double>> getVRate() {
		return this.vRate;
	}
	public int getVRateValue() {
		int count= 0;
		for(String s : vRate.keySet()) {
			for(String ss : vRate.get(s).keySet())
				if(vRate.get(s).get(ss) == 0.0 || vRate.get(s).get(ss) == 1.0)
					count++;	
		}
		return count;
	}
	public ArrayList<String> getTempResultCase(String caseName){
		ArrayList<String> tempResultCase = new ArrayList<>();
		for(int i = 0; i < this.currentCase.size(); i++)
			if(this.currentCase.get(i).equals(caseName))
				tempResultCase.add(this.caseResult.get(i));
		return tempResultCase;
	}
	public void findVRate(String caseName) {
		System.out.println("Case: " + caseName);
		Set<String> solvedCase = new HashSet<String>();
		for(String currentCase : currentCase) {
			if(!solvedCase.contains(currentCase) || solvedCase.isEmpty()) {
				solvedCase.add(currentCase);
				Map<String, Double> temp = new HashMap<>();
//				System.out.println(currentCase);
				double sum = Collections.frequency(this.currentCase, currentCase);
				ArrayList<String> tempResult = this.getTempResultCase(currentCase);
				Set<String> solvedResult = new HashSet<String>();
//				System.out.println(tempResult);
				for(String currentResult : tempResult) {
					if(!solvedResult.contains(currentResult) || solvedResult.isEmpty()) {
						solvedResult.add(currentResult);
//						System.out.println(currentResult);
//						System.out.println(Collections.frequency(tempResult, currentResult) + "/" + sum);
						temp.put(currentResult, Collections.frequency(tempResult, currentResult)/sum);
					}
				}
				vRate.put(currentCase, temp);
			}
		}
		
		for(String s : vRate.keySet()) {
			for(String ss : vRate.get(s).keySet())
				System.out.print(s + ", " + ss + " " + vRate.get(s).get(ss) + " ");
			System.out.println("");
		}
		System.out.println("\n");
		
	}


}
