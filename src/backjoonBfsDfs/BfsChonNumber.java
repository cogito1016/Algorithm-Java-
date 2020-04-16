package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsChonNumber {

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
		
		int manNum = Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		int firstMan = Integer.parseInt(st.nextToken())-1;
		int secondMan = Integer.parseInt(st.nextToken())-1;
		int relNum = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[manNum][manNum];
		Queue<Node> queue = new LinkedList<Node>();
		
		for(int i=0;i<relNum;i++) {
			
			st=new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken())-1;
			int second = Integer.parseInt(st.nextToken())-1;
			map[first][second] = true;
			map[second][first] = true;
		}//for end
		
		for(int i=0;i<manNum;i++) {
			if(map[firstMan][i]) {
				queue.offer(new Node(firstMan,i));
				map[firstMan][i]=false;
				map[i][firstMan]=false;
			}//if end
		}//for end
		
		int chonNum=1;
		boolean flag=false;
		
		while(!queue.isEmpty()) {
			
			int queueSize = queue.size();
			chonNum++;
			for(int j=0;j<queueSize;j++) {
				if(queue.isEmpty())
					break;
				Node node = queue.poll();
				
				for(int i=0;i<manNum;i++) {
					int thisX=i;
					int thisY=node.x;
					if(!map[thisY][thisX])
						continue;
					
					if(thisY==secondMan||thisX==secondMan)
					{
						flag=true;
						while(!queue.isEmpty())
							queue.poll();
						break;
					}//if end
					
					queue.offer(new Node(thisY,thisX));
					map[thisY][thisX]=false;
					map[thisX][thisY]=false;
				}//for end
			}//for end
		}//while ned
		
		if(flag)
			System.out.println(chonNum);
		else
			System.out.println(-1);
		br.close();
	}//main() end
}//class end