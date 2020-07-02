package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class CastleDefense {
	static int N;
	static int[][] map;
	static boolean passFlag;
	static int[][] copyMap;
	
	static class ArchersLoc{
		int first,second,third;
		
		public ArchersLoc(int first,int second, int third) {
			this.first=first;
			this.second=second;
			this.third=third;
		}//cons end
	}//class ArcherLoc end
	
	static class Node{
		int x,y;
		Node(int y,int x){
			this.x=x;
			this.y=y;
		}//cons end
	}//class Node end
	
	static class Monster extends Node{
		Monster(int y, int x) {
			super(y, x);
		}//cons end

		public boolean move() {
			if(copyMap[this.y][this.x]==0) {
				return false;
			}//if end 얘죽었어!
			
			//살아있어!
			copyMap[this.y][this.x]=0;
			this.y++;
			if(this.y==N) {
				passFlag=true;
			}//if end 성으로침입했어!
			else{
				copyMap[this.y][this.x]=1;
			}//else end 성으로 침입한건 아니야
			return true;
		}//move() end
	}//class node end
	
	static class Game{
		int M;
		int D;
		Deque<Monster> monsters;
		Stack<Integer[]> archersLoc;
		int result;
		
		public void init() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = null;
			monsters=new LinkedList<Monster>();
			archersLoc=new Stack<Integer[]>();
			result = 0;
			
			this.userInput(br,st);
			this.mapInit(br, st);
			this.archersInit();
		}//init() end
		
		public boolean isExistMap(int y,int x) {
			
			if(x<0 || x>=M || y<0 || y>=N)
				return false;
			return true;
		}//isExistMap() end
		
		public boolean hasMonster(int y,int x) {
			if(copyMap[y][x]==1)
				return true;
			return false;
		}//hasMonster() end
		
		public int getResult() {
			return this.result;
		}//getResult() end
		
		public void running() {
			int max = 0;
			Integer[] loc;
			Queue<Monster> copyMonsters;
			Iterator<Monster> iterator;
			while(!archersLoc.isEmpty()) {
				loc = archersLoc.pop();
				copyMonsters = new LinkedList<Monster>();
				
				iterator = monsters.iterator();
				while(iterator.hasNext()) {
					Monster monster = iterator.next();
					copyMonsters.add(new Monster(monster.y,monster.x));
				}//while() end
				
				copyMap = new int[N+1][M];
				for(int i=0;i<N;i++) {
					copyMap[i]=map[i].clone();
				}//for end

				int deadMonsterNum = 0;
				while(copyMonsters.size()!=0) {
					
					Stack<Node> targetMonsters = new Stack<Node>();
					
					//아처의 활
					for(int i=0;i<3;i++) {
						int archerIndex = loc[i];

						for(int range=1;range<=D;range++) {
							int thisX=0,thisY=0;
							boolean targetCheck = false;
							
							for(int j=1;j<range;j++) {
								thisX = archerIndex-range+j;
								thisY = N-j;
								
								if(!isExistMap(thisY,thisX))
									continue;
								
								targetCheck = hasMonster(thisY, thisX);
								if(targetCheck)
									break;
							}//for end
							if(targetCheck) {
								targetMonsters.add(new Node(thisY,thisX));
								break;
							}//if end 
							thisX= archerIndex;
							thisY= N-range;

							if(isExistMap(thisY,thisX)) {
								targetCheck = hasMonster(thisY, thisX);
								if(targetCheck) {
									targetMonsters.add(new Node(thisY,thisX));
									break;
								}//if end
							}//if end
							
							thisX= archerIndex; //명시
							for(int j=range;j>1;j--) {
								thisX++;
								thisY = N-j+1;

								if(!isExistMap(thisY,thisX))
									continue;
								targetCheck = hasMonster(thisY, thisX);
								if(targetCheck)
									break;
							}//for end
							if(targetCheck) {
								targetMonsters.add(new Node(thisY,thisX));
								break;
							}//if end
						}//for end
					}//for end 아처의 몬스터타게팅
					
					while(!targetMonsters.isEmpty()) {
						Node node = targetMonsters.pop();
						copyMap[node.y][node.x]=0;
					}//while end 죽은몬스터 처리
					
					
					//몬스터들 이동시켜
					//반환값이 true면 스택에 다시집어넣고(생존 몬스터취급)
					//반환값이 false면 스택에 집어넣지마(죽은 몬스터취급)
					int queueSize = copyMonsters.size();
					for(int i=0;i<queueSize;i++) {
						passFlag=false;
						Monster monster = copyMonsters.poll();
						boolean isAlive = monster.move();
						if(isAlive) {
							if(!passFlag)
								copyMonsters.add(monster);
						}//if end
						else {
							deadMonsterNum++;
						}//else end
					}//for end
				}//while end
				if(deadMonsterNum>max)
					max=deadMonsterNum;
			}//while end
			this.result=max;
		}//running() end
		
		public void archersInit() {
			int count = 1 ; 
			Stack<Integer> stack = new Stack<Integer>();
			stack.add(-1);
			
			while(!stack.isEmpty()) {
				int thisNum = stack.pop();
				count--;
				for(int i=thisNum+1;i<M;i++) {
					stack.add(i);
					count++;
					if(count==3) {
						archersLoc.add(new Integer[] {stack.get(0),stack.get(1),stack.get(2)});
						break;
					}//if end
				}//for end
			}//while end
		}//archersInit;
	
		public void userInput(BufferedReader br,StringTokenizer st) throws IOException {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
		}//userInput() end
		
		public void mapInit(BufferedReader br,StringTokenizer st) throws IOException {
			map = new int[N+1][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
					if(map[i][j]==1)
						monsters.addFirst(new Monster(i,j));
				}//for end
			}//for end
		}//mapInit ()end
	}//Game() end
	
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		game.init();
		game.running();
		System.out.println(game.getResult());
	}//main() end
}//class end 