package br.com.nttdata.selenium.pageobjects.pages;

import br.com.nttdata.selenium.pageobjects.features.FeatureBag;
import org.openqa.selenium.WebDriver;

public class PageBag extends FeatureBag {

  private WebDriver driver;

  public PageBag(WebDriver getdriver) {
    this.driver = getdriver;
  }

  public String pegarValorDoProdutoNaSacola() {
    return driver.findElement(valorProdutoPaginaSacola).getText();
  }
}
