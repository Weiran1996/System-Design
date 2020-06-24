package Sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testarray= new int[] { 12, 5, 2, 6, 4, 8 };
		SelectSort(testarray);
		for (int i= 0; i < testarray.length; i++ ) {
			System.out.print(testarray[i]);
		}
	}

	static void SelectSort(int[] array) {
		for (int i= 0; i < array.length; i++ ) {
			int smallidx= i;
			for (int j= i; j < array.length; j++ ) {
				if (array[j] < array[smallidx]) {
					smallidx= j;
				}
			}
			int temp= array[i];
			array[i]= array[smallidx];
			array[smallidx]= temp;
		}
	}

}
