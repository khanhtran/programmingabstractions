package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SumSquare extends Recursive {

	public static void main(String[] args) {
		System.out.println(new SumSquare().numSquares(13));
	}

	public int numSquares(int n) {
		List<Integer> squares = new ArrayList<>();
		for (int i = 1; i * i < n; i++) {
			squares.add(i * i);
		}
		List<List<Integer>> numberList = new ArrayList<>();
		numSquares(squares, 0, n, new ArrayList<Integer>(), numberList);
		System.out.println(numberList);
		int min = Integer.MAX_VALUE;

		for (List<Integer> l : numberList) {
			min = Math.min(min, l.size());
		}
		return min;
	}

	public void numSquares(List<Integer> numbers, int index, int currentSum, List<Integer> selected,
			List<List<Integer>> result) {
		rprint("numSquares " + selected + " | " + index + " | " + currentSum);
		if (currentSum == 0) {
			result.add(new ArrayList<>(selected));
		} else {
			for (int i = index; i < numbers.size(); i++) {
				int n = numbers.get(i);
				if (n <= currentSum) {
					selected.add(n);
					numSquares(numbers, i, currentSum - n, selected, result);
					selected.remove(selected.size() - 1);
				}
			}
		}
	}
}
