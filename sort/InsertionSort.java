import java.util.Arrays;

public class InsertionSort {

	public static int[] sort(int[] a) {

		for (int i = 1; i < a.length; i++) {
			int k = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > k) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = k;
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 100, 12, 3, 55, 3, 2212, 22, 98, 2, 0 };
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}