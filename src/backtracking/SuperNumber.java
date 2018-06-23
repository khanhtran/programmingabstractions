package backtracking;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SuperNumber {

	// Complete the digitSum function below.
	static int digitSum(String n, int k) {
		int sumOfSuperDigit = 0;
		for (int i = 0; i < k; i++) {
			sumOfSuperDigit += superDigit(n);
		}
		return superDigit(String.valueOf(sumOfSuperDigit));
	}
	
	

	private static int superDigit(String n) {		
		if (n.length() == 1) {
			return Integer.parseInt(n);
		} else {
			int sum = 0;
            for (int i = 0; i < n.length(); i++) {
                sum += Integer.parseInt(String.valueOf(n.charAt(i)));
            }
			return superDigit(String.valueOf(sum));
		}
	}
	
	static int digitSum2(String n, int k) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < k; i++) {
			sb.append(superDigitChar(n));
		}
		char ch = superDigitChar(sb.toString());
		return Integer.parseInt(String.valueOf(ch));
	}
	
	private static char superDigitChar(String n) {		
		if (n.length() == 1) {
			return n.charAt(0);
		} else {
			int sum = 0;
            for (int i = 0; i < n.length(); i++) {
                sum += Integer.parseInt(String.valueOf(n.charAt(i)));
            }
			return superDigitChar(String.valueOf(sum));
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		long t = System.currentTimeMillis();

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = digitSum2(n, k);

        System.out.println(result);
        System.out.println("time in milliseconds: " + (System.currentTimeMillis() - t));
	}

}
