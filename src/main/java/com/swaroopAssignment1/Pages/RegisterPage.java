package com.swaroopAssignment1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaroopAssignment1.BasePackage.TestBase;
import com.swaroopAssignment1.Utils.Utils;

public class RegisterPage extends TestBase{
	
	public RegisterPage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}
	
	@FindBy(id = "id_gender1")
	WebElement titleRadioButton;
	
	@FindBy(id = "customer_firstname")
	WebElement firstNameInput;
	
	@FindBy(id = "customer_lastname")
	WebElement lastNameInput;
	
	@FindBy(id = "passwd")
	WebElement passwordInput;
	
	@FindBy(id = "days")
	WebElement selectDateDropDown;
	
	@FindBy(id = "months")
	WebElement selectMonthDropDown;
	
	@FindBy(id = "years")
	WebElement selectYearDropDown;
	
	@FindBy(id = "newsletter")
	WebElement newsLetterCheckBox;
	
	@FindBy(id = "optin")
	WebElement specialOffersCheckBox;
	
	@FindBy(css = "input[name = 'firstname']")
	WebElement addressFirstNameInput;
	
	@FindBy(css = "input[name = 'lastname']")
	WebElement addressLastNameInput;
	
	@FindBy(id = "company")
	WebElement companyNameInput;
	
	@FindBy(id = "address1")
	WebElement addressLine1Input;
	
	@FindBy(id = "address2")
	WebElement addressLine2Input;
	
	@FindBy(id = "city")
	WebElement cityNameInput;
	
	@FindBy(id = "id_state")
	WebElement selectStateDropDown;
	
	@FindBy(css = "input[ name = 'postcode']")
	WebElement postalCodeInput;

	@FindBy(id = "id_country")
	WebElement selectCountryDropDownInput;
	
	@FindBy(id = "other")
	WebElement additionalInfoFieldInput;
	
	@FindBy(id = "phone")
	WebElement homePhoneNumberInput;
	
	@FindBy(id = "phone_mobile")
	WebElement mobilePhoneNumberInput;
	
	@FindBy(id = "alias")
	WebElement addressAliasInputInput;
	
	@FindBy(id = ".submit.clearfix .icon-chevron-right.right")
	WebElement submitButton;
	
	public void clickRadioButton() {
		Utils.waitForElementToBeClickable(titleRadioButton, 5).click();
	}
	
	public void inputFirstName(String firstName) {
		Utils.sendData(firstNameInput, null);
	}

	
}
