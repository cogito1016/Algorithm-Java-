import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test {
	static class A{
		int a;
	}
	public static void main(String[] args) {
		
//		List<Integer> rootList = new ArrayList<Integer>();
//		rootList.add(1);
//		rootList.add(2);
//		rootList.add(3);
//		rootList.add(4);
//		rootList.add(5);
//		rootList.add(6);
//		rootList.add(7);
//		rootList.add(8);
//		rootList.add(9);
//		rootList.add(10);
//		int node =7;
//		
//		//지금뽑은 엘리먼트를 넣어준다
//		for(int nodeTemp : rootList) {
//			if(nodeTemp==node) {
//				int size = rootList.size()-rootList.indexOf(nodeTemp);
//				
//				for(int i=0;i<size;i++) 
//					rootList.remove(rootList.size()-1);
//				break;
//			}
//		}//for end
//			
//		for(int result : rootList) {
//			System.out.println(result);
//		}
//		
//		int a = 10;
//		Integer ab = 100;
//		
		A hello = new A();
		A bye = hello;
		System.out.println(hello.equals(bye));
		
		String a = "1234";
		String b = new String("1234");
		System.out.println(a.equals(b));
		
		Set<Integer> set;
	}
}
