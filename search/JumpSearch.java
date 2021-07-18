public class JumpSearch {

	public static int search(int[] arr, int x) {
		int length = arr.length;
		int jump = (int) Math.sqrt(arr.length);
		int lastStep = 0;

		while (arr[Math.min(jump, length) - 1] < x) {
			lastStep = jump;
			jump += (int) (Math.sqrt(length));
			if (lastStep >= length)
				return -1;
		}
		while (arr[lastStep] < x) {
			lastStep++;
			if (lastStep == Math.min(jump, length))
				return -1;
		}

		if (arr[lastStep] == x)
			return lastStep;
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 6, 8, 9, 10, 14, 17 };
		int[] b = new int[] { 2, 4, 5, 11, 12, 15, 21 };
		System.out.println(search(a, 9));
		System.out.println(search(b, 9));
	}
}