package backtracking;

public class PrintBinary extends Recursive {

	public static void main(String[] args) {
		new PrintBinary().printBinary(3, "");
	}

	private void printBinary(int n, String output) {
		rprint("printBinary(" + n + ", \"" + output + "\")");
		if (n == 0) {
			System.out.println(output);
		} else {
			printBinary(n - 1, output + "0");
			printBinary(n - 1, output + "1");
		}
	}

}
