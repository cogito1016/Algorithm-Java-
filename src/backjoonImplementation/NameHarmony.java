package backjoonImplementation;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;


public class NameHarmony {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		char[] charList = new char[N+M];
		int[] resultList = new int[N+M];
		int[] alphabetDictionary =
			{3,2,1,2,4,3,1,3,1,1,3,1,3,2,1,2,2,2,1,2,1,1,1,2,2,1};
	
		int i = -1;
		int j = 0;
		int smallRange = N>M? M:N;
		int bigRange = N>M? N:M;
		
		while(++i <smallRange) {
			charList[j++] = str1.charAt(i);
			charList[j++] = str2.charAt(i);
		}//while end
		
		if(bigRange==str1.length()) {
			for(int a=i;a<bigRange;a++) {
				charList[j++] = str1.charAt(a);	
			}//for end
		}else {
			for(int a=i;a<bigRange;a++) {
				charList[j++] = str2.charAt(a);	
			}//for end
		}//if~else end

		for(int a=0;a<N+M-1;a++) {
			resultList[a] = (alphabetDictionary[charList[a]-65]+alphabetDictionary[charList[a+1]-65])%10;
		}//for end
		
		int repeatNum = N+M-1;
		
		for(int b=0;b<N+M-3;b++) {
			for(int a=0;a<repeatNum;a++) {
				resultList[a] = (resultList[a]+resultList[a+1])%10;
			}//for end
			repeatNum--;
		}//for end 
		
		if(resultList[0]==0) {
			System.out.println(resultList[1]+"%");
		}else {	
			System.out.println(resultList[0]+""+resultList[1]+"%");
		}
		
		
		br.close();
	}//main() end
}
