package br.com.nttdata.selenium.pageobjects.pages;

import br.com.nttdata.selenium.pageobjects.features.FeatureProduct;
import org.openqa.selenium.WebDriver;

public class PageProduct extends FeatureProduct {

  private WebDriver driver;

  public PageProduct(WebDriver getDriver) {
    this.driver = getDriver;
  }

  public String pegarValorDoProduto() {
    return driver.findElement(valorProdutoPaginaProduto).getText();
  }

  public void adicionarProdutoEIrSacola(){
    driver.findElement(adicionarProduto).click();
    driver.findElement(irSacola).click();
  }
}
