package com.swaroopAssignment1.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.swaroopAssignment1.Logger.WebDriverEvents;
import com.swaroopAssignment1.Utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver wd;
	public static Properties prop;
	public static Actions actions;
	public static WebDriverWait wdWait;
	public static Logger logger;
	public EventFiringWebDriver eDriver;
	public WebDriverEvents eventListener;
	public static JavascriptExecutor jse;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(
					"src//main//java//com//swaroopAssignment1//Config//Config.Properties");
			prop.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
		
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
		
		eDriver = new EventFiringWebDriver(wd);
		eventListener = new WebDriverEvents();
		eDriver.register(eventListener);
		wd = eDriver;
		
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Utils.IMPTICIT_Wait , TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		wd.get(prop.getProperty("URL"));
		actions = new Actions(wd);
		wdWait = new WebDriverWait(wd, 20);
	}

	public void tearDown() {
		wd.quit();
	}
	
	public void waitForDocumentCompleteState(int timeInSeconds) {
		new WebDriverWait(wd,timeInSeconds).until((ExpectedCondition<Boolean>) v->{
			jse = (JavascriptExecutor) wd;
			String documentIsReady = jse.executeScript("return document.readyState").toString();
			while (true) {
				if (documentIsReady.equalsIgnoreCase("complete")) {
					logger.info("Page has loaded completely...");
					return true;
				} else {
					return false;
				}
			}
		});
	}

}
