package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Test164 {

	/**
	 * @param args
	 * 卡特兰
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BigInteger catalans[] = new BigInteger[101];
		BigInteger four = BigInteger.valueOf(4);
		BigInteger two = BigInteger.valueOf(2);
		BigInteger one =BigInteger.valueOf(1);
		catalans[1] = one;
		
		for(int i = 2 ; i <= 100 ; ++i){
			catalans[i] = catalans[i-1].multiply(four.multiply(BigInteger.valueOf(i)).subtract(two)).divide(BigInteger.valueOf(i+1));
		}
		
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int line = -1;
		while(true){
			line = Integer.parseInt(br.readLine());
			if(line == -1){
				return ;
			}
			
			System.out.println(catalans[line]);
		}
	}


}
