package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends Base {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = Base.getChromeDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "#username")
	public WebElement txtUserName;

	@FindBy(how = How.CSS, using = "#password")
	public WebElement txtPassword;

	@FindBy(how = How.CSS, using = "#location")
	public WebElement cmbLocation;

	@FindBy(how = How.CSS, using = "#locale")
	public WebElement cmbLocale;

	@FindBy(how = How.CSS, using = ".confirm")
	public WebElement btnLogin;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Appointment Scheduling')]")
	public WebElement optAppointment;
	
	@FindBy(how = How.ID, using = "bahmni.registration")
	public WebElement optRegistration;
	
	@FindBy(how = How.CLASS_NAME , using = "back-btn")
	public WebElement btnHome;
	
	@FindBy(how = How.XPATH , using = "//*[@class=\"reg-header\"]/div/button")
	public WebElement btnUserInfo;
	
	@FindBy(how = How.XPATH , using = "//*[@class=\"active\"]/li[4]")
	public WebElement btnLogout;

	public void login(String username, String password, String location, String locale) {
		try {
			
			String URL = getVariables("url");
			driver.get(URL);
			Base.explicitWait();
			txtUserName.sendKeys(username);
			txtPassword.sendKeys(password);
			new Select(cmbLocation).selectByVisibleText(location);
			new Select(cmbLocale).selectByVisibleText(locale);
			btnLogin.click();
		} catch (Exception e) {
			System.out.println("Test login Error : \n" + e.getMessage());

		}
	}
	
	public void clickAppointmentOption() {
		Base.explicitWait();
		optAppointment.click();
		Base.explicitWait();
	}
	
	public void clickRegistration() {
		Base.explicitWait();
		optRegistration.click();		
		Base.explicitWait();
	}
	
	public void clickHomeBtn() {
		btnHome.click();
		Base.explicitWait();
	}
	
	public void clicklogout() {
		btnLogout.click();
	}
	
	public void clickUserInfo() {
		btnUserInfo.click();
	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
		Base.explicitWait();
	}
}
