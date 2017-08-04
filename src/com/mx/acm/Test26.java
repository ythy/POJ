package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 孪生素数问题
 * 
 * 描述 写一个程序，找出给出素数范围内的所有孪生素数的组数。一般来说，孪生素数就是指两个素数距离为2，近的不能再近的相邻素数。有些童鞋一看到题就开始写程序，不仔细看题，咱们为了遏制一下读题不认真仔细的童鞋，规定，两个素数相邻为1的也成为孪生素数。
输入第一行给出N(0<N<100)表示测试数据组数。
 接下来组测试数据给出m，表示找出m之前的所有孪生素数。
(0<m<1000000)输出每组测试数据输出占一行，该行为m范围内所有孪生素数组数。


 * @author maoxin
 * 921167 ythyhvh 孪生素数问题 Accepted  175  61 java 07-17 17:01:15 
 */
public class Test26 {

	private static int[]  primeac = new int[500000];
	private static int max = 8;
	private static int arrayNum = 3;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int m;
		int result;
		
		primeac[0] = 2;
		primeac[1] = 3;
		primeac[2] = 5;
		primeac[3] = 7;
		while(total-- > 0)
		{
			m = Integer.parseInt(br.readLine());
			result = 0;
			if(max < m)
			{
				setPrimeNumber(max, m);
				max = m;
			}
			 
			for(int i = 0; i <= arrayNum && primeac[i] < m; i++ )
			{
				if(i + 1 <= arrayNum && (primeac[i + 1] -  primeac[i] == 1 ||
						primeac[i + 1] -  primeac[i] == 2) && primeac[i + 1] <= m ) 
				{
					result++;
				}
			}
			System.out.println(result);
		}
	}
	
	
	
	private static void setPrimeNumber(int start, int end)
	{
		if(start%2 == 0)
			start++;
		
		for(int i = start; i <= end; i = i + 2)
		{
			primeac[++arrayNum] = i;
			for(int j = 3; j <= Math.sqrt(i + 0.5); j = j + 2)
			{
				if(i%j == 0)
				{
					primeac[arrayNum--] = 0;
					break;
				}
			}
				
		}
		
	}

}
