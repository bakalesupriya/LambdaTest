package ltDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LTExample 
{
	@Test
	public void Scenario1() throws MalformedURLException
	{
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("134");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "supriyabakale11");
		ltOptions.put("accessKey", "LT_GWpvqtCPPd962EhqKDpkOhxwEQYCHge36ugNJRJ2Dg00orK");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("build", "SeleniumBuild");
		ltOptions.put("project", "SeleniumBuild");
		ltOptions.put("console", "true");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-java");
		browserOptions.setCapability("LT:Options", ltOptions);
		
		WebDriver driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.findElement(By.linkText("Simple Form Demo")).click();
		
		String inputText = "Welcome to Lambda Test";
        WebElement textBox = driver.findElement(By.cssSelector("input[id='user-message']"));
        textBox.sendKeys(inputText);
        driver.findElement(By.id("showInput")).click();
        
        String actualText = driver.findElement(By.cssSelector("p[id='message']")).getText();

        if (inputText.equals(actualText)) {
            System.out.println("Text matches.");
        } else {
            System.out.println("Text does not match.");
        }
		
		driver.quit();
	}
}
