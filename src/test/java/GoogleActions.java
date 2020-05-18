import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.DriverUtil;
import io.cucumber.java8.En;

public class GoogleActions implements En {

	WebDriver driver = DriverUtil.getDriver();
	
	public void find(By elemento) {

		driver.findElement(elemento);

	}
	
	public void click(By elemento) {

		driver.findElement(elemento).click();

	}
	
	
}
