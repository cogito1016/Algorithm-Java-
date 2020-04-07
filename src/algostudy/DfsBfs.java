package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DfsBfs {

	static class Node{
		private int x,y;
		
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
		
		
		
	}//class Node end
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken())-1;
		
		int[][] map = new int[n][n];
		boolean[] visit = new boolean[n];
		
		Stack<Node> stack = new Stack<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		
		List<Integer> knockDfs = new ArrayList<Integer>();
		List<Integer> knockBfs = new ArrayList<Integer>();
		
		int y,x,thisY,thisX;
		Node node;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken())-1;
			x = Integer.parseInt(st.nextToken())-1;
			map[y][x]=1;
			map[x][y]=1;
		}//for end
		
		
		stack.push(new Node(v,0));
		
		while(!stack.isEmpty()) {
			node = stack.pop();
			thisY=node.getY();
			if(!visit[thisY]) {
				visit[thisY]=true;
				knockDfs.add(thisY);
			}
			
			for(int i=n-1;i>=0;i--) {
				thisX=i;
				
				if(map[thisY][thisX]==0)
					continue;
				if(visit[thisX])
					continue;

				stack.push(new Node(thisX,thisY));
			}//for end
			
		}//while end
		
		queue.add(new Node(v,0));
		visit= new boolean[n];
		
		while(!queue.isEmpty()) {
			node = queue.poll();
			thisY=node.getY();
			if(!visit[thisY]) {
				visit[thisY]=true;
				knockBfs.add(thisY);
			}
			
			for(int i=0;i<n;i++) {
				thisX=i;
				
				if(map[thisY][thisX]==0)
					continue;
				if(visit[thisX])
					continue;

				queue.add(new Node(thisX,thisY));
			}//for end
			
		}//while end
		
		for(int i=0;i<knockDfs.size();i++) {
			System.out.print(knockDfs.get(i)+1);
			if(i!=knockDfs.size()-1)
				System.out.print(" ");
		}//for end
		System.out.println();
		for(int i=0;i<knockBfs.size();i++) {
			System.out.print(knockBfs.get(i)+1);
			if(i!=knockBfs.size()-1)
				System.out.print(" ");
		}//for end
		
		
		br.close();
	}//main() end
}//class end
