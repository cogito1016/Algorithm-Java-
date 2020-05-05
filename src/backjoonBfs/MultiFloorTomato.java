package backjoonBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MultiFloorTomato {
	
	static class Node{
		
		int x,y,f;
		
		Node(int f, int y, int x){
			this.x=x;
			this.y=y;
			this.f=f;
		}//cons end
	}//Node Class end

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		int[][][] map = new int[f][y][x];
		
		int[][] direct = {
				{0,0,1},{0,1,0},{0,0,-1},{0,-1,0},
				{1,0,0},
				{-1,0,0}
				};
		
		int notDoneTomato=0;
		
		Queue<Node> queue = new LinkedList<Node>();
		
		for(int i=0;i<f;i++) {
			for(int j=0;j<y;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<x;k++) {
					map[i][j][k]=Integer.parseInt(st.nextToken());
					if(map[i][j][k]==1) {
						queue.offer(new Node(i,j,k));
						continue;
					}//if end
					if(map[i][j][k]==0)
						notDoneTomato++;
				}//for end
			}//for end 
		}//for end
		int days=0;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			days++;
			for(int i=0;i<queueSize;i++) {
				Node node =queue.poll();
				for(int j=0;j<6;j++) {
					int thisF = node.f+direct[j][0];
					int thisY = node.y+direct[j][1];
					int thisX = node.x+direct[j][2];
					
					if(thisF>=f||thisF<0||thisY>=y||thisY<0||thisX>=x||thisX<0)
						continue;
					if(map[thisF][thisY][thisX]==-1 || map[thisF][thisY][thisX]==1)
						continue;
					
					map[thisF][thisY][thisX]=1;
					queue.offer(new Node(thisF,thisY,thisX));
					notDoneTomato--;
				}//for end
				
			}//for end
			
		}//while end
		if(notDoneTomato!=0)
			System.out.println(-1);
		else
			System.out.println(days-1);
		
		br.close();
	}//main() end
}//class end 