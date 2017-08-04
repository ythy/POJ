package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test275 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
		{
			 int input = Integer.parseInt(st.nextToken());
			 if(input == 0)
			 {
				 System.out.println(0);
				 continue;
			 }
			 String result = "";
			 while(input > 0 )
			 {
				 result = (input % 2 == 0 ? "0" : "1") + result;
				 input = input / 2;
			 }
			 System.out.println(result);
		}

	}

}
