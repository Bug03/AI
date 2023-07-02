package coloring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Welsh_Powell {
	    
    public void Coloring(ArrayList<Vertex> t) {
        for(Vertex v : t) {
            v.setDegree(v.getAdjVertex().size());
        }
        
        ArrayList<Vertex> temp = new ArrayList<>();
        temp.addAll(t);
        
        Collections.sort(t, new Comparator<Vertex>() {
            public int compare(Vertex v1, Vertex v2) {
                return v2.getDegree() - v1.getDegree();
            }
        });
        
        for(Vertex c : t) {
        	int color = 1;
        	ArrayList<Vertex> adj = c.getAdjVertex();
            for(Vertex v : adj) {
                if(v.isColored()) 
                    color++;
            }
            c.setColor(color);
            c.setColored(true);
        }
        
        for(Vertex v : t) {
            System.out.println(v.getName() + "\t" + v.getColor());
        }
        
        System.out.println("Đỉnh:  A   B   C   D   E   F   G   H   I   J   K   L");
        for(int i = 1 ; i <= 4 ; i++) {
        	System.out.print("màu " + i + ": ");
        	for(Vertex v : temp) {
        		if(v.getColor() != i && !v.isColored())
        			System.out.print(v.getColor() + "  ");
        		else if(v.getColor() == i) {
        			System.out.print(v.getColor() + "  ");
        			v.setColored(false);
        		}
        		else if(v.getColor() != i){
        			System.out.print("-" + i + "  ");
        		}
        	}
        	System.out.println();
        }
        System.out.println();
        for(int i = 1 ; i <= 4 ; i++) {
        	System.out.print("Màu " + i + ": ");
        	for(Vertex v : temp) {
        		if(v.getColor() == i) {
        			System.out.print(v.getName() + " ");
        		}
        	}
        	System.out.println();
        }
    }
    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");
        Vertex vertex5 = new Vertex("E");
        Vertex vertex6 = new Vertex("F");
        Vertex vertex7 = new Vertex("G");
        Vertex vertex8 = new Vertex("H");
        Vertex vertex9 = new Vertex("I");
        Vertex vertex10 = new Vertex("J");
        Vertex vertex11 = new Vertex("K");
        Vertex vertex12 = new Vertex("L");
        
        vertex1.addAdj(vertex3);
        vertex1.addAdj(vertex4);
        vertex1.addAdj(vertex7);
        vertex1.addAdj(vertex6);
        vertex1.addAdj(vertex9);
        
        vertex3.addAdj(vertex1);
        vertex3.addAdj(vertex4);
        vertex3.addAdj(vertex7);
        
        vertex4.addAdj(vertex1);
        vertex4.addAdj(vertex3);
        vertex4.addAdj(vertex7);
        
        vertex7.addAdj(vertex1);
        vertex7.addAdj(vertex3);
        vertex7.addAdj(vertex4);
        
        vertex2.addAdj(vertex8);
        vertex2.addAdj(vertex11);
        vertex2.addAdj(vertex12);
        
        vertex8.addAdj(vertex2);
        vertex8.addAdj(vertex11);
        vertex8.addAdj(vertex12);
        
        vertex11.addAdj(vertex2);
        vertex11.addAdj(vertex8);
        vertex11.addAdj(vertex12);
        
        vertex5.addAdj(vertex10);
        vertex5.addAdj(vertex12);
        
        vertex10.addAdj(vertex5);
        vertex10.addAdj(vertex12);
        
        vertex12.addAdj(vertex2);
        vertex12.addAdj(vertex5);
        vertex12.addAdj(vertex8);
        vertex12.addAdj(vertex10);
        vertex12.addAdj(vertex11);
        
        vertex6.addAdj(vertex1);
        vertex6.addAdj(vertex9);
        
        vertex9.addAdj(vertex1);
        vertex9.addAdj(vertex6);
        
        ArrayList<Vertex> t = new ArrayList<Vertex>();
        t.add(vertex1);
        t.add(vertex2);
        t.add(vertex3);
        t.add(vertex4);
        t.add(vertex5);
        t.add(vertex6);
        t.add(vertex7);
        t.add(vertex8);
        t.add(vertex9);
        t.add(vertex10);
        t.add(vertex11);
        t.add(vertex12);
        
        Welsh_Powell c = new Welsh_Powell();
        c.Coloring(t);
	}

}