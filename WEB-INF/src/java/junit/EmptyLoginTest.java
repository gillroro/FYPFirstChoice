package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmptyLoginTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEmptyLogin() throws Exception {
    driver.get(baseUrl + "FYPFirstChoice/");
    driver.findElement(By.id("Login_Username")).clear();
    driver.findElement(By.id("Login_Username")).sendKeys("");
    driver.findElement(By.id("Login_Password")).clear();
    driver.findElement(By.id("Login_Password")).sendKeys("");
    driver.findElement(By.id("Login_0")).click();
    try {
      assertEquals("Invalid username", driver.findElement(By.cssSelector("div.errorMessage")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Invalid Password", driver.findElement(By.cssSelector("#wwerr_Login_Password > div.errorMessage")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
