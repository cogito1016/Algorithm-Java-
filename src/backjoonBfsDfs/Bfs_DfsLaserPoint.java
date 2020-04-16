package backjoonBfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bfs_DfsLaserPoint {
	static short[][] rootMap;
	static class Node{
		short x,y,element;
		Node(short y,short x){
			this.x=x;
			this.y=y;
			element=rootMap[y][x];
		}//cons end
	}//Class Node end
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		short[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
		char[][] map = new char[y][x]; 
		rootMap = new short[y][x];
		
		boolean[][] visit = new boolean[y][x];
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		
		short startX=0,startY=0;
		for(short i=0;i<y;i++) {
			String s = br.readLine();
			for(short j=0;j<x;j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='C') {
					startX=j;
					startY=i; 
					rootMap[i][j]=-1;
				}//if end
			}//for end
		}//for end
		
		queue.offer(new Node(startY,startX));
		visit[startY][startX]=true;
		short minDistance=0;
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			minDistance++;
			for(int i=0;i<queueSize;i++) {
				if(queue.isEmpty())
					break;
				Node node = queue.poll();
				for(short j=0;j<4;j++) {
					short thisX = (short) (node.x+direct[j][1]);
					short thisY = (short) (node.y+direct[j][0]);
					char thisState;
					if(thisY>=y||thisY<0||thisX>=x||thisX<0)
						continue;
					thisState = map[thisY][thisX];
					if(visit[thisY][thisX])
						continue;
					if(thisState=='*')
						continue;
					if(thisState=='C') {
						while(!queue.isEmpty())
							queue.poll();
						break;
					}//if end
					rootMap[thisY][thisX]=minDistance;
					visit[thisY][thisX]=true;
					queue.offer(new Node(thisY,thisX));
				}//for end
			}//for end
		}//while end
		

		rootMap[startY][startX]=0;
		visit = new boolean[y][x];
		stack.add(new Node(startY,startX));
		visit[startY][startX]=true;
		
		
		List<Node> rootList = new ArrayList<Node>();
		List<List<Node>> list = new ArrayList<List<Node>>();
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			
			for(Node nodeTemp : rootList) {
				if(nodeTemp.element==node.element) {
					int size = rootList.size()-rootList.indexOf(nodeTemp);
					for(int i=0;i<size;i++) 
						rootList.remove(rootList.size()-1);
					break;
				}//if end
			}//for end
			
			rootList.add(node);
			
			for(short i=0;i<4;i++) {
				short thisX= (short) (node.x+direct[i][1]);
				short thisY= (short) (node.y+direct[i][0]);
				int thisNum;
				if(thisY>=y||thisY<0||thisX>=x||thisX<0) {
					continue;}
				thisNum=rootMap[thisY][thisX];
				if(thisNum==0)
					continue;
				if(visit[thisY][thisX])
					continue;
				if(thisNum==-1) {
					rootList.add(new Node(thisY,thisX));
					List<Node> collectList = new ArrayList<Node>();
					collectList.addAll(rootList);
					list.add(collectList);
					visit= new boolean[y][x];
				}//if end
				if(thisNum==minDistance)
					continue;
				if(thisNum!=node.element+1)
					continue;
				visit[thisY][thisX]=true;
				stack.add(new Node(thisY,thisX));
			}//for end
		}//while end
		
		short[][] otherDirect = {{1,1},{1,-1},{-1,1},{-1,-1}}; 
		int min=1000;
		
		for(List<Node> smallList : list) {
			int result=0;
			for(int a= 1; a<smallList.size()-1;a++) {
				Node node = smallList.get(a-1);
				Node nextNode = smallList.get(a+1);
				int subY = nextNode.y - node.y;
				int subX = nextNode.x - node.x;
				for(int i=0;i<4;i++) {
					if((subY==otherDirect[i][0] && subX==otherDirect[i][1]))
							result++;
				}//for end				
			}	//for end
			if(result<min)
				min=result;
		}//for end

		System.out.println(min);
		br.close();
	}//main() end
}//class end