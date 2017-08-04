package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/**
 * 汉诺塔（一）
 * 
 * 描述 
在印度，有这么一个古老的传说：在世界中心贝拿勒斯（在印度北部）的圣庙里，一块黄铜板上插着三根宝石针。印度教的主神梵天在创造世界的时候，在其中一根针上从下到上地穿好了由大到小的64片金片，这就是所谓的汉诺塔。不论白天黑夜，总有一个僧侣在按照下面的法则移动这些金片：一次只移动一片，不管在哪根针上，小片必须在大片上面。僧侣们预言，当所有的金片都从梵天穿好的那根针上移到另外一根针上时，世界就将在一声霹雳中消灭，而梵塔、庙宇和众生也都将同归于尽。

现在请你计算出起始有m个金片的汉诺塔金片全部移动到另外一个针上时需要移动的最少步数是多少？（由于结果太大，现在只要求你算出结果的十进制位最后六位）

输入第一行是一个整数N表示测试数据的组数(0<N<20)
每组测试数据的第一行是一个整数m,表示起始时金片的个数。(0<m<1000000000)输出输出把金片起始针上全部移动到另外一个针上需要移动的最少步数的十进制表示的最后六位。

 * @author maoxin
 * 956613 ythyhvh 汉诺塔（一） Accepted  53  122 java 08-20 09:30:35 
 */
public class Test88 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		BigInteger input;
		BigInteger numTwo = BigInteger.valueOf(2L);
		BigInteger numMod = BigInteger.valueOf(1000000L);
		while(total-- > 0)
		{
			input = BigInteger.valueOf(Long.valueOf(br.readLine().trim()));
			System.out.println(numTwo.modPow(input, numMod).subtract(BigInteger.ONE));
		}
	}
	
}
