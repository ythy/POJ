package com.patterns.decorator;

public class IcecreamDecorator implements Icecream {
	
	protected Icecream mIcecream;
	
	public IcecreamDecorator(Icecream icecream) {
	    this.mIcecream = icecream;
	}
	
	@Override
	public String makeIcecream() {
		return mIcecream.makeIcecream();
	}

}
