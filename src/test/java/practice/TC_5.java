package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_5 {

	public static void main(String[] args) {
		        //STEP 1:Launch browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://localhost:8888/index.php?action=Login&module=Users");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//STEP 2:Login to application with valid credentials
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				//STEP 3:Navigate to Contacts link
				driver.findElement(By.linkText("Contacts")).click();
				
				//STEP 4:Click on Create contact look up image
				driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
				
				//STEP 5:Create contact with mandatory fields
				driver.findElement(By.name("lastname")).sendKeys("ONG");
				
				//STEP 6:Select the Organization from organization look up image
				driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
				driver.switchTo().frame(0);
				driver.findElement(By.name("search_text")).sendKeys("Tesla");
				driver.findElement(By.name("search")).click();
				driver.findElement(By.linkText("Tesla")).click();
				
				
				driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
				
				//STEP 7:Verification for contacts
				String ContactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				 if(ContactHeader.contains("ONG")) {
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
