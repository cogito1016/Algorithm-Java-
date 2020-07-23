package backjoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SortInside {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] N = br.readLine().toCharArray();
	
		Arrays.sort(N);
		
		for(int i=N.length-1;i>=0;i--) {
			bw.write(N[i]);
		}//for end

		bw.close();
		br.close();
	}//main() end 
}
