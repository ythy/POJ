package com.mx.acm;

import java.util.Scanner;
import java.util.Stack;
/**
 * 
 * @author maoxin
 * 测试超时  由于用了Stack API
 */
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Character> stack = null;
		boolean isRight = true;
		String str = null;
		while (n != 0 ) {
			str = sc.next();
			isRight = true;
			if (str.length() % 2 != 0 ) {
				System.out.println("No");
			} else {
				stack = new Stack<Character>();
				for (int i = 0; i < str.length(); i++) {
				    if ((str.charAt(i) == ']'  && stack.pop() != '[' ) ||
							(str.charAt(i) == ')' &&  stack.pop() != '(' )) {
						System.out.println("No");
						isRight = false;
						break;
					}
					else if(str.charAt(i) == '[' || str.charAt(i) == '('){
						stack.push(str.charAt(i));
					}
				}
				if (isRight)
					System.out.println("Yes");
			}
			n--;
		}
	}
}
