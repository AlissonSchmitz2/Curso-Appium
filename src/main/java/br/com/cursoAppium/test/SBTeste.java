package br.com.cursoAppium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.MenuPage;
import br.com.cursoAppium.seuBarriga.SBContasPage;
import br.com.cursoAppium.seuBarriga.SBHomePage;
import br.com.cursoAppium.seuBarriga.SBLoginPage;
import br.com.cursoAppium.seuBarriga.SBMenuPage;
import br.com.cursoAppium.seuBarriga.SBMovimentacaoPage;
import br.com.cursoAppium.seuBarriga.SBResumoPage;

public class SBTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();
	
	@Before
	public void setup() {
		menu.acessarSBNativo();
		login.setEmail("alisson@teste");
		login.setSenha("teste");
		login.entrar();
	}

	@Test
	public void deveInserirContaComSucesso() {
		// entrar em contas
		menuSB.acessarContas();

		// digitar nome conta
		contas.setConta("Conta de Teste");

		// salvar
		contas.salvar();

		// verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}

	@Test
	public void deveExcluirConta() {
		// entrar em contas
		menuSB.acessarContas();
		
		//clique longo na conta 
		contas.selecionarConta("123");
		
		//excluir
		contas.excluir();
		
		//verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void deveValidarInclusaoMov() {
		menuSB.acessarMovimentacoes();
		
		//validar desc
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));
		
		//validar inte
		mov.setDescricao("Desc");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));
		
		//validar valor
		mov.setInteressado("Interss");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));
		
		//validar conta
		mov.setValor("Conta para saldo");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));
		
		//inserir com sucesso
		mov.setConta("conta");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
	}
	
	@Test
	public void deveAtualizarSaldoAoExcluirMovimentacao() {
//		home.reset();
		
		// verificar saldo para "Conta para saldo" = 534.00
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		
		//ir para resumo
		menuSB.acessarResumo();
		
		//excluir Movimentacao 3 
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
		
		//validar mensagem "Movimentação removida com sucesso!"
		Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));
		
		//voltar para home
		menuSB.acessarHome();
		
		//atualizar saldos
		home.sleep(2000);
		home.scroll(0.2, 0.9);
		
		//verificar saldo = -1000.00
		Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
	}
}
