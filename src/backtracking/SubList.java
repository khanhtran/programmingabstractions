package backtracking;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Khanh
 *
 */
public class SubList extends Recursive {

	void subList(List<String> chosen, List<String> strList) {
		rprint("subList(" + chosen + ", " + strList + ")");
		if (strList.size() == 0) {
			rprint(chosen + "**");
		} else {
			// Pick an element
			String str = strList.remove(0);
			// try with that elemet on choosen
			chosen.add(str);
			subList(chosen, strList);
			
			// unpick that
			chosen.remove(chosen.size() - 1);
			subList(chosen, strList);
			strList.add(0, str);
		}
	}

	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
		strList.add("A");
		strList.add("B");
		strList.add("C");
		new SubList().subList(new ArrayList<String>(), strList);

	}

}
