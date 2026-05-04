package br.com.nttdata.cucumber.hooks;

import br.com.nttdata.cucumber.support.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

  @Before()
  public void beforeScenario() {
    DriverManager.initDriver();
  }


  @After()
  public void afterScenario() {
    DriverManager.quitDriver();
  }
}
