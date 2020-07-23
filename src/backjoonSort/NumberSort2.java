package backjoonSort;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class NumberSort2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}//for end 
		
		Collections.sort(arr);
		for(int item : arr) {
			bw.write(item+"\n");
		}//for end
		
		bw.close();
		br.close();
	}//main() end
}
