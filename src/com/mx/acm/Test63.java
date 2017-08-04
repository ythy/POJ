package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
小猴子下落

时间限制：3000 ms  |  内存限制：65535 KB 

难度：3

描述 
有一颗二叉树，最大深度为D,且所有叶子的深度都相同。所有结点从左到右从上到下的编号为1,2,3，·····，2的D次方减1。在结点1处放一个小猴子，它会往下跑。每个内结点上都有一个开关，初始全部关闭，当每次有小猴子跑到一个开关上时，它的状态都会改变，当到达一个内结点时，如果开关关闭，小猴子往左走，否则往右走，直到走到叶子结点。

一些小猴子从结点1处开始往下跑，最后一个小猴儿会跑到哪里呢？

 * @author maoxin
 * 1362871 ythyhvh 小猴子下落 Accepted  13  61 java 09-14 15:26:16 
 */
public class Test63 {

	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int d = Integer.parseInt(st.nextToken().trim());
			int m = Integer.parseInt(st.nextToken().trim());
			if(d == 0 && m == 0)
				break;
			
			int result = 1; // 奇数 result * 2；  偶数 result * 2 + 1
			for(int i = 1; i < d; i++)//已每一层做循环
			{
				 if((m & 1) == 1) //节点通过小猴 奇数向左，偶数向右 
				 {
					 m = (m + 1) / 2; //下一层节点需要通过的小猴 
					 result = result * 2;
				 }
				 else
				 {
					 m = m / 2;
					 result = result * 2 + 1;
				 }
			}
			System.out.println(result);
			
		}

	}

}
