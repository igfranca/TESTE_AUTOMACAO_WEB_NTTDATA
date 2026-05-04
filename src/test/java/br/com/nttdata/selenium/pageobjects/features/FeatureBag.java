package br.com.nttdata.selenium.pageobjects.features;

import org.openqa.selenium.By;

public class FeatureBag {
  public By valorProdutoPaginaSacola =  By.xpath("//div[@data-testid='ptz-resume-value-subtotal']//span[contains(text(), 'R$')]");
}
