package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.AppointmentPage;
import Pages.Base;
import Pages.ListViewAppointment;
import Pages.LoginPage;
import Pages.RegistrationPage;

public class AppointmentOptions {

	WebDriver driver = initiateDriver();
	AppointmentPage appointment = new AppointmentPage(driver);
	LoginPage login = new LoginPage(driver);
	ListViewAppointment listView = new ListViewAppointment(driver);
	RegistrationPage register = new RegistrationPage(driver);

	@BeforeTest
	public static WebDriver initiateDriver() {
		WebDriver driver1 = Base.getChromeDriver();
		return driver1;
	}

	@Test(priority = 6, description = "canceling the appointment")
	public void cancelAppointmentTest() {

		System.out.println("\ncanceling the appointment");
		String title = Base.getVariables("title3");
		try {
			
			// Appointment Page
			appointment.clickAppointmentList();
			appointment.titleCheck(title);
			appointment.clickCancel(title);
			appointment.clickConfirmCancel();

			Base.explicitWait();
			login.pageRefresh();
			
			// On List View Page
			listView.clickListView();
			Base.explicitWait();
			
			// Assertion statement
			Assert.assertTrue(listView.appointmentStatusCheck("Cancelled"), "Result is not correct");
			System.out.println("Test Case Completed\n");
			
		} catch (Exception e) {
			System.out.println("Test Case Error : \n" + e.getMessage());
		}
	}

	@Test(priority = 4, description = "Check-in the appointment")
	public void checkinAppointmentTest() {

		String title = Base.getVariables("title2");

		System.out.println("\nCheck-in Test Case");

		try {

			// Appointment Page

			appointment.clickAppointmentList();
			appointment.titleCheck(title);
			appointment.clickCheckIn(title);
			appointment.clickconfirmCheckIn();
			Base.explicitWait();
			login.pageRefresh();

			// On List View Page
			listView.clickListView();

			Base.explicitWait();
			// Assertion statement
			Assert.assertTrue(listView.appointmentStatusCheck("CheckedIn"), "Result is not correct");
			System.out.println("Test Case Completed\n");

		} catch (Exception e) {
			System.out.println("Test Case Error : \n" + e.getMessage());

		}
	}

	@Test(priority = 5, description = "Completed the appointment")
	public void completeAppointmentTest() {

		String title = Base.getVariables("title2");

		System.out.println("\nCompleted Appointment Test Case");

		try {

			// Appointment Page

			appointment.clickAppointmentList();
			appointment.titleCheck(title);
			appointment.clickComplete(title);
			appointment.clickConfirmCancel();
			Base.explicitWait();
			login.pageRefresh();
			// On List View Page
			listView.clickListView();
			Base.explicitWait();
			// Assertion statement
			Assert.assertTrue(listView.appointmentStatusCheck("Completed"), "Result is not correct");
			System.out.println("Test Case Completed\n");

		} catch (Exception e) {
			System.out.println("Test Case Error : \n" + e.getMessage());

		}
	}

	@Test(priority = 7, description = "Missed the appointment")
	public void missAppointmentTest() {
		String title = Base.getVariables("title1");
		System.out.println("\nMissed Test Case Scenario");
		 try {

		// Appointment Page
		appointment.clickAppointmentList();
		appointment.titleCheck(title);
		appointment.clickMissed(title);
		appointment.clickConfirmCancel();
		Base.explicitWait();
		login.pageRefresh();
		
		// On List View Page
		listView.clickListView();
		Base.explicitWait();
		
		// Assertion statement
		Assert.assertTrue(listView.appointmentStatusCheck("Missed"), "Result is not correct");
		System.out.println("Test Case Completed\n");
	
		} catch (Exception e) {
			System.out.println("Test Case Error : \n" + e.getMessage());

		}
	}

	@Test(priority = 3, description = "Editing the appointment")
	public void editAppointmentTest() {

		String title = Base.getVariables("title2");
		String locate = Base.getVariables("locate");

		System.out.println("\nEditing the appointment");

		try {
			// Appointment Page

			appointment.clickAppointmentList();
			appointment.titleCheck(title);
			appointment.clickEdit(title);
			appointment.selectLocation(locate);
			appointment.clickSave();

			// On List View Page
			listView.clickListView();
			Base.explicitWait();
			// Assertion statement
			Assert.assertTrue(listView.appointmentLocationCheck(locate), "Not Edited");
			System.out.println("Test Case Completed\n");
			
		} catch (Exception e) {
			System.out.println("Test Case Error : \n" + e.getMessage());
		}
	}

	@Test(priority = 2, description = "Filter the appointments by Status")
	public void filterAppointmentTest() {

		System.out.println("\nFilter the appointments by Status");

		try {
			String status = Base.getVariables("status");

			// login.clickAppointmentOption();
			// Appointment Page
			appointment.clickAppointmentList();

			// appoint status
			appointment.enterAppointmentStatus(status);
			appointment.clickApplyFilter();

			// List of all the appointments
			appointment.listOfAppointment();
			Base.explicitWait();

			// On List View Page
			listView.clickListView();
			Base.explicitWait();

			// Assertion statement
			Assert.assertTrue(listView.appointmentStatusCheck(status), "Result is not correct");
			System.out.println("Test Case Completed\n");

		} catch (Exception e) {
			System.out.println("Test Case Error : \n" + e.getMessage());
		}
	}

	@Test(priority = 1, description = "Creating Appointment")
	public void appointment() {

		System.out.println("\nCreating Appointment");

		String[] name1 = Base.getVariables("name1").split(",");
		String serviceName = Base.getVariables("serviceName");
		String setdate = Base.getVariables("setdate");
		String[] startTime1 = Base.getVariables("startTime1").split(",");
		String[] endTime1 = Base.getVariables("endTime1").split(",");
		String gender = Base.getVariables("gender");
		String age = Base.getVariables("age");
		String patientFamilyName = Base.getVariables("patientFamilyName");
		String patientName = Base.getVariables("patientName");
		String idValue = Base.getVariables("idValue");

		try {

			// Creating a new patient
			Base.explicitWait();
			login.clickHomeBtn();
			login.clickRegistration();
			register.clickCreateNewUser();
			register.enterUserName(patientName);
			register.enterUserFamilyName(patientFamilyName);
			register.checkPatientID();

			register.enterIDValue(idValue);
			register.enterAge(age);
			register.selectGender(gender);
			register.clickSave();

			login.clickHomeBtn();
			login.clickAppointmentOption();

			// On Appointment Page
			appointment.clickAppointmentList();

			for (int c = 0; ((name1.length) - 1) >= c; c++) {
				Base.explicitWait();
				appointment.clickNewAppointment();
				appointment.enterPatientID(name1[c]);
				appointment.setDate(setdate);
				appointment.setStartTime(startTime1[c]);
				appointment.setEndTime(endTime1[c]);
				appointment.selectService(serviceName);
				String title = appointment.getPatientName();
				Base.explicitWait();
				appointment.clickSave();
				Assert.assertTrue(appointment.titleChecking(title), "Appointment not created");
			}
			System.out.println("\nTest Case Completed\n");

		} catch (Exception e) {
			System.out.println("Test Case Error : \n" + e.getMessage());
		}
	}

	@BeforeMethod
	public void logingInTheApplication() {
		String username = Base.getVariables("username");
		String password = Base.getVariables("password");
		String location = Base.getVariables("location");
		String locale = Base.getVariables("locale");

		// Login to the application
		Base.explicitWait();
		login.login(username, password, location, locale);
		Base.explicitWait();
		login.clickAppointmentOption();
	}

	@AfterMethod
	public void logingOutOfTheApplication() {
		Base.explicitWait();
		login.clickHomeBtn();
		login.clickUserInfo();
		login.clicklogout();
	}

	@AfterTest
	public void endGame() {
		driver.quit();
	}

}
