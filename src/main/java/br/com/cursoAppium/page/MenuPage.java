package br.com.cursoAppium.page;

import static br.com.cursoAppium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cursoAppium.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarFormulario() {
		clicarPorTexto("Formul�rio");
	}

	public void acessarSplash() {
		clicarPorTexto("Splash");
	}

	public void acessarAlertas() {
		clicarPorTexto("Alertas");
	}

	public void acessarAbas() {
		clicarPorTexto("Abas");
	}

	public void acessarAccordion() {
		clicarPorTexto("Accordion");
	}

	public void acessarCliques() {
		clicarPorTexto("Cliques");
	}

	public void acessarOpcaoBemEscondida() {
		clicarPorTexto("Op��o bem escondida");
	}

	public void acessarSwipe() {
		clicarPorTexto("Swipe");
	}

	public void acessarSwipeList() {
		// Aguarda carregar a janela principal
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		scrollDown();
		clicarPorTexto("Swipe List");
	}
	
	public void acessarDragDrop() {
		// Aguarda carregar a janela principal
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		scrollDown();
		clicarPorTexto("Drag and drop");
	}
	
	public void acessarSBHibrido() {
		clicarPorTexto("SeuBarriga H�brido");
	}

	public void acessarSBNativo() {
		clicarPorTexto("SeuBarriga Nativo");
	}
}
