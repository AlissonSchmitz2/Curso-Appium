package br.com.cursoAppium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.core.DriverFactory;
import br.com.cursoAppium.page.FormularioPage;
import br.com.cursoAppium.page.MenuPage;

//Preferencias por busca de elemtentos
// id e content-desc: O melhor, não ocorre problema
// class: Vários elementos podem possuir a mesma classe. Deve percorrer os
// elementos
// Pode ocorrer problema na busca caso seja alterada no desenv.

public class FormularioTeste extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		
		//Selecionar formulário
		menuPage.acessarFormulario();
	}
	
	@Test
	public void DeveEscreverNome() throws MalformedURLException {
		
		page.escreverNome("Alisson");
		
		Assert.assertEquals("Alisson", page.obterNome());
	}

	@Test
	public void DeveInteragirCombo() throws MalformedURLException {
		// clicar no combo
		page.selecionarCombo("Nintendo Switch");

		// verificar opcao selecionada
		// Pegar o TextView que está abaixo do Spinner que é o combo
		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}

	@Test
	public void DeveInteragirSwitchCheckBox() throws MalformedURLException {
		// verificar status dos elementos
		
		Assert.assertFalse(page.isCheckMarcado()); // Pegando pelo atributo do elemento
		Assert.assertTrue(page.isSwitchMarcado()); // Pegando pelo atributo do elemento

		// clicar nos elementos
		page.clicarCheck();
		page.clicarSwitch();

		// verificar estados alterados
		Assert.assertTrue(page.isCheckMarcado()); // Pegando pelo atributo do elemento
		Assert.assertFalse(page.isSwitchMarcado()); // Pegando pelo atributo do elemento

	}

	@Test
	public void DeveRealizaCadastro() throws MalformedURLException {
		// clica no componente pelo clasname
		page.escreverNome("Preenchendo nome");
		// clica Checkbox
		page.clicarCheck();
		// clica no segundo Checkbox
		page.clicarSwitch();
		// clica no checkbox
		page.selecionarCombo("PS4");

		// Salvar
		// clica no botao salvar via path e via atributo "text"
		page.salvar();

		// Validando elementos da janela
		// Pegando o elemento por path que começa com o atributo text "Nome:"
		Assert.assertEquals("Nome: Preenchendo nome", page.obterNomeCadastrado());
		Assert.assertEquals("Console: ps4", page.obterConsoleCadastrado());
		Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));
	}
	
	@Test
	public void DeveRealizaCadastroDemorado() throws MalformedURLException {
		// clica no componente pelo clasname
		page.escreverNome("Preenchendo nome");

		// Salvar
		page.salvarDemorado();
		
		//Aguarda o elemento aparecer, usar caso a implicita não funcione em algum ponto
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Preenchendo nome']")));
		
		// Validando elementos da janela
		Assert.assertEquals("Nome: Preenchendo nome", page.obterNomeCadastrado());
	}
	
	@Test
	public void deveAlterarData() {
		page.clicarData();
		page.selecionarDiaData("15");
		Assert.assertTrue(page.verificarData("15/2/2000"));
	}
	
	@Test
	public void deveInteragirComSeekBar() {
		//Clicar no seekBar
		page.clicarSeekBar(0.50);
		
		//salvar
		page.salvar();
		
		//obter o valor
		
	}
}
