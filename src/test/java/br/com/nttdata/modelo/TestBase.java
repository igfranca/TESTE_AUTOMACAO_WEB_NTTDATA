package br.com.nttdata.modelo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

  @Test
  public void testeModelo() throws InterruptedException {

    WebDriverManager.chromedriver().setup(); //Instanciar o setup do Chrome Driver por bonigarcia
    WebDriver driver = new ChromeDriver(); //Instanciar Chrome Driver
    driver.manage().window().maximize(); //Maximizar a tela
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    //Navegar para o site
    driver.get("https://www.petz.com.br/");

    //Clicar no botão continuar e fechar
    driver.findElement(By.xpath("//button[contains(text(), 'Prosseguir com todos')]")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

    driver.findElement(By.xpath("//p[@class='ptz-card-label-left']")).click();
    String valorDoProduto = driver.findElement(By.xpath("//p[@class='text-ptz-md font-bold']")).getText();
    System.out.println("Valor do produto: "+ valorDoProduto);

    // Aguarda o botão "Adicionar à sacola" ficar clicável
    WebElement botaoAdicionar = wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(text(),'Adicionar à sacola')]")
        )
    );

    // Clica no botão
    botaoAdicionar.click();



//    Thread.sleep(2);
//    driver.findElement(By.xpath("//button[@data-testid='add-to-cart-button']")).click();
//    Thread.sleep(2);
//    driver.findElement(By.xpath("//button[@data-testid='drawer-bag-checkout-button']")).click();



    //driver.quit(); // feche se quiser



  }
}
