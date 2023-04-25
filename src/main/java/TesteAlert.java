import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TesteAlert {

	@Test
	@Ignore
	public void TesteParaInteragirComAlertSimples() throws Exception {
		
		WebDriver driver = new FirefoxDriver(); // Firefox
		
		// URL, Página do Projeto, acessada localmente, via arquivo HTML.
		// System.getProperty("user.dir") é o "ApplicationPath" detectado automáticamente pela IDE Eclipse.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		//driver.findElement(By.id("alert")).click();
		driver.findElement(By.id("alert")).sendKeys(Keys.ENTER);
		
		//Alternando entre "janelas" - Alert/Confirm/Popup - Caixas de Diálogo
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Alert Simples", alert.getText());
		System.out.println(alert.getText());
		
		//Armazenando Texto que está contido dentro do Alert
		String Nome = alert.getText();		
		
		Thread.sleep(3000);
		
		
		alert.accept();
		//alert.dismiss();
		
		//Inserindo Texto coletado no Alert no campo Nome
		driver.findElement(By.id("elementosForm:nome")).sendKeys(Nome);
		
		

		
		
		JOptionPane.showMessageDialog(null,"Encerrando a Execução!");
	}
	
	
	@Test
	@Ignore
	public void InteragirComPrompt() throws Exception {
		
		WebDriver driver = new FirefoxDriver(); // Firefox
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("prompt")).click();
		
		//Apontando a automação para o Alert
		Alert caixaDialogo = driver.switchTo().alert();
		
		//Checando se existe o texto "Digite um numero" dentro do Alert
		Assert.assertEquals("Digite um numero", caixaDialogo.getText());
		
		// Escrevendo no text field do alert
		caixaDialogo.sendKeys("12");
		
		// Aceitando/clicando no botão sim do alert
		caixaDialogo.accept();
		
		/*
		 * Nesta aplicação após confirmar o alert acima, é apresentado outro alert.
		 * Não é necessário instanciar/atribuir novamente a caixa de diálogo à uma nova 
		 * variável do tipo Alert. Ou seja, não é necessário outro ".switchTo().alert()"
		 */
		
		//Pegando texto do segundo alert e imprimindo na console
		System.out.println(caixaDialogo.getText());
		
		Thread.sleep(1000);
		
		// Aceitando/clicando no botão sim do alert
		caixaDialogo.accept();
		
		Thread.sleep(1000);
		// Aceitando/clicando no botão sim do terceiro alert que é apresentado
		caixaDialogo.accept();
		
	}
	
	@Test
	public void InteragirComOutrasJanelas() throws InterruptedException {
		WebDriver driver = new FirefoxDriver(); // Firefox
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// Clicando no botão que abre um Popup
		driver.findElement(By.id("buttonPopUpEasy")).click();
		
		// Alternando de Janelas, chaveando para Janela do Popup
		// Nota: Nesse caso está sendo usado como argumento o título da janela do popup para apontamento.
		// Porém à popups sem título na janela. Nesse caso, a automação ocorrerá de forma diferente.
		driver.switchTo().window("Popup");
		
		driver.wait(2000); // Milisegundos
		System.out.println("Estou no Popup");
		
		
	}
}
