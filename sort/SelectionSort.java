import java.util.Arrays;

public class SelectionSort {

	public static int[] sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min])
					min = j;
			}
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 6, 8, 9, 10, 14, 17 };
		int[] b = new int[] { 2, 4, 5, 11, 12, 15, 21 };
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}