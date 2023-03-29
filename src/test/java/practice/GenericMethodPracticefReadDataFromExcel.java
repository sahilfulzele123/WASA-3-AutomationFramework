package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import vtiger.GenericUtilities.ExcelFileUtility;

public class GenericMethodPracticefReadDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		ExcelFileUtility efu = new ExcelFileUtility();
		String value = efu.readDataFromExcel("Contacts", 1, 1);
		System.out.println(value);
		
		System.out.println(efu.getRowCount("Contacts"));
	}

}
