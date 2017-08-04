package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 不高兴的小明
 * 描述    小明又出问题了。妈妈认为聪明的小明应该更加用功学习而变的更加厉害，所以小明除了上学之外，还要参加妈妈为他报名的各科复习班。另外每周妈妈还会送他去学习朗诵、舞蹈和钢琴。但是小明如果一天上课超过八个小时就会不高兴，而且，上得越久就会越不高兴。假设小明不会因为其它事不高兴，并且她的不高兴不会持续到第二天。请你帮忙检查一下小明下周的日程安排，看看下周他会不会不高兴；如果会的话，哪天最不高兴。
输入第一行输入N（0<N<100）表示测试数据组数，接下来每组测试数据输入包括七行数据，分别表示周一到周日的日程安排。每行包括两个小于10的非负整数，用空格隔开，分别表示津津在学校上课的时间和妈妈安排她上课的时间。 
输出每组测试数据输出包括一行，这一行只包含一个数字。如果不会不高兴则输出0，如果会则输出最不高兴的是周几(用1,2,3,4,5,6,7分别表示周一，周二，周三，周四，周五，周六，周日)。如果有两天或两天以上不高兴的程度相当，则输出时间最靠前的—天。


 * @author maoxin
 * 955148 ythyhvh 不高兴的小明 Accepted  9  184 java 08-18 09:48:38 
 */
public class Test53 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int sum, result, resultHours, totalhours;
		int total = Integer.parseInt(br.readLine());
		while(total-- > 0)
		{
			resultHours = Integer.MIN_VALUE;
			result = 0;
			sum = 0;
			while(sum++ < 7 )
			{
				st = new StringTokenizer(br.readLine());
				totalhours = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
				if(totalhours > resultHours && totalhours > 8)
				{
					resultHours = totalhours;
					result = sum;
				}
			}
			System.out.println(result);
		}

	}

}
