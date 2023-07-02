package quinlan;
// Nguyễn Cảnh Hoàng Danh MSSV: 3121411034!!
import java.util.*;
public class Main {
	public static ArrayList<ArrayList<String>> database = new ArrayList<>();
	public static ArrayList<String> name = new ArrayList<>();
	
	
	public static void updateDatabase(String s, int index) {
		ArrayList<String> indexValue = database.get(index);
		database.remove(index);
		ArrayList<ArrayList<String>> tempDatabase = new ArrayList<>();
		for(int i = 0; i<database.size(); i++) {
			tempDatabase.add(new ArrayList<>());
			for(int j = 0; j<database.get(i).size(); j++)
				if(database.get(index).get(j).equals(s))
					tempDatabase.get(i).add(database.get(i).get(j));
		database = tempDatabase;
		name.remove(index);
		}
	}
	
	public static void main(String[] args) {
		
		database.add(new ArrayList<>()); 
		name.add("Tên");
		database.get(0).add("Sarah");
		database.get(0).add("Dana");
		database.get(0).add("Alex");
		database.get(0).add("Annie");
		database.get(0).add("Emily");
		database.get(0).add("Peter");
		database.get(0).add("John");
		database.get(0).add("Katie");
		database.add(new ArrayList<>());
		name.add("Màu tóc");
		database.get(1).add("Vàng");
		database.get(1).add("Vàng");
		database.get(1).add("Nâu");
		database.get(1).add("Vàng");
		database.get(1).add("Đỏ");
		database.get(1).add("Nâu");
		database.get(1).add("Nâu");
		database.get(1).add("Vàng");
		database.add(new ArrayList<>());
		name.add("Chiều cao");
		database.get(2).add("Trung bình");
		database.get(2).add("Cao");
		database.get(2).add("Thấp");
		database.get(2).add("Thấp");
		database.get(2).add("Trung bình");
		database.get(2).add("Cao");
		database.get(2).add("Trung bình");
		database.get(2).add("Thấp");
		database.add(new ArrayList<>());
		name.add("Cân nặng");
		database.get(3).add("Nhẹ");
		database.get(3).add("Trung bình");
		database.get(3).add("Trung bình");
		database.get(3).add("Trung bình");
		database.get(3).add("Nặng");
		database.get(3).add("Nặng");
		database.get(3).add("Nặng");
		database.get(3).add("Nhẹ");
		database.add(new ArrayList<>());
		name.add("Dùng kem");
		database.get(4).add("Không");
		database.get(4).add("Có");
		database.get(4).add("Có");
		database.get(4).add("Không");
		database.get(4).add("Không");
		database.get(4).add("Không");
		database.get(4).add("Không");
		database.get(4).add("Có");
		database.add(new ArrayList<>());
		name.add("Kết quả");
		database.get(5).add("Cháy nắng");
		database.get(5).add("Không cháy nắng");
		database.get(5).add("Không cháy nắng");
		database.get(5).add("Cháy nắng");
		database.get(5).add("Cháy nắng");
		database.get(5).add("Không cháy nắng");
		database.get(5).add("Không cháy nắng");
		database.get(5).add("Không cháy nắng");

////		dữ liệu 2
//		database.add(new ArrayList<>());
//		name.add("Người");
//		database.get(0).add("1");
//		database.get(0).add("2");
//		database.get(0).add("3");
//		database.get(0).add("4");
//		database.get(0).add("5");
//		database.get(0).add("6");
//		database.get(0).add("7");
//		database.get(0).add("8");
//		database.add(new ArrayList<>());
//		name.add("Dáng");
//		database.get(1).add("To");
//		database.get(1).add("Nhỏ");
//		database.get(1).add("Nhỏ");
//		database.get(1).add("To");
//		database.get(1).add("Nhỏ");
//		database.get(1).add("Nhỏ");
//		database.get(1).add("Nhỏ");
//		database.get(1).add("To");
//		database.add(new ArrayList<>());
//		name.add("Chiều cao");
//		database.get(2).add("Trung bình");
//		database.get(2).add("Thấp");
//		database.get(2).add("Trung bình");
//		database.get(2).add("Cao");
//		database.get(2).add("Trung bình");
//		database.get(2).add("Cao");
//		database.get(2).add("Cao");
//		database.get(2).add("Trung bình");
//		database.add(new ArrayList<>());
//		name.add("Giới tính");
//		database.get(3).add("Nam");
//		database.get(3).add("Nam");
//		database.get(3).add("Nam");
//		database.get(3).add("Nam");
//		database.get(3).add("Nữ");
//		database.get(3).add("Nam");
//		database.get(3).add("Nữ");
//		database.get(3).add("Nữ");
//		database.add(new ArrayList<>());
//		name.add("Thuộc châu");
//		database.get(4).add("Châu Á");
//		database.get(4).add("Châu Á");
//		database.get(4).add("Châu Á");
//		database.get(4).add("Châu Âu");
//		database.get(4).add("Châu Âu");
//		database.get(4).add("Châu Âu");
//		database.get(4).add("Châu Âu");
//		database.get(4).add("Châu Âu");
	
		quinlan q = new quinlan(database, name);
	
		q.build(null);
		
		
//		ArrayList<String> testdata = new ArrayList<>();
//		testdata.add("danh");
//		testdata.add("Vàng");
//		testdata.add("Trung bình");
//		testdata.add("Không");
//		System.out.println(q.TestData(database, name, testdata));
		
	}
}
