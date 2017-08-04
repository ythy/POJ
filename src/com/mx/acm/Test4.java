package com.mx.acm;

import java.util.Scanner;
/**
 * ASCII码排序
 * 描述 
输入三个字符（可以重复）后，按各字符的ASCII码从小到大的顺序输出这三个字符。
输入
第一行输入一个数N,表示有N组测试数据。后面的N行输入多组数据，每组输入数据都是占一行，有三个字符组成，之间无空格。
输出
对于每组输入数据，输出一行，字符中间用一个空格分开。
 * @author maoxin
 *
 */
public class Test4 {
	
	//843468 ythyhvh ASCII码排序 Accepted  29  307 java 04-29 13:34:05 
	public static void main2(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		char[] input = new char[3];
		int i;
		int j;
		StringBuffer strBuffer;
		while (total > 0) {
			input = scanner.next().toCharArray();
			strBuffer = new StringBuffer();
			strBuffer.append(input[0] + " ");
			for (i = 1; i < input.length; i++) {
				strBuffer.append(input[i] + " ");
				for(j = 0; j < strBuffer.length(); j += 2)
				{
					if(input[i] < strBuffer.charAt(j))
					{
						strBuffer.insert(j, input[i] + " ");
						strBuffer.delete(strBuffer.length() - 2, strBuffer.length() - 1);
						break;
					}
				}
			}
			System.out.println(strBuffer);
			total--;
		}
		
	}
	
	//843475 ythyhvh ASCII码排序 Accepted  160  307 java 04-29 13:45:11 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		char[] input = new char[3];
		char a,b,c,d;
		while (total > 0) {
			input = scanner.next().toCharArray();
			a = input[0];
			b = input[1];
			c = input[2];
			if(a > b)
			{
				d = a; a = b; b = d;
			}
			if(b > c)
			{
				d = b; b = c; c = d;
			}
			if(a > b)
			{
				d = a; a = b; b = d;
			}
			
			System.out.println(a + " " + b + " " + c);
			total--;
		}
		
	}
}
