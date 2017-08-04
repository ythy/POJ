package com.mx.acm;

import java.util.Scanner;

/**
 * 括号配对问题
 * 描述 
现在，有一行括号序列，请你检查这行括号是否配对。
输入
第一行输入一个数N（0<N<=100）,表示有N组测试数据。后面的N行输入多组输入数据，每组输入数据都是一个字符串S(S的长度小于10000，且S不是空串），测试数据组数少于5组。数据保证S中只含有"[","]","(",")"四种字符
输出
每组输入数据的输出占一行，如果该字符串中所含的括号是配对的，则输出Yes,如果不配对则输出No

 * @author maoxin
 * 842005 ythyhvh 括号配对问题 Accepted  85  550 java 04-28 17:18:54 
 *  不能用java 自带Stack类操作 ， 会造成超时。 需要自己定义栈
 *  不满足括号匹配原则必须及时退出循环，不能循环到底
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		char[] a = new char[10000];
		while (N > 0) {
			int top = -1;
			char[] ch = scanner.next().toCharArray();
			for (int i = 0; i < ch.length; i++) {
				if(ch[i] == '[' || ch[i] == '('){
					a[++top] = ch[i];
				} 
				else if (top > -1 && ((ch[i] == ']' && a[top] == '[' ) ||
							(ch[i] == ')' &&  a[top] == '(' ))) {
					top--; 
				}
				else
				{
					System.out.println("No");
					top = 0;
					break;
				}
			}
			if (top == -1)
				System.out.println("Yes");
			N--;
		}
	}

}
