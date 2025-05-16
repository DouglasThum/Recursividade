package application;

import java.math.BigInteger;

public class Fatorial {

	public static BigInteger fatorial(BigInteger n) {
		if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		return n.multiply(fatorial(n.subtract(BigInteger.ONE)));
	}

	private static final int MAX_ELEMENTS = 100000;
	private static final BigInteger[] fatElements = new BigInteger[MAX_ELEMENTS];

	public static BigInteger calcularFatorialPD(int n) {
		for (int i = 0; i < MAX_ELEMENTS; i++) {
			fatElements[i] = null;
		}
		return calcularFatorial(n);
	}

	// Top-Down
	private static BigInteger calcularFatorial(int n) {
		if (fatElements[n] == null) {
			if (n == 0 || n == 1) {
				fatElements[n] = BigInteger.ONE;
			} else {
				fatElements[n] = BigInteger.valueOf(n).multiply(calcularFatorial(n - 1));
			}
		}
		return fatElements[n];
	}

	// Bottom-up
	public static BigInteger calcularFatorialBottomUp(int n) {
		BigInteger[] fatElements = new BigInteger[n + 1];
		fatElements[0] = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			fatElements[i] = BigInteger.valueOf(i).multiply(fatElements[i - 1]);
		}
		return fatElements[n];
	}

	public static void main(String[] args) {

		System.out.println("Recursividade simples: ");
		for (int i = 1; i <= 100; i++) {
			BigInteger num = BigInteger.valueOf(i);
			System.out.println("Fatorial do elemento " + i + " = " + fatorial(num));
		}
		
		System.out.println("\nRecursividade Top Down: ");
		for (int i = 1; i < 100; i++) {
			System.out.println("Fatorial do elemento " + i + " = " + calcularFatorialPD(i));
		}
		int num = 101;
		System.out.println("Fatorial do elemento " + num + " = " + calcularFatorialPD(num));
		
		System.out.println("\nRecursividade Bottom Up: ");
		for (int i = 1; i < 100; i++) {
			System.out.println("Fatorial do elemento " + i + " = " + calcularFatorialBottomUp(i));
		}
		
		//maior fatorial calculado com esse método
		System.out.println("Fatorial do elemento 10413: " + fatorial(BigInteger.valueOf(10413)));
		
		//maior fatorial calculado com esse método
		System.out.println("Fatorial do elemento 7813: " + calcularFatorialPD(7813));
	}
}
