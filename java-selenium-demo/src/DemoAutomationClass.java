import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoAutomationClass {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		//open web site
		driver.get("https://www.saucedemo.com/"); 
		
		//Input valid user’s credential
		WebElement Username = driver.findElement(By.id("user-name"));
		Username.sendKeys("standard_user");
        
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("secret_sauce");
        
        WebElement submitButton = driver.findElement(By.id("login-button"));
        submitButton.click();
        
        
	}

}