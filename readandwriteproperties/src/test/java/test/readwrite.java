package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class readwrite {

	public static void main(String[] args) throws IOException {
		
		Properties properties = new Properties();
		FileInputStream inputstream =  new FileInputStream("C:\\Users\\nandish.h.r\\eclipse-workspace1\\readandwriteproperties\\src\\test\\resources\\properties\\testdata.properties");
		properties.load(inputstream);
		System.out.println(properties.getProperty("browser"));
		System.out.println(properties.getProperty("url"));
		
		FileOutputStream oututstram = new FileOutputStream("C:\\\\Users\\\\nandish.h.r\\\\eclipse-workspace1\\\\readandwriteproperties\\\\src\\\\test\\\\resources\\\\properties\\\\testdata.properties");
		properties.setProperty("testdata", "762868756");
		properties.store(oututstram, "this is customer data for testcase");
		
	}

}
