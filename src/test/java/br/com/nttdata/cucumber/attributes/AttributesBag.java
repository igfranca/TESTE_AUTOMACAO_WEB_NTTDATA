package br.com.nttdata.cucumber.attributes;

import org.openqa.selenium.By;

public class AttributesBag {
  public By produtoNaBag = By.xpath("//div[@class='clear-bag-link']");
  public By valorProdutoPaginaSacola =  By.xpath("//div[@data-testid='ptz-resume-value-subtotal']//span[contains(text(), 'R$')]");
}
