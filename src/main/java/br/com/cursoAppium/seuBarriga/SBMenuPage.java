package br.com.cursoAppium.seuBarriga;

import br.com.cursoAppium.core.BasePage;

public class SBMenuPage extends BasePage {

	public void acessarContas() {
		clicarPorTexto("CONTAS");
	}
	
	public void acessarMovimentacoes() {
		clicarPorTexto("MOV...");
	}
	
	public void acessarResumo() {
		clicarPorTexto("RESUMO");
	}
	
	public void acessarHome() {
		clicarPorTexto("HOME");
	}
	
}
