package com.swaroopAssignment1.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.swaroopAssignment1.BasePackage.TestBase;
import com.swaroopAssignment1.Pages.HomePage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	SoftAssert sf;
	
	@BeforeMethod
	public void setup() {
		initialization();
		sf = new SoftAssert();
	}
	
	@Test
	public void verifyTheStoreInformationOnHomePage() {
		homePage = new HomePage();
		homePage.scrollToTheStoreInformationSection();
		String storeAddress = homePage.getTextFromStoreAddress();
		String storePhone = homePage.getTextFromStorePhone();
		String storeEmail = homePage.getTextFromStoreEmail();
		sf.assertEquals(storeAddress, prop.getProperty("StoreAddress"), "Store Address does not match");
		sf.assertEquals(storePhone, prop.getProperty("StorePhone"), "Store Phone Number does not match");
		sf.assertEquals(storeEmail, prop.getProperty("StoreEmail"), "Store Email Address does not match");
		sf.assertAll();
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
