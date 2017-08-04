package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 无线网络覆盖
 * 
 * 1200349 ythyhvh 无线网络覆盖 Accepted  42  368 java 03-19 14:17:54 
 */
public class Test199 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		double l,d,r;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			l = Double.valueOf(st.nextToken());
			d = Double.valueOf(st.nextToken());
			r = Double.valueOf(st.nextToken());
			
			double h = d/2;
			double result = 0;
			if(h < r)
			{
				result = Math.ceil(l/(Math.sqrt(r*r - h*h)*2));
			}
			System.out.println(result == 0 ? "impossible" : (int)result);
		}

	}

}
