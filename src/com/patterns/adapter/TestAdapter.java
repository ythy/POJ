package com.patterns.adapter;

public class TestAdapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Apple apple1 = new Apple();
		apple1.getAColor("green");
 
		Orange orange = new Orange();
		AppleAdapter aa = new AppleAdapter(orange);
		aa.getAColor("red");

	}

}
