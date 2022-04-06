package com.swaroopAssignment1.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.swaroopAssignment1.BasePackage.TestBase;
import com.swaroopAssignment1.Pages.HomePage;
import com.swaroopAssignment1.Pages.LoginPage;
import com.swaroopAssignment1.Pages.MyAccountPage;
import com.swaroopAssignment1.Utils.ExcelUtils;

public class MyAccountPageTest extends TestBase{
	
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	HomePage homePage;
	SoftAssert sf;
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		sf = new SoftAssert();
		homePage = new HomePage();
	}
	
//	@Test (dataProvider = "LoginDataProvider")
//	public void verifyUserCanSignInUsingValidCredentials(String email, String password, String name) {
//		loginPage = homePage.clickSignInButton();
//		myAccountPage = loginPage.loginTOThePortal(email, password);
//		String messageFromWebPage = myAccountPage.getTextFromMessage();
//		String nameFromWebPage = myAccountPage.getNameFromLoginPage();
//		sf.assertEquals(messageFromWebPage, prop.getProperty("LoginSuccessMessage","Success Message does not Match"));
//		sf.assertEquals(nameFromWebPage, name, "Name displayed does not match");
//		sf.assertAll();
//	}
	
	@Test (priority = 1)
	public void verifyUserCanSignInUsingValidCredentials() {
		loginPage = homePage.clickSignInButton();
		myAccountPage = loginPage.loginTOThePortal(prop.getProperty("emailAddress"), prop.getProperty("password"));
		String messageFromWebPage = myAccountPage.getTextFromMessage();
		String nameFromWebPage = myAccountPage.getNameFromLoginPage();
		sf.assertEquals(messageFromWebPage, prop.getProperty("LoginSuccessMessage"),"Success Message does not Match");
		sf.assertEquals(nameFromWebPage, prop.getProperty("name"), "Name displayed does not match");
		sf.assertAll();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	
	
	@DataProvider(name = "LoginDataProvider")
	public String[][] readAndGetDataFromExcelFile() throws IOException {
		String filePath = "C:\\DESKTOP-UP3KE4H_E\\QA Testing\\AutomationPracticeData.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		int col = ExcelUtils.getCellCount(filePath, "Sheet1", rows);
		String[][] loginData = new String [rows][col];
		for (int i=1; i<rows;i++) {
			for(int j=0; j<col;j++) {
				loginData[i-1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, i);
			}
		}
		return loginData;
	}

}
