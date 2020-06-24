package Sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testarray= new int[] { 12, 5, 2, 6, 4, 8 };
		InsertionSort ans= new InsertionSort();
		int[] daan= ans.InsertSort(testarray);
		for (int i= 0; i < testarray.length; i++ ) {
			System.out.print(daan[i]);
		}
	}

//	public static void InsertSort(int[] arr) {
//		for (int i= 1; i < arr.length; i++ ) {
//			int key= arr[i];
//			int j= i - 1;
//			while (j >= 0 && arr[j] > key) {
//				arr[j + 1]= arr[j];
//				j-- ;
//			}
//			arr[j + 1]= key;
//
//		}
//	}

	public int[] InsertSort(int[] arr) {
		for (int i= 1; i < arr.length; i++ ) {
			int key= arr[i];
			int j= i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1]= arr[j];
				j-- ;
			}
			arr[j + 1]= key;
		}
		return arr;
	}
}
