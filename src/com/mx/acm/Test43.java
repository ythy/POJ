package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
24 Point game

时间限制：3000 ms  |  内存限制：65535 KB 

难度：5

描述 

There is a game which is called 24 Point game.

In this game , you will be given some numbers. Your task is to find an expression which have all the given numbers and the value of the expression should be 24 .The expression mustn't have any other operator except plus,minus,multiply,divide and the brackets. 

e.g. If the numbers you are given is "3 3 8 8", you can give "8/(3-8/3)" as an answer. All the numbers should be used and the bracktes can be nested. 

Your task in this problem is only to judge whether the given numbers can be used to find a expression whose value is the given number。
 
 * 1359516 ythyhvh 24 Point game Accepted  2093  9222 java 09-08 10:57:31 
 */
public class Test43 {

	
	private static final int OPERATOR_ADD = 1;
	private static final int OPERATOR_SUBTRACT = 2;
	private static final int OPERATOR_MULTIPLY = 3;
	private static final int OPERATOR_DIVIDE = 4; 
	
	private static int target;
	private static double current;
	private static DecimalFormat df = new DecimalFormat("#.00000000");  
	private static List<String> visitedList;
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int sum;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			sum = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());
			double[] input = new double[sum];
			for(int i = 0; i < sum; i++)
			{
				input[i] = Double.valueOf(st.nextToken());
			}
			current = -1;
			visitedList = new ArrayList<String>();
			
			perm(input, 0);
			
			if(compares())
				System.out.println("Yes");
			else
				System.out.println("No");
			
		}
	}
	
	private static double operate(double l, double r, int operator)
	{
		switch(operator)
		{
			case OPERATOR_ADD :
				return l + r;
			case OPERATOR_SUBTRACT :
				return l - r;
			case OPERATOR_MULTIPLY :
				return l * r;
			case OPERATOR_DIVIDE :
				if(r == 0)
					return Double.NaN;
				else
					return l / r;
		}
		return Double.NaN;
	}
	
	
	//任取2个  -- 全排列取前2个
	private static void perm(double[] list, int start) 
	{
		if(compares())
			return;
		double[] f;
		for(int i = start; i < list.length; i++)
		{
			f = list.clone();
			swap(f, start, i);
			if(i == 0 || i != start) //避免重复输出
			{
				if(addToList(f) && creates(f))
				{
					return;
				}
			}
			if(start == 0 && f.length > 1)	
				perm(f, 1);
		}
	}
	
	private static double[] swap(double[] list, int l, int r)
	{
		double m = list[l];
		list[l] = list[r];
		list[r] = m;
		return list;
	}
	
	//计算
	private static boolean creates(double[] list)
	{
		if(list.length > 1)
		{
			for(int i = 1; i <= 4; i++)
			{
				double[] result = new double[list.length - 1];
				result[0] = operate(list[0], list[1], i);
				if(Double.isNaN(result[0]))
					continue;
				for(int j = 1; j < list.length - 1; j++)
				{
					result[j] = list[j + 1];
				}
				perm(result, 0);
			}
		}
		else
		{
			current = list[0];
			return compares();
		}
		
		return false;	
	}
	
	//比较运算结果
	private static boolean compares()
	{
		if(!Double.isNaN(current))
		{
			String str = df.format(current);
			if(Double.valueOf(str) == target)
				return true;
		}
		return false;
	}
	
	//过滤已计算的表达式
	private static boolean addToList(double[] input)
	{
		StringBuffer sb = new StringBuffer();
		if(input.length > 2)
		{
			double[] temp = Arrays.copyOfRange(input, 2, input.length);
			Arrays.sort(temp);
			for(int i = 0; i < 2; i++)
			{
				sb.append(input[i] + " ");
			}
			for(int i = 0; i < temp.length; i++)
			{
				sb.append(temp[i] + " ");
			}
		}
		else
		{
			for(int i = 0; i < input.length; i++)
			{
				sb.append(input[i] + " ");
			}
		}
		if(!visitedList.contains(sb.toString()))
		{
			visitedList.add(sb.toString());
			return true;
		}
		return false;
	}
}
