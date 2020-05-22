package Testes;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Constante.ChamadaMassa;
import Constante.ScreenShotCapture;
import Constante.Utils;
import Funcoes.ConfigFunction;
import Telas.TelaProgramacao;

/********************************************************************
 * @category Teste para realizar a consulta de programacao atual
 ********************************************************************/

public class Programacao {

	private WebDriver driver;

	ChamadaMassa massaDados = new ChamadaMassa();
	//ScreenShotCapture telaScreen = new ScreenShotCapture();

	@Before
	public void IniciarBrowser() {

		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void RealizarConsultaProgramacao() {

		try {

			ConfigFunction config = new ConfigFunction(driver);
			TelaProgramacao program = new TelaProgramacao(driver);

			config.acessar();
			ScreenShotCapture.screenShot();
			program.FecharModal();
			ScreenShotCapture.screenShot();
			program.Programacao();
			Utils.WaitElement();
			ScreenShotCapture.screenShot();
			program.ButtonProgramacaoAtual();
			ScreenShotCapture.screenShot();
			Utils.MoverElemento();
			program.ProgramacaoAtual();
			ScreenShotCapture.screenShot();
			program.ValidacaoProgramacao();
			ScreenShotCapture.screenShot();
			ScreenShotCapture.arquivosDir();

		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
		}

	}

//	@After
//	public void FinalizarExecucao() {
//		driver.quit();
//	}

}
