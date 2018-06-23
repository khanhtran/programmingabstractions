package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find if an array of integer contains subset N element with sum equals S
 * 
 * @author Khanh
 *
 */
public class SubSum {

	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>();
		lst.add(7);
		lst.add(5);
		lst.add(6);
		lst.add(9);
		lst.add(10);
		lst.add(1);
		lst.add(2);
		boolean result = containSumSubset(lst, 3, 109);
		System.out.println(result);
	}

	private static boolean containSumSubset(List<Integer> lst, int numberOfElem, int desiredSum) {

		return containSumSubsetUtil(lst, numberOfElem, desiredSum, 0, new ArrayList<>());
	}

	private static boolean containSumSubsetUtil(List<Integer> lst, int numberOfElem, int desiredSum, int sumSofar,
			List<Integer> selected) {
		System.out.println("containSumSubsetUtil " + Arrays.toString(selected.toArray()));
		if (selected.size() == numberOfElem) {
			if (sumSofar == desiredSum) {
				System.out.println(Arrays.toString(selected.toArray()));
				return true;
			}
		} else if (selected.size() < numberOfElem) {
			for (int i = 0; i < lst.size(); i++) {
				int k = lst.remove(i);
				selected.add(k);
				boolean result = containSumSubsetUtil(lst, numberOfElem, desiredSum, sumSofar + k, selected);
				lst.add(i, k);
				selected.remove(selected.size() - 1);
				if (result == true) {
					return result;
				}
			}
		}
		return false;
	}
}
