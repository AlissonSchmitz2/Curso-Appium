package br.com.cursoAppium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.AbasPage;
import br.com.cursoAppium.page.MenuPage;

public class AbasTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();
	
	@Test
	public void deveInteragirComAbas() {
		//acessar menu abas
		menu.acessarAbas();
		
		//verificar que esta na aba 1
		Assert.assertTrue(page.isAba1());
		
		//acessar aba 2
		page.clicarAba2();
		
		//verificar que esta na aba 2
		Assert.assertTrue(page.isAba2());
	}
	
	
	
}
