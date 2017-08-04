package com.mx.acm;

import java.util.Scanner;

/**
 * 指数运算 
 * 
 * 描述 写一个程序实现指数运算 X^N。(1<X<10,0<N<20)
输入输入包含多行数据 
 每行数据是两个整数X N
数据以EOF结束输出于输入的每一行输出X^N的值


 * @author maoxin
 * 961827 ythyhvh 指数运算 Accepted  28  369 java 08-27 11:42:24 
 */
public class Test112 {
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
		long result;
		int x, n, total;
		while(scanner.hasNextInt())
		{
			x = scanner.nextInt();
			n = scanner.nextInt();
			result = 1l;
			total = n;
			while(total-- > 0)
			{
				result *= Long.valueOf(x);
			}
			System.out.println(result);
		}

	}

}
