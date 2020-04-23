package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsLaser {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons Node end
	}//class Node end
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[y][x];
		int[][] valMap = new int[y][x];
		boolean[][] visit = new boolean[y][x];
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		int[][] diagonal = {{1,1},{1,-1},{-1,1},{-1,-1}};  
		Queue<Node> queue = new LinkedList<Node>();
		int startX=0, startY=0;
		
		for(int i=0;i<y;i++) {
			String s = br.readLine();
			for(int j=0;j<x;j++) {
				map[i][j] = s.charAt(j);
				valMap[i][j]=0;
				if(map[i][j]=='C'){
					startX=j;
					startY=i;
				}//if end
			}//for end
		}//for end

//		for(int i=0;i<y;i++) {
//			for(int j=0;j<x;j++) {
//				System.out.print(valMap[i][j]);
//			}//for end
//			System.out.println();
//		}//for end
		
		queue.add(new Node(startY,startX));
		visit[startY][startX]=true;
		valMap[startY][startX]=0;
		int answer=0;
		while(!queue.isEmpty()) {
			if(queue.isEmpty())
				break;
			Node node = queue.poll();
			
			for(int i=0;i<4;i++) {
				int thisX= node.x+direct[i][1];
				int thisY= node.y+direct[i][0];
				if(thisY>=y||thisY<0||thisX>=x||thisX<0)
					continue;
				if(visit[thisY][thisX])
					continue;
				if(map[thisY][thisX]=='*')
					continue;
				if(map[thisY][thisX]=='C') {
					valMap[thisY][thisX]=valMap[node.y][node.x];
					answer=valMap[node.y][node.x];
					if(!queue.isEmpty())
						queue.clear();
					break;
				}
				valMap[thisY][thisX]=valMap[node.y][node.x];
				queue.add(new Node(thisY,thisX));
				visit[thisY][thisX]=true;
			}//for end
			
			if(queue.isEmpty())
				break;
			
			for(int i=0;i<4;i++) {
				int thisX= node.x+diagonal[i][1];
				int thisY= node.y+diagonal[i][0];
				if(thisY>=y||thisY<0||thisX>=x||thisX<0)
					continue;
				if(map[thisY][thisX]=='*')
					continue;
				if(visit[thisY][thisX])
					continue;
				if(map[thisY][thisX]=='C') {
					valMap[thisY][thisX]=valMap[node.y][node.x]+1;
					answer=valMap[node.y][node.x]+1;
					if(!queue.isEmpty())
						queue.clear();
					break;
				}
				visit[thisY][thisX]=true;
				valMap[thisY][thisX]=valMap[node.y][node.x]+1;
				queue.add(new Node(thisY,thisX));
			}//for end


			System.out.println();
			for(int i=0;i<y;i++) {
				for(int j=0;j<x;j++) {
					System.out.print(valMap[i][j]);
				}//for end
				System.out.println();
			}//for end
		}//while end
		
		System.out.println(answer);

		br.close();
	}//main() end
}//class end