package UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Login_TestCase {

	public static void main(String[] args) {
		
        WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//open web site
		driver.get("https://www.saucedemo.com/"); 
		driver.manage().window().maximize();
		
		//Input valid user’s credential correctly
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
        
		//Input password correctly
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
        
		//Click login button
        driver.findElement(By.id("login-button")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
        // Verify Check In successfully
        WebElement welcomeMessage = driver.findElement(By.id("inventory_container"));
        if (welcomeMessage.isDisplayed()) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }
        
        //Close Web site
        //driver.close();
        
        
	}

}

