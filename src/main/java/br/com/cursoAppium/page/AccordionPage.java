package br.com.cursoAppium.page;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;

public class AccordionPage extends BasePage {

	public void selecionarOp1() {
		clicarPorTexto("Opção 1");
	}
	
	//Via xpath, acessar a opcao 1, depois pula para o viwegroup do proximo nivel, depois pega o text d proximo textview
	public String obterValorOp1() {
		return obterTexto(By.xpath("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
	
	
}
