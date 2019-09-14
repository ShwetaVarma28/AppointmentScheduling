package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Base {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Create ')]")
	public WebElement btnCreateUser;
	
	@FindBy(how = How.ID , using = "givenName")
	public WebElement givenName;

	@FindBy(how = How.ID , using = "familyName")
	public WebElement givenfamilyName;
	
	@FindBy(how = How.ID, using = "gender")
	public WebElement dropDownGender;
	
	@FindBy(how = How.ID, using = "ageYears")
	public WebElement enterAgeYear;
	
	@FindBy(how = How.XPATH , using = "//patient-action/div/button")
	public WebElement btnSubmit;
	
	@FindBy(how=How.ID, using="hasOldIdentifier")
	WebElement checkIDBox;
	
	@FindBy(how=How.ID, using="registrationNumber")
	WebElement enterIDNumber;
	
	
	public void clickCreateNewUser() {
		btnCreateUser.click();
		Base.explicitWait();
	}
	
	public void enterUserName(String patientName) {
		givenName.sendKeys(patientName);
	}
	
	public void enterUserFamilyName(String patientFamilyName) {
		givenfamilyName.sendKeys(patientFamilyName);
	}
	
	public void selectGender(String gender) {
		new Select(dropDownGender).selectByVisibleText(gender);
	}
	
	public void enterAge(String age) {
		enterAgeYear.sendKeys(age);
	}

	public void clickSave() {
		btnSubmit.click();
		Base.explicitWait();
	}
	
	public void checkPatientID() {
		checkIDBox.click();
	}
	
	public void enterIDValue(String idValue) {
		enterIDNumber.sendKeys(idValue);
		Base.explicitWait();
	}
	
}
