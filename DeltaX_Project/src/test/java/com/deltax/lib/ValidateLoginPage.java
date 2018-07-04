package com.deltax.lib;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.deltax.pages.LoginPage;

public class ValidateLoginPage {
	LoginPage login;

	public void setLoginPageValues(WebDriver driver, Object testScenario, Object firstName, Object lastName,
			Object dept, Object userName, Object password, Object email, Object contact, Object expectedResult)
			throws Exception {
		initialiseLogin(driver);
		login.typeFirstName(firstName.toString());
		login.typeLastName(lastName.toString());
		login.selectDept(dept.toString());
		login.typeUserName(userName.toString());
		login.typePassword(password.toString());
		login.typeConfirmPassword(password.toString());
		login.typeEmail(email.toString());
		login.typeContact(contact.toString());
		login.clickSubmit();

	}

	public void initialiseLogin(WebDriver driver) {
		login = new LoginPage(driver);
	}

	public void validateTests(String testScenario, String expectedResult) {
		String actualResult = "";
		switch (testScenario) {

		case "TC_LoginWithAllValidParams":

			actualResult = login.driver.findElement(login.successLogin).getText();
			System.out.println("actualResult<<< " + actualResult);
			break;

		case "TC_LoginWithFirstnameEmpty":

			actualResult = login.driver.findElement(login.firstNameEmptyMessage).getText();
			System.out.println("actualResult<<< " + actualResult);
			break;

		case "TC_LoginWithFirstnameInvalid":

			actualResult = login.driver.findElement(login.firstNameInvalidValueMessage).getText();
			System.out.println("actualResult<<< " + actualResult);
			break;

		case "TC_LoginWithLastnameEmpty":

			actualResult = login.driver.findElement(login.lastNameEmptyMessage).getText();
			System.out.println("actualResult<<< " + actualResult);
			break;

		case "TC_LoginWithLastnameInvalid":

			actualResult = login.driver.findElement(login.lastNameInvalidValueMessage).getText();
			System.out.println("actualResult<<< " + actualResult);
			break;

		case "TC_LoginWithUsernameEmpty":

			actualResult = login.driver.findElement(login.userNameEmptyMessage).getText();
			System.out.println("actualResult<<< " + actualResult);
			break;

		case "TC_LoginWithUsernameInvalid":

			actualResult = login.driver.findElement(login.userNameInvalidValueMessage).getText();
			System.out.println("actualResult<<< " + actualResult);
			break;
		case "TC_LoginWithpasswordEmpty":

			actualResult = login.driver.findElement(login.passwordEmptyMessage).getText();
			System.out.println("actualResult<<< " + actualResult);
			break;

		case "TC_LoginWithpasswordInvalid":

			actualResult = login.driver.findElement(login.passwordInvalidValueMessage).getText();
			System.out.println("actualResult<<< " + actualResult);
			break;

		default:
			System.out.println("No scenarios given");
		}

		if (actualResult.equals(expectedResult)) {
			Assert.assertTrue(true, "Successfully validated the scenario " + testScenario);
			Reporter.log("Successfully validated the scenario " + testScenario, true);

		} else {
			Assert.fail("Failed to validated the scenario " + testScenario);
			Reporter.log("Failed to validated the scenario " + testScenario, true);

		}

	}
}
