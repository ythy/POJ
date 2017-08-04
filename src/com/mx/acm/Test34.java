package com.mx.acm;

import java.util.Scanner;
/**
 * 韩信点兵
 *描述 
相传韩信才智过人，从不直接清点自己军队的人数，只要让士兵先后以三人一排、五人一排、七人一排地变换队形，而他每次只掠一眼队伍的排尾就知道总人数了。输入3个非负整数a,b,c ，表示每种队形排尾的人数（a<3,b<5,c<7），输出总人数的最小值（或报告无解）。已知总人数不小于10，不超过100 。
输入
输入3个非负整数a,b,c ，表示每种队形排尾的人数（a<3,b<5,c<7）。例如,输入：2 4 5
输出
输出总人数的最小值（或报告无解，即输出No answer）。实例，输出：89


三人同行七十稀， 五树梅花廿一枝， 七子团圆正半月， 除百零五便得知。 

 * @author maoxin
 * 856847 ythyhvh 韩信点兵 Accepted  23  184 java 05-08 10:55:00 
 */
public class Test34 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		System.out.println((a*70 + b*21 + c*15) % 105);
	}
	
}
