package com.mx.acm;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 某种序列
 * 
 * 描述 数列A满足An = An-1 + An-2 + An-3, n >= 3 
编写程序，给定A0, A1 和 A2, 计算A99
输入输入包含多行数据 
 每行数据包含3个整数A0, A1, A2 (0 <= A0, A1, A2 <= 100000000) 
数据以EOF结束输出对于输入的每一行输出A99的值


 * @author maoxin
 * 961879 ythyhvh 某种序列 Accepted  51  369 java 08-27 13:28:55 
 */
public class Test114 {

	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int total;
		BigInteger x, y, z, result;
		BigInteger t1, t2, t3;
		while(scanner.hasNextInt())
		{
			x = scanner.nextBigInteger();
			y = scanner.nextBigInteger();
			z = scanner.nextBigInteger();
			result = BigInteger.valueOf(0l);
			total = 97;
			t1 = x;
			t2 = y;
			t3 = z;
			while(total-- > 0)
			{
				result = t1.add(t2).add(t3);
				t1 = t2;
				t2 = t3;
				t3 = result;
			}
			
			System.out.println(result);
		}

	}

}
