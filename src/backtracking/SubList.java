package backtracking;
import java.util.ArrayList;
import java.util.List;

public class SubList {

	static void subList(List<String> strList, List<String> choosen) {
		if (strList.size() == 0) {
			System.out.println(choosen);
		} else {
			// Pick an element
			String str = strList.remove(0);
			// try whout that elemet on choosen
			subList(strList, choosen);
			// try with that element on choosen
			choosen.add(str);
			subList(strList, choosen);
			// unpick that
			choosen.remove(choosen.size() - 1);
			strList.add(0, str);
		}
	}

	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
		strList.add("A");
		strList.add("B");
		strList.add("C");
		subList(strList, new ArrayList<String>());

	}

}
