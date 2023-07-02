package Taci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class AKT {
    int[][] initA; 
    int[][] curA = { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };
    int[][] GoalA; 
    int I1, J1;


    public AKT(int[][] initA, int[][] goalA) {
        this.initA = initA;
        this.GoalA = goalA;
    }

    public void findValue(int x) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (GoalA[i][j] == x) {
                    I1 = i;
                    J1 = j;
                    break;
                }
            }
    }

    public void Copy(Vertex v) {
    	int[][] board = v.getState().getBoard(); 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                curA[i][j] = board[i][j]; 
            }
        }
	}
    
    
    public int heuristic(int[][] board) {
    	int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = board[i][j];
    			if(value != GoalA[i][j]) {
    				sum++;
    			}
            }
        }
        return sum;
    }
    
    public void AKT(int[][] start) {
    	PriorityQueue<Vertex> openList = new PriorityQueue<>();
        ArrayList<Vertex> closedList = new ArrayList<>();

        Vertex vertex0 = new Vertex(new State(start));
        vertex0.setG(0);
        openList.add(vertex0);
        ArrayList<Vertex> temp = new ArrayList<>();
        ArrayList<Vertex> temp1 = new ArrayList<>();
        int dem = 0;
        while(!openList.isEmpty()) {
        	System.out.println("Bước: " + dem);
        	temp.addAll(openList);
        	temp1.addAll(closedList);
        	System.out.print("Open: " + temp);
	        System.out.println();
        	Vertex cur = openList.poll();
        	temp.clear();
        	System.out.println("puzzle đang xét: " + cur + "[g(n)=" + cur.getG() + " ,h(n)=" + cur.getH() + " ,f(n)=" + cur.getF() + "]");
        	closedList.add(cur);
        	System.out.print("Closed: " + temp1);
	        System.out.println("\n");
        	Copy(cur);
        	if(Arrays.deepEquals(cur.getState().getBoard(), GoalA)) {
        		//cur.tracePath().printPath();
        		break;
        	}
        	ArrayList<Vertex> array = new ArrayList<>();
        	for(int i = 0; i < 3; i++) {
        		for(int j = 0; j < 3; j++) {
        			if(curA[i][j] == 0) {
        				array.add(cur.moveUp(i,j));
        				array.add(cur.moveDown(i,j));
        				array.add(cur.moveLeft(i,j));
        				array.add(cur.moveRight(i,j));
        				for (Vertex newVertex : array){
        					 if (!closedList.contains(newVertex)){
        						 newVertex.setParent(cur);
        						 newVertex.setH(heuristic(newVertex.getState().getBoard()));
        						 newVertex.setG(newVertex.getParent().getG()+1);
        						 newVertex.setF();
        						 openList.add(newVertex);
        	                 }
        				}
        			}
        		}
        	}
        	dem++;
        }
        
    }
    
    public static void main(String[] args) {
    	int[][] initA = { {2, 8, 3}, {1, 6, 4}, {7, 0, 5} }; 
		int[][] GoalA = { {1, 2, 3}, {8, 0, 4}, {7, 6, 5} }; 
		AKT t = new AKT(initA,GoalA);
		t.AKT(initA);
	}

    
}