package backjoonPermutation;

import java.util.Arrays;

public class PermutationTest2 {

	static int[] src = {1,2,3,4};
	
	public static void permu(int r, int current, int[] temp, boolean[] visited) {
		
		if(r==current) {
			System.out.println(Arrays.toString(temp));
			return; 
		}else {
			
			for(int i=0;i<src.length;i++) {
				
				if(visited[i])
					continue;
				
				visited[i]=true;
				temp[current] = src[i];
				permu(r, current+1, temp, visited);
				
				visited[i]=false;
			}//for end
		}
		
	}//permu() end
	
	public static void main(String[] args) {
		
		int[] temp = new int[src.length];
		boolean[] visited = new boolean[src.length];
		
		permu(src.length, 0, temp, visited);
		
		
	}//main() end
}
