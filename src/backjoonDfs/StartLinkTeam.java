package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StartLinkTeam {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int size = Integer.parseInt(br.readLine());
		
		int[][] map = new int[size+1][size+1];
		boolean[] visit = new boolean[size+1];
		
		for(int i=1;i<=size;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=size;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}//for end
		}//for end
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		int curr=1;
		
		int min = 10000;
		
		while(!stack.isEmpty()) {
			curr--;
			int thisNum = stack.pop();
			visit[thisNum]=false;
			for(int i=thisNum+1;i<=size;i++) {
				curr++;
				stack.add(i);
				visit[i]=true;
				
				if(curr==size/2) {
					int[] firstTeam = new int[(size+1)/2+1];
					int[] secondTeam = new int[(size+1)/2+1];
					int fCount=1;
					int sCount=1;
					for(int a=1;a<=size;a++) {
						if(visit[a]) {
//							System.out.println(a);
							firstTeam[fCount++]=a;
						}
						else {
//							System.out.println("         "+a);
							secondTeam[sCount++]=a;
						}
					}//for end
					int firstTeamSum =0;
					for(int b=1;b<(size+1)/2+1;b++) {
						for(int c=1;c<(size+1)/2+1;c++) {
							firstTeamSum+=map[firstTeam[b]][firstTeam[c]];
						}//for end
					}//for end

					int secondTeamSum =0;
					for(int b=1;b<(size+1)/2+1;b++) {
						for(int c=1;c<(size+1)/2+1;c++) {
							secondTeamSum +=map[secondTeam[b]][secondTeam[c]];
						}//for end
					}//for end
					int result =Math.abs(firstTeamSum-secondTeamSum);
//					System.out.println("--"+result+"--");
					if(min > result)
						min=result;
					break; 
				}//if end
			}//for end
			
		}//while end
		System.out.println(min);
		br.close();
	}//main() end
}//class end