package backjoonRecursion;

public class Palidrome {

	public static boolean recur(String s) {
	
		if(s.length()==1)
			return true;
		if(s.charAt(0)==s.charAt(s.length()-1)) {
			recur(s.substring(1, s.length()-1));
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String s = "dave";
		
		System.out.println(recur(s));
	}//main() end
}
