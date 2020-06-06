
public class sfy {

	public static void problem1() {
		
//		int seats = 21;
//		int[] list = {5,3,1,-1,+5,-3,5,4,-5,-5,+4,3};
		
//		int seats = 5;
//		int[] list = {2,1,-4};
		
//		int seats = 41;
//		int[] list = {5,6,7,3,3,7,-4,-3,-1,-5,-3,2,4,-5,-1,6,-4,-4,5,-1};
		

		int seats = 51;
		int[] list = {5,3,-3,6,7,-2,3,-4,-5,1,-8,4,2,7,2,7,4,-5,7,1,-5,6,3,9,-6};
		
		
		int result =0;
		int max =0;
		for(int i=0;i<list.length;i++) {
			result+=list[i];
			if(result>max)
				max=result;
		}
		
		System.out.println("seats-max="+(seats-max)+" result"+result);
		
	}
	
	
	public static void main(String[] args) {
		
		problem1();
		
//		int[] list = new int[32];
//		list[0]=1;
//		list[1]=1;
//		
//		for(int i=2;i<32;i++) {
//			
//			if(i%2==0) {
//				System.out.println("홀");
//				list[i]=list[i-1]+list[i-2];}
//			else {
//				System.out.println("짝");
//				list[i]=list[i-1]-list[i-2];}
//			
//		}
//		
//		System.out.println(list[2]);
//		System.out.println(list[31]);
		
		
	}//main() end
}//class end