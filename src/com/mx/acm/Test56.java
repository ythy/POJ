package com.mx.acm;

import java.util.Scanner;
/**
 * 阶乘因式分解（一）
描述 
给定两个数m,n,其中m是一个素数。

将n（0<=n<=10000）的阶乘分解质因数，求其中有多少个m。

输入
第一行是一个整数s（0<s<=100)，表示测试数据的组数
随后的s行, 每行有两个整数n，m。
输出
输出m的个数。

 * @author maoxin
 * 875966 ythyhvh 阶乘因式分解（一） Accepted  41  369 java 05-21 10:18:14 
 */
public class Test56 {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int input;
		int primeNum;
		int i,j,p;
		
		while(total > 0)
		{
			input = scanner.nextInt();
			primeNum  = scanner.nextInt();
			j = 0;
			for(i = primeNum; i <= input; i +=primeNum)
			{
				p = i;
				while(p % primeNum == 0 && p != 0)
				{
					 j++;
					 p/=primeNum;
				}
			}
			
			System.out.println(j);
			total --;
		}
		
	}
 
}
