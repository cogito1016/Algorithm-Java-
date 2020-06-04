package backjoonHasing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

//15829 HASING
public class Hasing {

	static BigInteger M = BigInteger.valueOf(1234567891);
	static int r = 31;
	
	public static BigInteger mul(int number) {
		BigInteger result = BigInteger.ONE;
		
		for(int i=0;i<number;i++) {
			result = result.multiply(BigInteger.valueOf(r));
		}
		
		return result;
	}//mul
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		BigInteger key = BigInteger.ZERO;
		
		for(int i=0;i<size;i++) {
			BigInteger alpha = mul(i);
			alpha = alpha.multiply( BigInteger.valueOf((str.charAt(i)-96)));
			key = key.add(alpha);
		}//for end 
		
		
		System.out.println(key.mod(M));
		
		br.close();
		
	}//main() end
}//Hasing class end