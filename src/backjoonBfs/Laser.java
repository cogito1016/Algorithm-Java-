package backjoonBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Laser {
	

	static class Node{
		int x,y,val;
		char direct; //N W S E
		Node(int y,int x,int val){
			this.x=x;
			this.y=y;
			this.val=val;
		}//cons Node end
		
		Node(int y,int x,int val,char direct){
			this.x=x;
			this.y=y;
			this.val=val;
			this.direct=direct;
		}//cons Node end
		
		public char getDirect() {
			return this.direct;
		}//getDirect() end
		
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
						  //동   //남    //서    //북
		char[] directIdx = {'E','S','W','N'};
						  //0   //1 //2 //3
		
		Queue<Node> queue = new LinkedList<Node>();
		int startX=0, startY=0;
		
		for(int i=0;i<y;i++) {
			String s = br.readLine();
			for(int j=0;j<x;j++) {
				map[i][j] = s.charAt(j);
				valMap[i][j] = -1;  
				if(map[i][j]=='C'){
					startX=j;
					startY=i;
				}//if end
			}//for end
		}//for end 
		
		queue.add(new Node(startY,startX,0));
		visit[startY][startX]=true;
		valMap[startY][startX]=0;
		
		int result=0;
		while(!queue.isEmpty()) {

			for(int q=0;q<queue.size();q++) {
			
				Node node = queue.poll();
				int thisX,thisY;
				
				for(int i=0;i<4;i++) {
					thisX= node.x+direct[i][1];
					thisY= node.y+direct[i][0];
					char thisDirect = directIdx[i];
					
					if(thisX>=x||thisX<0||thisY>=y||thisY<0)
						continue;
					if(map[thisY][thisX]=='*')
						continue;
					if(visit[thisY][thisX])
						continue;
					
					//visit=true 할 후보들을 모아놔야함 그리고 이번턴 끝나면 다 true땡겨야해
					
					//-1이면 아직 아무런 가치가 안매겨진 땅이므로 걍 넣어
					if(valMap[thisY][thisX]==-1) {
						//만약 다이렉트가없다? 그건 최초라는뜻이니까 다 0으로 넣자
						if(node.getDirect()==' ') {
							queue.offer(new Node(thisY,thisX,0,thisDirect));
						}else {//다이렉트가 있으면? 
								
							int val = 0;
							if(node.getDirect()!=thisDirect) {//방향이달라!
								val =node.val+1 ;
							}//if end
							
							queue.add(new Node(thisY,thisX,val,thisDirect));
							valMap[thisY][thisX]=val;
						}//if~elseIf end
					}else { //지금 방향이다르지만 겹치는 구간이생긴거야.
						
						int thisVal = valMap[thisY][thisX];
						
						int val = node.val ;
						if(node.getDirect()!=thisDirect) {//방향이달라!
							val =node.val+1 ;
						}//if end
						 
					}
					
						//다음 들어갈곳에 있는 최소 거울의 수보다
						//내가 들어가고나서의 최소 거울의 수가 많으면 추가하지마, 필요없음
						
						//같으면 추가하고
						
						//내가 들어가고나서의 최소 거울의 수가 기존거보다 작으면
						//기존거없애고 내꺼 추가
				
					
				}//for end	
			}//for end
		}//while end
		
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				System.out.print(map[i][j]+"  ");
			}//for end
			System.out.println();
		}//for end 
		
		br.close();
	}//main() end
}//class end