package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DfsFindRoot {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//class Node end
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int v = Integer.parseInt(br.readLine());
		
		int[][] map = new int[v][v];
		int[][] resultMap = new int[v][v];
		boolean[][] visit;
		
		Stack<Node> stack = new Stack<Node>();
		
		for(int i=0;i<v;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<v;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}//for end
		}//for end
		
		for(int i=0;i<v;i++) {
			visit = new boolean[v][v];
			for(int j=0;j<v;j++) {
				if(map[i][j]==0)
					continue;
				stack.push(new Node(i,j));
				resultMap[i][j]=1;
			}//for end
			while(!stack.isEmpty()) {
				Node node = stack.pop();
				for(int a=0;a<v;a++) {
					int thisX= a;
					int thisY= node.x;
					
					if(map[thisY][thisX]==0)
						continue;
					if(visit[thisY][thisX])
						continue;
					
					visit[thisY][thisX]=true;
					resultMap[i][thisX]=1;
					stack.push(new Node(thisY,thisX));
				}//for end 
			}//while end
		}//for end
		
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				System.out.print(resultMap[i][j]+" ");
			}//for end
			System.out.println();
		}//for end
		
		br.close();
	}//main() end
}//class end