package backjoonDfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javax.swing.event.ListSelectionEvent;

public class TargetNumber {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,1,1,1,1));
		
		
		int targetNum = 3;
		int result = 0;
		int targetNumCollectNum=0;
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> resultList = new ArrayList<Integer>();
		
		stack.push(list.get(0));
		stack.push(list.get(0)*-1);
		

		
		int index=0;
		while(!stack.isEmpty()) {
			int thisVal = stack.pop();
			int nextIndex = ++index;
			result+=thisVal;
			
			if(result==targetNum)
				targetNumCollectNum++;
			
			if(nextIndex>=list.size()) {
				result-=thisVal;
				index--;
				continue;
			}//if end
			
			stack.push(list.get(nextIndex));
			stack.push(list.get(nextIndex)*-1);
			

		}//while end
		System.out.println(targetNumCollectNum);
	}//main() end
}//class end