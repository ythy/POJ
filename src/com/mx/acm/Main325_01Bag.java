package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 动态规划  01背包问题
 * @author maoxin
 *
 */
public class Main325_01Bag {
	
	private static int[] values;
	private static int[] weight;
	private static int[][] f;
	private static int totalV;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		totalV = Integer.parseInt(br.readLine());
		int total = Integer.parseInt(br.readLine());
		StringTokenizer st;
		values = new int[total + 1];
		weight = new int[total + 1];
		f = new int[total + 1][totalV + 1];
		
		int i, j;
		for(i = 1; i <= total; i++)
		{
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		 for(i = 1; i <= total; i++)
		 {
			 for(j = 1; j <= totalV; j++)
			 {
				 if(weight[i] > j)
					f[i][j] = f[i - 1][j];
				 else
					f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - weight[i]] + values[i]); 
			 }
		 }
		 
		System.out.println(f[total][totalV]);
	}
	
	
//	private static int dp(int i, int j)
//	{
//		
//		return 0;
//	}

}
