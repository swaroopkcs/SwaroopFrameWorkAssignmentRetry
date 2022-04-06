package com.swaroopAssignment1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaroopAssignment1.BasePackage.TestBase;
import com.swaroopAssignment1.Utils.Utils;

public class MyAccountPage extends TestBase{
	
	public MyAccountPage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}
	
	@FindBy(css = "#center_column p")
	WebElement welcomeMessageText;
	
	@FindBy(css = ".account")
	WebElement nameOfUser;
	
	@FindBy(css = "ul>li:nth-of-type(1)")
	WebElement womenButton;
	
	public String getTextFromMessage() {
		return Utils.getTextFromWebelement(welcomeMessageText);
	}
	
	public String getNameFromLoginPage() {
		return Utils.getTextFromWebelement(nameOfUser);
	}
	
	public WomenStorePage clickWomenButton() {
		womenButton.click();
		return new WomenStorePage();
	}

}
