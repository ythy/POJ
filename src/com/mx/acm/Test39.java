package com.mx.acm;

import java.util.Scanner;
/**
 * 水仙花数
 * @author maoxin
 *
 */
public class Test39 {
	
	//856925 ythyhvh 水仙花数 Accepted  30  184 java 05-08 11:17:52 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input; 
		int a,b,c = 0;
		String str;
		while(true)
		{
			input = scanner.nextInt();
			if(input == 0)
				break;
			str = String.valueOf(input);
			a = Integer.parseInt(str.substring(0, 1));
			b = Integer.parseInt(str.substring(1, 2));
			c = Integer.parseInt(str.substring(2));
			System.out.println(a*a*a + b*b*b + c*c*c == input ? "Yes" : "No");
			
		}
	}
	
 
	//856943 ythyhvh 水仙花数 Accepted  22  184 java 05-08 11:23:49 
	public static void main2(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input; 
		while(true)
		{
			input = scanner.nextInt();
			if(input == 0)
				break;
			System.out.println(input == 153 || input == 370 || input == 371 || input == 407 ? "Yes" : "No");
		}
	}
	
}
