package backjoonBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ant {
	
	
	static class AntMan {
		int num;
		int loc;
		int direct;
		AntMan(int num, int loc,int direct){
			this.num=num;
			this.loc=loc;
			this.direct=direct;
		}//cons end	
	}//class end 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Queue<AntMan> queue = new LinkedList<AntMan>();
		
		
		for(int i=1;i<=N;i++) {
			int antLoc = Integer.parseInt(br.readLine());
			
			if(antLoc>0) {
				queue.offer(new AntMan(i,antLoc,+1));
			}else {
				queue.offer(new AntMan(i,antLoc*-1,-1));
			}//if~else end
		}//for end
		
		int lastAntNum = 0;
		int time = 0;
		
		while(!queue.isEmpty()) {
			
			int queueSize = queue.size();
			time++;
			
			for(int i=0;i<queueSize;i++) {
				AntMan ant = queue.poll();
				
				int direct = ant.direct;
				int newLoc = ant.loc+direct;
				
				if(newLoc!=0&&newLoc!=L) {
					queue.offer(new AntMan(ant.num,newLoc,direct));
				}else {
					lastAntNum = ant.num;
				}//if~else end 
				
			}//for end 
		}//while end 
		
		System.out.println(lastAntNum+" "+time);
		
		
		br.close();
	}//main() end
}
