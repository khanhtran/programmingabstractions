package backtracking;

import java.util.ArrayList;
import java.util.List;

public class DiceSum {
	static int calls = 0;

	public static void main(String[] args) {
		diceSum(3, 4);
	}

	/**
	 * Print all combinations of dicing rolls with n dices
	 * 
	 * @param i
	 */
	private static void diceSum(int dice, int desiredSum) {
		diceSumHelper(dice, desiredSum, 0, new ArrayList<Integer>());
		System.out.println(calls);
	}

	private static void diceSumHelper(int dice, int desiredSum, int sumSoFar, List<Integer> choosen) {
		calls++;
		if (dice == 0) {
			System.out.println(choosen);
		} else {
			for (int i = 1; i <= 6; i++) {

				if (sumSoFar + i + (dice - 1) <= desiredSum && sumSoFar + i + 6 * (dice - 1) >= desiredSum) {
					// choose
					choosen.add(i);
					// explore
					diceSumHelper(dice - 1, desiredSum, sumSoFar + i, choosen);
					// unchoose
					choosen.remove(choosen.size() - 1);
				}
			}
		}
	}

}
