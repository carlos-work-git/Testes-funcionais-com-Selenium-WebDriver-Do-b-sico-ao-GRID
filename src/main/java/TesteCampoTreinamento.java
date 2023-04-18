import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteCampoTreinamento {
	
	@Test
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
	public void teste_RadioButton() {
		
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
	public void testeCheckBox() {
		
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
	
	
	private void closeSession () {
		
		try {
			Runtime.getRuntime().exec("taskkill /F /IM Firefox.exe");
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe"); // Encerrando processo com o Gecko WebDriver.
			System.out.println( "Encerrando as Sessões" );
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
