package com.mx.acm;

import java.util.Scanner;

public class Main33 {

	public static int[][] getMatrix(int n) {
		int[][] array = new int[n][n];
		int Num = 1;
		int Sum;
		// 计算i的循环次数
		if (n % 2 != 0)
			Sum = n / 2 + 1;
		else
			Sum = n / 2;

		int i, j;
		for (i = 0; i < Sum; i++) {// 由外到内的环形循环
			// 从上到下
			for (j = i; j < n - i; j++) {
				array[j][n - i - 1] = Num;
				Num++;
			}

			// 从右到左
			for (j = n - i - 2; j >= i; j--) {
				array[n - i - 1][j] = Num;
				Num++;
			}

			// 从下到上
			for (j = n - i - 2; j > i; j--) {
				array[j][i] = Num;
				Num++;
			}
			// 从左到右
			for (j = i; j < n - i - 1; j++) {
				array[i][j] = Num;
				Num++;
			}
		}

		return array;
	}

	private static void print(int[][] array, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		while (true) {
			n = scanner.nextInt();
			if (n == 0)
				break;
			print(getMatrix(n), n);
		}
	}

}
