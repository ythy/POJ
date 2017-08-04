package com.patterns.proxy;

public class TestProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Internet intConn = new InternetProxy();
        try {
            intConn.connectTo("java2novice.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            intConn.connectTo("bad-site.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}

}
