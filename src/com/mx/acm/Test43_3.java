package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author maoxin
 * 1359694 ythyhvh 24 Point game Accepted  173  676 java 09-08 16:29:25 
 * 
 * 任取2个数 计算结果 生成新的数组  递归
 */
public class Test43_3 {

	
	private static int target;
	private static int calculateFlag;
	
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
			calculateFlag = 0;
			
			perm(input);
			
			if(calculateFlag == 1)
				System.out.println("Yes");
			else
				System.out.println("No");
			
		}
	}
	
	private static void perm(double[] list) 
	{
		if(calculateFlag == 1)
			return;
		
		if(list.length == 1)
		{
			if(compares(list[0]))
			{
				calculateFlag = 1;
				return;
			}
		}
		else if(list.length == 2)
		{
			if(compares(list[0] + list[1]) || compares(list[0] - list[1]) || compares(list[1] - list[0]) || 
					compares(list[0] * list[1]) || (list[1] != 0 && compares(list[0] / list[1])) || 	
					(list[0] != 0 && compares(list[1] / list[0])) )
			{
				calculateFlag = 1;
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
					int k = 1;
					for(int m = 0; m < list.length; m++)
					{
						if(m != i && m != j)
							result[k++] = list[m];
					}
					double l = list[i];
					double r = list[j];
					result[0] = l + r;
					perm(result);
					result[0] = l - r;
					perm(result);
					result[0] = r - l;
					perm(result);
					result[0] = l * r;
					perm(result);
					if(r != 0)
					{
						result[0] = l / r;
						perm(result);
					}
					if(l != 0)
					{
						result[0] = r / l;
						perm(result);
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
	
}
