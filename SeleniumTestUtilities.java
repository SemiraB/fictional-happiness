package com.example.tests;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public final class SeleniumTestUtilities
{

	public static WebDriver getFirefoxDriver()
	{
		String path = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",path);

		DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new MarionetteDriver(capabilities);

		return driver;
	}

	public static WebDriver getFirefoxDriver(String pathToFirefoxExecutable)
	{
		String path = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",path);
		System.setProperty("webdriver.firefox.bin", pathToFirefoxExecutable);

		DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new MarionetteDriver(capabilities);

		return driver;
	}

	public static WebDriver getChromeDriver()
	{
		String path = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		return new ChromeDriver(cap);
	}

	public static WebDriver getChromeDriver(String pathToChromeExecutable)
	{
		String path = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("binary", pathToChromeExecutable);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		return new ChromeDriver(capabilities);
	}

//	The good news is that it looks like the IE driver *mostly* works with IE11, provided
//	that (a) all security zones are set to the same Protected Mode setting and (b) Enhanced
//	Protected Mode is turned off. Note that the standard registry checks that the IE driver
//	uses to test for Protected Mode settings in IE7-10 are broken for IE11.

	public static WebDriver get32IEDriver()
	{
		String path = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer32.exe";
		System.setProperty("webdriver.ie.driver", path);
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,	true);
		return new InternetExplorerDriver(caps);
	}

	public static WebDriver get64IEDriver()
	{
		String path = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer64.exe";
		System.setProperty("webdriver.ie.driver", path);
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(CapabilityType.BROWSER_NAME, "IE");
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,	true);

		return new InternetExplorerDriver(caps);
	}

	public static WebDriver getEdgeDriver()
	{
		String path = System.getProperty("user.dir") + "\\Drivers\\EdgeWebDriver.exe";
		System.setProperty("webdriver.ie.driver", path);
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,	true);
		return new InternetExplorerDriver(caps);
	}

	public static WebDriver getHtmlUnitDriver()
	{
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.setJavascriptEnabled(true);

		return driver;
	}

}