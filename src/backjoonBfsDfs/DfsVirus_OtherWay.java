package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DfsVirus_OtherWay {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int computer = Integer.parseInt(br.readLine());
		int networkNum = Integer.parseInt(br.readLine());
		
		int[][] map = new int[computer][computer];
		boolean[] visit = new boolean[computer]; 
		
		Stack<Integer> stack = new Stack<Integer>();
		int node,inspection=0;
		
		for(int i=0;i<networkNum;i++) {
			st=new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x]=1;
			map[x][y]=1;
		}//for end
		
		stack.push(0);
		visit[0]=true;
		
		while(!stack.isEmpty()) {
			node = stack.pop();
			
			for(int i=0;i<computer;i++) {
				
				if(map[node][i]==0)
					continue;
				if(visit[i])
					continue;
				
				visit[i]=true;
				inspection++;
				stack.push(i);
				
			}//for end
			
		}//while end
		
		
		System.out.println(inspection);
		br.close();
	}//main() end
}//class end
