package com.patterns.proxy;

import java.util.ArrayList;
import java.util.List;

public class InternetProxy implements Internet {
	
	private Internet internet = new RealInternet();
	private static List<String> restrictedSites;

    static {
        restrictedSites = new ArrayList<String>();
        restrictedSites.add("jumbxyz.com");
        restrictedSites.add("testme.com");
        restrictedSites.add("adult-site.com");
        restrictedSites.add("bad-site.com");

    }
    
	@Override
	public void connectTo(String host) throws Exception {
		// TODO Auto-generated method stub
		if(!restrictedSites.contains(host.toLowerCase())){
            internet.connectTo(host);
        }else
        	throw new Exception("Company restricted this site view : " + host);
	}

}
