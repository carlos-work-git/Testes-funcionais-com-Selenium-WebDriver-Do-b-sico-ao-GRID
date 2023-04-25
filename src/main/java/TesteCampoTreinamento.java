import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class TesteCampoTreinamento {
	
	@Test
	@Ignore
	public void testeTextField() {
		
		WebDriver driver = new FirefoxDriver(); // Firefox
		
		// URL, Página do Projeto, acessada localmente, via arquivo HTML.
		// System.getProperty("user.dir") é o "ApplicationPath" detectado automáticamente pela IDE Eclipse.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		String Nome = "José Carlos Junior";
		driver.findElement(By.id("elementosForm:nome")).sendKeys(Nome);
		Assert.assertEquals(Nome,driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		String nomeTeste = "Teste TextField";
		System.out.println(nomeTeste + " finish!");
		driver.close();
		
	}
	
	@Test
	@Ignore
	public void testandoOpcaoSelecionadaNoRadioButton() {
		
		WebDriver driver = new FirefoxDriver(); // Firefox
		
		// URL, Página do Projeto, acessada localmente, via arquivo HTML.
		// System.getProperty("user.dir") é o "ApplicationPath" detectado automáticamente pela IDE Eclipse.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

		String nomeTeste = "Teste RadioButton";
		System.out.println(nomeTeste + " finish!");
		driver.close();
		
	}
	
	
	@Test
	@Ignore
	public void testeOpcaoSelecionadaNoCheckBox() {
		
		WebDriver driver = new FirefoxDriver(); // Firefox
		
		// URL, Página do Projeto, acessada localmente, via arquivo HTML.
		// System.getProperty("user.dir") é o "ApplicationPath" detectado automáticamente pela IDE Eclipse.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		String nomeTeste = "Teste CheckBox";
		System.out.println(nomeTeste + " finish!");
		driver.close();
		
	}
	
	@Test
	@Ignore
	public void testandoItemSelecionadoNoMenuDropDown() {
		
		WebDriver driver = new FirefoxDriver(); // Firefox
		
		// URL, Página do Projeto, acessada localmente, via arquivo HTML.
		// System.getProperty("user.dir") é o "ApplicationPath" detectado automáticamente pela IDE Eclipse.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade")); //Capturando o Menu DropDown
		Select combo =  new Select(element);
		//combo.selectByIndex(2);
		//combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText() );
		System.out.println(combo.getFirstSelectedOption().getText());
		
		//Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
//		String nomeTeste = "Teste CheckBox";
//		System.out.println(nomeTeste + " finish!");
//		driver.close();
		
	}
	

	@Test
	@Ignore
	public void checandoItensDisponiveisNoMenuDropDown() {
		
		WebDriver driver = new FirefoxDriver(); // Firefox
		
		// URL, Página do Projeto, acessada localmente, via arquivo HTML.
		// System.getProperty("user.dir") é o "ApplicationPath" detectado automáticamente pela IDE Eclipse.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade")); //Capturando o Menu DropDown
		Select combo =  new Select(element);
		List<WebElement> options = combo.getOptions(); // Atribuindo opções do Menu DropDown à uma Lista de Elementos Web.
		Assert.assertEquals(8, options.size());
		
		//Verificando se um elemento consta dentro do Menu DropDown
		boolean encontrou = false;
		
		for(WebElement option:options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				System.out.println("Item Mestrado Encontrado!");
				break;
			}
		}
		
		if (encontrou == false) {
			System.out.println("Item Nao Encontrado!");
		}
		
		Assert.assertTrue(encontrou);
		
	}
	
	@Test
	//@Ignore
	public void checandoLinks() throws Exception {
		
		WebDriver driver = new FirefoxDriver(); // Firefox
		
		// URL, Página do Projeto, acessada localmente, via arquivo HTML.
		// System.getProperty("user.dir") é o "ApplicationPath" detectado automáticamente pela IDE Eclipse.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.linkText("Voltar")).click();
		System.out.println(driver.findElement(By.id("resultado")).getText());
		
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		driver.close();
		
		Thread.sleep(3000);
		//JOptionPane.showMessageDialog(null,"Encerrando a Execução!");


		
	}
	
	
	@Test
	//@Ignore
	public void checandoTituloDaPagina() {
		
		WebDriver driver = new FirefoxDriver(); // Firefox
		
		// URL, Página do Projeto, acessada localmente, via arquivo HTML.
		// System.getProperty("user.dir") é o "ApplicationPath" detectado automáticamente pela IDE Eclipse.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		//Capturando todo corpo da página ####################################
		//System.out.println(driver.findElement(By.tagName("body")).getText());
		
		//Esse método funciona, porém não é performático à depender do tamanho da página
/*
		Assert.assertTrue(
				driver.findElement(By.tagName("body"))
				.getText()
				.contains("Campo de Treinamento"));
*/
		
		
		
		JOptionPane.showMessageDialog(null,"Encerrando a Execução!");
	
	}
	
	
	@Test
	//@Ignore
	public void AbrirPagina () {
		
		WebDriver driver = new FirefoxDriver(); // Firefox
		
		// URL, Página do Projeto, acessada localmente, via arquivo HTML.
		// System.getProperty("user.dir") é o "ApplicationPath" detectado automáticamente pela IDE Eclipse.
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
	}
	
	
	private void closeSession () {
		
		try {
			JOptionPane.showMessageDialog(null,"Encerrando a Execução!");
			Runtime.getRuntime().exec("taskkill /F /IM Firefox.exe");
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe"); // Encerrando processo com o Gecko WebDriver.
			System.out.println( "Encerrando as Sessões" );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
