package com.mx.acm.hdu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main1131 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String []args){
		Scanner cin = new Scanner(System.in);
		Integer N = 101,i;
		BigInteger []cat = new BigInteger[N];
		BigInteger []fac = new BigInteger[N];
		
		fac[1] = cat[1] = BigInteger.valueOf(1);
		for(i = 2; i < N; ++i){
			fac[i] = fac[i-1].multiply(BigInteger.valueOf(i));
			cat[i] = cat[i-1].multiply(BigInteger.valueOf(i*4-2)).divide(BigInteger.valueOf(i+1));
		}
			
		while(cin.hasNext()){
			i = cin.nextInt();
			if(i == 0)
				break;
			System.out.println(cat[i]);
		}
		
	}


}
