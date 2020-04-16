package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DfsTermProject {
	
	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//Class Node end

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		int[] nonTeam = new int[testCase];
		
		for(int i=0;i<testCase;i++) {
			
			int v = Integer.parseInt(br.readLine());
			boolean[][] map = new boolean[v][v];
			boolean[][] visit;
			boolean[] team = new boolean[v];
			Stack<Node> stack = new Stack<Node>();

			st=new StringTokenizer(br.readLine());
			for(int a=0;a<v;a++) {
				map[a][Integer.parseInt(st.nextToken())-1]=true;
			}//for end

			for(int a=0;a<v;a++) {
				visit = new boolean[v][v];
				for(int b=0;b<v;b++) {
					if(!map[a][b])
						continue;
					stack.push(new Node(a,b));
					while(!stack.isEmpty()) {
						Node node = stack.pop();
						for(int check=0;check<v;check++) {
							int thisX= check;
							int thisY= node.x;
							
							if(!map[thisY][thisX])
								continue;
							if(visit[thisY][thisX])
								continue;
							if(thisX==a)
								team[a]=true;
							visit[thisY][thisX]=true;
							stack.push(new Node(thisY,thisX));
						}//for end
					}//while end
				}//for end
			}//for end
			
			for(int j=0;j<v;j++) {
				if(!team[j]) 
					nonTeam[i]++;
			}//for end
		}//for end
		
		for(int i=0;i<testCase;i++) {
			System.out.println(nonTeam[i]);
		}//for end
		
		br.close();
	}//main() end
}//class end