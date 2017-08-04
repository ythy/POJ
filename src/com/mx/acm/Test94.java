package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * cigarettes
描述 
Tom has many cigarettes. We hypothesized that he has n cigarettes and smokes them 

one by one keeping all the butts. Out of k > 1 butts he can roll a new cigarette. 
Now，do you know how many cigarettes can Tom has? 

输入
First input is a single line,it's n and stands for there are n testdata.then there are n lines ,each line contains two integer numbers giving the values of n and k.
输出
For each line of input, output one integer number on a separate line giving the maximum number of cigarettes that Peter can have.

样例输入
3
4 3
10 3
100 5

样例输出
5
14
124

 * @author maoxin
 * 895260 ythyhvh cigarettes Accepted  7  61 java 06-13 14:57:59 
 */
public class Test94 {

	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int result;
		int n,k;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			result = n;
			
			while(n >= k)
			{
				result += n/k;
				n = n/k + n%k;
			}
			System.out.println(result);
		}
		
		

	}

}
