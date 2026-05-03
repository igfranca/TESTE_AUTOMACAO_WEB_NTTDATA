package br.com.nttdata.pageobjects.pages;

import br.com.nttdata.pageobjects.features.FeatureProduct;
import org.openqa.selenium.WebDriver;

public class PageProduct extends FeatureProduct {

  private WebDriver driver;

  public PageProduct(WebDriver getDriver) {
    this.driver = getDriver;
  }

  public String pegarValorDoProduto() {
    String pegarPrecoProduto = driver.findElement(valorProdutoPaginaProduto).getText();
    System.out.println("Preço do produto na página do produto: " + pegarPrecoProduto);
    return pegarPrecoProduto;
  }

  public void adicionarProdutoEIrSacola(){
    driver.findElement(adicionarProduto).click();
    driver.findElement(irSacola).click();
  }
}
