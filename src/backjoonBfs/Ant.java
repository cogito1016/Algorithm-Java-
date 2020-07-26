package backjoonBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ant {
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] stick = new int[L];
		
		int time = 0;
		int targetIdx = 0;
		int value,tempTime;
		
		for(int i=1;i<=N;i++) {
			
			value = Integer.parseInt(br.readLine());
			tempTime = 0;
			
			if(value>0)
				tempTime = L-value;
			else
				tempTime = value*-1;
			
			
			if(tempTime>time) {
				time=tempTime;
				targetIdx = Math.abs(value);
			}
			stick[Math.abs(value)]= value>0?i:i*-1;
		}//for end
		
		int lastAntNum=Math.abs(stick[targetIdx]);
		if(stick[targetIdx]==+1) {
			
			for(int i=targetIdx+1;i<L;i++) {
				if(stick[i]<0)
					lastAntNum=stick[i]*-1;
			}
		}else {
			for(int i=targetIdx-1;i>0;i--) {
				if(stick[i]>0)
					lastAntNum=stick[i];
			}
		}//if ~ else end
			
		System.out.println(lastAntNum +" "+time);
		
		br.close();
	}//main() end
}
