package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ListViewAppointment {

	WebDriver driver;

	public ListViewAppointment(WebDriver driver) {
		//this.driver = Base.getChromeDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//tr/td[12]")
	WebElement locationValue;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'List view')]")
	WebElement btnListView;

	@FindBys(@FindBy(xpath = "//tbody/tr/td[1]"))
	public List<WebElement> patientIDs;

	@FindBys(@FindBy(xpath = "//tbody/tr/td[10]"))
	public List<WebElement> patientStatus;

	@FindBys(@FindBy(xpath = "//tbody/tr/td[12]"))
	public List<WebElement> patientLocation;
	
	@FindBy(how = How.XPATH, using = "//table[starts-with(@class,'ng-hide')]")
	public WebElement appointmentsCheck;
	
	
	public void clickListView() {
		btnListView.click();
		Base.explicitWait();
	}

	
	public boolean appointmentLocationCheck(String location) {
		boolean result = false;
		if (locationValue.isDisplayed() == false) {
			System.out.println("No appointments are created");
		} else {
			System.out.println("Appointments are displayed with " + location);
			for (WebElement eachElement : patientLocation) {
				result = eachElement.getText().contains(location);
				if (result == true)
					break;
			}
		}
		return result;
	}
	
	public boolean appointmentStatusCheck(String status) {
		boolean result = false;
		if (locationValue.isDisplayed() == false) {
			System.out.println("No appointments are created");
		} else {
			System.out.println("Appointments are displayed with " + status);
			for (WebElement eachElement : patientStatus) {
				result = eachElement.getText().contains(status);
				if (result == true)
					break;
			}
		}
		return result;
	}
}
