package com.mx.acm;

import java.util.Scanner;
/**
 * 奇偶数分离
 * 描述 
有一个整型偶数n(2<= n <=10000),你要做的是：先把1到n中的所有奇数从小到大输出，再把所有的偶数从小到大输出。
输入
第一行有一个整数i（2<=i<30)表示有 i 组测试数据；
每组有一个整型偶数n。
输出
第一行输出所有的奇数
第二行输出所有的偶数

 * @author maoxin
 * 843318 ythyhvh 奇偶数分离 Accepted  43  1694 java 04-29 11:41:15 
 */
public class Test11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int input = -1;
		int i;
		StringBuffer strBufferOdd;
		StringBuffer strBufferEven;
		while (total > 0) {
			input = scanner.nextInt();
			strBufferOdd = new StringBuffer();
			strBufferEven = new StringBuffer();
			for (i = 1; i <= input; i = i + 2) {
				strBufferOdd.append(i + " ");
			}
			for (i = 2; i <= input; i = i + 2) {
				strBufferEven.append(i + " ");
			}
			System.out.println(strBufferOdd);
			System.out.println(strBufferEven);
			total--;
		}
		
	}
}
