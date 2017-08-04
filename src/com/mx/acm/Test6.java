package com.mx.acm;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 喷水装置（一）
 * 
 * 描述 现有一块草坪，长为20米，宽为2米，要在横中心线上放置半径为Ri的喷水装置，每个喷水装置的效果都会让以它为中心的半径为实数Ri(0<Ri<15)的圆被湿润，这有充足的喷水装置i（1<i<600)个，并且一定能把草坪全部湿润，你要做的是：选择尽量少的喷水装置，把整个草坪的全部湿润。
输入第一行m表示有m组测试数据
 每一组测试数据的第一行有一个整数数n，n表示共有n个喷水装置，随后的一行，有n个实数ri，ri表示该喷水装置能覆盖的圆的半径。输出输出所用装置的个数
 
 
 * @author maoxin
 * 902752 ythyhvh 喷水装置（一） Accepted  53  1790 java 06-25 15:22:27 
 */
public class Test6 {
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int total = scanner.nextInt();
		int sum, i;
		double [] input;
		double cal;
		while(total-- > 0)
		{
			cal = 20;
			sum  = scanner.nextInt();
			input = new double[sum];
			for(i = 0; i < sum; i++)
				input[i] = scanner.nextDouble();
			Arrays.sort(input);
			
			for(i = sum - 1; cal > 0; i--)
				cal -= Math.sqrt(input[i]*input[i] - 1)*2;
			
			System.out.println(sum - 1 - i);
		}

	}
	 
}
