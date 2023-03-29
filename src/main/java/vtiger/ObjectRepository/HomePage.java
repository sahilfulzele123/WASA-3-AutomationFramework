package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
   
	//Declaration
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
    @FindBy(linkText = "Organizations")
    private WebElement OrganizationsLink;
    
    @FindBy(linkText = "Opportunities")
    private WebElement OpportunitiesLink;
    
    @FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
    private WebElement AdministrativeImg;
    
    @FindBy(linkText = "Sign Out")
    private WebElement SignOutLink;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//Utilization
	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getAdministrativeImg() {
		return AdministrativeImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	//Business Library
	/**
	 * This method will perform the click operation on contacts link
	 */
	public void clickOnContactsLink()
	{
		ContactsLink.click();
	}
	
	/**
	 * This method will perform the click operation on organization link
	 */
	public void clickOnOrganizationsLink()
	{
		OrganizationsLink.click();
	}
	
	/**
	 * This method will perform the click operation on opportunities link
	 */
	public void clickOnOpportunitiesLink()
	{
		OpportunitiesLink.click();
	}
	
	/**
	 * This method will perform logout operation
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver) 
	{
		mouseHoverAction(driver, AdministrativeImg);
		SignOutLink.click();
		
	}
    
	
	
	
	
	
	
}
