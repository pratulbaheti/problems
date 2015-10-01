package com.test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestMining {

	public static void main(String[] args) {
		MessageDigest md;
		int arg1 = 4;
		StringBuffer prependZero = new StringBuffer();
		for(int i=0;i<arg1;i++)
		{
			prependZero.append("0");
		}
		String leadingZero = prependZero.toString();
		try {
			md = MessageDigest.getInstance("SHA-256");
	        String text = "pratulbaheti;0000";
	        int nonce = 13;
	        boolean flag = true;
	        while(flag) {
	        	byte[] mdbytes = md.digest(text.concat(Integer.toString(++nonce)).getBytes("UTF-8"));
	
	        	StringBuffer hexString = new StringBuffer();
	        	for (int i=0;i<mdbytes.length;i++) {
		    		String hex=Integer.toHexString(0xff & mdbytes[i]);
		   	     	if(hex.length()==1) hexString.append('0');
		   	     	hexString.append(hex);
		    	}
	    		if(leadingZero.equals(hexString.substring(0, arg1))) {
	    			System.out.println("Bitcoin: "+text.concat(Integer.toString(nonce)));
	    			break;
	    		} else {
	    			continue;
	    		}
	        }
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
