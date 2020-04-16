import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		List<Integer> rootList = new ArrayList<Integer>();
		rootList.add(1);
		rootList.add(2);
		rootList.add(3);
		rootList.add(4);
		rootList.add(5);
		rootList.add(6);
		rootList.add(7);
		rootList.add(8);
		rootList.add(9);
		rootList.add(10);
		int node =7;
		
		//지금뽑은 엘리먼트를 넣어준다
		for(int nodeTemp : rootList) {
			if(nodeTemp==node) {
				int size = rootList.size()-rootList.indexOf(nodeTemp);
				
				for(int i=0;i<size;i++) 
					rootList.remove(rootList.size()-1);
				break;
			}
		}//for end
			
		for(int result : rootList) {
			System.out.println(result);
		}
	}
}
