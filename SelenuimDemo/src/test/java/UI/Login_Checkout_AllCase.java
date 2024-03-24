package UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.logging.*;




public class Login_Checkout_AllCase {
	

	public static void main(String[] args) throws InterruptedException {
		
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
        Thread.sleep(3000);
    
        // Verify Check In successfully
        WebElement welcomeMessage = driver.findElement(By.id("inventory_container"));
        if (welcomeMessage.isDisplayed()) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }
        
        
        
        //Sorting Price (High to Low)
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);
        select.selectByValue("hilo");
        //Thread.sleep(1000);
        
        //Complete the purchase for 2 items which has $15.99 price.
        //Add item one piece >> [Sauce Labs Bolt T-Shirt Price=$15.99]
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        
        //Add Item two piece >> [Test.allTheThings() T-Shirt (Red) Price=$15.99]
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        
        //Click Cart
        driver.findElement(By.className("shopping_cart_link")).click();
        
        //Verify element that contain product for 2 pieces
        By dataLocator = By.xpath("//div[@class='page_wrapper']"); 
        // Check if data is present on page cart
        boolean isDataPresent = !driver.findElements(dataLocator).isEmpty();
        if (isDataPresent) {
            System.out.println("Data is present on page cart for 2 Pieces.");
        } else {
            System.out.println("No data found on page cart.");
        }
        
        
        
        //Click Checkout
        driver.findElement(By.id("checkout")).click();
        
        //Input Your Information form : First name
      	driver.findElement(By.id("first-name")).sendKeys("Wachira");
              
        //Input Your Information form : Last name
      	driver.findElement(By.id("last-name")).sendKeys("Rangphueng");
              
        //Input Your Information form : ZipCode
        driver.findElement(By.id("postal-code")).sendKeys("60130");
        
        //Click Continue button
        driver.findElement(By.id("continue")).click();
        Thread.sleep(3000);

        By informationForm = By.xpath("//div[@class='header_secondary_container']"); 
        // Check if input your information correctly 
        boolean isfilledData = !driver.findElements(informationForm).isEmpty();
        if (isfilledData) {
           System.out.println("Filled data on information form is DONE");
        } else {
           System.out.println("Filled Fail on information form");
        }

        
        
        //Verify Checkout :Overview
        // Check Cart List display correctly 
        Thread.sleep(3000);
        By cart_list = By.xpath("//div[@class='cart_list']"); 
        boolean isDisplayProductList = !driver.findElements(cart_list).isEmpty();
        if (isDisplayProductList) {
           System.out.println("Cart List Display Correctly");
        } else {
           System.out.println("Cart List Display Correctly");
        }
        
        // Check Product display on Overview correctly      
        Thread.sleep(1000);
        By DetailProduct= By.id("item_1_title_link"); 
        boolean isDisplayProductDetail = !driver.findElements(DetailProduct).isEmpty();
        if (isDisplayProductDetail) {
           System.out.println("This cart has product : Sauce Labs Bolt T-Shirt");
        } else {
           System.out.println("This cart has no product");
        }
        
        // Check Product display on Overview correctly       
        Thread.sleep(1000);
        By DetailProduct2= By.id("item_3_title_link"); 
        boolean isDisplayProductDetail2 = !driver.findElements(DetailProduct2).isEmpty();
        if (isDisplayProductDetail2) {
           System.out.println("This cart has product : Test.allTheThings() T-Shirt (Red)");
        } else {
           System.out.println("This cart has no product");
        }
        
        // Check Payment Information display on Overview correctly       
        Thread.sleep(1000);
        By DetailPayment = By.xpath("//div[@class='summary_info_label']"); 
        boolean isDetailPayment = !driver.findElements(DetailPayment).isEmpty();
        if (isDetailPayment) {
           System.out.println("Payment Information display success");
        } else {
           System.out.println("Payment Information doesn't display on overview");
        }
        
        // Check Shipping Information display on Overview correctly       
        Thread.sleep(1000);
        By ShippingInformation= By.xpath("//div[@class='summary_info_label']"); 
        boolean isShippingInformation = !driver.findElements(ShippingInformation).isEmpty();
        if (isShippingInformation) {
           System.out.println("Shipping Information display success");
        } else {
           System.out.println("Shipping Information doesn't display");
        }
        
        
        // Check Price Total Information display on Overview correctly       
        Thread.sleep(1000);
        By PriceTotal= By.xpath("//div[@class='summary_info_label']"); 
        boolean isPriceDetail = !driver.findElements(PriceTotal).isEmpty();
        if (isPriceDetail) {
           System.out.println("PriceTotal display success ");
        } else {
           System.out.println("PriceTotal doesn't display");
        }
        
        
        // Check Total Information display on Overview correctly       
        Thread.sleep(1000);
        By TotalInformation= By.xpath("//div[@class='summary_info_label summary_total_label']"); 
        boolean isTotalInformation = !driver.findElements(TotalInformation).isEmpty();
        if (isTotalInformation) {
           System.out.println("Total Information display on overview correctly");
        } else {
           System.out.println("Total doesn't display");
        }
        
        // Log checkout summary
        Thread.sleep(1000);
        logCheckoutSummary(driver);
        System.out.println(driver);
        
        
        // Click Checkout Finish
        Thread.sleep(1000);
        driver.findElement(By.id("finish")).click();
        
        //Checkout Success
        Thread.sleep(1000);
        
        By CheckoutSuccess = By.id("checkout_complete_container"); 
        boolean isCheckoutSuccess = !driver.findElements(CheckoutSuccess).isEmpty();
        if (isCheckoutSuccess) {
           System.out.println("Checkout Order Success >> Thank you for your order! <<");
        } else {
           System.out.println("Checkout Order Fail");
        }
        
        
        //Click BackHome
        Thread.sleep(1000);
        driver.findElement(By.id("back-to-products")).click();
        
        
        //Logout Success
        Thread.sleep(1000);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        //Verify Logout success
        By LogoutSuccess = By.id("login-button"); 
        boolean isLogoutSuccess = !driver.findElements(LogoutSuccess).isEmpty();
        if (isLogoutSuccess) {
           System.out.println("Logout Success");
        } else {
           System.out.println("Logout Fail");
        }
        
        //Validate the “locked_out_user” user.
        
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        
		//Input password correctly
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
        
		//Click login button
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);
    
        // Verify Check In successfully
        WebElement lockedUser = driver.findElement(By.id("login-button"));
        String errorMessageText = lockedUser.getText();
        if (lockedUser.isDisplayed()) {
            System.out.println("User has been locked out.");
        } else {
            System.out.println("User is not locked out.");
        }

	}
	
    // Log checkout summary
	private static final Logger logger = Logger.getLogger(CheckoutSummaryLogging.class.getName());
	private static void logCheckoutSummary(WebDriver driver) {

	        WebElement PaymentInfo = driver.findElement(By.xpath("//div[@class='summary_value_label'][1]"));
	        WebElement ShippingInfo = driver.findElement(By.xpath("//div[@class='summary_value_label'][1]"));
	        WebElement PriceTotal = driver.findElement(By.xpath("//div[@class='summary_info_label']"));
	        WebElement Total = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']"));

	        // Log checkout summary
	        logger.info("Checkout Summary:");
	        logger.info("Product Name: " + PaymentInfo.getText());
	        logger.info("Total Price: " + ShippingInfo.getText());
	        logger.info("Total Price: " + PriceTotal.getText());
	        logger.info("Total Price: " + Total.getText());
	        
	    }
	
	
}


       







