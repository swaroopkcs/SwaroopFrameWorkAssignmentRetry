package com.swaroopAssignment1.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.swaroopAssignment1.BasePackage.TestBase;
import com.swaroopAssignment1.Pages.HomePage;
import com.swaroopAssignment1.Pages.LoginPage;
import com.swaroopAssignment1.Pages.MyAccountPage;
import com.swaroopAssignment1.Pages.OrderDelConfirmPage;
import com.swaroopAssignment1.Pages.OrderPage;
import com.swaroopAssignment1.Pages.WomenStorePage;
import com.swaroopAssignment1.Utils.ExcelUtils;

public class OrderPageTest extends TestBase {

	LoginPage loginPage;
	MyAccountPage myAccountPage;
	WomenStorePage womenStorePage;
	OrderPage orderPage;
	OrderDelConfirmPage orderDelConfirmPage;
	SoftAssert sf;

	@BeforeMethod
	public void setup() {
		initialization();
		sf = new SoftAssert();
		HomePage homePage = new HomePage();
		loginPage = homePage.clickSignInButton();
//		loginPage.enterEmail(prop.getProperty("emailAddress"));
//		loginPage.enterPassword(prop.getProperty("password"));
		myAccountPage = loginPage.loginTOThePortal(prop.getProperty("emailAddress"), prop.getProperty("password"));
//		myAccountPage = loginPage.clickSigninButton();
	}

	@Test(priority = 4)
	public void verifyUserisAbleToDelItemFromCart() {
		womenStorePage = myAccountPage.clickWomenButton();
		womenStorePage.hoverMouseOnProduct();
		womenStorePage.clickAddToCartButton();
		orderPage = womenStorePage.clickProceedtoCheckOutButton();
		orderPage.clickDelButton();
		String delMessage = orderPage.getTextFromMessageBanner();

		sf.assertEquals(delMessage, prop.getProperty("delMessage"));
//		sf.assertEquals(delMessage, "Deleted");
		sf.assertAll();

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	
	

}
