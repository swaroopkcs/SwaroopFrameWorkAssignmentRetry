package com.swaroopAssignment1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaroopAssignment1.BasePackage.TestBase;
import com.swaroopAssignment1.Utils.Utils;

public class ContactUsPage extends TestBase{
	public ContactUsPage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}
	

	@FindBy(id = "id_contact")
	WebElement subjectHeading;
	
	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(name = "id_order")
	WebElement orderReference;

	@FindBy(id = "message")
	WebElement messageInput;

	@FindBy(css = ".alert.alert-success")
	WebElement successMessage;

	@FindBy(id = "submitMessage")
	WebElement clickSubmitBtn;
	
	@FindBy(css = ".alert.alert-danger p")
	WebElement errorMessage;
	
	public void selecSubjectHeadingAsCS() {
		Utils.selectFromDropDownUsingIndex(subjectHeading, 1);
	}
	
	public void enterEmailAddress(String email) {
		Utils.waitForElementToBeVisible(emailInput, 3).sendKeys(email);
	}
	
	public void enterOrderReference(String orderRef) {
		Utils.sendData(orderReference, orderRef);
	}
	
	public void enterMEssageInMessageBox(String orderRef) {
		Utils.sendData(messageInput, orderRef);
	}
	
	public ContactUsPage clickSendButton() {
		Utils.waitForElementToBeClickable(clickSubmitBtn, 5).click();
		return new ContactUsPage();
	}
	
	public String getSuccessMessageFromContactUsPage() {
		return Utils.getTextFromWebelement(successMessage);
	}
	
	public String getErroressageFromContactUsPage() {
		return Utils.getTextFromWebelement(errorMessage);
	}

}
