package com.swaroopAssignment1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaroopAssignment1.BasePackage.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(id = "passwd")
	WebElement passwordInput;

	@FindBy(id = "SubmitLogin")
	WebElement signinButton;

	public void enterEmail(String emailAddress) {
		emailInput.sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public MyAccountPage clickSigninButton() {
		signinButton.click();
		return new MyAccountPage();
	}

}
