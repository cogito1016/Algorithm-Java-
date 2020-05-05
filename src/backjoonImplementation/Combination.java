package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;
import java.util.StringTokenizer;

public class Combination {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
//		Stack<Integer> stack = new Stack<Integer>();
//		
//		int thisSize=1;
//		BigInteger result = BigInteger.ZERO;
//		BigInteger one = BigInteger.ONE;
//		
//		stack.push(0);
//		while(!stack.isEmpty()) {
//			int thisNumber = stack.pop();
//			thisSize--;
//			
//			for(int i=thisNumber+1;i<=n;i++) {
//				stack.add(i);
//				thisSize++;
//				if(thisSize==m) {
//					result = result.add(one);
//					break;
//				}//if end
//			}//for end
//			
//		}//while end
		
		BigInteger nFactorial = BigInteger.ONE;
		for(int i=1;i<=n;i++) {
			nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
		}//for end
//		System.out.println("n!="+nFactorial);
		
		BigInteger mFactorial = BigInteger.ONE;
		for(int i=1;i<=m;i++) {
			mFactorial = mFactorial.multiply(BigInteger.valueOf(i));
		}//for end
//		System.out.println("m!="+mFactorial);
		
		BigInteger nSubmFactorial = BigInteger.ONE;
		for(int i=1;i<=n-m;i++) {
			nSubmFactorial = nSubmFactorial.multiply(BigInteger.valueOf(i));
		}//for end
//		System.out.println("n-m!="+nSubmFactorial);
		
		BigInteger bigResult = nFactorial.divide(mFactorial.multiply(nSubmFactorial));
		System.out.println(bigResult);
//		br.close();
		
//		BigInteger result =BigInteger.ONE;
//		for(long i=1;i<=100;i++) {
//			result = result.multiply(BigInteger.valueOf(i));
//		}
//		System.out.println(result);
		
	}//main() end
}//class end