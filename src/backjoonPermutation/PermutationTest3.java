package backjoonPermutation;

public class PermutationTest3 {
	static int[] src = {1,2,3,4,5};
	
	public static void permu(int N, int current, int[] temp,boolean[] visited) {
		
		if(N==current) {
			for(int item : temp) {
				System.out.print(item);
			}
			System.out.println();
		}//if end
		
		for(int i=0;i<N;i++) {
			
			if(visited[i])
				continue;
			visited[i]= true;
			temp[current] =src[i];
			permu(N,current+1,temp,visited);
			visited[i]= false;
		}//for end
		
	}//permu() end
	
	public static void main(String[] args) {
		
		int N = 4;
		
		int[] temp = new int[N];
		boolean[] visited = new boolean[N];
		
		int current = 0;
		
		permu(N,current,temp,visited);
		
	}//main() end

}
