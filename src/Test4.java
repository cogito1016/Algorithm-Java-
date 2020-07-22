import java.util.ArrayList;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {
		
		System.out.println(11*11*11);
		
		System.out.println((long)Math.sqrt(99999));
		System.out.println( (long)Math.pow((long)Math.sqrt(99999), 2));
		String a = "ab";
		String b = "ab";
		
		System.out.println("a"=="a");
		System.out.println("abc"=="bca");
		System.out.println(""==null);
		System.out.println("ab"=="ab");
		System.out.println(a==b);
		
		List<Integer> hi = new ArrayList<Integer>();
		hi.add(0);
		Integer ha = null;
		System.err.println(hi.get(0).getClass());
	}//main() end
}
