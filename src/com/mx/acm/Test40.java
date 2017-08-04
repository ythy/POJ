package com.mx.acm;

import java.util.Scanner;
/**
 * 公约数和公倍数
 * 描述 
小明被一个问题给难住了，现在需要你帮帮忙。问题是：给出两个正整数，求出它们的最大公约数和最小公倍数。
输入
第一行输入一个整数n（0<n<=10000)，表示有n组测试数据;
随后的n行输入两个整数i,j（0<i,j<=32767)。
输出
输出每组测试数据的最大公约数和最小公倍数

 * @author maoxin
 * 866913 ythyhvh 公约数和公倍数 Accepted  363  2527 java 05-15 15:52:02 
 */
public class Test40 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int a,b,e,f,g;
		while(total > 0)
		{
			a = scanner.nextInt();
			b = scanner.nextInt();
			e = Math.max(a, b);
			f = Math.min(a, b);
			while(true)
			{
				g = e%f;
				if(g == 0)
					break;
				e = f;
				f = g;
				
			}
			System.out.println(f + " " + (a*b/f));
			total--;
		}
	}
}
