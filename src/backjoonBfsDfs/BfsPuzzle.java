package backjoonBfsDfs;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BfsPuzzle {

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
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		int[][] map = new int[3][3];
		boolean[][] finish = new boolean[3][3];
		Queue<Node> queue = new LinkedList<Node>();
		
		int startX=0, startY=0;
		for(int i=0;i<3;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}//for end
		}//for end
		
		int result =0;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				
				queue.offer(new Node(i,j));
				int thisVal = map[i][j];
				int originVal = (i*3)+(j+1);
				if(originVal==9)
					originVal=0;
				if(originVal==thisVal)
					continue;
				while(!queue.isEmpty()) {
					int queueSize = queue.size();
					result++;
					for(int a=0;a<queueSize;a++) {
						if(queue.isEmpty())
							break;
						Node node = queue.poll();
						int thisNode = map[node.y][node.x];
						
						for(int b=0;b<4;b++) {
							int thisX=node.x+direct[b][1];
							int thisY=node.y+direct[b][0];
							if(thisX>=3||thisX<0||thisY>=3||thisY<0)
								continue;
							
							int nextVal = map[thisY][thisX];
							
							if(originVal == nextVal) {
								map[i][j]= map[thisY][thisX];
								map[thisY][thisX]=thisVal;
								queue.clear();
								break;
							}//if end
							
							queue.offer(new Node(thisY,thisX));
						}//for end
					}//for end

//					for(int a=0;a<3;a++) {
//						for(int b=0;b<3;b++) {
//							System.out.print(map[a][b]);
//						}//for end
//						System.out.println();
//					}//for end
				}//while end
			}//for end
		}//for end
		
		if(result==0)
			System.out.println(-1);
		else
			System.out.println(result);
		

		
		br.close();
	}//main() end
}//class end