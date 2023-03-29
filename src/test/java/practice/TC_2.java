package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_2 {

	public static void main(String[] args) {
	
		        //STEP 1:Launch browser
				WebDriver driver =new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://localhost:8888/index.php?action=Login&module=Users");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//STEP 2:Login to application with valid credentials
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				//STEP 3:Navigate to Organizations link
				driver.findElement(By.linkText("Organizations")).click();
				
				//STEP 4:Click on Create Organization look Up Image
				driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
				
				//STEP 5:Create Organization with Mandatory fields
				driver.findElement(By.name("accountname")).sendKeys("TCS");
				driver.findElement(By.name("button")).click();
				
				//STEP 6:Verification for organizations
				String OrganizationsHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				if(OrganizationsHeader.contains("TCS")) {
					System.out.println(OrganizationsHeader+"------------pass--------");
				}
				else {
					System.out.println(OrganizationsHeader+"------------fail---------");
					
				}
				
				 //STEP 7:logout of Application
				WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				Actions a = new Actions(driver);
				a.moveToElement(ele).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Sign out sucessful");

	}

}
