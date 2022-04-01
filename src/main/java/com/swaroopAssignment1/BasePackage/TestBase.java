package com.swaroopAssignment1.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver wd;
	public static Properties prop;
	public static Actions actions;
	public static WebDriverWait wdWait;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(
					"C:\\Users\\swaro\\eclipse-workspace\\AutomationPracticeFramework\\src\\main\\java\\com\\swaroopAssignment1\\Config\\Config.Properties");
			prop.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			wd = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			wd = new ChromeDriver();
			break;
		default:
			System.out.println("Please use a valid browser name");
			break;

		}
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wd.get(prop.getProperty("URL"));
		actions = new Actions(wd);
		wdWait = new WebDriverWait(wd, 20);
	}

	public void tearDown() {
		wd.quit();
	}

}
