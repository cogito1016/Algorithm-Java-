package backjoonRecursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Hanoi {

	public static void hanoi() {
		
		
		
	}//hanoi() end
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] first = new int[N+1];
		int[] second = new int[N+1];
		int[] third = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			first[i]=i;
		}//for end
		
		br.close();
		bw.close();
	}//main() end
}
