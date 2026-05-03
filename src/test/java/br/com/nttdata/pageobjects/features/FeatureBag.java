package br.com.nttdata.pageobjects.features;

import org.openqa.selenium.By;

public class FeatureBag {
  public By produtoNaBag = By.xpath("//div[@class='clear-bag-link']");
  public By valorProdutoPaginaSacola =  By.xpath("//div[@data-testid='ptz-resume-value-subtotal']//span[contains(text(), 'R$')]");
}
