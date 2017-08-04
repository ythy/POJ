package com.mx.acm;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Test55 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
	 
		int total = scanner.nextInt() , i, sum;
		long output, temp;
		Queue<Long> input = new PriorityQueue<Long>();
		while(total-- > 0)
		{
			sum = scanner.nextInt();
			output = 0L;
			for(i = 0; i < sum; i++)
				input.add(scanner.nextLong());
			while(input.size() > 1)
			{
				temp = input.poll() + input.poll();
				input.add(temp);
				output += temp;
			}
			System.out.println(output);
			input.clear();
		}
	}

}
