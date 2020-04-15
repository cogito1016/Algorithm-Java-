package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DfsSafetyZone {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}
	}//class Node end
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int size = Integer.parseInt(br.readLine());
		
		int[][] map = new int[size][size];
		boolean[][] visit;
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		int result,max=0;
		Stack<Node> stack = new Stack<Node>();
		
		for(int i=0;i<size;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}//for end
		}//for end
		
		for(int i=0;i<=100;i++) {
			visit = new boolean[size][size];
			result = 0;
			for(int a=0;a<size;a++) {
				for(int b=0;b<size;b++) {
					
					if(map[a][b]<=i)
						continue;
					if(visit[a][b])
						continue;
					
					visit[a][b]=true;
					stack.push(new Node(a,b));
					result++;
					while(!stack.isEmpty()) {
						Node node = stack.pop();
						for(int c=0;c<4;c++) {
							int thisX= node.x+direct[c][1];
							int thisY= node.y+direct[c][0];
							if(thisX>=size||thisX<0||thisY>=size||thisY<0)
								continue;
							if(visit[thisY][thisX])
								continue;
							if(map[thisY][thisX]<=i)
								continue;
							visit[thisY][thisX]=true;
							stack.push(new Node(thisY,thisX));
						}//for end
					}//while end
				}//for end
			}//for end
			if(result>max)
				max=result;
		}//for end
		
		System.out.println(max);
		
		br.close();
	}//main() end
}//class end