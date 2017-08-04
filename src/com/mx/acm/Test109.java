package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 数列转换
 * 
 * 描述 
有一个数列a1,a2,a3...an,每次可以从中任意选三个相邻的数ai-1 ,ai , ai+1 ,进行如下操作（此操作称为“对ai进行操作”）

(ai-1,ai,ai+1)->(ai-1+ai,-ai,ai+ai+1)

给定初始和目标序列，是否能通过以上操作，将初始序列转换成为目标序列？例如，初始序列(1 6 9 4 2 0)目标序列（7 -6 19 2 -6 6)可经过如下操作：

 (1 6 9 4 2 0)->( 1 6 13 -4 6 0)->(1 6 13 2 -6 6)->(7 -6 19 2 -6 6)

请你判断给定的初始状态和目标状态，输出Yes（能够转换）或No（不能转换）

输入第一行是一个正整数N,表示测试数据的组数。(N<=100)
每组测试数据的第一行是一个整数M(3<=M<=1000),表示该组测试数据的起始状态与结束状态都有M个数。
 每组测试数据的第二行是M个整数Ai(-1000<=Ai<=1000)，表示起始状态。
 每组测试数据的第三行是M个整数Bi(-1000<=Bi<=1000),表示终止状态。输出如果能够转换，输出Yes
如果不能转换，输出No


 * @author maoxin
 * 961180 ythyhvh 数列转换 Accepted  206  12216 java 08-26 13:08:58 
 */
public class Test109 {
	
	static int MAX = 1010;
	static int[] input = new int[MAX];
	static int[] output = new int[MAX];
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int i;
		boolean brokenflag;
		while(total-- > 0)
		{
			brokenflag = false;
			sum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(i = 1; i <= sum; i++)
				input[i] = Integer.parseInt(st.nextToken());
				
			st = new StringTokenizer(br.readLine());
			for(i = 1; i <= sum; i++)
				output[i] = Integer.parseInt(st.nextToken());
				
			for(i = 1; i <= sum - 1; i++)
			{
				if(input[i] == output[i])
					continue;
				if(!dp(i))
				{
					brokenflag = true;
					break;
				}
			}
			
			if(input[sum] != output[sum])
				brokenflag = true;
			
			System.out.println(brokenflag ? "No" : "Yes");
		}

	}
	
	static boolean dp(int num)
	{
		int[] temparr = Arrays.copyOf(input, input.length) ;
		int i, j, totals = 0;
		boolean result = false;
		for(i = num + 1; i < sum; i++)
		{
			totals += input[i];
			if(input[num] + totals == output[num]) //有解  重置input数组
			{
				result = true;
				break;
			}
				
		}
		if(result)
		{
			input[num] = output[num];
			input[num + 1] = - totals;
			input[i + 1] = temparr[i + 1] + temparr[i];
			for(j = i; j > num + 1; j--)
			{
				input[j] = temparr[j  - 1];
			}
		}
		
		return result;
	}
	

}
