package backjoonRecursion;

public class RecurPractice {

	public static void recur(int N) {
	
		if(N==1)
			return;
		
		if(N%2!=0) {
			System.out.println(3*N+1);
			recur(3*N+1);
		}else {
			System.out.println(N/2);
			recur(N/2);
		}
			
	}
	
	public static void main(String[] args) {
		
		recur(3);
		
	}//main() end
}
