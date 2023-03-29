package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	@FindBy(xpath = "//img[@title=\"Create Organization...\"]")
	private WebElement CreateNewOrgLookUpImg;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewOrgLookUpImg() {
		return CreateNewOrgLookUpImg;
	}
	
	//Business Library
	
	/**
	 * This method will perform click operation on create organization look up img
	 */
	public void clickOnCreateOrgImg()
	{
		CreateNewOrgLookUpImg.click();
	}
	
	

}
