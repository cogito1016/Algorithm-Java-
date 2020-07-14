package backjoonRecursion;

public class Sum {

	public static int recur(int N) {
		if(N==0)
			return 0;	
		return N+recur(N-1);
	}
	
	public static void main(String[] args) {
		
		int N = 5;
		
		System.out.println(recur(N));
		
	}//main() end
}
