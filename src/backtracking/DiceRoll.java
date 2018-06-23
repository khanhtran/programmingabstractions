package backtracking;

import java.util.ArrayList;
import java.util.List;

public class DiceRoll {
	static int calls = 0;
	public static void main(String[] args) {
		diceRoll(3);
	}

	/**
	 * Print all combinations of dicing rolls with n dices
	 * @param i
	 */
	private static void diceRoll(int dice) {
		List<Integer> choosen = new ArrayList<>(); 
		diceRollHelper(dice, choosen);
		System.out.println(calls);
	}

	private static void diceRollHelper(int dice, List<Integer> choosen) {
		calls++;
		if (dice == 0) {
			System.out.println(choosen);
		} else {
			for (int i = 1; i <= 6; i++) {
//				choose
				choosen.add(i);
//				explore
				diceRollHelper(dice - 1, choosen);
//				unchoose
				choosen.remove(choosen.size() - 1);
			}
		}
	}

}
