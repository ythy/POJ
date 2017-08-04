package com.mx.acm;

import java.util.Scanner;
/**
 * 素数求和问题
 * 描述 
现在给你N个数（0<N<1000），现在要求你写出一个程序，找出这N个数中的所有素数，并求和。
输入
第一行给出整数M(0<M<10)代表多少组测试数据
每组测试数据第一行给你N，代表该组测试数据的数量。
接下来的N个数为要测试的数据，每个数小于1000
输出
每组测试数据结果占一行，输出给出的测试数据的所有素数和
 * @author maoxin
 * 847537 ythyhvh 素数求和问题 Accepted  201  1596 java 05-02 13:31:28 
 */
public class Test22 {
	
	static int maxn = 1100;
	static int[] f = new int[maxn]; 
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int linenum;
		
		int i;
		int sum = 0; //求和
		setPrimeNumber();
		while(total > 0)
		{
			linenum = scanner.nextInt();
			sum = 0;
			for(i = 0; i < linenum; i++)
			{
				sum += f[scanner.nextInt()];
			}
			
			System.out.println(String.valueOf(sum));
			total--;
		}
	}
	
	static void setPrimeNumber()
	{
		f[2] = 2;
		int i;
		int j;
		for(i = 3; i < maxn; i = i + 2)
		{
			f[i] = i;
			for(j = 3; j <= Math.sqrt(i); j = j + 2)
			{
				if(i%j == 0)
				{
					f[i] = 0;
					break;
				}
			}
		}
	}
}
