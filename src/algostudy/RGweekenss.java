package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class RGweekenss {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//class Node end
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		char[][] map = new char[size][size];
		boolean[][] visit = new boolean[size][size];
		int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		
		Stack<Node> stack = new Stack<Node>();
		
		for(int i=0;i<size;i++) {
			String s = br.readLine();
			for(int j=0;j<size;j++) {
				map[i][j]=s.charAt(j);
			}//for end
		}//for end
		
		Deque<Node> dequeue = new ArrayDeque<Node>();
		int weekmans=0;
		int normalmans=0;
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(visit[i][j])
					continue;
				
				visit[i][j]=true;
				stack.push(new Node(i,j));
				
				weekmans++;
				normalmans++;
				
				while(!stack.isEmpty()) {
					Node node = stack.pop();
					int thisX = node.x;
					int thisY = node.y;
					char thisColor = map[thisY][thisX];
					char otherColor='X';
					
					if(thisColor=='R') {
						otherColor='G';
						normalmans++;
						}
					if(thisColor=='G') {
						otherColor='R';
						normalmans++;
					}
					
					for(int d=0;d<4;d++) {
						int newX = thisX+direct[d][1];
						int newY = thisY+direct[d][0];
						
						if(newX>=size||newX<0||newY>=size||newY<0)
							continue;
						if(visit[newY][newX])
							continue;
						
						//블루면
						if(otherColor=='X') {
							stack.push(new Node(newY,newX));
							visit[newY][newX]=true;
						}else {//블루아니면
							if(map[newY][newX]==otherColor)
								dequeue.push(new Node(newY,newX));
							else
								dequeue.offer(new Node(newY,newX));
							visit[newY][newX]=true;
						}
					}
					
					while(!dequeue.isEmpty()) {
						stack.push(dequeue.poll());
					}

					System.out.println();
					for(int a=0;a<size;a++) {
						for(int b=0;b<size;b++) {
							System.out.print(visit[a][b]);
						}//for end
						System.out.println();
					}//for end
				}//while end
				
			}//for end
		}//for end
		
		System.out.println(normalmans+" "+weekmans);
		
		br.close();
	}//main() end
	
}//class end
