package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Count any combination of power using backtracking Backtracking variable:
 * currSum
 * 
 * @author Khanh
 *
 */
public class PowerSum {
	static int powerSum(int X, int N) {
		List<Integer> numList = makeList(X, N);
		return powerSumHelper(X, numList, N, 0);
	}

	private static List<Integer> makeList(int x, int n) {
		List<Integer> ret = new ArrayList<>();
		for (int i = 1; Math.pow(i, n) <= x; i++) {
			ret.add(i);
		}
		return ret;
	}

	private static int powerSumHelper(int X, List<Integer> numList, int N, int currSum) {
		if (numList.isEmpty()) {
			if (currSum == X) {
				return 1;
			} else {
				return 0;
			}
		} else {
			int x = numList.remove(0);
			currSum += Math.pow(x, N);
			int s1 = 0;
			if (currSum <= X) {
				s1 = powerSumHelper(X, numList, N, currSum);
			}
			currSum -= Math.pow(x, N);
			int s2 = powerSumHelper(X, numList, N, currSum);
			numList.add(0, x);
			return s1 + s2;
		}
	}

	public static void main(String[] args) {
		int count = powerSum(800, 2);
		System.out.println(count);
	}

}
