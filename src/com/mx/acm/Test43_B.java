package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @author maoxin
 * 1359694 ythyhvh 24 Point game Accepted  173  676 java 09-08 16:29:25 
 * 
 * 任取2个数 计算结果 生成新的数组  递归   输出所有可能性
 */
public class Test43_B {

	
	private static int target;
	private static int calculateFlag;
	private static List<String> slist;
	
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
			String[] exp = new String[sum];
			for(int i = 0; i < sum; i++)
			{
				exp[i] = st.nextToken();
				input[i] = Double.valueOf(exp[i]);
			}
			calculateFlag = 0;
			slist = new ArrayList<String>();
			perm(new Node(exp, input));
			
			if(calculateFlag == 1)
			{
				System.out.println("Yes");
				for(int i = 0; i < slist.size(); i++)
				{
					System.out.println(convertRPN(slist.get(i)));
				}
			}
			else
				System.out.println("No");
			
		}
	}
	
	private static void perm(Node node) 
	{
		double[] list = node.result;
		String[] exp = node.expression;
		
//		if(calculateFlag == 1)
//			return;
		
		if(list.length == 1)
		{
			if(compares(list[0]))
			{
				calculateFlag = 1;
				slist.add(exp[0]);
				return;
			}
		}
		else if(list.length == 2)
		{
			if(compares(list[0] + list[1]))
			{
				calculateFlag = 1;
				slist.add(exp[0] + " " + exp[1] + " +");
				return;
			}
			else if(compares(list[0] - list[1]))
			{
				calculateFlag = 1;
				slist.add(exp[0] + " " + exp[1] + " -");
				return;
			}
			else if(compares(list[1] - list[0]))
			{
				calculateFlag = 1;
				slist.add(exp[1] + " " + exp[0] + " -");
				return;
			}
			else if(compares(list[0] * list[1]))
			{
				calculateFlag = 1;
				slist.add(exp[0] + " " + exp[1] + " *");
				return;
			}
			else if(list[1] != 0 && compares(list[0] / list[1]))
			{
				calculateFlag = 1;
				slist.add(exp[0] + " " + exp[1] + " /");
				return;
			}
			else if(list[0] != 0 && compares(list[1] / list[0]))
			{
				calculateFlag = 1;
				slist.add(exp[1] + " " + exp[0] + " /");
				return;
			}
		}
		else
		{
			for(int i = 0; i < list.length; i++)
			{
				for(int j = i + 1; j < list.length; j++)
				{
					
					double[] result = new double[list.length - 1];
					String[] expression = new String[list.length - 1];
					int k = 1;
					for(int m = 0; m < list.length; m++)
					{
						if(m != i && m != j)
						{
							result[k] = list[m];
							expression[k] = exp[m];
							k++;
						}
							
					}
					double l = list[i];
					double r = list[j];
					String le = exp[i];
					String re = exp[j];
					
					result[0] = l + r;
					expression[0] = le + " " + re + " +";
					perm(new Node(expression, result));
					result[0] = l - r;
					expression[0] = le + " " + re + " -";
					perm(new Node(expression, result));
					result[0] = r - l;
					expression[0] = re + " " + le + " -";
					perm(new Node(expression, result));
					result[0] = l * r;
					expression[0] = le + " " + re + " *";
					perm(new Node(expression, result));
					if(r != 0)
					{
						result[0] = l / r;
						expression[0] = le + " " + re + " /";
						perm(new Node(expression, result));
					}
					if(l != 0)
					{
						result[0] = r / l;
						expression[0] = re + " " + le + " /";
						perm(new Node(expression, result));
					}
				}
			}
		}
		
	}
	
	//比较运算结果
	private static boolean compares(double num)
	{
		return  (!Double.isNaN(num) && Math.abs(num - target) < 0.000001) ? true : false;
	}
	
	//逆波兰式转中缀法
	private static String convertRPN(String input)
	{
		String[] in = input.split(" ");
		Queue<String> queueInput = new LinkedList<String>();
		Stack<String> stacktemp = new Stack<String>();
		for(int i = 0; i < in.length; i++)
		{
			queueInput.add(in[i]);
		}
		
		while(!queueInput.isEmpty())
		{
			String tmp = queueInput.poll();
			if(tmp.equals("+"))
			{
				String r = stacktemp.pop();
				String l = stacktemp.pop();
				stacktemp.push("(" + l + " + " + r + ")");
			}
			else if(tmp.equals("-"))
			{
				String r = stacktemp.pop();
				String l = stacktemp.pop();
				stacktemp.push("(" + l + " - " + r + ")");
			}
			else if(tmp.equals("*"))
			{
				String r = stacktemp.pop();
				String l = stacktemp.pop();
				stacktemp.push(l + " * " + r);
			}
			else if(tmp.equals("/"))
			{
				String r = stacktemp.pop();
				String l = stacktemp.pop();
				stacktemp.push(l + " / " + r);
			}
			else
			{
				stacktemp.push(tmp);
			}
			
		}
		 
		
		return stacktemp.pop();
	}
	
	private static class Node
	{
		private String[] expression;
		private double[] result;
		
		Node(String[] e, double[] r)
		{
			expression = e;
			result = r;
		}
	}

}
