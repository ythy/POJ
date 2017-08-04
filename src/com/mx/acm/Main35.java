package com.mx.acm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author maoxin
 * 求逆波兰式
 */
public class Main35 {

	/**
	 * @param args
	 * 
	 */
	private static Scanner scanner = new Scanner(System.in);
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	private static List<String> list = new ArrayList<String>();
	static{
		map.put("+", 1);
		map.put("-", 1);
		map.put("*", 2);
		map.put("/", 2);
		
		list.add("+");
		list.add("-");
		list.add("*");
		list.add("/");
		list.add("(");
		list.add(")");
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int total = scanner.nextInt();
		String input;
		while(total-- > 0)
		{
			input = scanner.next();
			input = input.substring(0, input.length() - 1);
			
			Stack<String> stackinput = getBolanshi(input);
			System.out.println(cal(stackinput));
		}
	}
	
	private static String cal(Stack<String> stack)
	{
		int i;
		for(i = 0; i < stack.size(); i++)
		{
			String f = (String) stack.get(i);
			if(list.contains(f))
			{
				double left = Double.valueOf(stack.get(i - 2));
				double right =  Double.valueOf(stack.get(i - 1));
				stack.remove(i);
				stack.remove(i - 1);
				stack.remove(i - 2);
				double result = 0;
				if(f.equals("+"))
					result = left + right;
				else if(f.equals("-"))
					result = left - right;
				else if(f.equals("*"))
					result = left * right;
				else if(f.equals("/"))
					result = left / right;
				stack.add(i - 2, String.valueOf(result));
				i -= 2;
			}
		}
		DecimalFormat f = new DecimalFormat("0.00");
		return f.format(Double.valueOf(stack.get(0)));
	}
	
	private static Stack<String> getBolanshi(String value)
	{
		Stack<String> stackResult = new Stack<String>();
		Stack<String> stackTemp = new Stack<String>();
		int i;
		String handchar;
		String tempStr = "";
		for(i = 0; i < value.length(); i++)
		{
			handchar = String.valueOf(value.charAt(i));
			if(!tempStr.equals(""))
				handchar = tempStr + handchar; 
			if(!list.contains(handchar) && i+1 < value.length() &&
					!list.contains(String.valueOf(value.charAt(i + 1)))	)
			{
				tempStr = handchar;
				continue;
			}
				
			if(!list.contains(handchar))
			{
				stackResult.push(handchar);
			}	
			else if(handchar.equals("("))
				stackTemp.push(handchar);
			else if(handchar.equals(")"))
			{
				while(stackTemp.size() > 0 && !stackTemp.peek().equals("("))
				{
					stackResult.push(stackTemp.pop());
				}
				stackTemp.pop();
			}
			else
			{
				if(stackTemp.size() == 0 || stackTemp.peek().equals("("))
					stackTemp.push(handchar);
				else
				{
					while(stackTemp.size() > 0 && map.get(stackTemp.peek()) != null &&
							map.get(stackTemp.peek()) >= map.get(handchar))
					{
						stackResult.push(stackTemp.pop());
					}
					stackTemp.push(handchar);
					 
				}
					
			}
			tempStr = "";
		}
		while(!stackTemp.empty())
			stackResult.push(stackTemp.pop());
		
		return stackResult;
	}
	
}
