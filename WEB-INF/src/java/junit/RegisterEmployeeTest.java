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
import org.openqa.selenium.support.ui.Select;

public class RegisterEmployeeTest {
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
  public void testRegisterEmployee() throws Exception {
    driver.get(baseUrl + "FYP/");
    driver.findElement(By.id("Login_Username")).clear();
    driver.findElement(By.id("Login_Username")).sendKeys("gillian");
    driver.findElement(By.id("Login_Password")).clear();
    driver.findElement(By.id("Login_Password")).sendKeys("test");
    driver.findElement(By.id("Login_0")).click();
    driver.findElement(By.linkText("Register Employee")).click();
    driver.findElement(By.id("Register_newFirstName")).clear();
    driver.findElement(By.id("Register_newFirstName")).sendKeys("Sarah");
    driver.findElement(By.id("Register_surname")).clear();
    driver.findElement(By.id("Register_surname")).sendKeys("Test");
    driver.findElement(By.id("Register_Username")).clear();
    driver.findElement(By.id("Register_Username")).sendKeys("sarahtest12");
    driver.findElement(By.id("Register_Password")).clear();
    driver.findElement(By.id("Register_Password")).sendKeys("test");
    driver.findElement(By.id("Register_Address")).clear();
    driver.findElement(By.id("Register_Address")).sendKeys("Dublin");
    driver.findElement(By.id("Register_Salary")).clear();
    driver.findElement(By.id("Register_Salary")).sendKeys("12345");
    driver.findElement(By.id("Register_UserType")).clear();
    driver.findElement(By.id("Register_UserType")).sendKeys("employee");
    new Select(driver.findElement(By.id("Register_firstName"))).selectByVisibleText("Gillian");
    driver.findElement(By.id("Register_0")).click();
    try {
      assertEquals("Employee Registered", driver.findElement(By.cssSelector("h4.center")).getText());
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
