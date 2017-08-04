package com.mx.acm;

import java.util.Scanner;
/**
 * 素数求和问题  C最优算法
 * @author maoxin
 * 847574 ythyhvh 素数求和问题 Accepted  235  1665 java 05-02 14:07:29 
 */
public class Main22 {
	
	static int maxn = 1100;
	static boolean[] f = new boolean[maxn]; 
	
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int total = scanner.nextInt();
//		int linenum;
//		
//		int i;
//		int sum = 0; //求和
//		int input;
//		setPrimeNumber();
//		while(total > 0)
//		{
//			linenum = scanner.nextInt();
//			sum = 0;
//			for(i = 0; i < linenum; i++)
//			{
//				input = scanner.nextInt();
//				sum += (f[input] ? 0 : input);
//			}
//			
//			System.out.println(String.valueOf(sum));
//			total--;
//		}
		setPrimeNumber();
		int a = 'z';
		System.out.println(a);
	}
	
	
	static void setPrimeNumber()
	{
		int i;
		int j;
		int m = (int) Math.sqrt(maxn);
		f[1] = true;
		for(i = 2; i < m; i++)
		{
			if(!f[i])
			{
				for(j = i*i; j < maxn; j+=i)
				{
					f[j] = true; 
				}
			}
			
		}
	}
}
