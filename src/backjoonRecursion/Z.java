package backjoonRecursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
	
	static int result = 0;
	static int r;
	static int c;
	public static void solve(int size, int x, int y) {
		
		if(size==1)
			return;
		
		if(size==2) {
			if(x==c&&y==r) { 
				System.out.println(result);
				return;
			}
			result++;
			if(x+1==c&&y==r) {
				System.out.println(result);
				return;
			}
			result++;
			if(x==c&&y+1==r) {
				System.out.println(result);
				return;
			}
			result++;
			if(x+1==c&&y+1==r) {
				System.out.println(result);
				return;
			}
			result++;
		}//if end
		
		size = size/2;
		solve(size,x,y);
		solve(size,size+x,y);
		solve(size,x,size+y);
		solve(size,size+x,size+y);
		
		
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		
		solve((int)Math.pow(2, N),0,0);
		
		
		br.close();
	}
}
