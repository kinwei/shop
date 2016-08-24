package com.jinwei.util;

import java.io.File;
import java.io.FilenameFilter;

public class BankUtilImpl {

	private String bankPath = "";
	
	public String[] getBankImage(){
		return new File(bankPath).list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".gif");
			}
		});
	}
	
}
