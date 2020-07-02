import java.util.Stack;

public class ArrowTest {

	public static void main(String[] args) {
		
		int[] loc = {1,3,5};
		int D=2 ;
		int N=6 ;
		int M=6 ; 
		int[][] map = new int[N][M];
		
		for(int i=0;i<3;i++) {
			int archerIndex = loc[i];
			
			for(int range=1;range<=D;range++) {
				int thisX=0,thisY=0;
				
				for(int j=1;j<range;j++) {
					thisX = archerIndex-range+j;
					thisY = N-j;
					System.out.print(thisY+" "+thisX+" ");
				}//for end
				
				thisX= archerIndex;
				thisY= N-range;
				System.out.print(thisY+" "+thisX+" ");
				
				thisX= archerIndex; //명시
				for(int j=range;j>1;j--) {
					thisX++;
					thisY = N-j+1;
					System.out.print(thisY+" "+thisX+" ");
				}
				
				System.out.println();
			}//for end
		}//for end 아처는 셋
		
		
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
					System.out.println(stack.get(0)+" "+stack.get(1)+" "+stack.get(2));
					break;
				}//if end
			}//for end
		}//while end
		
	}
}
