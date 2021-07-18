import java.util.Arrays;

public class BubbleSort {

	public static int[] bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 100, 12, 3, 55, 3, 2212, 22, 98, 2, 0 };
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}
}