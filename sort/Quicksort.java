import java.util.Arrays;

public class QuickSort {

	static void tauschen(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int teilen(int[] arr, int links, int rechts) {
		int axi = arr[rechts];

		int i = (links - 1);
		for (int j = links; j <= rechts - 1; j++) {
			if (arr[j] < axi) {
				i++;
				tauschen(arr, i, j);
			}
		}
		tauschen(arr, i + 1, rechts);
		return i + 1;
	}

	static void sort(int[] arr, int links, int rechts) {
		if (links < rechts) {
			int a = teilen(arr, links, rechts);
			sort(arr, links, a - 1);
			sort(arr, a + 1, rechts);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 100, 12, 3, 55, 3, 2212, 22, 98, 2, 0 };
		sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}