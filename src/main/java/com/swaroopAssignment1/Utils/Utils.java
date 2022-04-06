package com.swaroopAssignment1.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.swing.JSeparator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.swaroopAssignment1.BasePackage.TestBase;

public class Utils extends TestBase{
	public static int IMPTICIT_Wait = 20;
	public static int PAGE_LOAD_TIMEOUT = 30;
	
	
	public static String generateRandomEmail() {
		String email = RandomStringUtils.randomNumeric(3);
		String emailID = "Swaroop" + email + "@gmal.com";
		return emailID;

	}

	public static String generateRandomPassword() {
		String randomStringForPassword = RandomStringUtils.randomNumeric(3);
		String password = "Manager@" + randomStringForPassword;
		return password;

	}
	
	public static void takeSCreenShotOfFailedTestCase(String nameOfTestCase) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File file = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./FailedScreenshot\\"+"_"+nameOfTestCase+"_"+timeStamp+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sleep(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void javaScrpitClick(WebElement webElement) {
		jse.executeScript("arguments[0].click", webElement);
	}
	
	public static WebElement waitForElementToBeClickable(WebElement webElement, int timeOutInSeconds) {
		return new WebDriverWait(wd, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public static WebElement waitForElementToBeVisible(WebElement webElement, int timeOutInSeconds) {
		return new WebDriverWait(wd, timeOutInSeconds).until(ExpectedConditions.visibilityOf(webElement));
	}

	public static Boolean waitForElementToBeSelectable(WebElement webElement, int timeOutInSeconds) {
		return new WebDriverWait(wd, timeOutInSeconds)
				.until(ExpectedConditions.elementSelectionStateToBe(webElement, false));
	}

	public static Alert waitForAlertToBePresent(int timeOutInSeconds) {
		return new WebDriverWait(wd, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
	}

	public static void selectFromDropDownUsingIndex(WebElement element, int index) {
		try {
			if (waitForElementToBeSelectable(element, 15)) {
				new Select(element).selectByIndex(index);
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

	}

	public static void selectFromDropDownUsingVisibleText(WebElement element, String text) {
		try {
			if (waitForElementToBeSelectable(element, 15)) {
				new Select(element).deselectByVisibleText(text);
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

	}

	public static void moveToElement(WebElement element) {
		Actions actions = new Actions(wd);
		actions.moveToElement(element).build().perform();
	}

	public void acceptAlert() {
		if (waitForAlertToBePresent(5) != null) {
			wd.switchTo().alert().accept();
		}
	}

	public void dismissAlert() {
		if (waitForAlertToBePresent(5) != null) {
			wd.switchTo().alert().dismiss();
		}
	}

	public static void sendData(WebElement webElement, String text) {
		waitForElementToBeVisible(webElement, 10).sendKeys(text);

	}
	
	public static void scrollIntoViewUsingJavascript(WebElement webElement) {
		jse.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}
	
	public static String getTextFromWebelement(WebElement webElement) {
		return waitForElementToBeVisible(webElement, 10).getText();
	}

	public void switchToWindowHandle(WebElement element) {
		String parentHandle = wd.getWindowHandle();
		element.click();
		Set<String> getAllHandles = wd.getWindowHandles();
		for (String individualHandle : getAllHandles) {
			if (!individualHandle.equalsIgnoreCase(parentHandle)) {
				wd.switchTo().window(individualHandle);
			}
		}
	}

	public void switchToFrame(WebElement element) {
		wd.switchTo().frame(waitForElementToBeVisible(element, 10));
	}

}
