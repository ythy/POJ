package com.patterns.adapter;

public class AppleAdapter extends Apple {
	private Orange orange;
	 
	public AppleAdapter(Orange orange) {
		this.orange = orange;
	}
 
	public void getAColor(String str) {
		orange.getOColor(str);
	}

}
