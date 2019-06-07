package br.com.cursoAppium.page;

import br.com.cursoAppium.core.BasePage;

public class AbasPage extends BasePage{

	public boolean isAba1() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 1");
	}
	
	public boolean isAba2() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 2");
	}

	public void clicarAba2() {
		clicarPorTexto("ABA 2");
	}
	
}
