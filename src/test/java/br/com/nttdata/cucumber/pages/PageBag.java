package br.com.nttdata.cucumber.pages;

import br.com.nttdata.cucumber.attributes.AttributesBag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBag extends AttributesBag {

  private WebDriver driver;

  public PageBag(WebDriver getdriver) {
    this.driver = getdriver;
  }

  public boolean verificaProdutoNaBag() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    boolean estaExibindoProduto = wait.until(ExpectedConditions.visibilityOfElementLocated(produtoNaBag)).isDisplayed();
    return estaExibindoProduto;
  }

  public String pegarValorDoProdutoNaSacola() {
    String pegarPrecoProdutoSacola = driver.findElement(valorProdutoPaginaSacola).getText();
    System.out.println("Preço do produto na página da sacola: " +  pegarPrecoProdutoSacola);
    return pegarPrecoProdutoSacola;
  }
}
