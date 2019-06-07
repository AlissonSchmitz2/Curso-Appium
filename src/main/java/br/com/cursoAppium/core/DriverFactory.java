package br.com.cursoAppium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	
	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			createDriverTestObject();
		}
		
		return driver;
	}
	
	@SuppressWarnings("unused")
	private static void createDriver(){
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "5200f7f6f0cf65e7");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		// Ao iniciar instala o apk, caso já esteja instalado irá sobrescrever
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\A\\CTAppium-1-1.apk");
		//Acessar APP da da playStore
//		desiredCapabilities.setCapability("appPackage", "com.android.calculator"); //Pacote principal do APP
//		desiredCapabilities.setCapability("appActivity", "com.android.calculator.Calculadora"); //Activity inicial
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		//Parecido com o aguardeJanelaTimeOut
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	private static void createDriverTestObject(){
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appiumVersion", "1.13.0");
		desiredCapabilities.setCapability("testobject_api_key", "0E79F9937E3A4A69A9A337480A2A6B54");
		//desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		// Ao iniciar instala o apk, caso já esteja instalado irá sobrescrever
		//desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\A\\CTAppium-1-1.apk");
		//Acessar APP da da playStore
//		desiredCapabilities.setCapability("appPackage", "com.android.calculator"); //Pacote principal do APP
//		desiredCapabilities.setCapability("appActivity", "com.android.calculator.Calculadora"); //Activity inicial
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("https://us1.appium.testobject.com/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		//Parecido com o aguardeJanelaTimeOut
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
