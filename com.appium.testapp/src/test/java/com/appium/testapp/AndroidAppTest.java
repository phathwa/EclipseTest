package com.appium.testapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidAppTest {

//	WebDriver driver;
	AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1"); 
		capabilities.setCapability("deviceName","GalaxyNexus");
		capabilities.setCapability("platformName","Android");
	 
	   
	   capabilities.setCapability("appPackage", "com.android.calculator2");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	   //driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	}

	@Test
	public void testCal() throws Exception {
		driver.findElementById("com.android.calculator2:id/digit_1").click();
	   //locate the Text on the calculator by using By.name()
		
//	   WebElement two=driver.findElement(By.name("2"));
//	   two.click();
//	   WebElement plus=driver.findElement(By.name("+"));
//	   plus.click();
//	   WebElement four=driver.findElement(By.name("4"));
//	   four.click();
//	   WebElement equalTo=driver.findElement(By.name("="));
//	   equalTo.click();
//	   //locate the edit box of the calculator by using By.tagName()
//	   WebElement results=driver.findElement(By.tagName("EditText"));
//		//Check the calculated value on the edit box
//	assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";

	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
	}
