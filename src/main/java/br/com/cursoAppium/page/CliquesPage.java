package br.com.cursoAppium.page;

import static br.com.cursoAppium.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;

public class CliquesPage extends BasePage {

	public void cliqueLongo() {
		cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
	}
	
	public String obterTextoCampo() {
		return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
	
	public void clicarCliqueDuplo() {
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		clicarPorTexto("Clique duplo");
	}
	
}
