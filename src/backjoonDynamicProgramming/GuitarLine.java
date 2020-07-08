package backjoonDynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuitarLine {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int setMin=1000,oneMin=1000;

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int thisSet = Integer.parseInt(st.nextToken());
			int thisOne = Integer.parseInt(st.nextToken());
			if(setMin>thisSet)
				setMin=thisSet;
			if(oneMin>thisOne)
				oneMin=thisOne;
		}//for end
		
		int min = 100000;
		int top = N/6;
		
		for(int i=1;i<top+1;i++) {
			int setNum = i;
			int oneNum = N-setNum*6;
			
			int sum = setMin*setNum + oneMin*oneNum;
			if(min>sum)
				min=sum;
		}//for end 
		
		if(min>(top+1)*setMin)
			min = (top+1)*setMin;
		
		if(min>N*oneMin)
			min=N*oneMin;
		
		System.out.println(min);
		br.close();
	}//main() end
}
