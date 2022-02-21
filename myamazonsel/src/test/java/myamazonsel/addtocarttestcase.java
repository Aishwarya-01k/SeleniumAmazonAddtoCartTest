
package myamazonsel;

import static org.junit.Assert.*;

import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;


public class addtocarttestcase {

	WebDriver driver=new ChromeDriver();
	
	static WebDriverWait wait=null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		
		System.setProperty("WebDriver.Chrome.driver","chromedriver.exe");
		
	}

	/**
	 * @throws java.lang.Exceptios
	 */
	@Before
	public void setUp() throws Exception {
		
		
		driver.get("https://www.amazon.in/");
	}

	@Test
	public void test1addtocart() {
		driver.get("https://www.amazon.in/");
		driver.findElement(By.linkText("Today's Deals")).click();
		wait= new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Today's Deals")));
		//test
		Assert.assertTrue(driver.getTitle().equals("Amazon.in - Today's Deals"));
		
		driver.findElement(By.xpath("//*[@id=\"slot-15\"]/div/div/div[2]/div[3]/div/div[1]/div/div/a[1]/div/div/img")).click();
		driver.findElement(By.cssSelector("#octopus-dlp-asin-stream > ul > li:nth-child(2) > span > div > div.a-section.octopus-dlp-asin-info-section > div.a-section.octopus-dlp-asin-title > a")).click();
		
		int a = driver.findElements(By.id("add-to-cart-button")).size();
		System.out.println(+a);
		if (a==1) {
			driver.findElement(By.id("add-to-cart-button")).click();
		}
		else if(a==0) {
			System.out.println("No Add to cart element found");
			
		}
		else {
			System.out.println("There are more elements on the page with the given locator");
		}
		wait=new WebDriverWait(driver,2);
		
		String t= driver.getTitle();
		String str = "Apple iPhone 12 (128GB) - Blue : Amazon.in: Electronics";
		
		if (t.equals(str)) {
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
			}
		
		}
		
	
	public static void cleanup(){
		
	}

}
