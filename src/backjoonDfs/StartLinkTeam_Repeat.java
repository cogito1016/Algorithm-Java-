package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StartLinkTeam_Repeat {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int size = Integer.parseInt(br.readLine());
		int[][] abilityMap = new int[size][size];
		boolean[] firstTeam = new boolean[size];
		Stack<Integer> stack = new Stack<Integer>();
		int possibleTeamNum = size/2; 
		int min=11000;
		
		for(int i=0;i<size;i++) {//능력치 맵
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				abilityMap[i][j]= Integer.parseInt(st.nextToken());
			}//for end
		}//for end
		
		stack.add(-1);
		
		while(!stack.isEmpty()) {
			int thisIndex=stack.pop();
			
			if(thisIndex!=-1)
				firstTeam[thisIndex]=false;
			
			for(int i=thisIndex+1;i<size;i++) {
				stack.add(i);
				firstTeam[i]=true;
				if(stack.size()==possibleTeamNum) {
					
					int[] trueTeam = new int[possibleTeamNum];
					int trueIndex=0;
					int[] falseTeam = new int[possibleTeamNum];
					int falseIndex=0;
					
					for(int a=0;a<size;a++) {
						if(firstTeam[a])
							trueTeam[trueIndex++]=a;
						else
							falseTeam[falseIndex++]=a;
					}//for end
					
					int trueTotal=0;
					for(int a=0;a<possibleTeamNum;a++) {
						for(int b=0;b<possibleTeamNum;b++) {
							trueTotal += abilityMap[trueTeam[a]][trueTeam[b]];
						}//for end
					}//for end
					
					int secondTotal=0;
					for(int a=0;a<possibleTeamNum;a++) {
						for(int b=0;b<possibleTeamNum;b++) {
							secondTotal += abilityMap[falseTeam[a]][falseTeam[b]];
						}//for end
					}//for end
					
					int total = Math.abs(trueTotal-secondTotal);
					if(total<min)
						min=total;
				}//if end
			}//for end
		}//while end
		
		
		System.out.println(min);
		br.close();
	}//main() end
}//class end