package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Test97 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		Double x,m,y,z;
		DecimalFormat f = new DecimalFormat("#.00");
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			m = Double.valueOf(st.nextToken());
			x = Double.valueOf(st.nextToken());
			y = Double.valueOf(st.nextToken());
			z = Double.valueOf(st.nextToken());
			System.out.println(f.format(((x * m)/(y - x )) * z));
		}

	}

}
