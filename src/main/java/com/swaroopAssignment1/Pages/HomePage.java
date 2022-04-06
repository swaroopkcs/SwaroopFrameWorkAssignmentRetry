package com.swaroopAssignment1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaroopAssignment1.BasePackage.TestBase;
import com.swaroopAssignment1.Utils.Utils;

public class HomePage extends TestBase{
	public HomePage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}
	
	@FindBy(css = "div.header_user_info")
	WebElement signInButton;
	
	@FindBy(css = "#contact-link")
	WebElement contactUsButton;
	
	@FindBy(css = "#block_contact_infos ul>li:nth-of-type(1)")
	WebElement storeAddress;
	
	@FindBy(css = "#block_contact_infos ul>li:nth-of-type(2) span")
	WebElement storePhone;
	
	@FindBy(css = "#block_contact_infos ul>li:nth-of-type(3) a")
	WebElement storeEmail;
	
	@FindBy (id  = "block_contact_infos")
	WebElement storeInformation;
	
	public LoginPage clickSignInButton() {
		Utils.waitForElementToBeClickable(signInButton, 5).click();
		return new LoginPage();
	}
	
	public ContactUsPage clickContactUsButton() {
		Utils.waitForElementToBeClickable(contactUsButton, 5).click();
		return new ContactUsPage();
	}
	
	public void scrollToTheStoreInformationSection() {
		Utils.scrollIntoViewUsingJavascript(storeInformation);
	}
	
	public String getTextFromStoreAddress() {
		return Utils.getTextFromWebelement(storeAddress);
	}
	
	public String getTextFromStorePhone() {
		return Utils.getTextFromWebelement(storePhone);
	}
	
	public String getTextFromStoreEmail() {
		return Utils.getTextFromWebelement(storeEmail);
	}

}
