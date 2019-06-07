package br.com.cursoAppium.page;

import static br.com.cursoAppium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage{

	public void escreverNome(String nome) {
		escrever(By.id("nome"), nome);
	}

	public String obterNome() {
		return obterTexto(By.id("nome"));
	}

	public void selecionarCombo(String valor) {
		selecionarCombo(By.id("console"), valor);
	}

	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public void clicarCheck() {
		clicar(By.id("check"));
	}
	
	public void clicarSwitch() {
		clicar(By.id("switch"));
	}
	
	public void clicarSeekBar(double posicao) {
		//Valor a ser retirado do elemento devido a sobras no elemento
		int delta = 33;
		MobileElement seek = getDriver().findElement(By.id("slid"));
		//Pega a posicao do ponto esquerdo na altura, verifica a metade do elemento
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		System.out.println(y);
		
		//Pega o tamanho da largura do elemento e multiplica pela porcentagem passada
		int xinicial = seek.getLocation().x + delta;
		int x = (int) (xinicial + ((seek.getSize().width - 2 * delta)* posicao));
		System.out.println(x);
		
		tap(x, y);
	}

	public boolean isCheckMarcado() {
		return isCheckedMarcado(By.id("check"));
	}
	
	public boolean isSwitchMarcado() {
		return isCheckedMarcado(By.id("switch"));
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void salvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO");
	}
	
	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}
	
	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String obterCheckCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}
	
	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}
	
	public void clicarData() {
		clicarPorTexto("01/01/2000");
	}
	
	public void selecionarDiaData(String dia) {
		clicarPorTexto(dia);
		clicarPorTexto("OK");
	}
	
	public boolean verificarData(String data) {
		return existeElementoPorTexto(data);
	}
}
