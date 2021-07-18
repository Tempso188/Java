// time Complexity with fibonacci
public class dpfibo {
	// O(2^n)
	public static int recFibo(int n) {
		int result = 0;
		if (n == 0 || n == 1)
			result = 1;
		else
			result = recFibo(n - 1) + recFibo(n - 2);
		return result;
	}

	// O(2n+1) = O(n)
	public static int memFibo(int n, int[] memo) {
		int result;
		if (memo[n] != 0)
			return memo[n];
		if (n == 0 || n == 1)
			result = 1;
		else
			result = memFibo(n - 1, memo) + memFibo(n - 2, memo);
		return result;
	}

	// O(n)
	public static int bUpFibo(int n) {
		if (n == 0 || n == 1)
			return 1;
		int[] bott = new int[n + 1];
		bott[0] = 1;
		bott[1] = 1;
		for (int i = 2; i <= n; i++) {
			bott[i] = bott[i - 1] + bott[i - 2];
		}
		return bott[n];
	}

	public static void main(String[] args) {
		int[] memo = new int[21];
		long start = System.nanoTime();
		System.out.println(recFibo(20));
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println(timeElapsed + " ns");
		start = System.nanoTime();
		System.out.println(memFibo(20, memo));
		finish = System.nanoTime();
		timeElapsed = finish - start;
		System.out.println(timeElapsed + " ns");
		start = System.nanoTime();
		System.out.println(bUpFibo(20));
		finish = System.nanoTime();
		timeElapsed = finish - start;
		System.out.println(timeElapsed + " ns");

	}
}