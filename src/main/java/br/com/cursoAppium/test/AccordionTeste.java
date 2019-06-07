package br.com.cursoAppium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.AccordionPage;
import br.com.cursoAppium.page.MenuPage;

public class AccordionTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		//Acessar menu
		menu.acessarAccordion();
		
		//clicar op 1
		page.selecionarOp1();
		
		//verificar texto op 1
		Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
		
	}
	
	
}
