package backjoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberSort3 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] inventory = new int[10001];
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			int thisNum = Integer.parseInt(br.readLine());
			int checkValue = inventory[thisNum];
			
			if(checkValue==0) {
				inventory[thisNum]=1;
				list.add(thisNum);
			}else {
				inventory[thisNum]= checkValue+1;
			}//if~else end 
		}//fore end 
		
		Collections.sort(list);
		
		for(int item : list) {
			for(int i=0;i<inventory[item];i++) {
				bw.write(item+"\n");
			}//for end 
		}//for end 
		
		bw.close();
		br.close();
	}//main() end
}
