package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 汉诺塔（二）
 * 
 * 描述 
汉诺塔的规则这里就不再多说了，详见题目：汉诺塔（一）

现在假设规定要把所有的金片移动到第三个针上，给你任意一种处于合法状态的汉诺塔，你能计算出从当前状态移动到目标状态所需要的最少步数吗？

输入第一行输入一个整数N，表示测试数据的组数(0<N<20)
每组测试数据的第一行是一个整数m表示汉诺塔的层数(0<m<32)，随后的一行有m个整数Ai,表示第i小的金片所在的针的编号。（三根针的编号分别为1，2，3）输出输出从当前状态所所有的金片都移动到编号为3的针上所需要的最少总数


 * @author maoxin
 * 956829 ythyhvh 汉诺塔（二） Accepted  2  122 java 08-20 11:49:39 
 */
public class Test89 {

	static int[] step = new int[34];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int sum, i;
		int temp, result;
		int[] init;
		calStep();
		
		while(total-- > 0)
		{
			sum =  Integer.parseInt(br.readLine().trim());
			init = new int[sum + 1];
			temp = 3;
			result = 0;
			st = new StringTokenizer(br.readLine().trim());
			for(i = 0; i < sum; i++)
				init[i] = Integer.parseInt(st.nextToken());
			
			for(i = sum - 1; i >= 0; i--)
			{
				if(init[i] != temp)// 从最大的盘M开始算， 大盘在3上不用挪, 不在3上 需要把 M-1都挪到 1/2 上(不能是temp 或者 init[m]), temp重新设置为m-1的位置
				{
					result += step[i];
					temp = 6 - init[i] - temp;
				}
			}
			
			System.out.println(result);
		}

	}
	
	static void calStep()
	{
		 step[0]=1;
		 for(int i = 1; i <= 33; i++)
			step[i] = step[i-1]*2;
	}
	 
}
