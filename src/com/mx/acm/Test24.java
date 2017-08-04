package com.mx.acm;

import java.util.Scanner;
/**
 * 素数距离问题
 *描述 
现在给出你一些数，要求你写出一个程序，输出这些整数相邻最近的素数，并输出其相距长度。如果左右有等距离长度素数，则输出左侧的值及相应距离。
如果输入的整数本身就是素数，则输出该素数本身，距离输出0
输入
第一行给出测试数据组数N(0<N<=10000)
接下来的N行每行有一个整数M(0<M<1000000)，
输出
每行输出两个整数 A B.
其中A表示离相应测试数据最近的素数，B表示其间的距离。

 * @author maoxin
 * 853295 ythyhvh 素数距离问题 Accepted  361  937 java 05-06 13:55:04 
 */
public class Test24 {
	
	private static int maxn = 1000100;
	private static int[] f = new int[maxn];
	private static int[] primeac = new int[maxn]; // -1 非素数    0 未判断   1 素数
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int currentNum;
		f[0] = 2;
		f[1] = 2;
		f[2] = 2;
		f[3] = 2;
		primeac[0] = -1;
		primeac[1] = -1;
		primeac[2] = 1;
		int j;
		for(j = 4; j < maxn; j = j + 2)
		{
			primeac[j] = -1;
		}
		
		while(total > 0)
		{
			currentNum =  scanner.nextInt();
			if(f[currentNum] == 0)
				getPrimeNumber(currentNum);
			System.out.println(f[currentNum] + " " + Math.abs(currentNum - f[currentNum]));
			total--;
		}
	}
	
	private static boolean isPrimeNumber(int v)
	{
		if(primeac[v] == 0)
		{
			primeac[v] = 1;
			int j;
			for(j = 3; j <= Math.sqrt(v + 0.5); j = j + 2)
			{
				if(v%j == 0)
				{
					primeac[v] = -1;
					break;
				}
			}
		}
		
		return (primeac[v] == -1 ? false : true);
	}
	
	private static void getPrimeNumber(int v)
	{
		int j;
		int min = 2;
		int minr = 2; 
		if(!isPrimeNumber(v))
		{
			for(j = v - 1; j > 1 ; j = j - 1)
			{
				if(isPrimeNumber(j))
				{
					min = j;
					break;
				}
			}
			if(Math.abs(v - j) > 1)
			{
				for(j = v + 1; j <  maxn; j = j + 1)
				{
					if(isPrimeNumber(j))
					{
						minr = j;
						break;
					}
				}
				if(Math.abs(minr - v) < Math.abs(min - v))
					min = minr;
			}
			f[v] = min;
		}
		else
			f[v] = v;
	}
}
