package br.com.cursoAppium.page;

import static br.com.cursoAppium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;

public class SwipeElementPage extends BasePage {

	public void SwipeElementLeft(String opcao) {
		swipeElementLeft(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")));
	}
	
	public void SwipeElementRight(String opcao) {
		swipeElementRight(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")));
	}
	
	public void clicarBotaoMais() {
		clicar(By.xpath("//*[@text='(+)']/.."));
	}
	
	public void clicarBotaoMenos() {
		clicar(By.xpath("//*[@text='(-)']/.."));
	}	
}
