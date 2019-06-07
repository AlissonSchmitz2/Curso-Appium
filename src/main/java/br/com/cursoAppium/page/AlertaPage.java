package br.com.cursoAppium.page;

import br.com.cursoAppium.core.BasePage;

public class AlertaPage extends BasePage {

	public void clicarAlertaConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public void confirmar() {
		clicarPorTexto("CONFIRMAR");
	}
	
	public void sair() {
		clicarPorTexto("SAIR");
	}
	
	public void clicarAlertaSimples() {
		clicarPorTexto("ALERTA SIMPLES");
	}
	
	public void clicarForaCaixa() {
		tap(100, 150);
	}
	
	public boolean existeAlertaSimples() {
		return existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair");
	}
}
