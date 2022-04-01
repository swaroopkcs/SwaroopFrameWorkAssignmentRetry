package com.swaroopAssignment1.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	
	@BeforeMethod
	public void setup() {
		initialization();
		HomePage homePage = new HomePage();
		loginPage = homePage.clickSignInButton();
		loginPage.enterEmail(prop.getProperty("emailAddress"));
		loginPage.enterPassword(prop.getProperty("password"));
		myAccountPage = loginPage.clickSigninButton();
	}
	
	@Test
	public void verifyUserisAbleToDelItemFromCart() {
		womenStorePage = myAccountPage.clickWomenButton();
		womenStorePage.hoverMouseOnProduct();
		womenStorePage.clickAddToCartButton();
		orderPage = womenStorePage.clickProceedtoCheckOutButton();
		orderPage.clickProceedToCheckoutButtonOnOrderPage();
		orderPage.clickProceedToCheckoutButtonOnAddressPage();
		orderPage.clickTermsOfServiceButton();
		orderPage.clickProceedToCheckoutButtonOnShippingPage();
		orderPage.clickPaymentByWireMethod();
		orderConfirmationPage = orderPage.clickIConfirmMyOrderButton();
		String orderConfirmationMessage = orderConfirmationPage.getTextFromSuccessMessage();
		Assert.assertEquals(orderConfirmationMessage, prop.getProperty("OrderConfirmMessage"));
		
	}

}
