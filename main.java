package ID3;
//Nguyễn Cảnh Hoàng Danh MSSV: 3121411034!!
import java.util.*;

public class Main {

	public static void main(String[] args) {
		String[] attributes = {"Mau toc", "Chieu cao", "Can nang", "Dung kem","Ket qua"};
		String[][] data = {
			{"Vang", "Trung binh", "Nhe", "Khong", "Chay nang"},
			{"Vang", "Cao", "Trung binh", "Co", "Khong chay nang"},
			{"Nau", "Thap", "Trung binh", "Co", "Khong chay nang"},
			{"Vang", "Thap", "Trung binh", "Khong", "Chay nang"},
			{"Do", "Trung binh", "Nang", "Khong", "Chay nang"},
			{"Nau", "Cao", "Nang", "Khong", "Khong chay nang"},
			{"Nau", "Trung binh", "Nang", "Khong", "Khong chay nang"},
			{"Vang", "Thap", "Nhe", "Co", "Khong chay nang"}
		};
		
//		String[] attributes = {"Dang", "Chieu cao", "Gioi tinh","Nguoi"};
//		String[][] data = {
//			{"To", "Trung binh", "Nam", "Chau A"},
//			{"Nho", "Thap", "Nam", "Chau A"},
//			{"Nho", "Trung binh", "Nam", "Chau A"},
//			{"To", "Cao", "Nam", "Chau Au"},
//			{"Nho", "Trung binh", "Nu", "Chau Au"},
//			{"Nho", "Cao", "Nam", "Chau Au"},
//			{"Nho", "Cao", "Nu", "Chau Au"},
//			{"To", "Trung binh", "Nu", "Chau Au"}
//		};
		Vertex V = ID3(data, attributes);
		System.out.println(V +"\n");

		System.out.println("------------------\nBo luat: \n" +V.toString1(""));
		
		
		System.out.println("------------------\nTest data:\n");

//		String[] testdata= {"To","Cao","Nam"};
		String[] testdata= {"Vang","Cao","Nang","Khong"};
		String[] testdata1= {"Nau","Thap","Nang", "Co"};
		String[] testdata2= {"Vang","Trung binh","Nang"};
		String[] testdata3= {"Vang"};
		
		
		
		System.out.println(classify(V, testdata, attributes));
		System.out.println(classify(V, testdata1, attributes));
		System.out.println(classify(V, testdata2, new String[] {"Mau toc","Chieu cao","Can nang", "Ket qua"}));
		System.out.println(classify(V, testdata3, new String[] {"Mau toc","Ket qua"}));
	

	}
	public static Vertex ID3(String data[][],String label[]) {
	        String[] lastColumn = cloneColumn(data,data[0].length-1);
	       	ArrayList<Vertex> Vertices = new ArrayList<Vertex>();
	       	for(int i=0;i<(label.length-1);i++) 
	       		Vertices.add(new Vertex(label[i], cloneColumn(data,i),lastColumn));
	       	 Vertex Min=  Vertices.get(0);
	       	for (Vertex V: Vertices) 
    			if (V.entropy()<Min.entropy()) 
	    			Min = V;

	       	for (Map.Entry<String, HashMap<String, Integer>> entry : Min.getMapSumLog2HashMapEquals0().entrySet()) {
	       	    String key1 = entry.getKey();
	       	    String Label = Min.getLabel();
	       	    int index = getIndex(label, Label);
	       	    ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(label));
	       	 	arrayList.remove(index);
	       	 	String[] newLabel = arrayList.toArray(new String[0]);
	       	 	HashMap<String,Vertex> newMap = new HashMap<String,Vertex>();
	       	 	newMap.put(key1, ID3(cloneAndRemoveColumn(data, key1,index), newLabel));
	       		Min.addAdjacentVertex(newMap);

	       	}
	       	return Min;
	}
	public static String[] cloneColumn(String[][] data, int columnIndex) {
	        int numRows = data.length;
	        String[] column = new String[numRows];
	        for (int i = 0; i < numRows; i++) {
	            column[i] = data[i][columnIndex];
	        }
	        return column;
	    }

	public static String[][] cloneAndRemoveColumn(String[][] array, String value1, int column1) {
	    List<String[]> tempRows = new ArrayList<>();
	    for (String[] row : array) {
	        if (row[column1].equals(value1)) {
	            tempRows.add(row);
	        }
	    }
	    String[][] result = new String[tempRows.size()][array[0].length - 1];
	    for (int i = 0; i < tempRows.size(); i++) {
	        String[] tempRow = tempRows.get(i);
	        int index = 0;
	        for (int j = 0; j < tempRow.length; j++) {
	            if (j != column1) {
	                result[i][index++] = tempRow[j];
	            }
	        }
	    }
	    return result;
	}
	public static int getIndex(String[] A, String value) {
	    for (int i = 0; i < A.length; i++) {
	        if (A[i] == value) {
	            return i; 
	        }
	    }
	    return -1;
	}
	public static String classify(Vertex v, String[] testdata, String[] label) {
		String s = "data:"+ Arrays.toString(testdata)+"\n";
		Vertex currentVertex= v;
		String LABEL, attribute;
		int indexLabel;
		while(true) {
			LABEL = currentVertex.getLabel();
			indexLabel = getIndex(label, LABEL);
			if(indexLabel <= -1) {
				return "data:"+ Arrays.toString(testdata)+"\n" + "-> Thieu thong tin " + LABEL +"\n";
			}
			attribute = testdata[indexLabel];
			s+= currentVertex.getLabel() + ":" + attribute;
			if(currentVertex.checkAttributes(attribute)){
			 for (String key : currentVertex.getAttributesHash().get(attribute).keySet()) 
	                s+= "\n-> " +label[label.length-1] +": " + key +"\n";
			 return s;
			}else { 
				s+= " & ";
				Vertex maptest = null;
				for(HashMap<String,Vertex> map1: currentVertex.getAdjacentVer()) 
					if(map1.get(attribute) != null) {
						currentVertex = map1.get(attribute);
						maptest = map1.get(attribute);
					}
				
				if(maptest == null) 
					return "data:"+ Arrays.toString(testdata)+"\n" + "-> Khong du thong tin \n";
				
				
			
			
		}
	}
	
}
}
