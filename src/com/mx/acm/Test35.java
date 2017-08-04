package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 表达式求值
 * 
 * 描述 ACM队的mdd想做一个计算器，但是，他要做的不仅仅是一计算一个A+B的计算器，他想实现随便输入一个表达式都能求出它的值的计算器，现在请你帮助他来实现这个计算器吧。
 比如输入：“1+2/4=”，程序就输出1.50（结果保留两位小数）
输入第一行输入一个整数n，共有n组测试数据（n<10)。
 每组测试数据只有一行，是一个长度不超过1000的字符串，表示这个运算式，每个运算式都是以“=”结束。这个表达式里只包含+-与小括号这几种符号。其中小括号可以嵌套使用。数据保证输入的操作数中不会出现负数。
 数据保证除数不会为0输出每组都输出该组运算式的运算结果，输出结果保留两位小数。
 
 样例输入
2
1.000+2/4=
((1+2)*5+1)/4=
样例输出
1.50
4.00

 * @author maoxin
 * 914137 ythyhvh 表达式求值 Accepted  51  393 java 07-10 15:17:32 
 * 转逆波兰式
 */
public class Test35 {

	/**
	 * @param args
	 * 
	 */
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		String input;
		while(total-- > 0)
		{
			input = br.readLine();
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