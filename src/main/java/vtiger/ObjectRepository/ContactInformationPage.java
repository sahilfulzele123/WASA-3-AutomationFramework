package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement ContactHeaderText;
	
	
	
	
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}




	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	

	//Business Library
	
		/**
		 * This method will capture text from the contact header and return it to caller
		 */
		public String getContactHeader()
		{
			return ContactHeaderText.getText();
		}
	
	
	
	
	
	
	

}
