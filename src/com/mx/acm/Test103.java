package com.mx.acm;


import java.math.BigInteger;
import java.util.Scanner;
/**
 * A+B Problem II
描述 
I have a very simple problem for you. Given two integers A and B, your job is to calculate the Sum of A + B.

A,B must be positive.

输入
The first line of the input contains an integer T(1<=T<=20) which means the number of test cases. Then T lines follow, each line consists of two positive integers, A and B. Notice that the integers are very large, that means you should not process them by using 32-bit integer. You may assume the length of each integer will not exceed 1000.
输出
For each test case, you should output two lines. The first line is "Case #:", # means the number of the test case. The second line is the an equation "A + B = Sum", Sum means the result of A + B. Note there are some spaces int the equation. 

 * @author maoxin
 * 890026 ythyhvh A+B Problem II Accepted  30  246 java 06-05 09:29:00 
 */
public class Test103 {

	static Scanner cin = new Scanner(System.in);

	public static void main(String[] args)
	{
		int total = cin.nextInt();
		BigInteger a;
		BigInteger b;

		for (int i = 1; i <= total; i++)
		{
			a = cin.nextBigInteger();
			b = cin.nextBigInteger();
			System.out.println("Case " + i + ":\n" + a + " + "+ b + " = " + a.add(b));
		}
	}

}
 
       