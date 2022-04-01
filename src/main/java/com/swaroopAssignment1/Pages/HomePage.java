package com.swaroopAssignment1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaroopAssignment1.BasePackage.TestBase;

public class HomePage extends TestBase{
	public HomePage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "div.header_user_info")
	WebElement signInButton;
	
	public LoginPage clickSignInButton() {
		signInButton.click();
		return new LoginPage();
	}

}
