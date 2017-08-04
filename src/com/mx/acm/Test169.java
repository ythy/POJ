package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 素数
 * 描述 
走进世博园某信息通信馆，参观者将获得前所未有的尖端互动体验，一场充满创想和喜悦的信息通信互动体验秀将以全新形式呈现，从观众踏入展馆的第一步起，就将与手持终端密不可分，人类未来梦想的惊喜从参观者的掌上展开。

在等候区的梦想花园中，参观者便开始了他们奇妙的体验之旅，等待中的游客可利用手机等终端参与互动小游戏，与梦想剧场内的虚拟人物Kr. Kong 进行猜数比赛。当屏幕出现一个整数X时，若你能比Kr. Kong更快的发出最接近它的素数答案，你将会获得一个意想不到的礼物。

例如：当屏幕出现22时，你的回答应是23；当屏幕出现8时，你的回答应是7；若X本身是素数，则回答X;若最接近X的素数有两个时，则回答大于它的素数。

 

输入第一行：N 要竞猜的整数个数
 接下来有N行，每行有一个正整数X
 1<=N<=5 1<=X<=1000输出输出有N行，每行是对应X的最接近它的素数
 
 * @author maoxin
 * 902367 ythyhvh 素数 Accepted  1  61 java 06-24 17:00:39 
 */

public class Test169 {

	private static int maxn = 1010;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int input, i, result = 0;
		while(total-- > 0)
		{
			input =  Integer.parseInt(br.readLine());
			if(isPrimeNum(input))
				result = input;
			else
			{
				for(i = input + 1; i < maxn; i++)
				{
					if(isPrimeNum(i))
					{
						result = i;
						break;
					}
				}
				for(i = input - 1; i >= 2 && i > input - (result - input); i--)
				{
					if(isPrimeNum(i))
					{
						result = i;
						break;
					}
				}
			}
			
			System.out.println(result);
			
		}

	}

	private static boolean isPrimeNum(int num)
	{
		int i;
		boolean result = false;
		if(num == 2)
			result = true;
		else if(num == 1)
			result = false;
		else if(num%2 != 0)
		{
			result = true;
			for(i = 3; i <= Math.sqrt(num + 0.5); i+=2)
			{
				if(num%i == 0)
				{
					result = false;
					break;
				}
					
			}
		}
		return result;
			 
	}
}
