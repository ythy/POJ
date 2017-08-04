package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 数数小木块
 * 描述 
在墙角堆放着一堆完全相同的正方体小木块，如下图所示：

 因为木块堆得实在是太有规律了，你只要知道它的层数就可以计算所有木块的数量了。

现在请你写个程序 给你任一堆木块的层数，求出这堆木块的数量.

输入第一行是一个整数N(N<=10)表示测试数据的组数）
 接下来的n行 每行只有一个整数 ，表示这堆小木块的层数，输出对应每个输入的层数有一个输出，表示这堆小木块的总数量，每个输出占一行
 
 * @author maoxin
 * 903985 ythyhvh 数数小木块 Accepted  1  61 java 06-27 17:18:56 
 */
public class Test260 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int input, output, i;
		int[] f;
		while(total-- > 0)
		{
			input = Integer.parseInt(br.readLine());
			f = new int[input + 1];
			f[1] = 1;
			output = f[1];
			for(i = 1; i <= input - 1; i++)
			{
				f[i + 1] = f[i] + i + 1;
				output += f[i + 1];
			}
				
			System.out.println(output);
		}
		
	}

}
