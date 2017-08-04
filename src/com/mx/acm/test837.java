package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test837 {

	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String line = br.readLine();
			if(line == null || line.equals(""))
				break;
			print(Integer.parseInt(line));
		}
	}
	
	static void print(int n)
	{
		int[] minArray = new int[1000000];
		StringBuffer  result = new StringBuffer("(0,0)");
		minArray[0] = 1;
		for(int i = 1; i <= n; i++)
		{
			int a = getMin(minArray);
			result.append("(" + a + "," + (a + i) + ")");
			minArray[a] = 1;
			minArray[a + i] = 1;
		}
		System.out.println(result);
	}
	
	
	static int getMin(int[] minArray)
	{
		for(int i = 0; i < minArray.length; i++)
		{
			if(minArray[i] == 0)
				return i;
		}
		return -1;
	}
	
}
