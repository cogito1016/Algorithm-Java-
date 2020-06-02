package datastructure;

public class QuickSort {


	public static void quickSort(int[] array,int left,int right) {
		if(left>=right) return; //정렬방식과 반대면 종료
		int pivot = partition(array,left,right); //피벗을 선택
		quickSort(array, left, pivot-1); //피벗을 기준으로 좌측분활퀵소트진행
		quickSort(array, pivot+1, right); //피벗을 기준으로 우측분활퀵소트진행
	}//quickSort() end
	
	public static int partition(int[] array, int left,int right) {
		int pivot = array[left];
		int i=left,j=right;
		
		while(i<j) {
			
			while(pivot<array[j]) {
				j--;
			}//while end 피벗보다 작을때까지 오른쪽에서 내려온다 
			while(i<j && pivot >= array[i]) {
				i++;
			}//while end 피벗보다 클때까지 왼쪽에서 올라간다
			swap(array,i,j); //둘을 바꾼다
		}//while end 
		
		//파벗과 마지막 좌측요소를 교환한다
		//그럼 최종적으로 피벗 좌측은 피벗보다 작은거 우측은 피벗보다 큰게정렬
		array[left] = array[i];
		array[i] = pivot;
		
		return i;
	}//partition() end

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}//swap() end
	
	public static void main(String[] args) {
		int[] array = {1,2,5,10,99,123,8};
		quickSort(array, 0, array.length-1);
		for(int item : array) {
			System.out.print(item + " ");
		}
	}
}
