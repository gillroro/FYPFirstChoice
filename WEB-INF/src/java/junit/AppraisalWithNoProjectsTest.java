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

public class AppraisalWithNoProjectsTest {
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
  public void testAppraisalWithNoProjects() throws Exception {
    driver.get(baseUrl + "FYP/");
    driver.findElement(By.id("Login_Username")).clear();
    driver.findElement(By.id("Login_Username")).sendKeys("poppy");
    driver.findElement(By.id("Login_Password")).clear();
    driver.findElement(By.id("Login_Password")).sendKeys("test");
    driver.findElement(By.id("Login_0")).click();
    driver.findElement(By.linkText("Self Appraise")).click();
    driver.findElement(By.id("Appraisal_accomplishments")).clear();
    driver.findElement(By.id("Appraisal_accomplishments")).sendKeys("accomplishments");
    driver.findElement(By.id("Appraisal_barriers")).clear();
    driver.findElement(By.id("Appraisal_barriers")).sendKeys("barriers");
    driver.findElement(By.id("Appraisal_improvements")).clear();
    driver.findElement(By.id("Appraisal_improvements")).sendKeys("improvement");
    driver.findElement(By.id("Appraisal_performance")).clear();
    driver.findElement(By.id("Appraisal_performance")).sendKeys("knowledge");
    driver.findElement(By.id("Appraisal_attendanceRecordVery Good")).click();
    driver.findElement(By.id("Appraisal_respectRecordAverage Respect for others")).click();
    new Select(driver.findElement(By.id("Appraisal_firstName"))).selectByVisibleText("Mary");
    driver.findElement(By.id("Appraisal_Appraisal")).click();
    try {
      assertEquals("Self Appraisal Complete", driver.findElement(By.cssSelector("h6.center")).getText());
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
