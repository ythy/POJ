package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//876382 ythyhvh 笨小熊 Accepted  18  184 java 05-21 16:45:53 
public class Main62 {
	public static void main(String [] args) throws IOException {
	 
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		for(int i=0; i<n; i++) {
			int[] a = new int[26];
			String str = input.readLine();
			char[] ch = str.toCharArray();
			for(int j=0; j<ch.length; j++) {
				if(ch[j] == ' ') {
					continue;
				}
				int k = ch[j]-'a';
				//System.out.print(k+" ");
				a[k]++;
			}
			int max = getMax(a);
			//System.out.println("max"+max+" ");
			int min = getMin(a);
			//System.out.println("min"+min+" ");
			if(max != min) {
				if(isPrime(max-min)) {
					System.out.println("Lucky Word\n"+(max-min));
				} else {
					System.out.println("No Answer\n0");
				}
			} else {
				System.out.println("No Answer\n0");
			}
		}
	}

	private static boolean isPrime(int num) {
		// TODO Auto-generated method stub
		if(num<2) {
			return false;
		}
		if(num==2) {
			return true;
		}
		for(int i=2; i<=(int)Math.sqrt(num); i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int getMin(int[] a) {
		// TODO Auto-generated method stub
		int min = 0;
		for(int i=0; i<a.length; i++) {
			if(a[i]!=0) {
				min = a[i];
				break;
			}
		}
		for(int i=0; i<a.length; i++) {
			if(a[i] == 0) {
				continue;
			}
			min = min<a[i] ? min : a[i];
		}
		return min;
	}

	private static int getMax(int[] a) {
		// TODO Auto-generated method stub
		int max = 0;
		for(int i=0; i<a.length; i++) {
			if(a[i] == 0) {
				continue;
			}
			max = max>a[i] ? max : a[i];
		}
		return max;
	}
}           