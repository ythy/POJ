package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * 一笔画问题
时间限制：3000 ms  |  内存限制：65535 KB
难度：4

描述

    zyc从小就比较喜欢玩一些小游戏，其中就包括画一笔画，他想请你帮他写一个程序，判断一个图是否能够用一笔画下来。

    规定，所有的边都只能画一次，不能重复画。
 *
 *1356028 	ythyhvh	一笔画问题	Accepted 	153 	15850 	java	09-01 10:26:00
 */

public class Test42 {

	private static int[][] qArray;
	private static int[][] visitedArray;
	private static boolean[] visitedPointArray;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int p, q;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			qArray = new int[p + 1][p + 1];
			visitedArray = new int[p + 1][p + 1];
			visitedPointArray = new boolean[p];
			for(int i = 0; i < q; i++)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				qArray[a][b] = 1;
				qArray[b][a] = 1;
			}
			
			visitedPointArray[0] = true;
			dfs(1);
			if(Arrays.toString(visitedPointArray).contains("false"))
				System.out.println("No");
			else
			{
				int oddNum = 0; //judge odd numbers
				for(int i = 1; i < qArray.length; i++)
				{
					int qs = 0;
					for(int j = 1; j < qArray[i].length; j++)
					{
						if(qArray[i][j] == 1)
							qs++;
					}
					if(qs % 2 != 0)
						oddNum++;
					if(oddNum > 2)
						break;
				}
				
				if(oddNum == 0 || oddNum == 2)
					System.out.println("Yes");
				else
					System.out.println("No");
			}
		}
	}
	
	private static void dfs(int a)
	{
		 
		for(int i = 1; i < qArray[a].length; i++ )
		{
			if(qArray[a][i] == 1 && visitedArray[a][i] != 1 )
			{
				visitedArray[a][i] = 1;
				visitedArray[i][a] = 1;
				if(!visitedPointArray[i - 1])
				{
					visitedPointArray[i - 1] = true;
				}
				dfs(i);
			}
		}
	}
	

}
