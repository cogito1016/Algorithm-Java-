package backjoonBfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Picture {
	
	static class Node{
		int y,x;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//Node class end

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st=  new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		
		Queue<Node> outerQueue = new LinkedList<Node>();
		Queue<Node> innerQueue = new LinkedList<Node>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					outerQueue.offer(new Node(i,j));
			}//for end
		}//for end
		
		int numberOfPicture = 0;
		int sizeOfPicture;
		int max = 0;
		
		while(!outerQueue.isEmpty()) {
			
			Node outerNode = outerQueue.poll();
			if(visited[outerNode.y][outerNode.x])
				continue;
						
			innerQueue.offer(outerNode);
			visited[outerNode.y][outerNode.x]=true;
			numberOfPicture++;
			sizeOfPicture = 1;
			while(!innerQueue.isEmpty()) {
				
				int queueSize = innerQueue.size();
				
				for(int i=0;i<queueSize;i++) {
					
					Node node = innerQueue.poll();
					for(int a=0;a<4;a++) {
						int thisY = node.y+direct[a][0];
						int thisX = node.x+direct[a][1];
						
						if(thisX<0 || thisX>=m || thisY<0 || thisY>=n)
							continue;
						if(visited[thisY][thisX])
							continue;
						if(map[thisY][thisX]==0)
							continue;
						
						visited[thisY][thisX]=true;
						innerQueue.offer(new Node(thisY,thisX));
						sizeOfPicture++;
					}//for end
				}//for end
			}//while end 
			
			if(max<sizeOfPicture)
				max=sizeOfPicture;
		}//while end

		bw.write(numberOfPicture+"\n");
		bw.write(max+"\n");
		
		br.close();
		bw.close();
	}//main() end
}
