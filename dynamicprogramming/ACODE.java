package dynamicprogramming;

import java.util.Scanner;
/**
 * @author KJS1124
 * Problem link http://www.spoj.com/submit/ACODE/
 */
public class ACODE {

	static int dp[] = new int[5002];

	public static long topDownDP(int pointer, String s) {
		if (pointer == s.length())
			return 1;
		if (pointer > s.length())
			return 0;
		if (dp[pointer] != 0)
			return dp[pointer];

		if (s.charAt(pointer) - '0' != 0) {

			if (pointer + 2 <= s.length()) {
				dp[pointer] += (int) topDownDP(pointer + 1, s);
				int x = (s.charAt(pointer) - '0') * 10 + (s.charAt(pointer + 1) - '0');
				if (x <= 26) {
					dp[pointer] += (int) topDownDP(pointer + 2, s);
				}
			} else
				dp[pointer] += (int) topDownDP(pointer + 1, s);
		}
		return dp[pointer];
	}

	public static void main(String agrs[]) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		while (!s.equals("0")) {
			for (int i = 0; i <= s.length(); i++) {
				dp[i] = 0;
			}
			System.out.println(topDownDP(0, s));
			s = in.nextLine();
		}
	}
}
