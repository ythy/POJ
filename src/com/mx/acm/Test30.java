package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
Gone Fishing

时间限制：3000 ms  |  内存限制：65535 KB 

难度：5

描述 John is going on a fishing trip. He has h hours available (1 <= h <= 16), and there are n lakes in the area (2 <= n <= 25) all reachable along a single, one-way road. John starts at lake 1, but he can finish at any lake he wants. He can only travel from one lake to the next one, but he does not have to stop at any lake unless he wishes to. For each i = 1,...,n - 1, the number of 5-minute intervals it takes to travel from lake i to lake i + 1 is denoted ti (0 < ti <=192). For example, t3 = 4 means that it takes 20 minutes to travel from lake 3 to lake 4. To help plan his fishing trip, John has gathered some information about the lakes. For each lake i, the number of fish expected to be caught in the initial 5 minutes, denoted fi( fi >= 0 ), is known. Each 5 minutes of fishing decreases the number of fish expected to be caught in the next 5-minute interval by a constant rate of di (di >= 0). If the number of fish expected to be caught in an interval is less than or equal to di , there will be no more fish left in the lake in the next interval. To simplify the planning, John assumes that no one else will be fishing at the lakes to affect the number of fish he expects to catch. 
 Write a program to help John plan his fishing trip to maximize the number of fish expected to be caught. The number of minutes spent at each lake must be a multiple of 5. 
 * @author maoxin
 * 1361242 ythyhvh Gone Fishing Accepted  57  554 java 09-11 13:29:57 
 * 假定在每一个湖结束钓鱼的情况  算每5分钟最大钓鱼数量    时间为减去从2走到i的时间
 * 以上每种情况取最大的值
 * ps  能一起完成的操作  不要分开进行
 */
public class Test30 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static int h;
	static int[] fi, di, ti;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true)
		{
			int n = Integer.parseInt(br.readLine().trim());
			if(n == 0)
				break;
			h = Integer.parseInt(br.readLine().trim()) * 60; //用时转化为分钟
			fi = new int[n];
			st = new StringTokenizer(br.readLine().trim());
			for(int i = 0; i < n; i++)
				fi[i] = Integer.parseInt(st.nextToken());
			di = new int[n];
			st = new StringTokenizer(br.readLine().trim());
			for(int i = 0; i < n; i++)
				di[i] = Integer.parseInt(st.nextToken());
			ti = new int[n - 1];
			st = new StringTokenizer(br.readLine().trim());
			for(int i = 0; i < n - 1; i++)
				ti[i] = Integer.parseInt(st.nextToken()) * 5;
			
			
			int t = 0;
			int maxFishs = 0;
			int[] maxfishArray = new int[n];
					
			for(int i = 0; i < n; i++)
			{
				int smaxFishs = 0;
				int[] stimes = new int[n]; 
				int[] timesFish5 = fi.clone(); 
				if(i > 0)
					t += ti[i - 1];
				int totaltime = h - t;
				while(totaltime > 0)
				{
					int max5 = 0;
					int select = -1;
					for(int j = 0; j <= i; j++)
					{
						if( timesFish5[j] > max5)
						{
							max5 =  timesFish5[j];
							select = j;
						}
					}
					if(select > -1)
					{
						smaxFishs += max5;
						stimes[select] += 5;
						totaltime -= 5;
						timesFish5[select] -= di[select];
					}
					else
					{
						stimes[0] += totaltime;
						break;
					}
				}
				
				if(smaxFishs > maxFishs)
				{
					maxFishs = smaxFishs;
					maxfishArray = stimes.clone();
				}
				
			}
			
			StringBuffer resulttime = new StringBuffer();
			for(int i = 0; i < n; i++)
			{
				resulttime.append(maxfishArray[i] + (i == n - 1 ? "" : ", "));
			}
			
			System.out.println(resulttime + "\n" + 
					"Number of fish expected: " + maxFishs + "\n");
			
		}
	}
	
}
