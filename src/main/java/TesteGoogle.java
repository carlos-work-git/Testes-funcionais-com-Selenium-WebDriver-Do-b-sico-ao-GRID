import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public void teste() {
	
		//Caso o caminho do webdriver não tenha sido adicionado ao Path, é necessário incluir a linha abaixo:
		System.setProperty("webdriver.gecko.driver", "C:\\Webdriver\\geckodriver.exe"); // Firefox
		//System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe"); // Chrome
		//System.setProperty("webdriver.edge.driver", "C:\\Webdriver\\msedgedriver.exe"); // Chrome
		
		// Iniciando a Sessão com o Navegador
		WebDriver driver = new FirefoxDriver(); // Firefox
		//WebDriver driver = new ChromeDriver(); // Chrome
		//WebDriver driver = new EdgeDriver(); // Edge
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		
		JOptionPane.showMessageDialog(null,"Encerrando a Execução!");
		
		try {
			driver.close(); // Fecha somente a aba atual
			//Nota Linha Abaixo Funciona Mas Lança uma Exception.
			//driver.quit(); // Encerra a conexão com o navegador e encerrar tudo que foi aberto.
			//Thread.sleep(5000);
			System.out.println("Finish!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}