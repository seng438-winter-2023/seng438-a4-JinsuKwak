// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class ChangeRegionTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void changeRegionCAtoFR() {
    driver.get("https://www.costco.ca/");
    driver.manage().window().setSize(new Dimension(1017, 831));
    {
      WebElement element = driver.findElement(By.id("country-select"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("#country-select > .co-arrow-right"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("country-select")).click();
    driver.findElement(By.id("country-select")).click();
    driver.findElement(By.linkText("France")).click();
    assertThat(driver.findElement(By.id("languageMenuTrigger")).getText(), is("France"));
    driver.close();
  }
  @Test
  public void changeRegionCAtoUS() {
    driver.get("https://www.costco.ca/");
    driver.manage().window().setSize(new Dimension(1017, 831));
    {
      WebElement element = driver.findElement(By.id("myaccount-react-t"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("#cart-t > .co-cart-rwd"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector("#country-select > .co-arrow-right")).click();
    driver.findElement(By.cssSelector("#country-select > .co-arrow-right")).click();
    driver.findElement(By.linkText("United States")).click();
    assertThat(driver.findElement(By.cssSelector("#country-select > span:nth-child(1)")).getText(), is("US"));
    driver.close();
  }
  @Test
  public void changeRegionUStoCA() {
    driver.get("https://www.costco.ca/");
    driver.manage().window().setSize(new Dimension(1017, 831));
    {
      WebElement element = driver.findElement(By.cssSelector("#country-select > .co-arrow-right"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector("#country-select > .co-arrow-right")).click();
    driver.findElement(By.cssSelector("#country-select > .co-arrow-right")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.linkText("Canada")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("#warehouse-locations-t > .top-button-title"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("#country-select > .co-arrow-right"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector("#country-select > .co-arrow-right")).click();
    driver.findElement(By.cssSelector("#country-select > .co-arrow-right")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("#country-select > .co-arrow-right"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.linkText("United States")).click();
    driver.findElement(By.cssSelector(".co-arrow-right:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".co-arrow-right:nth-child(3)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".co-arrow-right:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.linkText("Canada")).click();
    assertThat(driver.findElement(By.cssSelector("#country-select > span:nth-child(1)")).getText(), is("CA"));
    driver.close();
  }
  @Test
  public void changeRegionCAtoCA() {
    driver.get("https://www.costco.ca/");
    driver.manage().window().setSize(new Dimension(999, 719));
    {
      WebElement element = driver.findElement(By.id("country-select"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("#country-select > span:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector("#country-select > .co-arrow-right")).click();
    driver.findElement(By.cssSelector("#country-select > .co-arrow-right")).click();
    driver.findElement(By.linkText("Canada")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("#warehouse-locations-t > .top-button-title"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("#country-select > .co-arrow-right"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector("#country-select > .co-arrow-right")).click();
    driver.findElement(By.cssSelector("#country-select > .co-arrow-right")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("#country-select > .co-arrow-right"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.linkText("Canada")).click();
    assertThat(driver.findElement(By.cssSelector("#country-select > span:nth-child(1)")).getText(), is("CA"));
    driver.close();
  }
}