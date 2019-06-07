package br.com.cursoAppium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.MenuPage;
import br.com.cursoAppium.page.WebViewPage;

public class WebViewTest extends BaseTest{

	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		//acessar menu
		menu.acessarSBHibrido();
		menu.sleep(3000);
		page.entrarContextoWeb();
		
		//preencher email
		page.setEmail("a@a");
		
		//senha
		page.setSenha("a");
		
		//entrar
		page.entrar();
		
		//verificar mensagem de sucesso
		Assert.assertEquals("Bem vindo, Wagner!", page.getMensagem());
	}
	//alisson@teste   teste
	
	@After
	public void tearDown() {
		page.sairContextoWeb();
	}
	
}
