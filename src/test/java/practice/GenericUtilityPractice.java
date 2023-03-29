package practice;

import java.io.IOException;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
    
	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		System.out.println(URL);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String value = eUtil.readDataFromExcel("Contacts", 1, 2);
		System.out.println(value);
		
		int rowcount = eUtil.getRowCount("Organization");
		System.out.println(rowcount);
		
		
		eUtil.writeDataIntoExcel("Contacts", 1, 4, "Sushama");
		
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getSystemDateInFormat());
        System.out.println(jUtil.getRandomNumber());
		
		
		
		
	}
}
