package backtracking;

public class Recursive {
	private int origStackCount;

	public Recursive() {
		origStackCount = getStackCount();
	}

	private int getStackCount() {
		return Thread.currentThread().getStackTrace().length;
	}

	public void rprint(String message) {
		int indent = getStackCount() - origStackCount;
		for (int i = 0; i < indent; i++) {
			System.out.print("    ");
		}
		System.out.print(message + "\n");
	}

}
