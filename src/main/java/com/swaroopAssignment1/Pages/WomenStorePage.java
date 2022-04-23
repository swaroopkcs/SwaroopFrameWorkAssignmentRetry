package com.swaroopAssignment1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaroopAssignment1.BasePackage.TestBase;

public class WomenStorePage extends TestBase{
	public WomenStorePage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}
	
	@FindBy(css = "div.left-block [title = 'Faded Short Sleeve T-shirts']")
	WebElement imageForProduct;
	
	@FindBy (xpath = "//a[@title = 'Add to cart']")
	WebElement addToCartButton;
	
	@FindBy(css = "div .layer_cart_product.col-xs-12.col-md-6> h2")
	WebElement successMessage;
	
	@FindBy(css = "div [title = 'Proceed to checkout']")
	WebElement proceedToCheckoutButton;
	
	public void hoverMouseOnProduct() {
		actions.moveToElement(imageForProduct).perform();
	}
	
	public void hoverMouseOnProductUsingJavascript() {
		jse.executeScript("arguments[0].scrollIntoView(true)", imageForProduct);
		 
	}
	
	public WomenStorePage clickAddToCartButton() {
		addToCartButton.click();
		return new WomenStorePage();
		
	}
	
	public String getTextFromSuccessMessage() {
		return successMessage.getText();
	}
	
	public OrderPage clickProceedtoCheckOutButton() {
		proceedToCheckoutButton.click();
		System.out.println("Order is sccessfully Checked out! Be ready!");
		return new OrderPage();
	}
	

}
