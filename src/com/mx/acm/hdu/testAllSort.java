package com.mx.acm.hdu;

public class testAllSort {
	
	public static void main(String[] args) {
		String[] input = { "a", "b", "c", "d", "e"};
		print(input);
		dp(input, input.length - 1);
		
	}
	
	static void dp(String[] input, int index)
	{
		if(index - 1 < 0)
			return;
		dp(input.clone(), index - 1);
		for(int i = index; i < input.length; i++)
		{
			String temp = input[i];
			input[i] = input[i - 1];
			input[i - 1] = temp;
			print(input);
			dp(input, index - 1);
		}
	}
	
	
	
	static void print(String[] num)
	{
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < num.length;  i++)
			sb.append(num[i]);
		System.out.println(sb);
	}
	
	
}
