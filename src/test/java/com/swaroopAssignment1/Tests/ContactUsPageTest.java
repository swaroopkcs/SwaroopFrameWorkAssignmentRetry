package com.swaroopAssignment1.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.swaroopAssignment1.BasePackage.TestBase;
import com.swaroopAssignment1.Pages.ContactUsPage;
import com.swaroopAssignment1.Pages.HomePage;
import com.swaroopAssignment1.Pages.LoginPage;

public class ContactUsPageTest extends TestBase{
	
	HomePage homePage;
	ContactUsPage contactUsPage;
	SoftAssert sf;
	
	@BeforeMethod
	public void setup() {
		initialization();
		sf = new SoftAssert();
		homePage = new HomePage();
	}
	
	@Test (priority = 3)
	public void verifyUserIsNotAbleToSendMessageInContactUsPage() {
		contactUsPage = homePage.clickContactUsButton();
		contactUsPage.selecSubjectHeadingAsCS();
		contactUsPage.enterOrderReference(prop.getProperty("OrderReference"));
		contactUsPage.enterMEssageInMessageBox(prop.getProperty("messageText"));
		contactUsPage = contactUsPage.clickSendButton();
		String successMessage = contactUsPage.getErroressageFromContactUsPage();
		sf.assertEquals(successMessage, prop.getProperty("errorMessageContactUs"), "Error MEssage does not match");
		sf.assertAll();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
