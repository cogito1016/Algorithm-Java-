import java.util.Stack;

public class CombiTest {

	public static void main(String[] args) {
		
		int[] possible = new int[10];
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		int brickNum = 1;
		
		while(!stack.isEmpty()) {
			
			int standard = stack.pop();
			brickNum--;
			
			for(int a=standard+1;a<possible.length;a++) {
				stack.add(a);
				brickNum++;
				if(brickNum==3) {
					System.out.println(stack.get(0)+" "+stack.get(1)+" "+stack.get(2));
					break;
				}
			}
		}
	}
}
