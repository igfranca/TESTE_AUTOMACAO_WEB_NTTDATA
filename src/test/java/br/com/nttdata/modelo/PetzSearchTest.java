package br.com.nttdata.modelo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PetzSearchTest {

  @Test
  public void pesquisarProduto() {

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("https://www.petz.com.br/");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // 1. Esperar o campo de busca ficar clicável
    WebElement campoBusca = wait.until(
        ExpectedConditions.elementToBeClickable(By.id("headerSearch"))
    );

    // 2. Clicar no campo
    campoBusca.click();

    // 3. Digitar o texto
    campoBusca.sendKeys("Escada Baw & Miaw Grafite para Cães e Gatos");

    // 4. Pressionar ENTER
    campoBusca.sendKeys(Keys.ENTER);

    // (opcional) aguardar a página de resultados carregar
    wait.until(ExpectedConditions.urlContains("Escada"));

    // driver.quit(); // feche se quiser
  }
}