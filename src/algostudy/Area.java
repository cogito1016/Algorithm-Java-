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

public class Area {

	static class Node{
		
		private int x,y;
		
		Node(int y, int x){
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

		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int rectNum = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[y][x];
		int[][] direct = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		
		Queue<Node> queue = new LinkedList<Node>();
		List<Integer> resultSet = new ArrayList<Integer>();
		
		int firstY,firstX,secondX,secondY;		
		
		for(int i=0;i<rectNum;i++) {
			st = new StringTokenizer(br.readLine());
			firstX = Integer.parseInt(st.nextToken());
			firstY = Integer.parseInt(st.nextToken());
			secondX = Integer.parseInt(st.nextToken());
			secondY = Integer.parseInt(st.nextToken());
			
			for(int j=(y-secondY);j<(y-firstY);j++) {
				for(int k=firstX;k<secondX;k++) {
					if(map[j][k])
						continue;
					map[j][k]=true;
				}//for end
			}//for end
		}//for end
		
//		for(int j=0;j<y;j++) {
//			for(int k=0;k<x;k++) {
//				System.out.print(map[j][k]);
//			}//for end
//			System.out.println();
//		}//for end
		
		Node node;
		int result=0,thisX,thisY,areaNum=0;
		

		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				if(!map[i][j]) {
					result =0;
					areaNum++;
					queue.offer(new Node(i,j));
					while(!queue.isEmpty()) {
						node = queue.poll();
						
						for(int k=0;k<4;k++) {
							thisX= node.getX()+direct[k][0];
							thisY= node.getY()+direct[k][1];
							if(thisX>=x||thisX<0||thisY>=y||thisY<0)
								continue;
							if(map[thisY][thisX])
								continue;
							result++;
							map[thisY][thisX]=true;
							queue.offer(new Node(thisY,thisX));
						}//for end
					}//while end
					if(result==0)
						resultSet.add(1);
					else
						resultSet.add(result);
					
				}//if end
			}//for end
		}//for end
		
		int thisVal,nextVal;
		for(int i=0;i<resultSet.size();i++) {
			for(int j=i;j<resultSet.size()-1;j++) {
				thisVal=resultSet.get(j);
				nextVal =resultSet.get(j+1);
				if(thisVal>nextVal) {
					resultSet.set(j, nextVal);
					resultSet.set(j+1, thisVal);
				}
			}//for end
		}//for end
		
		System.out.println(areaNum);
		for(int i=0;i<resultSet.size();i++) {
			System.out.print(resultSet.get(i));
			if(i!=resultSet.size()-1)
				System.out.print(" ");
		}//for end
		
		br.close();
	}//main() end
}//class end
