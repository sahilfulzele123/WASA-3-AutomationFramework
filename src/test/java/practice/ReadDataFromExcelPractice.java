package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

    //STEP 1: Open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
    //STEP 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
    //STEP 3:Get control of sheet
		Sheet sh = wb.getSheet("Contacts");
		
    //STEP 4: Get control of row
		Row rw = sh.getRow(1);
		
    //STEP 5: Get control of cell
		Cell ce = rw.getCell(2);
		
    //STEP 6: Read the data inside cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		
		
		
		
		
		
		
		
	}

}
