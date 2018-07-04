package com.deltax.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.deltax.lib.ValidateLoginPage;
import com.deltax.utilities.ExcelReader;

public class LoginPageTest {

	public WebDriver driver;
	public String testDataFile = System.getProperty("user.dir") + File.separator + "TestData" + File.separator
			+ "LoginPageTestData.xlsx";

	@BeforeMethod
	public void startBrowserSession() throws Exception {
		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
					+ "chromedriver_win32" + File.separator + "chromedriver.exe");
			System.out.println("ChromeDriverLocaion <<< " + System.getProperty("webdriver.chrome.driver"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

			driver.get("http://adjiva.com/qa-test/");
			System.out.println("Before");

		} catch (Exception ex) {
			System.out.println("error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	@Test(dataProvider = "LoginTestData")

	public void runLoginTests(Object testScenario, Object firstName, Object lastName, Object dept, Object userName,
			Object password, Object email, Object contact, Object expectedResult) throws Exception {
		/* driver.navigate().refresh(); */

		System.out.println("******************************************");
		System.out.println("Executing Test " + testScenario.toString());
		ValidateLoginPage validateLoginPage = new ValidateLoginPage();
		validateLoginPage.setLoginPageValues(driver, testScenario, firstName, lastName, dept, userName, password, email,
				contact, expectedResult);
		validateLoginPage.validateTests(testScenario.toString(), expectedResult.toString());

	}

	@DataProvider
	public Object[][] LoginTestData() throws Exception {
		System.out.println("DataProvider");
		Object[][] testObjArray = ExcelReader.getTableArray(testDataFile, "Sheet1");
		System.out.println("testObjArray ");
		return (testObjArray);

	}

	@AfterMethod

	public void closeBrowserSession() {

		driver.quit();

	}

}
