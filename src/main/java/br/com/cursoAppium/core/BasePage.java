package br.com.cursoAppium.core;

import static br.com.cursoAppium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	protected void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	protected String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	protected void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
	
	protected void clicarPorID(String id) {
		clicar(By.id(id));
	}
	
	protected void selecionarCombo(By by, String valor) {
		clicar(by);
		clicarPorTexto(valor);
	}
	
	protected boolean isCheckedMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size() > 0;
	}
	
	@SuppressWarnings("rawtypes")
	protected void tap(int x, int y) {
		new TouchAction(getDriver()).tap(PointOption.point(x,y)).perform();
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void scroll(double inicio, double fim) {
		//tamanho da tela do dispositivo
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width / 2;
		
		int inicio_y = (int) (size.height * inicio);
		int fim_y = (int) (size.height * fim);
		
		new TouchAction(getDriver())
			.press(PointOption.point(x, inicio_y))
			.waitAction(Duration.ofMillis(500))
			.moveTo(x, fim_y)
			.release()
			.perform();
	}
	
	public void scrollDown() {
		scroll(0.9, 0.1);
	}
	
	public void scrollUp() {
		scroll(0.1, 0.9);
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void swipe(double inicio, double fim) {
		//tamanho da tela do dispositivo
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height / 2;
		
		int inicio_x = (int) (size.width * inicio);
		int fim_x = (int) (size.width * fim);
		
		new TouchAction(getDriver())
			.press(PointOption.point(inicio_x, y))
			.waitAction(Duration.ofMillis(500))
			.moveTo(fim_x, y)
			.release()
			.perform();
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void swipeElement(MobileElement elemento, double inicio, double fim) {
		//tamanho do elemento
		
		int y = elemento.getLocation().y + (elemento.getSize().height / 2);
		
		int inicio_x = (int) (elemento.getSize().width * inicio);
		int fim_x = (int) (elemento.getSize().width * fim);
		
		new TouchAction(getDriver())
			.press(PointOption.point(inicio_x, y))
			.waitAction(Duration.ofMillis(500))
			.moveTo(fim_x, y)
			.release()
			.perform();
	}
	
	protected void swipeElementLeft(MobileElement elemento) {
		swipeElement(elemento, 0.1, 0.9);
	}
	
	protected void swipeElementRight(MobileElement elemento) {
		swipeElement(elemento, 0.9, 0.1);
	}
	
	public void swipeLeft() {
		swipe(0.1, 0.9);
	}
	
	public void swipeRight() {
		swipe(0.9, 0.1);
	}
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}
	
	public void sleep(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void cliqueLongo(By by) {
		sleep(2000);
		new TouchAction(getDriver())
		.longPress((getDriver().findElement(by)))
		.perform();
	}
}
