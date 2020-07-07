package programmersLvCheck;

import java.math.BigInteger;

public class Lv2_MakeBigNumber {

	static int[] numbersTemp;
	static BigInteger max = BigInteger.ZERO ;
	public static void perfumatation(int r,int current,int[] temp,boolean[] visited) {
		
		if(r==current) {
			String s = "";
			for(int item : temp) {
				s+=item+"";
			}//for end
			BigInteger thisNum = BigInteger.valueOf(Long.parseLong(s) );
			
			if(max.compareTo(thisNum)==-1)
				max=thisNum;
			return;
		}else {
			for(int i=0;i<numbersTemp.length;i++) {
				
				if(visited[i])
					continue;
				
				visited[i]=true;
				temp[current]=numbersTemp[i];
				
				perfumatation(r, current+1, temp, visited);
				visited[i]=false;
			}//for end
		}//if~else end
	}//perfumatation
	
	public static void main(String[] args) {
		int[] numbers = {6,10,2};
		numbersTemp = numbers;
		int[] temp = new int[numbersTemp.length];
		boolean[] visited = new boolean[numbersTemp.length];
		
		perfumatation(numbersTemp.length, 0, temp, visited);
		System.out.println(max.toString());
		
	}//main() end
}
