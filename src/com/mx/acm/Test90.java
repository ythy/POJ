package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 整数划分
 * 描述 将正整数n表示成一系列正整数之和：n=n1+n2+…+nk， 
其中n1≥n2≥…≥nk≥1，k≥1。 
正整数n的这种表示称为正整数n的划分。求正整数n的不 
同划分个数。 
例如正整数6有如下11种不同的划分： 
6； 
5+1； 
4+2，4+1+1； 
3+3，3+2+1，3+1+1+1； 
2+2+2，2+2+1+1，2+1+1+1+1； 
1+1+1+1+1+1。 


输入第一行是测试数据的数目M（1<=M<=10）。以下每行均包含一个整数n（1<=n<=10）。输出输出每组测试数据有多少种分法。

 * @author maoxin
 * 950498 ythyhvh 整数划分 Accepted  15  61 java 08-14 10:36:59 
 */
public class Test90 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int input;
		while(total-- > 0)
		{
			input = Integer.parseInt(br.readLine());
			System.out.println(dp(input, input));
		}
	}
	
	
	// 等同 m个苹果放入n个盘子  盘子可以为空  有多少种放置方式
	private static int dp(int m, int n)
	{
        if (m < 0) 
            return 0;
        /* 所有数都是1 */
        if (m == 0) 
            return 1;
        /* 1个数 */
        if (n == 1) 
            return 1;
        /* n个盘子内至少都放1个 + 只放入n-1个盘子中 */
        return dp(m - n, n) + dp(m, n - 1);
	}

}
