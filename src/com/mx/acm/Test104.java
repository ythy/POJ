package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
最大和

时间限制：1000 ms  |  内存限制：65535 KB 

难度：5

描述 
给定一个由整数组成二维矩阵（r*c），现在需要找出它的一个子矩阵，使得这个子矩阵内的所有元素之和最大，并把这个子矩阵称为最大子矩阵。 
例子：
0 -2 -7 0 
9 2 -6 2 
-4 1 -4 1 
-1 8 0 -2 
其最大子矩阵为：

9 2 
-4 1 
-1 8 
其元素总和为15。 

输入第一行输入一个整数n（0<n<=100）,表示有n组测试数据；
 每组测试数据：
 第一行有两个的整数r，c（0<r,c<=100），r、c分别代表矩阵的行和列；
 随后有r行，每行有c个整数；
输出输出矩阵的最大子矩阵的元素之和。
 * 
 * 1205321 ythyhvh 最大和 Accepted  303  769 java 03-23 12:18:50 
 */
public class Test104 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		long[][] f;
		int m,n;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			f = new long[m + 1][n + 1];
			for(int i = 1; i <= m; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= n; j++)
				{
					f[i][j] = f[i - 1][j] + Long.valueOf(st.nextToken());
				}
			}
			
			long maxnum = Long.MIN_VALUE; 
			long sum = 0;
			for(int i = 1; i <= m; i++)
			{
				for(int j = i; j <= m ; j++)
				{
					sum = 0;
					for(int k = 1; k <= n; k++)
					{
						if(sum < 0)
							sum = f[j][k] - f[i - 1][k];
						else
							sum += f[j][k] - f[i - 1][k];
						
						maxnum = Math.max(sum, maxnum);
					}
				}
			}
			
			System.out.println(maxnum);
			
		}

	}

}
