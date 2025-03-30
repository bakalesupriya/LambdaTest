package ltDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LTExample3 
{
	@Test
	public void Scenario3() throws MalformedURLException
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
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test");
		driver.findElement(By.id("inputEmail4")).sendKeys("test123@gmail.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("test@123");
		driver.findElement(By.id("company")).sendKeys("TestCompany");
		driver.findElement(By.id("websitename")).sendKeys("https://test.com");
		
		
		WebElement countryDropdown = driver.findElement(By.cssSelector("select[name='country']")); // Replace with actual ID
        Select select = new Select(countryDropdown);
        select.selectByVisibleText("United States");
        
        driver.findElement(By.id("inputCity")).sendKeys("Miami");
        driver.findElement(By.id("inputAddress1")).sendKeys("Address1");
        driver.findElement(By.id("inputAddress2")).sendKeys("Address2");
        driver.findElement(By.id("inputState")).sendKeys("Florida");
        driver.findElement(By.id("inputZip")).sendKeys("123456");
        
        driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success-msg"))); // Replace with actual ID

        // Retrieve the success message text
        String actualMessage = successMsg.getText();

        // Expected success message
        String expectedMessage = "Thanks for contacting us, we will get back to you shortly.";

        // Assert the success message
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("Success message is displayed correctly.");
		driver.quit();
	}
}
