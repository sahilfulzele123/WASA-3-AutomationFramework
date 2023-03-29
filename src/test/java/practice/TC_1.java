package practice;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_1 {

	public static void main(String[] args) throws IOException {
		
		//STEP 1:Launch browser
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//STEP 2:Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//STEP 3:Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//STEP 4:Click on Create contact look Up Image
		driver.findElement(By.cssSelector("img[title=\"Create Contact...\"]")).click();
		
		//STEP 5:Create Contact with Mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Jack");
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
