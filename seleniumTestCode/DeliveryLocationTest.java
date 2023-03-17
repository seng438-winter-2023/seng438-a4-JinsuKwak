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
public class DeliveryLocationTest {
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
  public void changeDeliveryLocationInvalid() {
    driver.get("https://www.costco.ca/");
    driver.manage().window().setSize(new Dimension(999, 719));
    driver.findElement(By.cssSelector(".css-1jvjmvl > .MuiButtonBase-root")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".css-1jvjmvl > .MuiButtonBase-root"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.id("zipCode")).click();
    driver.findElement(By.id("zipCode")).sendKeys("A2S 2G1");
    driver.findElement(By.cssSelector(".MuiButton-primary")).click();
    assertThat(driver.findElement(By.id("zipCode-helper-text")).getText(), is("Please enter a valid Postal code."));
  }
  @Test
  public void changeDeliveryLocationValidCanada() {
    driver.get("https://www.costco.ca/");
    driver.manage().window().setSize(new Dimension(999, 719));
    driver.findElement(By.cssSelector(".css-1jvjmvl > .MuiButtonBase-root")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".css-1jvjmvl > .MuiButtonBase-root"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".MuiBackdrop-root"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector(".css-1jvjmvl > .MuiButtonBase-root")).click();
    driver.findElement(By.id("zipCode")).click();
    driver.findElement(By.id("zipCode")).click();
    driver.findElement(By.id("zipCode")).sendKeys("T2N 1N4");
    driver.findElement(By.cssSelector(".MuiButton-primary")).click();
    assertThat(driver.findElement(By.cssSelector(".css-1jvjmvl > .MuiButtonBase-root")).getText(), is("T2N 1N4"));
  }
}