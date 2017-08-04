package com.mx.acm;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class Main90 {
	
	static Scanner cin = new Scanner(new BufferedInputStream(System.in));
	static PrintStream cout = new PrintStream(new BufferedOutputStream(System.out));
	
	public static void main(String[] args) {
		for (int N = cin.nextInt(); N-- > 0 && cin.hasNext() && solve(););
		cin.close();
		cout.close();
	}
	
	static int N = 11;
	static int Q[][] = new int[N + 1][N + 1];
	
	static boolean solve() {
		cout.println(f(cin.nextInt()));
		return true;
	}
	
	private static int f(int n) {
		return q(n, n);
	}
	static int q(int n, int m) {
		if (Q[n][m] != 0) return Q[n][m];
		if (n < 1 || m < 1) return Q[n][m] = 0;
		if (n == 1 || m == 1) return Q[n][m] = 1;
		if (n < m) return Q[n][m] = q(n, n);
		if (n == m) return Q[n][m] = q(n, m - 1) + 1;
		return Q[n][m] = q(n, m - 1) + q(n - m, m);
	}
}
       
