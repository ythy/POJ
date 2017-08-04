package com.mx.acm;

import java.util.Scanner;

public class Test170 {

	static Scanner scanner = new Scanner(System.in); 
	public static void main(String[] args){
		while(scanner.hasNext())
		{
			int total = scanner.nextInt();
			int[] f = new int[total + 1];
			for(int i = 1; i <  total; i++)
			{
				f[scanner.nextInt()]++;
				f[scanner.nextInt()]++; 
			}
			
			int result = 0;
			for(int i = 1; i <=  total; i++)
			{
				if(f[i] == 1)
					result++;
			}
			System.out.println((result + 1)/2);
		}
	}

}
