package br.com.cursoAppium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.AlertaPage;
import br.com.cursoAppium.page.MenuPage;

public class AlertTeste extends BaseTest{

	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	@Test
	public void deveConfirmarAlerta(){
		//Acessar menu alerta
		menu.acessarAlertas();
		
		//clicar em alerta confirma
		page.clicarAlertaConfirm();
		
		//verificar os textos
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		//confirmar alerta
		page.confirmar();
		
		//verificar nova mensagem
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		//sair
		page.sair();
	}
	
	@Test
	public void deveClicarForaAlerta() {
		//acessar menu alerta
		menu.acessarAlertas();
		
		//clicar alerta simples
		page.clicarAlertaSimples();
		
		//clicar fora da caixa
		//Clicar em 100, 150
		page.clicarForaCaixa();
		
		//verificar que a mensagem não está presente
		Assert.assertFalse(page.existeAlertaSimples());
	}
	
}
