package datastructure;

import java.util.Arrays;

public class MergeSort {
	
	public static void mergeSort(int[] array, int left, int right) {
		
		if(left<right) {
			int mid = (left+right)/2;
			
			mergeSort(array, left, mid);
			mergeSort(array, mid+1,right);
			
			merge(array,left,mid,right);
		}//if end 
	}//mergeSort end
	
	public static void merge(int[] array, int left, int mid, int right) {
		
		int[] L = Arrays.copyOfRange(array, left,mid+1);
		int[] R = Arrays.copyOfRange(array, mid+1, right+1);
		
		int i = 0, j = 0, k = left;
		int ll = L.length, rl = R.length;
		
		while(i<ll&&j<rl) {
			if(L[i]<=R[j]) {
				array[k]=L[i++];
			}else {
				array[k]=R[j++];
			}//if~ else end
			k++;
		}//while end 
		
		while(i<ll) {
			array[k++]=L[i++];
		}//while end 
		while(j<rl) {
			array[k++]=R[j++];
		}
	}//merge end 
	
	
	public static void main(String[] args) {
		int[] array = {9,13,121,15,19};
		
		mergeSort(array, 0, array.length-1);
		
		for(int item : array) {
			System.out.print(item+" ");
		}
	}//main() end
	
}//MergerSort end