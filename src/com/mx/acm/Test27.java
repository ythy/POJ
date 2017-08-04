package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 水池数目
 * 
 * 描述 南阳理工学院校园里有一些小河和一些湖泊，现在，我们把它们通一看成水池，假设有一张我们学校的某处的地图，这个地图上仅标识了此处是否是水池，现在，你的任务来了，请用计算机算出该地图中共有几个水池。

输入第一行输入一个整数N，表示共有N组测试数据
 每一组数据都是先输入该地图的行数m(0<m<100)与列数n(0<n<100)，然后，输入接下来的m行每行输入n个数，表示此处有水还是没水（1表示此处是水池，0表示此处是地面）输出输出该地图中水池的个数。
 要注意，每个水池的旁边（上下左右四个位置）如果还是水池的话的话，它们可以看做是同一个水池。
 
 * @author maoxin
 * 905835 ythyhvh 水池数目 Accepted  51  684 java 06-30 13:45:54 
 */
public class Test27 {

	static int[][] input;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int x,y,i,j,output;
		
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			input = new int[110][110];
			output = 0;
			for(i = 1; i <= x; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(j = 1; j <= y; j++)
					input[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(i = 1; i <= x; i++)
			{
				for(j = 1; j <= y; j++)
				{
					if(input[i][j] == 1)
					{
						output++;
						dp(i, j);
					}
						
				}
			}
			
			System.out.println(output);
		}

	}
 
	static void dp(int i, int j)
	{
		if(input[i][j - 1] == 1)
		{
			input[i][j - 1] = 0;
			dp(i, j - 1);		
		} 
		if(input[i - 1][j] == 1)
		{
			input[i - 1][j] = 0;
			dp(i - 1, j);		
		}
		if(input[i + 1][j] == 1)
		{
			input[i + 1][j] = 0;
			dp(i + 1, j);		
		}
		if(input[i][j + 1] == 1)
		{
			input[i][j + 1] = 0;
			dp(i, j + 1);		
		}
		
	}
	 
	
}
