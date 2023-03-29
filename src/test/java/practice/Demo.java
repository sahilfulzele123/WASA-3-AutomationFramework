package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		        
		        //Property file
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				Properties p = new Properties();
				p.load(fis);
				String URL = p.getProperty("url");
				String USERNAME = p.getProperty("username");
				String PASSWORD = p.getProperty("password");
				
				//Read data from excel 
				FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fi);
				Sheet sh = wb.getSheet("Contacts");
				Row rw = sh.getRow(4);
				Cell ce = rw.getCell(2);
				String value = ce.getStringCellValue();
				System.out.println(value);
				
				

				
				//STEP 1:Launch browser
				WebDriver driver =new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//STEP 2:Login to application with valid credentials
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//STEP 3:Navigate to Contacts link
				driver.findElement(By.linkText("Contacts")).click();
				
				//STEP 4:Click on Create contact look Up Image
				driver.findElement(By.cssSelector("img[title=\"Create Contact...\"]")).click();
				
				//STEP 5:Create Contact with Mandatory fields
				driver.findElement(By.name("lastname")).sendKeys(value);
				driver.findElement(By.name("button")).click();
				
				//STEP 6:Verification for contacts
				 String ContactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				 if(ContactHeader.contains("Kohli")) {
					 System.out.println(ContactHeader+"=====pass====");
				 }
				 else {
					 System.out.println(ContactHeader+"=====fail=====");
				 }
				 
				 //STEP 7:logout of Application
			   WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			   Actions a= new Actions(driver);
			   a.moveToElement(ele).perform();
			   
			   driver.findElement(By.linkText("Sign Out")).click();
			   System.out.println("Sign out sucessful");
			   
			}
			

	}


