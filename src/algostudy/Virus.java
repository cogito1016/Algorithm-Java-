package algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Virus {

	static class Node{
		
		int x,y;
		
		Node(int y,int x){
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
		
		
		
	}//Class Node end
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//컴퓨터 수
		int computerNum= Integer.parseInt(br.readLine());
		//맵 크기
		int[][] map = new int[computerNum][computerNum];
		boolean[] visit = new boolean[computerNum];
		//쌍 수
		int twinNum = Integer.parseInt(br.readLine());
		//스택
		Stack<Node> stack = new Stack<Node>();
		//감염시킨수
		int infection=0;
		int thisX,thisY;
		
		//입력부
		for(int i=0;i<twinNum;i++) {
			String[] s = br.readLine().split(" ");
			int first = Integer.parseInt(s[0]);
			int second = Integer.parseInt(s[1]);
			map[first-1][second-1]=1;
			map[second-1][first-1]=1;
		}//for end
		
		map[0][0]=1;
		visit[0]=true;
		stack.push(new Node(0,0));
		
		for(int i=1;i<computerNum;i++) {
			
			if(visit[i]==true)
				continue;
			
			if(map[0][i]==1) {
				stack.push(new Node(0,i));
				visit[i]=true;
				
				infection++;
				
				if(map[0][i]==1) {
					
				}
			}//if end
		}//for end
		
		
		
		System.out.println(infection);
		
		
		br.close();
	}//main() end
}//class end
