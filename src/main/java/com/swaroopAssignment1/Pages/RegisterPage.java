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
	
	@FindBy(id = "submitAccount")
	WebElement submitButton;
	
	public void clickRadioButton() {
		Utils.waitForElementToBeClickable(titleRadioButton, 5).click();
	}
	
	public void inputFirstName(String firstName) {
		Utils.sendData(firstNameInput, firstName);
	}
	
	public void inputLastName(String lastName) {
		Utils.sendData(lastNameInput, lastName);
	}
	
	public void inputPassword(String password) {
		Utils.sendData(passwordInput, password);
	}
	
	public void selectDay() {
		Utils.selectFromDropDownUsingIndex(selectDateDropDown, 2);
	}
	
	public void selectMonth() {
		Utils.selectFromDropDownUsingIndex(selectMonthDropDown, 2);
		}
	
	public void selectYear() {
		Utils.selectFromDropDownUsingIndex(selectYearDropDown, 20);
	}
	
	public void clickNewsLetterCheckBox() {
		Utils.javaScrpitClick(newsLetterCheckBox);
	}
	
	public void clickSpecialOfferCheckBox() {
		Utils.javaScrpitClick(specialOffersCheckBox);
	}
	
	public void inputFistNameForAddress(String firstName) {
		Utils.sendData(addressFirstNameInput, firstName);
	}
	
	public void inputLastNameForAddress(String lastName) {
		Utils.sendData(addressLastNameInput, lastName);
	}
	
	public void inputCompanyName(String companyName) {
		Utils.sendData(companyNameInput, companyName);
	}
	
	public void inputAddressLine1(String address1) {
		Utils.sendData(addressLine1Input, address1);
	}
	
	public void inputAddressLine2(String address2) {
		Utils.sendData(addressLine2Input, address2);
	}
	
	public void inputcityName(String cityName) {
		Utils.sendData(cityNameInput, cityName);
	}
	
	public void selectStateFromDropDown() {
		Utils.selectFromDropDownUsingIndex(selectStateDropDown, 1);
	}
	
	public void inputpostalCode(String postalCode) {
		Utils.sendData(postalCodeInput, postalCode);
	}
	public void selectCountryFromDropDown() {
		Utils.selectFromDropDownUsingIndex(selectCountryDropDownInput, 21);
	}
	
	public void inputAdditionalInfo(String additionalInfo) {
		Utils.sendData(additionalInfoFieldInput, additionalInfo);
	}
	
	public void inputMobilePhone() {
		Utils.sendData(mobilePhoneNumberInput, Utils.generateRandomPhone());
	}
	
	public void inputHomePhone() {
		Utils.sendData(homePhoneNumberInput, Utils.generateRandomPhone());
	}
	
	public void inputAddressAlias(String addressAlias) {
		Utils.sendData(addressAliasInputInput, addressAlias);
	}
	
	public MyAccountPage clickRegisterButton() {
		Utils.waitForElementToBeClickable(submitButton, 5).click();
		System.out.println("registration successful");
		return new MyAccountPage();
	}
}
