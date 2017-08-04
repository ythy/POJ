package com.mx.acm;

import java.util.Scanner;

public class Main62W {
	
	
	//计算字母出现次数并存到数组中
	private static int[] count(String str){		
		int j, sumA = 0, k = 1;
		char i,ch;
		int[] count = new int[26]; 
		int[] array = new int[27];
		str = str.toLowerCase();
		
		for (i = 'a';  i <=  ('a' + 25); i++) {
			for (j = 0; j < str.length(); j++) {
				ch = str.charAt(j);
				if (i == ch) {
					count[i - 'a']++;
					sumA = count[i - 'a'];
				}					
			}
			
			array[k] = sumA;
			k++;
		}	
		array[0] = sumA;
		return array;
	}
	//计算最大值和最小值之差
	private static int[] dif(int[] array){
		int i, dif,sumB = 1, sumC = 0x80000000;
		int[] arr = new int[2];
		for(i = 1; i < array.length; i++){
			if(array[i] > sumB && array[i] != 0)
				sumB = array[i];	
			if(array[i] < sumC && array[i] != 0)
				sumC = array[i];
		}
		dif = sumB - sumC;
		arr[0] = array[0];
		arr[1] = dif;
		return arr;
	}
	
	//判断是否为素数并打印
	private static void print(int[] array){
		int i;
		boolean flagBoolean = true;
		int dif = array[1];
		if( array[0] != 0){
			for(i = 2; i < dif; i++){
				if(dif%i == 0){
					
					flagBoolean = false;
					break;
				}
					flagBoolean =true;							
			}
		
			if (flagBoolean && dif != 0 && dif != 1 ) 
				System.out.println("right");//是素数
			else 
				System.out.println("wrong");//不是素数
		}
		
	}
		
	public static void main(String[] args){
		
		Scanner scn = new Scanner(System.in);		
		String line; 
		while(true){	
			line = scn.nextLine();	
			print(count(line));
		}		
	}

}
