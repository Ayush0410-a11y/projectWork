import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon extends AmazonproductSearch  {
	public Amazon(WebDriver driver) {
		super(driver);
	}
	public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("pleae provide the url"); //amazon url link as per project requirment
		String weburl= scanner.next();
		System.out.println("pleae enter the product name: ");
		String productName =scanner.next(); //please provide the product which is in list view
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HELLO\\Downloads\\chromedriver.exe");    
        WebDriver driver=new ChromeDriver();       
        AmazonproductSearch amzPdtScr = new AmazonproductSearch(driver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(weburl);
        amzPdtScr.productSearch(productName);
        String productname1=driver.findElement(productname1st).getText();
        System.out.println("1st product name: "+productname1);
        String productname2=driver.findElement(productname2nd).getText();;
        System.out.println("2nd product name: "+productname2);
        String productprice1 =driver.findElement(productprice1st).getText();
        System.out.println("1st product price: "+productprice1);
        String productprice2 =driver.findElement(productprice2nd).getText();
        System.out.println("2nd product price: "+productprice2);
        driver.close();
        amzPdtScr.insertDBdata(productname1, productprice1);
        amzPdtScr.insertDBdata(productname2, productprice2);
        amzPdtScr.selectDBdata(productname1, productprice1);        
	}

}
