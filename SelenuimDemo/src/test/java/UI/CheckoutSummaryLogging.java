package UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.logging.*;

public class CheckoutSummaryLogging {

	 private static final Logger logger = Logger.getLogger(CheckoutSummaryLogging.class.getName());

	    public static void main(String[] args) {
	        // Configure logger
	        ConsoleHandler handler = new ConsoleHandler();
	        SimpleFormatter formatter = new SimpleFormatter();
	        handler.setFormatter(formatter);
	        logger.addHandler(handler);

	        // Set the path to your chromedriver executable
	        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver/chromedriver");

	        // Initialize the Chrome driver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to the checkout page
	        driver.get("http://example.com/checkout");

	        // Log checkout summary
	        logCheckoutSummary(driver);

	        // Close the browser
	        driver.quit();
	    }

	    private static void logCheckoutSummary(WebDriver driver) {
	        // Find elements containing checkout summary (modify locators as per your webpage)
	        WebElement productNameElement = driver.findElement(By.xpath("//div[@class='product-name']"));
	        WebElement totalPriceElement = driver.findElement(By.xpath("//span[@class='total-price']"));

	        // Log checkout summary
	        logger.info("Checkout Summary:");
	        logger.info("Product Name: " + productNameElement.getText());
	        logger.info("Total Price: " + totalPriceElement.getText());
	    }
	}

	


   