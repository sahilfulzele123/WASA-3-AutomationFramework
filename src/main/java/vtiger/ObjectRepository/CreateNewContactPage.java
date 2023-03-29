package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {

	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(name = "button")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement SearchEdt;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

    public WebElement getSaveBtn() {
		return SaveBtn;
	}

    public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

    public WebElement getSearchEdt() {
		return SearchEdt;
	}

    public WebElement getSearchBtn() {
		return SearchBtn;
	}



	//Business libraries
    
    /**
     * This method will create new contact with lastname
     * @param lastname
     */
	 public void createNewContacts(String Lastname)
	 {
		 LastNameEdt.sendKeys(Lastname);
		 SaveBtn.click();
		 
	 }
	 
	 /**
	  * This method will create new contact with organization
	  * @param Lastname
	  * @param driver
	  * @param OrgName
	  */
	 public void createNewContacts(String Lastname, WebDriver driver, String OrgName)
	 {
		 LastNameEdt.sendKeys(Lastname);
		 OrgLookUpImg.click();
		 switchToWindow(driver, "Accounts");
		 SearchEdt.sendKeys(OrgName);
		 SearchBtn.click();
		 driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		 switchToWindow(driver, "Contacts");
		 SaveBtn.click();
		 
		
		
	 }
}
