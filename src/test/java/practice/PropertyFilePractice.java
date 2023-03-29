package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
   public static void main(String[] args) throws IOException {
	
	   //STEP 1: open the file in java readable format
	   FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	   
	   //STEP 2:create object of properties from java.util package
	   Properties pObj= new Properties();
	   
	   //STEP 3:load the file input stream into properties
	   pObj.load(fis);
	   
	   //STEP 4:access the values with keys
	   String URL = pObj.getProperty("url");
	   String USERNAME = pObj.getProperty("username");
	   String BROWSER = pObj.getProperty("browser");
	   String PASSWORD = pObj.getProperty("password");
	   
	   System.out.println(URL);
	   System.out.println(USERNAME);
	   System.out.println(BROWSER);
	   System.out.println(PASSWORD);
}
}

