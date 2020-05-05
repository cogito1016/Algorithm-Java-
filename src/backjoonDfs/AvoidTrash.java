package backjoonDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class AvoidTrash {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//class Node end
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		boolean map[][] = new boolean[y][x];
		int direct[][] = {{0,1},{1,0},{0,-1},{-1,0}};
		
		Stack<Node> stack = new Stack<Node>();
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int thisY = Integer.parseInt(st.nextToken())-1;
			int thisX = Integer.parseInt(st.nextToken())-1;
			
			map[thisY][thisX]=true;
		}//for end
		
		int max=0;
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				if(!map[i][j])
					continue;
				int result =1;
				stack.push(new Node(i,j));
				map[i][j]=false;
				while(!stack.isEmpty()) {
					Node node = stack.pop();
					
					for(int a=0;a<4;a++) {
						int thisX = node.x+direct[a][1];
						int thisY = node.y+direct[a][0];
						
						if(thisX>=x||thisX<0||thisY>=y||thisY<0)
							continue;
						if(!map[thisY][thisX])
							continue;
						result++;
						map[thisY][thisX]=false;  
						stack.push(new Node(thisY,thisX));
					}//for end
				}//while end
				if(result>max)
					max=result;
			}//for end
		}//for end
		
		
		System.out.println(max);
		
		br.close();
	}//main() end
}//class end