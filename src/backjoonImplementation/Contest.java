package backjoonImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Contest {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Integer[] wList = new Integer[10];
		Integer[] kList = new Integer[10];
		int w=0,k=0;
				
		for(int i=0;i<10;i++) {
			wList[i]=Integer.parseInt(br.readLine());
		}//for end
		
		for(int i=0;i<10;i++) {
			kList[i]=Integer.parseInt(br.readLine());
		}//for end
		
		Arrays.sort(wList);
		w=wList[9]+wList[8]+wList[7];
		Arrays.sort(kList);
		k=kList[9]+kList[8]+kList[7];
		
		System.out.println(w+" "+k);		
		br.close();
	}//main() end
}//class end