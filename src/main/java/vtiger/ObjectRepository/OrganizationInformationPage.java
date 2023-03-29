package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement OrgHeaderText;
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
	//Business Library
	
	/**
	 * This method will capture text from the org header and return it to caller
	 */
	public String getOrgHeader()
	{
		return OrgHeaderText.getText();
	}

}
