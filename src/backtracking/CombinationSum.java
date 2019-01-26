package backtracking;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum extends Recursive {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(6);
		list.add(3);
		list.add(7);
		list.add(2);
		List<List<Integer>> result = new ArrayList<>();
		new CombinationSum().combinationSum(list, 0, 7, new ArrayList<>(), result);
		System.out.println(result);
	}

	private void combinationSum(List<Integer> list, int index, int target, List<Integer> selected,
			List<List<Integer>> result) {
		rprint("combinationSum " + selected + " | " + index + " | " + target);
		if (target == 0) {
			result.add(new ArrayList<>(selected));
		} else {
			for (int i = index; i < list.size(); i++) {
				if (list.get(i) <= target) {
					selected.add(list.get(i));
					combinationSum(list, index, target - list.get(i), selected, result);
					selected.remove(selected.size() - 1);
				}
			}
		}
	}

}
