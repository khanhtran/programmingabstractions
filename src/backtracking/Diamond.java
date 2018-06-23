package backtracking;
/**
 * 
 * @author Khanh
 * Diamon issue in C++
 *               A
 *             /    \
 *            B      C
 *            \     /
 *               D
 *  http://www.lambdafaq.org/what-about-the-diamond-problem/
 */

interface A {
	default void m() {
		System.out.println("hello from A");
	}
}

interface B extends A {
	default void m() {
		System.out.println("hello from B");
	}
}

interface C extends A {
//	java will cause error on duplicate default methods
//	default void m() {
//		System.out.println("hello from C");
//	}
}

class D implements B, C {
}

public class Diamond {

	public static void main(String[] args) {
		C c = new D();
	    c.m();

	}

}
