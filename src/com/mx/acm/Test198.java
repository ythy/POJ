package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 描述 
我们平时数数都是喜欢从左向右数的，但是我们的小白同学最近听说德国人数数和我们有些不同，他们正好和我们相反，是从右向左数的。因此当他看到123时会说“321”。

现在有一位德国来的教授在郑州大学进行关于ACM的讲座。现在他聘请你来担任他的助理，他给你一些资料让你找到这些资料在书中的页数。现在你已经找到了对应的页码，要用英文把页码告诉他。

为了简化我们的问题，你只需要返回单词的大写的首字母。（数字0读成字母O）

注意：每个数字式单独读取的，因此不会出现11读成double one的情况。

输入输入分两部分：
 第一部分：一个整数T(1<=T<=1000)
第二部分：一共T行，每行为一个数字。每个数的长度不超过10位。输出每组输出单独占一行，输出对应的返回给德国教授的页码缩写。

 * @author maoxin
 * 902620 ythyhvh 数数 Accepted  34  307 java 06-25 09:29:01 
 */
public class Test198 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		String input;
		int length,i;
		StringBuffer result;
		String[] f = new String[60];
		f[48] = "O";
		f[49] = "O";
		f[50] = "T";
		f[51] = "T";
		f[52] = "F";
		f[53] = "F";
		f[54] = "S";
		f[55] = "S";
		f[56] = "E";
		f[57] = "N";
		
		while(total-- > 0)
		{
			input  = br.readLine();
			length = input.length();
			result = new StringBuffer();
			for(i = length - 1; i >= 0; i--)
				result.append(f[input.charAt(i)]);
			System.out.println(result);
		}

	}

}
