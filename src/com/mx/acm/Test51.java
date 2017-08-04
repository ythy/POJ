package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 管闲事的小明
 * 描述 某校大门外长度为L的马路上有一排树，每两棵相邻的树之间的间隔都是1米。我们可以把马路看成一个数轴，马路的一端在数轴0的位置，另一端在L的位置；数轴上的每个整数点，即0，1，2，……，L，都种有一棵树。
 　　由于马路上有一些区域要用来建地铁。这些区域用它们在数轴上的起始点和终止点表示。　　已知任一区域的起始点和终止点的坐标都是整数，区域之间可能有重合的部分。现在要把这些区域中的树（包括区域端点处的两棵树）移走。聪明的小明干了一件又一件事，他觉得这个很有意思，就想用计算机来帮助建筑工人统计这些树，现在任务来了，计算将这些树都移走后，马路上还有多少棵树。
输入第一行是一个整数N表示有N组测试数据（1<=N<=100)
每组测试数据的第一行有两个整数：L（1 <= L <= 10000）和 M（1 <= M <= 100），L代表马路的长度，M代表区域的数目，L和M之间用一个空格隔开。接下来的M行每行包含两个不同的整数，用一个空格隔开，表示一个区域的起始点和终止点的坐标。 


输出输出包括一行，这一行只包含一个整数，表示马路上剩余的树的数目。


 * @author maoxin
 * 952183 ythyhvh 管闲事的小明 Accepted  142  1115 java 08-15 13:41:04 
 */
public class Test51 {
	
	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int roadlength, num, result, start, end, j;
		int[] f;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			roadlength = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			result = 0;
			f = new int[roadlength + 1];
			while(num-- > 0)
			{
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				for(j = start; j <= end; j++)
					f[j] = 1;
			}
			
			for(j = 0; j <= roadlength; j++)
			{
				if(f[j] == 0)
					result++;
			}
				
			
			System.out.println(result);
		}

	}
	

}
