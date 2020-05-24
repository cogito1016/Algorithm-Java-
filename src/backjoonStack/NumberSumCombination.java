package backjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberSumCombination {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		int[] list = new int[size];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<size;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}//for end 
		
		int count = 0;
		
		for(int i=0;i<size;i++) {
			
			int thisIndex = i;
			int result = 0;
			
			for(int j=thisIndex;j<size;j++) {
				result+=list[j];
				if(result==goal) {
					count++;
					break;
				}//if end
				if(result>goal) {
					break;
				}//if end
			}//for end 
		}//for end
		
		System.out.println(count);
		
		br.close();
	}//main() end
}//class end