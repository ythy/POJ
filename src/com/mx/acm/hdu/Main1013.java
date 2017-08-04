package com.mx.acm.hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Digital Roots
Problem Description
The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resulting value contains two or more digits, those digits are summed and the process is repeated. This is continued as long as necessary to obtain a single digit.

For example, consider the positive integer 24. Adding the 2 and the 4 yields a value of 6. Since 6 is a single digit, 6 is the digital root of 24. Now consider the positive integer 39. Adding the 3 and the 9 yields 12. Since 12 is not a single digit, the process must be repeated. Adding the 1 and the 2 yeilds 3, a single digit and also the digital root of 39.

Input
The input file will contain a list of positive integers, one per line. The end of the input will be indicated by an integer value of zero.

Output
For each integer in the input, output its digital root on a separate line of the output.


 * @author maoxin
 * 10848760 2014-06-06 09:29:24 Accepted 1013 140MS 5044K 821 B Java ythy 
 */

public class Main1013 {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String input;
		List<Integer> result = new ArrayList<Integer>();
		
		while(scanner.hasNext())
		{
			input = scanner.next();
			if(input.equals("0"))
				break;
			
			result.add(sumdigital(input));
		}
		
		
		for(int i = 0; i < result.size(); i++)
		{
			System.out.println(result.get(i));
		}
	}
	
	static int sumdigital(String str)
	{
		int i;
		int digital;
		int sum = 0;
		for(i = 0; i < str.length(); i++)
		{
			digital = Character.getNumericValue(str.charAt(i));
			sum += digital;
			if(sum >= 10)
				sum = sumdigital(String.valueOf(sum));
		}
		return sum;
	}
}
