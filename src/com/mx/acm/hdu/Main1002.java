package com.mx.acm.hdu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * A + B Problem II
Problem Description
I have a very simple problem for you. Given two integers A and B, your job is to calculate the Sum of A + B.

Input
The first line of the input contains an integer T(1<=T<=20) which means the number of test cases. Then T lines follow, each line consists of two positive integers, A and B. Notice that the integers are very large, that means you should not process them by using 32-bit integer. You may assume the length of each integer will not exceed 1000.
 
Output
For each test case, you should output two lines. The first line is "Case #:", # means the number of the test case. The second line is the an equation "A + B = Sum", Sum means the result of A + B. Note there are some spaces int the equation. Output a blank line between two test cases.

Sample Input
2
1 2
112233445566778899 998877665544332211
 

Sample Output
Case 1:
1 + 2 = 3

Case 2:
112233445566778899 + 998877665544332211 = 1111111111111111110

 * @author maoxin
 * 10842073 2014-06-04 17:02:41 Accepted 1002 93MS 3024K 1996 B Java ythy 
 */
public class Main1002 {

	private static int[] f;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		String[][] input = new String[total][2];
		String[] result = new String[total];
		int i,j,max;
		StringTokenizer st;
		int[] n, m;
		
		for(j = 0; j < total; j++)
		{
			st = new StringTokenizer(br.readLine());
			 
			input[j][0] = st.nextToken();
			input[j][1] = st.nextToken();
			
			n = new int[input[j][0].length()];
			for(i = 0; i < input[j][0].length(); i++)
				n[input[j][0].length() - i - 1 ] = Integer.parseInt(String.valueOf(input[j][0].charAt(i)));
			m = new int[input[j][1].length()];
			for(i = 0; i < input[j][1].length(); i++)
				m[input[j][1].length() - i - 1 ] = Integer.parseInt(String.valueOf(input[j][1].charAt(i)));
			
			max = Math.max(input[j][0].length(), input[j][1].length());
			f = new int[max + 1];
			
			for(i = 0; i < max; i++)
			{
				if(i < n.length && i < m.length)
					calValues(i, n[i] + m[i]);
				else if(i < n.length)
					calValues(i, n[i]);
				else if(i < m.length)
					calValues(i, m[i]);
			}
			
			StringBuffer sb = new StringBuffer();
			
			
			for(i = max; i >= 0; i--)
				sb.append(f[i]);
			if(sb.charAt(0) == '0')
				sb.deleteCharAt(0);
			
			result[j] = sb.toString();
		}
		
		
		
		for(i = 0; i < total; i++)
		{
			System.out.println("Case " + (i + 1) + ":");
			System.out.println(input[i][0] + " + " + input[i][1] + " = " + result[i]);
			if(i < total - 1)
				System.out.println();
		}
		
	}
	
	private static void calValues(int i, int num)
	{
		if(f[i] + num  >= 10)
		{
			f[i] = f[i] + num - 10;
			f[i + 1] = 1;
		}
		else
			f[i] = f[i] + num;
	}

}
