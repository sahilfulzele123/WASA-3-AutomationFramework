package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  // rule 1: Create a pom class for every web page
	
   // rule 2: Identify the web elements with @FindBy, @FindBy and @FindBys
	@FindBy(name = "user_name")
	private WebElement UsernameEdt;
	
	@FindAll({@FindBy(name = "user_password"),@FindBy(xpath = "//input[@type=\"password\"]")})
	private WebElement PasswordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement LoginBtn;
	
	// rule 3: Create a constructor to initialise to these web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	
	// rule 4: Provide getters to access these web elements
	
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	// Business Libraries - generic methods specific to current project
	 public void LoginToApp(String username,String password)
	 {
		 UsernameEdt.sendKeys(username);
		 PasswordEdt.sendKeys(password);
		 LoginBtn.click();
	 }
	
}
