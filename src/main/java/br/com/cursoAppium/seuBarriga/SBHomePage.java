package br.com.cursoAppium.seuBarriga;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;

public class SBHomePage extends BasePage {

	public String obterSaldoConta(String conta) {
		return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
	}
	
	public void reset() {
		clicarPorTexto("RESET");
	}
	
}
