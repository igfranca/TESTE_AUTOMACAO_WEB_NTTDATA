package br.com.nttdata.selenium.pageobjects;

import br.com.nttdata.selenium.pageobjects.pages.PageBag;
import br.com.nttdata.selenium.pageobjects.pages.PageHome;
import br.com.nttdata.selenium.pageobjects.pages.PageProduct;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class StartTests {

  public static WebDriver driver;

  @BeforeClass
  public static void setUpClass() {
    WebDriverManager.chromedriver().setup(); //Instanciar o setup do Chrome Driver por bonigarcia
    ChromeOptions options = new ChromeOptions(); //Instanciar o Chrome Options
    options.addArguments("--force-device-scale-factor=0.9"); //Diminuir a escala dá página
    driver = new ChromeDriver(options); //Instanciar Chrome Driver
    driver.manage().window().maximize(); //Maximizar a tela
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //Espera implícita 20 segundos
  }

  @Test
  public void BuscarEValidarOProduto() throws InterruptedException {
    PageHome pageHome = new PageHome(driver);
    PageProduct pageProduct = new PageProduct(driver);
    PageBag pageBag = new PageBag(driver);

    //Acessar o site, aceitar os cookies e pesquisar o produto desejado
    pageHome.acessarOSite();
    pageHome.clicarNoBotaoCookie();
    pageHome.clicarNaPesquisaEDigitarItem("Escada Baw & Miaw Grafite para Cães e Gatos");

    //Buscar o preço do produto na página do produto e adicionar na sacola
    String precoProduto = pageProduct.pegarValorDoProduto();
    pageProduct.adicionarProdutoEIrSacola();

    //Buscar o preço do produto na página sacola
    String precoSacola = pageBag.pegarValorDoProdutoNaSacola();

    System.out.println("Preço do produto na página do produto: " + precoProduto);
    System.out.println("Preço do produto na página da sacola: " +  precoSacola);

    if (precoProduto.equals(precoSacola)) {
      System.out.println("Os valores da página do produto e página da sacola estão corretos");
    } else System.out.println("Os valores da página do produto e página da sacola não estão corretos");

  }

  @AfterClass
  public static void tearDownClass() {
    driver.quit();
  }
}
