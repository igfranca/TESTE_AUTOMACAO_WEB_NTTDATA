package br.com.nttdata.pageobjects;

import br.com.nttdata.pageobjects.pages.PageHome;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RunnerTests {

  private static WebDriver driver;

  @BeforeClass
  public static void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

  }

  @Test
  public void cenario1() {
    //Instâncias
    PageHome pageHome = new PageHome(driver);

    //Home
    pageHome.acessarOSite();
    pageHome.clicarNoAvisoDeCookie();




  }






//  @AfterClass
//  public static void teardown() {
//    driver.quit();
//  }

}
