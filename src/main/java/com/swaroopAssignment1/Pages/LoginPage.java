package com.swaroopAssignment1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaroopAssignment1.BasePackage.TestBase;
import com.swaroopAssignment1.Utils.Utils;

import bsh.util.Util;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}

	@FindBy(id = "email")
	WebElement emailInput;
	
	@FindBy( id ="email_create")
	WebElement newEmailInput;

	@FindBy(id = "passwd")
	WebElement passwordInput;

	@FindBy(id = "SubmitLogin")
	WebElement signinButton;
	
	@FindBy( css = ".alert.alert-danger p")
	WebElement errorMessage;
	
	@FindBy(id = "SubmitCreate")
	WebElement createAccountButton;

	public void enterEmail(String emailAddress) {
		emailInput.sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public MyAccountPage clickSigninButton() {
//		signinButton.click();
		Utils.javaScrpitClick(signinButton);
		System.out.println("user is successfully logged in");
		return new MyAccountPage();
	}
	
	public RegisterPage clickCreateAccountButton() {
		Utils.waitForElementToBeClickable(createAccountButton, 3).click();
		return new RegisterPage();
	}
	
	
	
	public MyAccountPage loginTOThePortal(String email, String password) {
//		emailInput.sendKeys(email);
		Utils.waitForElementToBeVisible(emailInput, 5).sendKeys(email);
		Utils.waitForElementToBeVisible(passwordInput, 5).sendKeys(password);
		Utils.waitForElementToBeClickable(signinButton, 10).click();
		return new MyAccountPage();
	}
	
	public LoginPage loginWithInvalidCred(String email, String password) {
		Utils.waitForElementToBeVisible(emailInput, 5).sendKeys(email);
		Utils.waitForElementToBeVisible(passwordInput, 5).sendKeys(password);
		Utils.waitForElementToBeClickable(signinButton, 10).click();
		return new LoginPage();
	}
	
	public String getErrorMessageForLogin() {
		 return Utils.waitForElementToBeVisible(errorMessage, 5).getText();
	}
	
	public void enterNewEmail() {
		String newEmail = Utils.generateRandomEmail();
		Utils.sendData(newEmailInput, newEmail);
	}

}
