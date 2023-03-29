package vtiger.OrganizationTests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;


@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)

public class CreateOrganizationTest extends BaseClass {
    
	    @Test(groups = {"SmokeSuite","RegressionSuite"})
	    public void createOrganizationTest() throws IOException {
		
		
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		// Step 4: Click on Organizations link
	    HomePage hp = new HomePage(driver);
	    hp.clickOnOrganizationsLink();
	    Reporter.log("Click on Organizations link sucessfully");
		
		// Step 5: Click on Create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("Click on Create Organization look up image sucessfully");
		
		// Step 6: Create organization with mandatory fields and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		Reporter.log("Create organization with mandatory fields and save sucessfully");
		
		// step 7: Validate for organization
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println("-------------Organization created------------");
		
		System.out.println("Sign out sucessfully");
		
		}
	    
	    @Test(groups = "RegressionSuite")
	    public void Demo()
	    {
	    	System.out.println("TESTING API");
	    	//Assert.fail();
	    }
	    
	    @Test(groups = "RegionalRegressionSuite")
	    public void regional()
	    {
	    	System.out.println("Regional regression");
	    }
	    
	   

}
