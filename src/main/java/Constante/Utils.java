package Constante;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utils {

	private static WebDriver driver;

	public Utils(WebDriver driver) {
		Utils.driver = driver;
	}

	/********************************************************************
	 * @category Clicar em Ok no pop-up
	 ********************************************************************/
	public static void AlertOK() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/********************************************************************
	 * @category Teste parado por determinado tempo setado
	 ********************************************************************/
	public static void WaitElement() throws InterruptedException {
		Thread.sleep(5 * 1000);
	}

	public static void ScrollParaCima() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("javascript:window.scroll(0, -250)");

	}

	public static void ScrollParaBaixo() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("javascript:window.scrollBy(0,200)");

	}

	public static void MoverElemento() throws InterruptedException {

		WebElement element = driver.findElement(By.className("virtual-list"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

}
