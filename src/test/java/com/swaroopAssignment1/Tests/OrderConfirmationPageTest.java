package com.swaroopAssignment1.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.swaroopAssignment1.BasePackage.TestBase;
import com.swaroopAssignment1.Pages.HomePage;
import com.swaroopAssignment1.Pages.LoginPage;
import com.swaroopAssignment1.Pages.MyAccountPage;
import com.swaroopAssignment1.Pages.OrderConfirmationPage;
import com.swaroopAssignment1.Pages.OrderPage;
import com.swaroopAssignment1.Pages.WomenStorePage;

public class OrderConfirmationPageTest extends TestBase{
	
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	WomenStorePage womenStorePage;
	OrderPage orderPage;
	OrderConfirmationPage orderConfirmationPage;
	SoftAssert sf;
	
	@BeforeMethod
	public void setup() {
		initialization();
		sf = new SoftAssert();
		HomePage homePage = new HomePage();
		loginPage = homePage.clickSignInButton();
//		loginPage.enterEmail(prop.getProperty("emailAddress"));
//		loginPage.enterPassword(prop.getProperty("password"));
//		myAccountPage = loginPage.clickSigninButton();
		myAccountPage = loginPage.loginTOThePortal(prop.getProperty("emailAddress"), prop.getProperty("password"));

	}
	
	@Test(priority = 5)
	public void verifyUserisAbleToOrderItem() {	
		womenStorePage = myAccountPage.clickWomenButton();
		womenStorePage.hoverMouseOnProduct();
//		womenStorePage.hoverMouseOnProductUsingJavascript();
		womenStorePage.clickAddToCartButton();
		orderPage = womenStorePage.clickProceedtoCheckOutButton();
		orderPage.clickProceedToCheckoutButtonOnOrderPage();
		orderPage.clickProceedToCheckoutButtonOnAddressPage();
		orderPage.clickTermsOfServiceButton();
		orderPage.clickProceedToCheckoutButtonOnShippingPage();
		orderPage.clickPaymentByWireMethod();
		orderConfirmationPage = orderPage.clickIConfirmMyOrderButton();
		String orderConfirmationMessage = orderConfirmationPage.getTextFromSuccessMessage();
		sf.assertEquals(orderConfirmationMessage, prop.getProperty("OrderConfirmMessage"));
		sf.assertAll();
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
