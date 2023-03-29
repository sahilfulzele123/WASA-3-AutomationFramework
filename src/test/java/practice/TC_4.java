package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_4 {

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
		
		//STEP 3:Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//STEP 4:Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		
		//STEP 5:Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Tesla");
		
		//STEP 6:Select "Energy" in the industry drop down
	     WebElement dd = driver.findElement(By.name("industry"));
	     Select s = new Select(dd);
	     s.selectByValue("Energy");
	     
	    //STEP 7:Select "Customer" in the Type Drop down
	     WebElement DD = driver.findElement(By.name("accounttype"));
	     Select ss=new Select(DD);
	     ss.selectByValue("Customer");
	     
	     driver.findElement(By.name("button")).click();
	     
	    //STEP 8:Verification for organizations
	     String organizationsHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	     if(organizationsHeader.contains("Tesla")) {
	    	 System.out.println(organizationsHeader+"------------------pass-----------");
	     }
	     else {
	    	 System.out.println(organizationsHeader+"-------------------fail----------");
	     }
	     
	     //STEP 9:logout of Application
	     WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
	     Actions a = new Actions(driver);
	     a.moveToElement(ele).perform();
	     driver.findElement(By.linkText("Sign Out")).click();
	     System.out.println("Sign out sucessful");

	     
	     
	}

}
