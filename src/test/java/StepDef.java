
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.Box.Filler;

import Utils.DriverUtil;
import io.cucumber.java8.En;
import junit.framework.Assert;
import Utils.DriverUtil;

public class StepDef implements En {

	DriverUtil driver = new DriverUtil();
	GoogleActions action = new GoogleActions();
	WebDriver driver2 = DriverUtil.getDriver();
	

	public StepDef() {
		
		Scanner input = new Scanner(System.in);


		ArrayList<Filme> listaFilme = new ArrayList<>();
		int cont = -1;

		Given("Cadastre o Filme", () -> {


			Filme information;

			while (cont != 0) {

				information = new Filme();

				information.setFilme(JOptionPane.showInputDialog(null, "Informe o Filme"));

				information.setAno(JOptionPane.showInputDialog(null, "Informe o Ano de Estréia"));

				information.setDiretor(JOptionPane.showInputDialog(null, "Informe o Diretor"));

				information.setDtNasc(JOptionPane.showInputDialog(null, "Informe a Data de Nasc do Diretor"));

				listaFilme.add(information);

				int a = JOptionPane.showConfirmDialog(null, "Deseja Cadastrar Novo Filme?");

				if (a == 1 || a == -1 || a == 2) {

					break;

				}

			}

			for (int i = 0; i < listaFilme.size(); i++) {

				System.out.println("================================");
				System.out.println(listaFilme.get(i).getFilme());
				System.out.println(listaFilme.get(i).getAno());
				System.out.println(listaFilme.get(i).getDiretor());
				System.out.println(listaFilme.get(i).getDtNasc());				
				System.out.println("================================");

			}

		});

		Given("Abro o Navegador", () -> {

			driver.getDriver();
		});

		And("Acesso o Site {string}", (String site) -> {

			driver.getUrl(site);
			action.click(GooglePage.CAIXA_BUSCA);
			driver2.findElement(GooglePage.CAIXA_BUSCA).sendKeys(JOptionPane.showInputDialog("Informe o Filme")," " ,JOptionPane.showInputDialog("Informe o Diretor"), Keys.ENTER );
			String a = driver2.findElement(GooglePage.RESULT).getText();
			JOptionPane.showMessageDialog(null, a);
			
		});

		Given("Teste API", () -> {

			String uriBase = "https://jsonplaceholder.typicode.com/todos/1";

			Response response = null;

			try {
				response = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).get(uriBase);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("================================");
			
			System.out.println("Response :" + response.asString());
			
			JOptionPane.showMessageDialog(null, response.asString());
			
			System.out.println("Status Code :" + response.getStatusCode());
			
			System.out.println("================================");
			assertEquals(200, response.getStatusCode());

		});

	}
}
