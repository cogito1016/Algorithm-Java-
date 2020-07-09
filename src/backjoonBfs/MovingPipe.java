package backjoonBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MovingPipe {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//class end
	
	public static enum PipeState {LandScape,Portrait,Diagonal};
	
	static class Pipe{

		Node start,end;
		PipeState pipeState;
		Pipe(Node start,Node end,PipeState pipeState){
			this.start=start;
			this.end=end;
			this.pipeState=pipeState;
		}//cons end
	}//class end 
	
	public static void main(String[] args) throws Exception{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		int[][] drawMap = new int[N][N];
		int[][] direct = {{0,1},{1,0},{1,1}};
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}//for end
		}//for end

		Queue<Pipe> queue = new LinkedList<Pipe>();
		Node startNode = new Node(0,0);
		int possibleCount = 0;
		if(map[0][1]!=1)
			queue.offer(new Pipe(startNode,new Node(0,1),PipeState.LandScape));
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			for(int i=0;i<queueSize;i++){
				Pipe pipe = queue.poll();
				Node end = pipe.end;

				if(end.y==N-1&&end.x==N-1) {
					possibleCount++;
					continue;
				}//if end 
				PipeState pipeState = pipe.pipeState;
				
				for(int a=0;a<3;a++) {
					int thisX = end.x+direct[a][1];
					int thisY = end.y+direct[a][0];
					
					if(thisX>=N || thisY>=N)
						continue;
					if(map[thisY][thisX]==1)
						continue;
					
					//각각 가로,세로,대각 이동가능여부
					if((pipeState==PipeState.LandScape || pipeState==PipeState.Diagonal) && a==0) {
						//현재가로or대각 - 가로가능
						queue.offer(new Pipe(end,new Node(thisY,thisX),PipeState.LandScape));
						drawMap[thisY][thisX]=drawMap[end.y][end.x]+1;
						continue;
					}else if((pipeState==PipeState.Portrait || pipeState==PipeState.Diagonal) && a==1){
						//현재세로or대각 - 세로가능 
						queue.offer(new Pipe(end,new Node(thisY,thisX),PipeState.Portrait));
						drawMap[thisY][thisX]=drawMap[end.y][end.x]+1;
						continue;
					}
					
					//대각은 다 가능
					if(a==2) {
						if(map[thisY-1][thisX]!=1&&
								map[thisY][thisX-1]!=1) {	
							queue.offer(new Pipe(end,new Node(thisY,thisX),PipeState.Diagonal));
							drawMap[thisY][thisX]=drawMap[end.y][end.x]+1;
						}//if~else end
					}//if end
					
				}//for end
			}//for end

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(drawMap[i][j]+"  ");
				}//for end
				System.out.println();
			}//for end
			System.out.println();
		}//while end
		
		System.out.println(possibleCount);
		br.close();
	}//main() end
}
