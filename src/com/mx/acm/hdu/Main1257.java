package com.mx.acm.hdu;

import java.util.Scanner;

public class Main1257 {

	static Scanner scanner = new Scanner(System.in); 
	
	public static void main(String[] args) {
		int total, i, j, max;
		int[] f;
		int[] dp;
		while(scanner.hasNextInt())
		{
			total = scanner.nextInt();
			f = new int[total + 1];
			dp = new int[total + 1];
			max = 0;
					
			for(i = 1; i <= total; i++)
				f[i] = scanner.nextInt();
//N*N 复杂度			
			for(i = 1; i <= total; i++)
			{
				dp[i] = 1;
				for(j = 1; j <i; j++)
				{
					if(f[j] < f[i])
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			
			for(i = 1; i<= total; i++)
			{
				if(dp[i] > max)
					max = dp[i];
			}
			
//			int[] stack = new int[total + 1];
//			int top = 0;
//			stack[top] = Integer.MIN_VALUE;
//			
//			int low,high,mid;
//			for(i = 1; i <= total; i++ )
//			{
//				if(f[i] > stack[top])
//				{
//					top++;
//					stack[top] = f[i];
//				}
//				else
//				{
//					low = 1;
//					high = top;
//					while(low <= high)
//					{
//						mid = (low + high)/2;
//						if(f[i] > stack[mid])
//							low = mid + 1;
//						else
//							high = mid - 1;
//					}
//					stack[low] = f[i];
//				}
//			}
			
			
			System.out.println(max);
		}

	}

}
