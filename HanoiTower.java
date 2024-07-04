package dataStructure;

public class HanoiTower {
	public static void hanoi(int n, String source, String destination , String auxilary) {
	      if(n == 1){
	         System.out.println("Move disk 1 from " + source + " to " + destination);
	      }
	      else{
	         hanoi(n-1, source, auxilary, destination);
	         System.out.println("Move disk " + n + " from " + source + " to " + destination);
	         hanoi(n-1, auxilary, destination, source);
	      }
	   }
	   public static void main(String[] args) {
	      int n = 4;
	      String source = "A";
	      String destination = "B";
	      String auxilary = "C";
	   
	      hanoi(n, source, auxilary, destination);
	   }
	}