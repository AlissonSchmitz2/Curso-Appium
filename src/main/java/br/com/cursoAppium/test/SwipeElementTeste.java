package br.com.cursoAppium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.MenuPage;
import br.com.cursoAppium.page.SwipeElementPage;

public class SwipeElementTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SwipeElementPage page = new SwipeElementPage();
	
	@Test
	public void deveResolverDesafio() {
		//1 - Clicar swipe list
		menu.acessarSwipeList();
		
		//2 - op2 para direita
		page.SwipeElementRight("Opção 1");
		
		//3 - op1+
		page.clicarBotaoMais();
		
		//4 - verificar op1+
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 1 (+)"));
		
		//5 - op4 para direita 
		page.SwipeElementRight("Opção 4");
		
		//6 - op4 - 
		page.clicarBotaoMenos();
		
		//7 - verificar op4-
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 4 (-)"));
		
		//8 - op5 para esquerda
		page.SwipeElementLeft("Opção 5 (-)");
		
		//9 - verificar op5
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 5"));
	}
	
}
