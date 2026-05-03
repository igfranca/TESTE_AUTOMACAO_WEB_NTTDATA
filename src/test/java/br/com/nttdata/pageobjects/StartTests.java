package br.com.nttdata.pageobjects;

import br.com.nttdata.pageobjects.pages.PageBag;
import br.com.nttdata.pageobjects.pages.PageHome;
import br.com.nttdata.pageobjects.pages.PageProduct;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StartTests {

  public static WebDriver driver;

  @BeforeClass
  public static void setUpClass() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  @Test
  public void CN1_BuscarEValidarOProduto() throws InterruptedException {
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

    //Produto Visível na sacola
//    boolean estaNoCarrinho = pageBag.verificaProdutoNaBag();
//    assertTrue("O produto deve estar visível na bag", estaNoCarrinho);

  }

  @AfterClass
  public static void tearDownClass() {
    driver.quit();
  }
}
