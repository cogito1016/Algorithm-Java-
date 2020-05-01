package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsPuyoPuyo {

	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//class Node end
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[12][6];
		boolean[][] visit = new boolean[12][6];
		int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		boolean removeFlag= true;
		Queue<Node> queue = new LinkedList<Node>();
		
		for(int i=0;i<12;i++) {
			String s = br.readLine();
			for(int j=0;j<6;j++) {
				map[i][j]=s.charAt(j);
			}//for end
		}//for end
		
		int result =0;
		ArrayList<Integer> popXList = null;
		ArrayList<Integer> realPopXList = null;
		
		while(removeFlag) {
			removeFlag=false;
			for(int i=11;i>=0;i--) {
				for(int j=5;j>=0;j--) {
					if(map[i][j]=='.')
						continue;
					
					queue.offer(new Node(i,j));
					visit = new boolean[12][6];
					visit[i][j]=true;
					char[][] tempMap = new char[12][6];
					popXList = new ArrayList<Integer>();
					for(int r =0;r<12;r++) {
						System.arraycopy(map[r], 0, tempMap[r], 0, 6);
					}//for end
					tempMap[i][j]='.';
					int count =1;
					popXList.add(j);
					while(!queue.isEmpty()) {
						
						Node node = queue.poll();
						char thisColor = map[node.y][node.x];
						
						for(int a=0;a<4;a++) {
							int thisX = node.x+direct[a][1];
							int thisY = node.y+direct[a][0];
							if(thisX>=6||thisX<0||thisY>=12||thisY<0)
								continue;
							if(visit[thisY][thisX])
								continue;
							if(map[thisY][thisX]!=thisColor)
								continue;
							visit[thisY][thisX]=true;
							tempMap[thisY][thisX]='.';
							queue.offer(new Node(thisY,thisX));
							count++;
							if(!popXList.contains(thisX))
								popXList.add(thisX);
						}//for end
					}//while end
					
					if(count>=4) {
						map=tempMap;
						removeFlag=true;
						realPopXList=(ArrayList<Integer>) popXList.clone();
						
					}
					
				}//for end
			}//for end
			if(removeFlag) {
				result++;
				for(int x : realPopXList) {
					
					for(int y=11;y>=0;y--) {
						char thisColor = map[y][x];
						if(map[y][x]=='.')
							continue;
						for(int z=y;z<11;z++) {
							if(map[z+1][x]=='.'){
								map[z][x]='.';
								map[z+1][x]=thisColor;
							}else
								break;
						}//for end
					}
				}//for end
			}//if end

//			System.out.println();
//			for(int a=0;a<12;a++) {
//				for(int b=0;b<6;b++) {
//					System.out.print(map[a][b]);
//				}//for end
//				System.out.println();
//			}//for end
		}
		
		
		System.out.println(result);

		br.close();
	}//main() end
}//class end