package com.swaroopAssignment1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaroopAssignment1.BasePackage.TestBase;

public class OrderConfirmationPage extends TestBase{
	
	public OrderConfirmationPage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}
	
	@FindBy (css = ".cheque-indent .dark")
	WebElement successMessageOrderConfirmation;
	
	public String getTextFromSuccessMessage() {
		return successMessageOrderConfirmation.getText();
	}

}
