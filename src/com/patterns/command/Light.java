//reciever

package com.patterns.command;

public class Light {
	private boolean on;
	
	//action 
	public void switchOn() {
		on = true;
	}
	
	//action
	public void switchOff() {
		on = false;
	}
}
