package testscripts.regression;

import java.io.File;

public class FolderDemo {

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("user.dir"));
		
		File srcDir=new File(System.getProperty("user.dir")+"\\Screenshots");
		
		srcDir.mkdir();
		
		
		

	}

}
