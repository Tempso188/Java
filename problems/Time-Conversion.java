//Convert AM/PM to 24hr Format
//e.g String s "09:23:43PM" to "21:23:43"

import java.util.Scanner;

public class TimeConversion {

	public static String timeConversion(String s) {
		int time = 0;
		String res = "";
		if (s.endsWith("PM")) {
			time = Integer.valueOf(s.substring(0, 2));
			if (time + 12 == 24) {
				res = "12" + s.substring(2, 8);
			} else
				res = String.valueOf(time + 12) + s.substring(2, 8);

		} else if (s.endsWith("AM")) {
			time = Integer.valueOf(s.substring(0, 2));
			if (time == 12) {
				res = "00" + s.substring(2, 8);
			}
			if (time < 10) {
				res = "0" + String.valueOf(time) + s.substring(2, 8);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		String n = i.next();
		System.out.println(timeConversion(n));
		i.close();
	}
}