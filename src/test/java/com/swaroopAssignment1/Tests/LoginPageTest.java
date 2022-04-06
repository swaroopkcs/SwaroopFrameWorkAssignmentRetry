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
import com.swaroopAssignment1.Utils.ExcelUtils;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	SoftAssert sf;
	
	@BeforeMethod
	public void setup() {
		initialization();
		sf = new SoftAssert();
		homePage = new HomePage();
	}
	
//	@Test(dataProvider = "InvalidLoginDataProvider")
//	public void verifyUserIsNotAbletoSignInUsingInvalidOrBlankCredentials(String email, String password) {
//		loginPage = homePage.clickSignInButton();
//		loginPage = loginPage.loginWithInvalidCred(email, password);
//		String errorMessage = loginPage.getErrorMessageForLogin();
//		sf.assertEquals(errorMessage, prop.getProperty("errorMessage"));
//	}
	
	
	@Test (priority = 2)
	public void verifyUserIsNotAbletoSignInUsingInvalidOrBlankCredentials() {
		loginPage = homePage.clickSignInButton();
		loginPage = loginPage.loginWithInvalidCred(prop.getProperty("invalidEmail"), prop.getProperty("invalidPassword"));
		String errorMessage = loginPage.getErrorMessageForLogin();
		sf.assertEquals(errorMessage, prop.getProperty("errorMessage"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	
	@DataProvider(name = "InvalidLoginDataProvider")
	public String[][] readAndGetDataFromExcelFile() throws IOException {
		String filePath = "C:\\DESKTOP-UP3KE4H_E\\QA Testing\\AutomationPracticeData.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		int col = ExcelUtils.getCellCount(filePath, "Sheet1", rows);
		String[][] loginData = new String [rows][col];
		for (int i=1; i<rows;i++) {
			for(int j=0; j<col;j++) {
				loginData[i-1][j] = ExcelUtils.getCellData(filePath, "Sheet2", i, i);
			}
		}
		return loginData;
	}
}
