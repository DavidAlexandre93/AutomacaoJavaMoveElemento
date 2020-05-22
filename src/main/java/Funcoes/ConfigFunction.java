package Funcoes;

import org.openqa.selenium.WebDriver;

import Dados.DadosTeste;


public class ConfigFunction {
	
	private WebDriver driver;
	
	public ConfigFunction(WebDriver driver) {
		this.driver = driver;
	}
	

/********************************************************************
* @category Capturar com get a URL setada no teste
********************************************************************/
	public ConfigFunction acessar() {
		driver.get(DadosTeste.LINK);
		return this;
	}
	
public ConfigFunction seleniumDrig() {
	driver.get(DadosTeste.HUB);
	return this;
  }
}
