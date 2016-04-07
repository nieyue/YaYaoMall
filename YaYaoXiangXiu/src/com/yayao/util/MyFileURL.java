package com.yayao.util;

public class MyFileURL {

	public static String getFileName(String fileURL) throws Exception{
		if(fileURL.contains("/")){
		String[] str = fileURL.split("/");
		if(str!=null&&!str.equals("")){
			
			fileURL=str[str.length-1];
		}
		}
		return fileURL;
	}
	public static void main(String[] args) throws Exception {
		
		System.out.println(getFileName("dfsd/dfds//aaa/.jsp"));
	}
}
