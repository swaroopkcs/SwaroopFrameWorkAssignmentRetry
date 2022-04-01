package com.swaroopAssignment1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaroopAssignment1.BasePackage.TestBase;

public class MyAccountPage extends TestBase{
	
	public MyAccountPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "ul>li:nth-of-type(1)")
	WebElement womenButton;
	
	public WomenStorePage clickWomenButton() {
		womenButton.click();
		return new WomenStorePage();
	}

}
