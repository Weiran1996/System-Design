package Sorting;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort ans= new QuickSort();
		int[] res= new int[] { 3, 6, 1, 9, 12 };
		ans.quickSort(res, 0, 4);
		for (int i : res)
			System.out.print(i);
	}

	void quickSort(int[] arr, int left, int right) {
		int index= partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
	}

	int partition(int[] arr, int left, int right) {
		// array中选出一个值当做 pivot
		int pivot= arr[(left + right) / 2];
		while (left <= right) {
			// 找到第一个比pivot大的 应该在右侧的
			while (arr[left] < pivot)
				left++ ;
			// 找到第一个比pivot小的 应该在左侧的
			while (arr[right] > pivot)
				right-- ;

			if (left <= right) {
				swap(arr, left, right);
				left++ ;
				right-- ;
			}
		}
		return left;
	}

	void swap(int[] arr, int idx1, int idx2) {
		int temp= arr[idx1];
		arr[idx1]= arr[idx2];
		arr[idx2]= temp;
	}

}
