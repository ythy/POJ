package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 
 * 棋盘覆盖
时间限制：3000 ms  |  内存限制：65535 KB
难度：3

描述

    在一个2k×2k（1<=k<=100）的棋盘中恰有一方格被覆盖，如图1（k=2时），现用一缺角的2×2方格（图2为其中缺右下角的一个），去覆盖2k×2k未被覆盖过的方格，求需要类似图2方格总的个数s。如k=1时，s=1;k=2时，s=5
 *
 * @author maoxin
 * 1356063 	ythyhvh	棋盘覆盖	Accepted 	33 	122 	java	09-01 11:04:25
 * 大数问题
 */
public class Test45 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		BigInteger[] result = new BigInteger[101];
		result[1] = BigInteger.valueOf(1);
		int top = 1;
		while(total-- > 0)
		{
			int cur = Integer.parseInt(br.readLine());
			while(top < cur)
			{
				top++;
				result[top] = BigInteger.valueOf(4).multiply(result[top - 1]).add(BigInteger.valueOf(1));
			}
			System.out.println(result[cur]);
		}

	}

}
