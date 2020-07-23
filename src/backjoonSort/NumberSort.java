package backjoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NumberSort {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}//for end
		
		Arrays.sort(arr);
		
		for(int item : arr) {
			bw.write(item+"\n");
		}//for end 
		
		
		br.close();
		bw.close();
	}//main() end
}
