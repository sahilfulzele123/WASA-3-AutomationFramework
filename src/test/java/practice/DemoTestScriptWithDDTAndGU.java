package practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class DemoTestScriptWithDDTAndGU {

	public static void main(String[] args) throws IOException {
		
		       //STEP 1: Create object for all utilities
		       PropertyFileUtility pUtil = new PropertyFileUtility();
		       ExcelFileUtility eUtil = new ExcelFileUtility();
		       WebDriverUtility wUtil = new WebDriverUtility();
		       JavaUtility jUtil = new JavaUtility();
		
		
		        //STEP 2: Read all necessary data
				/* Read data from property file - Common Data */
				
				String URL = pUtil.readDataFromPropertyFile("url");
				String BROWSER = pUtil.readDataFromPropertyFile("browser");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
				
				
				/* Read data from excel sheet - Test data */
				String contactName = eUtil.readDataFromExcel("Contacts", 1, 2)+jUtil.getRandomNumber();
				
				WebDriver driver = null;
				//STEP 3: Launch the browser - Runtime polymorphism
				if(BROWSER.equalsIgnoreCase("chrome")) {
					
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					
				}else if(BROWSER.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					
				}else {
					System.out.println("Invalid browser name");
				}
				wUtil.maximizeWindow(driver);
				wUtil.waitForPage(driver);
				driver.get(URL);
				
				// Step 4:Login to Application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				// Step 5:Navigate to Contacts Link
				driver.findElement(By.linkText("Contacts")).click();
				
				// Step 6:Click on create contact look up image
				driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
				
				// Step 7: Create contact with mandatory fields and save
				driver.findElement(By.name("lastname")).sendKeys(contactName);
				driver.findElement(By.name("button")).click();
				
				// step 8: Verification for contact
				String ContactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				if(ContactHeader.contains(contactName)) {
					System.out.println(ContactHeader+"=============pass===========");
				}else {
					System.out.println(ContactHeader+"=============fail============");
				}
				

				// Step 9: Logout of Application
				WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				wUtil.mouseHoverAction(driver, ele);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Sign out sucessful");
				
				
	}
}
