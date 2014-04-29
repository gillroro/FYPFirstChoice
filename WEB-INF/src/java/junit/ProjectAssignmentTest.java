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

public class ProjectAssignmentTest {
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
  public void testProjectAssignment() throws Exception {
    driver.get(baseUrl + "FYP/");
    driver.findElement(By.id("Login_Username")).clear();
    driver.findElement(By.id("Login_Username")).sendKeys("gillian");
    driver.findElement(By.id("Login_Password")).clear();
    driver.findElement(By.id("Login_Password")).sendKeys("test");
    driver.findElement(By.id("Login_0")).click();
    driver.findElement(By.linkText("Manage Projects")).click();
    driver.findElement(By.linkText("Assign Employee")).click();
    new Select(driver.findElement(By.id("CompleteAssignment_projectName"))).selectByVisibleText("iOS App Development");
    new Select(driver.findElement(By.id("CompleteAssignment_firstName"))).selectByVisibleText("Sarah");
    driver.findElement(By.id("CompleteAssignment_Assign")).click();
    try {
      assertEquals("Project Assignment Complete", driver.findElement(By.cssSelector("h4.center")).getText());
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
