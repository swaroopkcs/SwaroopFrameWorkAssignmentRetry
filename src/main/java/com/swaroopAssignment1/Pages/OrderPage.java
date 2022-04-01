package com.swaroopAssignment1.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.swaroopAssignment1.BasePackage.TestBase;

public class OrderPage extends TestBase{
	
	public OrderPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy (css = "i.icon-trash")
	WebElement deleteButton;
	
	@FindBy(css = "p>a[title = 'Proceed to checkout']")
	WebElement proceedToCheckoutButton;
	
	@FindBy(css = "button[name= 'processAddress']")
	WebElement addressPageCheckoutButton;
	
	@FindBy(id = "cgv")
	WebElement termsOfServiceCheckBox;
		
	@FindBy (css = "button[name= 'processCarrier']")
	WebElement shippingPageCheckoutButton;
	
	@FindBy (css = "a[title = 'Pay by bank wire']")
	WebElement paymentMethodByWireButton;
	
	@FindBy(css = "button i.icon-chevron-right.right")
	WebElement orderConfirmButton;
	
	@FindBy(xpath = "//div[@id = 'center_column'] // p")
	WebElement messageBanner;
	
	
	
	
	public OrderDelConfirmPage clickDelButton() {
		deleteButton.click();
		return new OrderDelConfirmPage();
	}
	
	public OrderPage clickProceedToCheckoutButtonOnOrderPage() {
		proceedToCheckoutButton.click();
		return new OrderPage();
	}
	
	public OrderPage clickProceedToCheckoutButtonOnAddressPage() {
		addressPageCheckoutButton.click();
		return new OrderPage();
	}
	
	public void clickTermsOfServiceButton() {
		termsOfServiceCheckBox.click();
	}
	
	public OrderPage clickProceedToCheckoutButtonOnShippingPage() {
		shippingPageCheckoutButton.click();
		return new OrderPage();
	}
	
	public OrderPage clickPaymentByWireMethod() {
		paymentMethodByWireButton.click();
		return new OrderPage();
	}
	
	public OrderConfirmationPage clickIConfirmMyOrderButton() {
		orderConfirmButton.click();
		return new OrderConfirmationPage();
	}
	
	public String getTextFromMessageBanner() {
		wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.alert.alert-warning")));
		return messageBanner.getText();
	}
	

}
