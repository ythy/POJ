package com.mx.acm.hdu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1237 {

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		while(scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			if(line.equals("0"))
				break;
			StringTokenizer st = new StringTokenizer(line);
			List<String> result = new ArrayList<String>();
			Stack<String> stack_symbol = new Stack<String>();
			while(st.hasMoreTokens())
			{
				String tempStr = st.nextToken();
				if(isNumber(tempStr))
				{
					result.add(tempStr);
				}
				else 
				{
					if(!stack_symbol.empty())
					{
						if((tempStr.equals("*") || tempStr.equals("/")) &&  
								(stack_symbol.peek().equals("+") || stack_symbol.peek().equals("-")))
						{
							stack_symbol.push(tempStr);
						}
						else
						{
							while(!stack_symbol.empty())
								result.add(stack_symbol.pop());
							stack_symbol.push(tempStr);
						}
					}
					else
						stack_symbol.push(tempStr);
				
				}
					 
			}
			while(!stack_symbol.isEmpty())
			{
				result.add(stack_symbol.pop());
			}
			
			
			Stack<Double> stack_num = new Stack<Double>();
			double finalResult = 0;
			for(int i = 0; i < result.size(); i++)
			{
				String symbol = result.get(i);
				if(isNumber(symbol))
					stack_num.push(Double.valueOf(symbol));
				else
				{
					finalResult = cacular(stack_num.pop(), stack_num.pop(), symbol);
					stack_num.push(finalResult);
				}
			}
			
			DecimalFormat df = new DecimalFormat("#.00");
			System.out.println(df.format(finalResult));
		}
	}
	
	static boolean isNumber(String str)
	{
		return !(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
	}
	
	static double cacular(double a, double b, String symbol)
	{
		double result = 0;
		if(symbol.equals("+"))
			result = a + b;
		if(symbol.equals("-"))
			result = b - a;
		if(symbol.equals("*"))
			result = a * b;
		if(symbol.equals("/"))
			result = b / a;
		return result;
	}
}
