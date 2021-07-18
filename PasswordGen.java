import java.util.Scanner;

public class PasswordGen {

	// n = length of password
	public static String gen(int n) {
		String pass = "";
		String upp = "QWERTZUIOPASDFGHJKLYXCVBNM";
		String low = "qwertzuiopasdfghjklyxcvbnm";
		String spe = "~`!@#$%^&*()-_=+[{]}\\\\|;:\\'\\\",<.>/?";

		for (int i = 0; i < n; i++) {
			int ran = (int) (4 * Math.random());
			switch (ran) {
			case 0:
				pass += String.valueOf((int) (9 * Math.random()));
				break;
			case 1:
				ran = (int) (upp.length() * Math.random());
				pass += String.valueOf(upp.charAt(ran));
				break;
			case 2:
				ran = (int) (low.length() * Math.random());
				pass += String.valueOf(low.charAt(ran));
				break;
			case 3:
				ran = (int) (spe.length() * Math.random());
				pass += String.valueOf(spe.charAt(ran));
				break;

			}
		}
		return pass;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println(gen(n));
	}
}