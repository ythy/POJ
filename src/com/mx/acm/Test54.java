package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 小明的存钱计划
 * 
 * 描述 
小明的零花钱一直都是自己管理。每个月的月初妈妈给小明300元钱，小明会预算这个月的花销，并且总能做到实际花销和预算的相同。 
 为了让小明学习如何储蓄，妈妈提出，小明可以随时把整百的钱存在她那里，到了年末她会加上20％还给小明。因此小明制定了一个储蓄计划：每个月的月初，在得到妈妈给的零花钱后，如果他预计到这个月的月末手中还会有多于100元或恰好100元，他就会把整百的钱存在妈妈那里，剩余的钱留在自己手中。 
 例如11月初小明手中还有83元，妈妈给了小明300元。小明预计11月的花销是180元，那么他就会在妈妈那里存200元，自己留下183元。到了11月月末，小明手中会剩下3元钱。 
 小明发现这个储蓄计划的主要风险是，存在妈妈那里的钱在年末之前不能取出。有可能在某个月的月初，小明手中的钱加上这个月妈妈给的钱，不够这个月的原定预算。如果出现这种情况，小明将不得不在这个月省吃俭用，压缩预算。 
 现在请你根据2010年1月到12月每个月小明的预算，判断会不会出现这种情况。如果不会，计算到2010年年末，妈妈将小明平常存的钱加上20％还给小明之后，小明手中会有多少钱。 

输入第一行输入一个整数N，表示测试数据的组数（N<=10)
每组测试数据输入12行数据，每行包含一个小于350的非负整数，分别表示1月到12月小明的预算。

输出每组输出包括一行，这一行只包含一个整数。如果储蓄计划实施过程中出现某个月钱不够用的情况，输出-X，X表示出现这种情况的第一个月；否则输出到2010年年末小明手中会有多少钱(如果是小数，请四舍五入到整数位）。


 * @author maoxin
 * 955398 ythyhvh 小明的存钱计划 Accepted  1  61 java 08-18 15:39:29 
 */
public class Test54 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int sum, moneyBoy, moneyMum, result;
		int[] f;
		while(total-- > 0)
		{
			sum = 0;
			moneyBoy = 0;
			moneyMum = 0;
			result = 0;
			f = new int[13];
			while(sum++ < 12)
				f[sum] = Integer.parseInt(br.readLine().trim());
			sum = 0;
			while(sum++ < 12)
			{
				moneyBoy += 300;
				moneyBoy -= f[sum];
				if(moneyBoy < 0)
				{
					result = -sum;
					break;
				}
				else
				{
					 while(moneyBoy >= 100)
					 {
						 moneyMum++;
						 moneyBoy -= 100;
					 }
				}
			}
			System.out.println(result == 0 ? moneyMum * 120 + moneyBoy : result);
		}

	}
	
}
