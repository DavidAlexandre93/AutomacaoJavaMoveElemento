package Telas;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Constante.ChamadaMassa;

public class TelaProgramacao {

	private WebDriver driver;
	ChamadaMassa massaDados = new ChamadaMassa();
	

	public TelaProgramacao(WebDriver driver) {
		this.driver = driver;
	}

	/********************************************************************
	 * @category Clicar em close para fechar a Modal
	 ********************************************************************/
	public TelaProgramacao FecharModal() {
		driver.findElement(By.xpath("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_YQcCxObpxg0J\"]/div/div[2]/div/div[2]/div/div/div/div[1]/button")).click();
		return this;
	}

	/********************************************************************
	 * @category Clicar no menu em Programação
	 *********************************************************************/
	public TelaProgramacao Programacao() {
		driver.findElement(By.linkText("Programação")).click();
		return this;
	}
	
	/********************************************************************
	 * @category Clicar no botao programacao atual
	 *********************************************************************/
	public TelaProgramacao ButtonProgramacaoAtual() {
		driver.findElement(By.xpath("//*[@id=\"schedules-container\"]/div[1]")).click();
		driver.findElement(By.linkText("50")).click();
		return this;
	}
	
	

	/********************************************************************
	 * @category Clicar na programacao atual
	 ********************************************************************/
	public TelaProgramacao ProgramacaoAtual() {
		driver.findElement(By.xpath("//*[@id=\"schedules-container\"]/div[4]/div[3]/div/div/div[3]/div[2]/div/div/div/div[4]/div/div[1]/h2")).click();
		return this;
	}

	/********************************************************************
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @category Validar Programacao Atual
	 ********************************************************************/

	public TelaProgramacao ValidacaoProgramacao() throws FileNotFoundException, IOException, ParseException {
		JSONObject obj = massaDados.dadosJson();
		driver.findElement(By.xpath("//*[@id=\"schedules-container\"]/div[4]/div[3]/div/div/div[3]/div[2]/div/div/div/div[4]/div/div[1]/h2")).getText().equals((String)obj.get("programacaoAtual"));
		return this;
	}

}
