package datastructure;

import java.util.Arrays;

public class MergeSortRepeat {

	public static void mergeSort(int[] array, int left, int right) {
		
		if(left<right) {
			int mid = (left+right)/2;
			
			mergeSort(array,left,mid);
			mergeSort(array,mid+1,right);
			
			merge(array,left,mid,right);
		}//if end
		
	}//mergeSort() end
	
	public static void merge(int[] array, int left, int mid, int right) {
		
		int[] L = Arrays.copyOfRange(array, left, mid+1);
		int[] R = Arrays.copyOfRange(array, mid+1, right+1);
		
		int ll = L.length, rl = R.length;
		int k = left;
		int i = 0, j = 0;
		
		while(j<ll&&i<rl) {
			
			if(R[i]<L[j]) {
				array[k]=R[i++];
			}else {
				array[k]=L[j++];
			}//if~ else end
			
			k++;
		}//while end
		
		while(j<ll) {
			array[k]=L[j++];
			k++;
		}//while end 
		
		while(i<rl) {
			array[k]=R[i++];
			k++;
		}//while end
		
	}//merge() end 
	
	public static void main(String[] args) {
		
		int[] array = {1,9,3,8,15,12};
		
		mergeSort(array,0,array.length-1);
		
		for(int item : array) {
			System.out.print(item+" ");
		}//for end
		
	}//main() end
}//msr end