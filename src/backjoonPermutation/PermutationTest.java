package backjoonPermutation;

import java.util.Arrays;

public class PermutationTest {
	
	public static char[] src = {'a','b','c','d'};
	
	public static void makePermutation(int r,int current, char[] temp, boolean[] visited) {
		
		if(r==current) {
			System.out.println(Arrays.toString(temp));
			return;
		}else {
			for(int i=0;i<src.length;i++) {
				if(!visited[i]){
					visited[i]=true;
					temp[current]=src[i];
					makePermutation(r, current+1, temp, visited);
					visited[i]=false;
				}//if end
			}//for end
		}//if~else end
	}//makePermutation() end
	
	public static void main(String[] args) {
		
		boolean[] visited = new boolean[4];
		char[] temp = new char[4];
		
		makePermutation(4, 0, temp, visited);
		
	}//main() end
}
