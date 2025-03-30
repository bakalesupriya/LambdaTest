package ltDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LTExample2 
{
	@Test
	public void Scenario2() throws MalformedURLException
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

        
        driver.findElement(By.linkText("Drag & Drop Sliders")).click();

        
        WebElement slider = driver.findElement(By.cssSelector("input[value='15']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(215, 0).release().build().perform();

        WebElement sliderValue = driver.findElement(By.xpath("//div[@class='sp__range sp__range-success']/input/following-sibling::output"));
        String value = sliderValue.getText();

        if (value.equals("95")) {
            System.out.println("Slider moved successfully to 95!");
        } else {
            System.out.println("Slider didn't reach 95. Current value: " + value);
        }

		driver.quit();
	}
}
