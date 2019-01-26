package backtracking;

public class Permutation2 extends Recursive {

	public static void main(String[] args) {
		
		new Permutation2().permu("abc");
	}

	private void permu(String input) {
		permuHelper("", input);
	}

	private void permuHelper(String chosen, String input) {
		rprint("permuHelper(" + chosen + ", " + input + ")");
		if (input.isEmpty()) {
			rprint(chosen);
		} else {
			StringBuilder b = new StringBuilder(input);
			for (int i = 0; i < b.length(); i++) {
				char c = b.charAt(i);
				b.deleteCharAt(i);
				chosen = chosen + c;
				permuHelper(chosen, b.toString());
				chosen = chosen.substring(0,  chosen.length() - 1);
				b.insert(i, c);
			}
		}
	}

}
