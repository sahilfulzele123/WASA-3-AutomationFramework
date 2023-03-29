package vtiger.ContactsTests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.IConstantsUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class createContactsWithOrganizationTest extends BaseClass {
    
	@Test(groups = "SmokeSuite")
	public void createContactsWithOrgTest() throws IOException {
		
		
		/*Read data from excel sheet*/
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
		
		// Step 5: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		// Step 6: Click on Create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		// Step 7: Create Organization with mandatory details
	    CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	    cnop.createOrganization(ORGNAME);
		
		// Step 8: Validate for Organization
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String OrganizationHeader = oip.getOrgHeader();
		assertTrue(OrganizationHeader.contains(ORGNAME));
		System.out.println(OrganizationHeader+"-----------organisation created---------");
		
		// Step 9: Navigate to contacts Link
	       hp.clickOnContactsLink();
		
		// Step 10:Click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		// Step 11: Create contact with mandatory fields and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContacts(LASTNAME, driver, ORGNAME);
		
		
		// Step 12: Validate for Contacts
		ContactInformationPage cip = new ContactInformationPage(driver);
		String ContactsHeader = cip.getContactHeader();
	    assertTrue(ContactsHeader.contains(LASTNAME));
	    System.out.println(ContactsHeader+"----------Contact created--------------");
		
		System.out.println("Sign out successfull");
		
		
	}
	
}
