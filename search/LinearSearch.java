public class LinearSearch {

	public static int search(int arr[], int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 4, 5, 11, 12, 15, 21 };
		System.out.println(search(a, 15));
	}
}