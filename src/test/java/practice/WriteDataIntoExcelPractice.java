package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

        //STEP 1: Open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
        //STEP 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
	    //STEP 3: Get control of sheet
		Sheet sh = wb.getSheet("Organization");
		
	   //STEP 4: Get control of row
		Row rw = sh.getRow(3);
		
       //STEP 5: Create a cell in that row
		Cell ce = rw.createCell(4);
		
	   //STEP 6: Set the value to the cell
	   ce.setCellValue("WASA");
		
       //STEP 7: Open the document in write mode
	   FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
	   //STEP 8: Write the data
	   wb.write(fos);
	   System.out.println("data added");
		  
	}

}
