
public class TimeCheck {

	public static void main(String[] args) {

	    
		long beforeTime = System.currentTimeMillis();
		
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("Time(m) : "+secDiffTime);
		
	}
}
