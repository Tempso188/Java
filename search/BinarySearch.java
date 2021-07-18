public class BinarySearch {

	public static int binarySearch(int[] arr, int links, int rechts, int x) {
		if (rechts >= links) {
			int mit = links + (rechts - links) / 2;
			if (arr[mit] == x)
				return mit;
			if (arr[mit] > x)
				return binarySearch(arr, links, mit - 1, x);
			return binarySearch(arr, mit + 1, rechts, x);
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 5, 7, 9, 11, 17, 25, 30 };
		int n = arr.length;
		int x = 17;
		int result = binarySearch(arr, 0, n - 1, x);
		if (result == -1)
			System.out.println("Nicht gefunden");
		else
			System.out.println("Gefunden! Stelle : " + result);
	}
}