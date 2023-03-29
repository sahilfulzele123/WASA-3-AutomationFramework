package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDown;
	
	@FindBy(name = "button")
	private WebElement SaveBtn;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryTypeDropDown() {
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	//Business Library
	    /**
	     * This method will create organization with org name
	     * @param OrgName
	     */
		public void createOrganization(String OrgName) 
		{
		  OrgNameEdt.sendKeys(OrgName);
		  SaveBtn.click();
		}
		
		/**
		 * This method will create organization with industry type
		 * @param OrgName
		 * @param IndustryType
		 */
		public void createOrganization(String OrgName, String IndustryType)
		{
			OrgNameEdt.sendKeys(OrgName);
			handleDropdown(IndustryDropDown, IndustryType);
			SaveBtn.click();
			
		}

	
	
	
}
