package br.com.cursoAppium.seuBarriga;

import static br.com.cursoAppium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;
import io.appium.java_client.MobileElement;

public class SBResumoPage extends BasePage {

	public void excluirMovimentacao(String desc) {
		MobileElement el = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
		swipeElementRight(el);
		clicarPorTexto("Del");
	}
	
}
