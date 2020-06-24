package Sorting;
import java.util.Arrays;
import java.util.Comparator;

public class compara {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr= new int[][] { { 9, 3 }, { 4, 9, 12 }, { 10 } };
		String[] arr= new String[] { "bhappy", "dwang", "cis", "ame" };
//		Comparator<int[]> arrayComparator= new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//		};

		Comparator<String> arrayComparator= new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		};
		Arrays.sort(arr, arrayComparator);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}

}
