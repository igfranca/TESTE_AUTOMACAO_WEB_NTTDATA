package br.com.nttdata.pageobjects.features;

import org.openqa.selenium.By;

public class FeatureHome {
  public By botaoCookie = By.xpath("//button[contains(text(), 'Prosseguir com todos')]");
  public By campoBusca = By.id("headerSearch");
  public By itemSelecionado = By.xpath("//p[@class='ptz-card-label-left']");
}
