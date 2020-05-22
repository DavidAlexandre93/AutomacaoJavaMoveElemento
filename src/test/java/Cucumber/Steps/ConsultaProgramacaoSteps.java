package Cucumber.Steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Constante.ChamadaMassa;
import Constante.ScreenShotCapture;

public class ConsultaProgramacaoSteps {

	private static WebDriver driver;
	static ChamadaMassa massaDados = new ChamadaMassa();

	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.sky.com.br/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ScreenShotCapture.screenShot();
	}

	public void FecharModal() {
		driver.findElement(By.xpath(
				"//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_YQcCxObpxg0J\"]/div/div[2]/div/div[2]/div/div/div/div[1]/button"))
				.click();
		ScreenShotCapture.screenShot();
	}

	public void Programacao() {
		driver.findElement(By.linkText("Programação")).click();
	}

	public void ButtonProgramacaoAtual() {
		driver.findElement(By.xpath("//*[@id=\"schedules-container\"]/div[1]")).click();
	}

	public void ProgramacaoAtual() {
		ScreenShotCapture.screenShot();
		driver.findElement(By.xpath(
				"//*[@id=\"schedules-container\"]/div[4]/div[3]/div/div/div[1]/div[2]/div/div/div/div[4]/div/div[1]/h2"))
				.click();
	}

	public void ValidacaoProgramacao() throws FileNotFoundException, IOException, ParseException {
		ScreenShotCapture.screenShot();
		JSONObject obj = massaDados.dadosJson();
		driver.findElement(By.cssSelector("tr[class='program-schedule-title']")).getText()
				.equals((String) obj.get("programacaoAtual"));
	}

	public void Evidencias() throws Exception {
		ScreenShotCapture.screenShot();
		ScreenShotCapture.arquivosDir();
	}

}
