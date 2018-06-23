package backtracking;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UNCOMPLETED_Crossword {
	static final char NO_SPACE = '+';

	static String[] crosswordPuzzle(String[] crossword, String hints) {
		List<String> hintList = new ArrayList<>();
		String[] tmp = hints.split(";");
		for (int i = 0; i < tmp.length; i++) {
			hintList.add(tmp[i]);
		}
		return crosswordPuzzleHelper(crossword, hintList, new ArrayList<String>());
	}

	public static String[] crosswordPuzzleHelper(String[] crossword, List<String> hints, List<String> choosen) {
		if (hints.isEmpty()) {
			/* stop searching */
			return crossword;
		} else {
			for (int i = 0; i < hints.size(); i++) {
				String hint = hints.remove(i);
				boolean canPut = putWord(crossword, hint);
				if (canPut) {
					choosen.add(hint);
					crosswordPuzzleHelper(crossword, hints, choosen);
					choosen.remove(choosen.size() - 1);
				}
			}

			return crossword;
		}
	}

	private static boolean putWord(String[] crossword, String hint) {
		if (crossword.length == 0) {
			return false;
		}
		int cols = crossword[0].length();
		for (int i = 0; i < cols; i++) {
			if (putCol(crossword, i, hint)) {
				return true;
			}
		}
		int rows = crossword.length;
		for (int i = 0; i < rows; i++) {
			if (putRow(crossword, i, hint)) {
				return true;
			}
		}

		return true;
	}

	private static boolean putRow(String[] crossword, int row, String hint) {
		System.out.println("putRow " + row + " " + hint);
		if (crossword.length == 0) {
			return false;
		}
		char[] tmp = crossword[row].toCharArray();
		int i = 0;
		while (i < tmp.length) {
			while (i < tmp.length && tmp[i] == NO_SPACE) {
				i++;
			}
			if (i == tmp.length) {
				return false;
			}
			int k = 0;
			for (; k < hint.length() && i + k < tmp.length && tmp[i + k] != NO_SPACE; k++) {
				tmp[k] = hint.charAt(k);
			}
			if (k == hint.length()) {
				crossword[row] = new String(tmp);
				return true;
			}
			i++;
		}
		return false;
	}

	private static boolean putCol(String[] crossword, int col, String hint) {
		System.out.println("putCol " + col + " " + hint);
		int i = 0;
		int rows = crossword.length;
		while (i < rows) {
			while (i < rows && crossword[i].charAt(col) == NO_SPACE) {
				i++;
			}
			if (i == rows) {
				return false;
			}
			
			int k = 0;
			List<String> changes = new ArrayList<>();
			for (; k < hint.length() && k + i < rows && crossword[i + k].charAt(col) != NO_SPACE; k++) {
				// crossword[i].
				char[] tmp = crossword[i].toCharArray();
				tmp[col] = hint.charAt(k);
				changes.add(new String(tmp));
			}
			if (k == hint.length()) {
				for (int j = 0; j < changes.size(); j++) {
					crossword[i + j] = changes.get(j);
				}
				return true;
			}
			i++;
		}
		return false;
	}

	public static void main(String[] args) {
//		String[] crossword = new String[] { "+-++++++++", "+-++++++++", "+-++++++++", "+-----++++", "+-+++-++++",
//				"+-+++-++++", "+++++-++++", "++------++", "+++++-++++", "+++++-++++" };
//		boolean result = putRow(crossword, 3, "DELHI");
//		System.out.println(result);
//		System.out.println(Arrays.toString(crossword));

//		 Scanner in = new Scanner(System.in);
//		 String[] crossword = new String[10];
//		 for (int crossword_i = 0; crossword_i < 10; crossword_i++) {
//		 crossword[crossword_i] = in.next();
//		 }
//		 String hints = in.next();
//		 String[] result = crosswordPuzzle(crossword, hints);
//		 for (int i = 0; i < result.length; i++) {
//		 System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
//		 }
//		 System.out.println("");
//		
//		 in.close();
	}
}
