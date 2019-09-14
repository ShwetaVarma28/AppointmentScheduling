package Pages;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {

	WebDriver driver;

	public AppointmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = ("Appointments List"))
	public WebElement appointmentList;

	@FindBy(how = How.CLASS_NAME, using = "add-app-btn")
	public WebElement addNewAppointment;

	@FindBy(how = How.ID, using = "patientID")
	public WebElement patientID;

	@FindBy(how = How.CLASS_NAME, using = "ui-corner-all")
	public WebElement patientName;

	@FindBy(how = How.ID, using = "service")
	public WebElement service;

	@FindBy(how = How.ID, using = "date")
	public WebElement date;

	@FindBy(how = How.ID, using = "startTimeID")
	public WebElement startTime;

	@FindBy(how = How.ID, using = "endTimeID")
	public WebElement endTime;

//	@FindBy(how = How.XPATH, using = "//*[starts-with(@class,'ng-pristine ng-valid ng-touched')]")
//	public WebElement notes;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Save')]")
	public WebElement btnSave;

//	@FindBy(how = How.CLASS_NAME, using = "message-text")
//	public WebElement validationMessage;

//	@FindBy(how = How.XPATH, using = "//body/div[2]/div[3]/div/div/section/div[2]/div/div[2]/div/div/date-picker/p/input")
//	public WebElement selectDate;

	@FindBys(@FindBy(className = "fc-title"))
	public List<WebElement> titles;

	@FindBy(how = How.ID, using = "patient")
	public WebElement patientDropDown;

	@FindBy(how = How.XPATH, using = "//*[starts-with(@id, 'ngdialog')]/div[2]/div[1]/p[4]/button[1]")
	public WebElement btnEdit;

	@FindBy(how = How.XPATH, using = "//*[starts-with(@id, 'ngdialog')]/div[2]/div[1]/p[4]/button[5]")
	public WebElement btnCancel;
	
	@FindBy(how = How.XPATH, using = "//*[starts-with(@id, 'ngdialog')]/div[2]/div[1]/p[4]/button[2]")
	public WebElement btnCheckIn;
	
	@FindBy(how = How.XPATH, using = "//*[starts-with(@id, 'ngdialog')]/div[2]/div[1]/p[4]/button[3]")
	public WebElement btnCompleted;
	
	@FindBy(how = How.XPATH, using = "//*[starts-with(@id, 'ngdialog')]/div[2]/div[1]/p[4]/button[4]")
	public WebElement btnMissed;

	@FindBy(how = How.ID, using = "modal-revise-button2")
	public WebElement btnPopUpProceedAndSave;

	@FindBy(how = How.ID, using = "location")
	public WebElement selectlocation;

	@FindBy(how = How.ID, using = "yes")
	public WebElement btnConfirmCancelOption;
	
	@FindBy(how = How.XPATH, using = "//*[starts-with(@class,'app-check-in-btn')]/button[1]")
	public WebElement btnConfirmCheckInOption;

	@FindBy(how = How.XPATH, using = "//div[3]/multi-select-autocomplete/div/tags-input/div/div/input")
	public WebElement enterStatus;

	@FindBy(how = How.XPATH, using = "//*[starts-with(@class,'suggestion-ite')]")
	public WebElement autoSuggestOption;

	@FindBy(how = How.XPATH, using = "//*[starts-with(@class,'app-filter-action-btn')]/button[2]")
	public WebElement btnApplyFilter;

	public void enterAppointmentStatus(String status) {
		Base.explicitWait();
		enterStatus.sendKeys(status);
		Base.explicitWait();
		autoSuggestOption.click();
	}

	public void clickApplyFilter() {
		Base.explicitWait();
		btnApplyFilter.click();
	}

	public void clickProceedAndSave() {
		if(btnPopUpProceedAndSave.isEnabled()==true) {
		Base.explicitWait();
		btnPopUpProceedAndSave.click();
		}
	}

	public void clickCancel(String patientName) {
		Base.explicitWait();
		checkPatientDropDown(patientName);
		btnCancel.click();
	}
	
	public void clickCheckIn(String patientName) {
		Base.explicitWait();
		checkPatientDropDown(patientName);
		btnCheckIn.click();
	}
	
	public void clickconfirmCheckIn() {
		Base.explicitWait();
		btnConfirmCheckInOption.click();
	}
	
	public void clickMissed(String patientName) {
		Base.explicitWait();
		checkPatientDropDown(patientName);
		btnMissed.click();
	}
	
	public void clickComplete(String patientName) {
		Base.explicitWait();
		checkPatientDropDown(patientName);
		btnCompleted.click();
	}

	public void clickConfirmCancel() {
		Base.explicitWait();
		btnConfirmCancelOption.click();
		
	}
	public void checkPatientDropDown(String patientName) {
		if (patientDropDown.isEnabled() == true) {
			new Select(patientDropDown).selectByVisibleText(patientName);
		}
	}

	public void selectLocation(String locate) {
		Base.explicitWait();
		new Select(selectlocation).selectByVisibleText(locate);
	}

	public void clickEdit(String patientName) {
		Base.explicitWait();
		checkPatientDropDown(patientName);
		btnEdit.click();
	}


	public void clickAppointmentList() {
		appointmentList.click();
		Base.explicitWait();
	}

	public void clickNewAppointment() {
		addNewAppointment.click();
		Base.explicitWait();
	}

	public void enterPatientID(String name) {
		patientID.sendKeys(name);
		Base.explicitWait();
		patientName.click();
		
	}

	public String getPatientName() {
		String str = patientID.getAttribute(patientName.getText());
		str= patientID.getAttribute("value");
		return str;
	}

	public void selectService(String serviceName) {
		new Select(service).selectByVisibleText(serviceName);
	}

	public void setDate(String setdate) {
		date.sendKeys(setdate);
	}

	public void setStartTime(String time) {
		startTime.sendKeys(time);
	}

	public void setEndTime(String time) {
		endTime.sendKeys(time);
	}

	public void clickSave() {
		btnSave.click();
		Base.explicitWait();
	}
	
	public boolean titleChecking(String title) {
		boolean s = false;
		for (WebElement eachElement : titles) {
			if (eachElement.getText().contains(title) == true) {
				s = true;
				break;
			}
		}
		return s;
		
	}

	public boolean titleCheck(String title) {
		boolean s = false;
		for (WebElement eachElement : titles) {
			if (eachElement.getText().contains(title) == true) {
				eachElement.click();
				s = true;
				break;
			}
		}
		return s;
	}

	public void listOfAppointment() {
		if (titles.isEmpty() == true) {
			System.out.println("No Appointment");
		} else {
			System.out.println("List of all the appointments by Name");
			for (WebElement eachElement : titles)
				System.out.println("Appointment = " + eachElement.getText());
		}
	}

	public boolean checkCompletedStatus() {
		return btnCompleted.isEnabled();
	}

}
