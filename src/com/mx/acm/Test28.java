package com.mx.acm;

import java.math.BigInteger;
import java.util.Scanner;
/**
 *  大数阶乘
 * @author maoxin
 * 
 */
public class Test28 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		BigInteger input;
		BigInteger result;
		while (scanner.hasNextInt()) {
			input = scanner.nextBigInteger();
			result = BigInteger.valueOf(1);
			BigInteger start = BigInteger.valueOf(1);
			while (start.compareTo(input) <= 0) {
				result = result.multiply(start);
				start = start.add(BigInteger.valueOf(1));
			}
			System.out.println(result);
		}
	}

}
