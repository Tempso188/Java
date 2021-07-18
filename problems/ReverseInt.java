
//e.g input 4321 then output 1234
import java.util.Scanner;

public class ReversInt {

	public static int reverseInt(int n) {
		long reverse = 0;
		while (n != 0) {
			reverse = reverse * 10 + n % 10; // adds last digit of n to reverse*10
			n = n / 10; // remove last digit of n
		}
		// reverse bigger or smaller than Integer MAX/MIN
		if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
			return 0;

		return (int) reverse;
	}

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		int n = i.nextInt();
		System.out.println(reverseInt(n));
	}
}