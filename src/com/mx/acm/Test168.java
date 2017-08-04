package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 房间安排
 * 描述 
2010年上海世界博览会(Expo2010),是第41届世界博览会。于2010年5月1日至10月31日期间，在中国上海市举行。本次世博会也是由中国举办的首届世界博览会。上海世博会以“城市，让生活更美好”(Better City,Better Life)为主题，将充分探索21世纪城市生活。

这次世博会总投资达450亿人民币，创造了世界博览会史上的最大规模记录。吸引200个国家和国际组织参展。预计有7000万人次的参观者。

为了更好地接待在这期间来自世界各地的参观者，如何合理安排各宾馆的住房问题提到了日程。组委会已接到了大量的客户住宿定单，每张定单的内容包括要住宿的房间数，开始住宿时间和要住的天数。为了便于整个城市各宾馆的管理，组委会希望对这些定单进行安排，目的是用尽可能少的房间来满足这些定单，以便空出更多的房间用于安排流动游客。

组委会请求DR.Kong来完成这个任务，对这些定单进行合理安排，使得满足这些定单要求的房间数最少。

假设：某个定单上的游客一旦被安排到某房间，在他预定住宿的期间内是不换房间的。为了简化描述，定单上的开始住宿时间为距离现在的第几天。例如，定单为（10，30，5）表示游客要求使用10个房间，第30天开始连住5天。

输入第一行：T 表示有T组测试数据
 每组测试数据第一行：N 表示定单数
 每组测试数据接下来有N行，每行有三个整数 A B C 表示房间数，开始住宿时间和天数
1<=T<=100
 1<=N<=10000 1<=A<=10 1<=B<=180 1<=c<=10输出输出一个整数，为满足所有定单要求的最少房间数。样例输入1
3
3 10 4
4 9 3
3 12 6
样例输出
7

 * @author maoxin
 * 902271 ythyhvh 房间安排 Accepted  425  16461 java 06-24 14:52:33 
 */
public class Test168 {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int datanum, i, j, max;
		int num, start, days, end;
		int[] f;
		while(total-- > 0)
		{
			datanum = Integer.parseInt(br.readLine());
			f = new int[200];
			max = Integer.MIN_VALUE;
			
			for(i = 0; i < datanum; i++)
			{
				st = new StringTokenizer(br.readLine());
				num =  Integer.parseInt(st.nextToken());
				start =  Integer.parseInt(st.nextToken());
				days =  Integer.parseInt(st.nextToken());
				end = start + days;
				
				for (j = start ; j < end ; j++)
					 f[j] += num ;
			}
			
			for(i = 0; i < 200; i++)
			{
				if(f[i] > max)
					max = f[i];
			}
			
			System.out.println(max);
			 
		}

	}

}
