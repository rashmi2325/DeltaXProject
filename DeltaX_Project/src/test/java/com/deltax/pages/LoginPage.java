package com.deltax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	By firstName = By.xpath("/html/body/div/form/fieldset/div[1]/div/div/input");
	By lastName = By.xpath("/html/body/div/form/fieldset/div[2]/div/div/input");
	By dept = By.xpath("/html/body/div/form/fieldset/div[3]/div/div/select");
	By username = By.xpath("/html/body/div/form/fieldset/div[4]/div/div/input");
	By password = By.xpath("/html/body/div/form/fieldset/div[5]/div/div/input");
	By confirmPassword = By.xpath("/html/body/div/form/fieldset/div[6]/div/div/input");
	By email = By.xpath("/html/body/div/form/fieldset/div[7]/div/div/input");
	By contact = By.xpath("/html/body/div/form/fieldset/div[8]/div/div/input");
	By submit = By.xpath("/html/body/div/form/fieldset/div[10]/div/button");

	public By firstNameInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[1]/div/small[1]");
	public By firstNameEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[1]/div/small[2]");

	public By lastNameInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[2]/div/small[1]");
	public By lastNameEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[2]/div/small[2]");

	public By userNameInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[4]/div/small[1]");
	public By userNameEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[4]/div/small[2]");

	public By passwordInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[5]/div/small[1]");
	public By passwordEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[5]/div/small[2]");

	public By confirmPasswordInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[6]/div/small[1]");
	public By confirmPasswordEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[6]/div/small[2]");

	public By emailInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[7]/div/small[1]");
	public By emailEmptyMessage = By.xpath("/html/body/div/form/fieldset/div[7]/div/small[2]");

	public By contactInvalidValueMessage = By.xpath("/html/body/div/form/fieldset/div[8]/div/small");

	public By successLogin = By.xpath("/html/body/div/form/fieldset/legend/center/h2/b");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void typeFirstName(String firstName) {
		driver.findElement(this.firstName).sendKeys(firstName);
	}

	public void typeLastName(String lastName) {
		driver.findElement(this.lastName).sendKeys(lastName);
	}

	public void selectDept(String dept) {

		driver.findElement(this.dept).sendKeys(dept);
	}

	public void typeUserName(String userName) {
		driver.findElement(this.username).sendKeys(userName);
	}

	public void typePassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}

	public void typeConfirmPassword(String password) {
		driver.findElement(this.confirmPassword).sendKeys(password);
	}

	public void typeEmail(String email) {
		driver.findElement(this.email).sendKeys(email);
	}

	public void typeContact(String contact) {
		driver.findElement(this.contact).sendKeys(contact);
	}

	public void clickSubmit() {
		driver.findElement(submit).click();
	}

}
