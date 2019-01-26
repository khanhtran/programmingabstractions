package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
	
	static List<String> permutations(String str) {
		if (str.length() <= 1) {
			return Arrays.asList(str);
		} else {
			List<String> prevResult = permutations(str.substring(0,  str.length() - 1));
			char last = str.charAt(str.length() - 1 );
			List<String> result = new ArrayList<>();
			for (String p : prevResult) {
				for (int i = 0; i <= p.length(); i++) {
					StringBuilder builder = new StringBuilder(p);
					builder.insert(i, last);
					result.add(builder.toString());
				}
			}
			return result;
		}
	}
	public static void main(String[] args) {
		System.out.println(permutations("abc"));
	}

}
