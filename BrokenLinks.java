package testers;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		
		List <WebElement> link =  driver.findElements(By.tagName("a"));
		System.out.println("Total number of links"+ link.size());
		
		for (WebElement linkElement : link) {
			
			String hrefvalue =linkElement.getAttribute("href");
			
			if (hrefvalue==null || hrefvalue.isEmpty()) {
				
				System.out.println("This is not possible check");
				continue;		
				}
			try {
				URL linkUrl = new URL (hrefvalue);
				HttpURLConnection connlinkURL = (HttpURLConnection) linkUrl.openConnection();
				connlinkURL.connect();
				if (connlinkURL.getResponseCode()>=400) {
					System.out.println("Broken link"+ connlinkURL);
					}
				else {
					
					System.out.println("it is not a broken link" +connlinkURL);
				}
			}catch(Exception e) {
			}
		}
	}
}
