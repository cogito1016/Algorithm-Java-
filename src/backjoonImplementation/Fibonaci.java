package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Fibonaci {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int inputNum = Integer.parseInt(br.readLine());
		long[] result = new long[13];
		result[0]=0;
		result[1]=1;
		result[2]=1;
		
		for(int i=3;i<=inputNum;i++) {
			result[i]=result[i-2]+result[i-1];
		}//for end
		
		for(int i=0;i<=inputNum;i++) {
			System.out.println(result[i]);	
		}
		br.close();
	}
}//class end 
