package br.com.nttdata.pageobjects.pages;

import br.com.nttdata.pageobjects.features.FeatureHome;
import org.openqa.selenium.WebDriver;

public class PageHome extends FeatureHome {

  private WebDriver driver;

  public PageHome(WebDriver getDriver) {
    this.driver = getDriver;
  }

  public void acessarOSite() {
    driver.get("https://www.petz.com.br/");
  }

  public void clicarNoAvisoDeCookie() {
    driver.findElement(clicarAvisoCookie).click();
  }
}
