package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Binary String Matching
 * 描述 Given two strings A and B, whose alphabet consist only ‘0’ and ‘1’. Your task is only to tell how many times does A appear as a substring of B? For example, the text string B is ‘1001110110’ while the pattern string A is ‘11’, you should output 3, because the pattern A appeared at the posit
输入The first line consist only one integer N, indicates N cases follows. In each case, there are two lines, the first line gives the string A, length (A) <= 10, and the second line gives the string B, length (B) <= 1000. And it is guaranteed that B is always longer than A.输出For each case, output a single line consist a single integer, tells how many times do B appears as a substring of A.

 * @author maoxin
 * 903290 ythyhvh Binary String Matching Accepted  7  245 java 06-26 17:38:13 
 */
public class Test5 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int result, length;
		String inputA;
		StringBuffer inputB;
		while(total-- > 0)
		{
			inputA = br.readLine();
			inputB = new StringBuffer(br.readLine());
			result = 0;
			length = inputA.length();
			while(inputB.length() >= length)
			{
				if(inputA.equals(inputB.substring(0, length)))
					result++;
				inputB.deleteCharAt(0);
			}
			System.out.println(result);
		}
	}

}
