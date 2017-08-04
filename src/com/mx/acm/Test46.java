package com.mx.acm;

import java.util.Scanner;
/**
 * 
最少乘法次数

时间限制：1000 ms  |  内存限制：65535 KB 

难度：3

描述 
给你一个非零整数，让你求这个数的n次方，每次相乘的结果可以在后面使用，求至少需要多少次乘。如24：2*2=22（第一次乘），22*22=24（第二次乘），所以最少共2次；

 * @author maoxin
 * 1361276 ythyhvh 最少乘法次数 Accepted  130  123 java 09-11 15:16:18 
 */

public class Test46 {
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
		int total = scanner.nextInt();
		while(total-- > 0)
		{
			int input = scanner.nextInt();
			int result = 0;
			while(input > 1)
			{
				if(input % 2 != 0)
					input--;
				else
					input = input >> 1;
				result++;
			}
			System.out.println(result);
		}
	}

}
