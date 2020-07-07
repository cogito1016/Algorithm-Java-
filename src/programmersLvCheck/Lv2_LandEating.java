package programmersLvCheck;


public class Lv2_LandEating {
	static int[][] landTemp;
	static int max = 0;
	public static void solu(int depth, int current,int visited, int[] temp) {
		
		
		if(current==depth) {
			int sum = 0;
			for(int i : temp) {
				sum+=i;
			}
			if(max<sum)
				max=sum;
			return;
		}else {
			int beforeVisited = visited;
			for(int i=0;i<4;i++) {
				if(i==visited)
					continue;
				
				visited = i;
				temp[current]= landTemp[current][i];
				solu(depth, current+1, visited, temp);
				visited = beforeVisited;
			}//for end
		}//if~else end
		
	}
	
	public static void main(String[] args) {
		
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1},{5,4,3,2}};
		landTemp = land;
		
		int N = land.length ;
		int[] temp = new int[N];
		
		solu(N,0,-1,temp);
		
		System.out.println(max);
	}//main() end
}
