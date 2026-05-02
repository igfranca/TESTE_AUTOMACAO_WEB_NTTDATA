package br.com.nttdata.modelo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

  private static WebDriver driver;

  @BeforeClass
  public static void setUpClass() {
    WebDriverManager.chromedriver().setup(); //Instanciar o setup do Chrome Driver por bonigarcia
    driver = new ChromeDriver(); //Instanciar Chrome Driver
    driver.manage().window().maximize(); //Maximizar a tela
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //Espera implícita 20 segundos
  }

  @Test
  public void testeModelo() throws InterruptedException {
    //Navegar para o site
    driver.get("https://www.petz.com.br/");

    //Clicar no botão aceitar Cookies
    driver.findElement(By.xpath("//button[contains(text(), 'Prosseguir com todos')]")).click();

    //Esperar 1 segundo antes de iniciar a busca
    Thread.sleep(1000);

    //Abrir Search, digitar o item desejado e apertar Enter
    driver.findElement(By.id("headerSearch")).sendKeys("Escada Baw & Miaw Grafite para Cães e Gatos" + Keys.ENTER);

    //Clicar no item da busca
    driver.findElement(By.xpath("//p[@class='ptz-card-label-left']")).click();

    //Pegar o valor do item na página do produto
    String valorDoItemNaPaginaDoProduto = driver.findElement(By.xpath("//p[@class='text-ptz-md font-bold']")).getText();

    //Imprimir na tela o valor do item na página do produto
    System.out.println("Valor do item na página do produto: " + valorDoItemNaPaginaDoProduto);

    //Clicar em Adicionar a sacola
    driver.findElement(By.xpath("//div[@class='ds-button w-full']")).click();

    //Clicar em ir para a sacola
    driver.findElement(By.xpath("/html/body/div[10]/div/div[2]/div[3]/div[2]/button")).click();

    //Pegar o valor do item na sacola
    String valorDoItemNaSacola = driver.findElement(By.xpath("//*[@id='cart-item-164109']/div/div[1]/div/div[2]/div[1]/div")).getText();

    //Imprimir na tela o valor do item na sacola
    System.out.println("Valor do item na sacola: " + valorDoItemNaSacola);

  }

  @AfterClass
  public static void tearDownClass() {
    driver.quit(); //Fechar o navegador e encerrar o Chrome Driver
  }
}
